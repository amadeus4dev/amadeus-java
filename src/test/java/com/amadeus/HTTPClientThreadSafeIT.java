package com.amadeus;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static java.util.concurrent.CompletableFuture.runAsync;
import static org.assertj.core.api.BDDAssertions.then;

import com.amadeus.exceptions.ResponseException;
import com.github.tomakehurst.wiremock.WireMockServer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HTTPClientThreadSafeIT {

  private static Logger logger = LoggerFactory.getLogger(HTTPClientThreadSafeIT.class);

  private WireMockServer wireMockServer;

  private Amadeus amadeus;

  /**
   * In every tests, we will authenticate.
   */
  @BeforeEach
  public void setup() {
    wireMockServer = new WireMockServer(8080);
    wireMockServer.start();

    //https://developers.amadeus.com/self-service/apis-docs/guides/authorization-262
    String address = "/v1/security/oauth2/token"
        + "?grant_type=client_credentials&client_secret=DEMO&client_id=DEMO";
    wireMockServer.stubFor(post(urlEqualTo(address))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBodyFile("auth_ok.json")));

    amadeus = Amadeus
      .builder("DEMO", "DEMO")
      .setHost("localhost")
      .setPort(8080)
      .setSsl(false)
      .setLogLevel("debug")
      .build();
  }

  @AfterEach
  public void teardown() {
    wireMockServer.stop();
  }

  /**
   * To avoid duplication, we create a class that implements both interfaces.
   */
  public class Task implements Callable<String>, Runnable {

    private final String endpoint = "/v1/color";
    private final Amadeus amadeus;
    private final Integer color;

    Task(Amadeus amadeus, Integer color) {
      this.amadeus = amadeus;
      this.color = color;
    }

    private void process() {
      try {
        if (esPar(this.color)) {
          Params params = new Params().and("id", "blue");
          Response response = amadeus.get(this.endpoint, params);
          then(response.getResult().get("result").getAsString()).isEqualTo("blue");
        } else {
          Params params = new Params().and("id", "red");
          Response response = amadeus.get(this.endpoint, params);
          then(response.getResult().get("result").getAsString()).isEqualTo("red");
        }
      } catch (ResponseException e) {
        logger.error(e.getMessage(), e);
      }
    }

    public boolean esPar(int numero) {
      return (numero % 2 == 0) ? true : false;
    }

    @Override
    public String call() {
      this.process();
      return "";
    }

    @Override
    public void run() {
      this.process();
    }
  }

  /**
   * Define a test to prove that in a concurrent scenario,
   * Amadeus object doesn´t suffer a concurrency issue in terms of Shared Mutability
   * For that purpose, we define 2 fake endpoints where in a deterministic way we expose a response
   * and we define multiple tasks to run un parallel.
   * Every tasks will consume the different endpoints and the idea is to probe that
   * when you call in the same time, different endpoints, data is not shared between Threads.
   *
   * @throws InterruptedException A possible error with the Executor
   */
  @Test
  public void given_client_when_call_in_parallel_multiple_times_then_thread_safety()
      throws InterruptedException {

    //Given

    //Alternative 1
    String address = "/v1/color?id=blue";
    wireMockServer.stubFor(get(urlEqualTo(address))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBody("{result:'blue'}")));

    //Alternative 2
    String address2 = "/v1/color?id=red";
    wireMockServer.stubFor(get(urlEqualTo(address2))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBody("{result:'red'}")));

    ExecutorService service = Executors.newFixedThreadPool(2);

    //When
    //Then
    AtomicInteger counter = new AtomicInteger(0);
    for (int i = 1; i < 10_000; i++) {
      List<Task> taskList = new ArrayList<>();
      taskList.add(new Task(amadeus, counter.incrementAndGet()));
      taskList.add(new Task(amadeus, counter.incrementAndGet()));

      service.invokeAll(taskList);
    }

    service.shutdown();
    service.awaitTermination(1, TimeUnit.MINUTES);
  }

  /**
   * Define a test to prove that in a concurrent scenario,
   * Amadeus object doesn´t suffer a concurrency issue in terms of Shared Mutability
   * For that purpose, we define 2 fake endpoints where in a deterministic way we expose a response
   * and we define multiple tasks to run un parallel.
   * Every tasks will consume the different endpoints and the idea is to probe that
   * when you call in the same time, different endpoints, data is not shared between Threads.
   *
   * @throws InterruptedException A possible error with CompletableFuture
   */
  @Test
  public void given_client_when_call_in_parallel_multiple_times_then_thread_safety2()
      throws InterruptedException {

    //Given

    //Alternative 1
    String address = "/v1/color?id=blue";
    wireMockServer.stubFor(get(urlEqualTo(address))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBody("{result='blue'}")));

    //Alternative 2
    String address2 = "/v1/color?id=red";
    wireMockServer.stubFor(get(urlEqualTo(address2))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBody("{result='red'}")));

    ExecutorService service = Executors.newFixedThreadPool(2);

    AtomicInteger counter = new AtomicInteger(0);
    for (int i = 1; i < 10_000; i++) {
      CompletableFuture<Void> cf1 = runAsync(new Task(amadeus, counter.incrementAndGet()), service);
      CompletableFuture<Void> cf2 = runAsync(new Task(amadeus, counter.incrementAndGet()), service);
      CompletableFuture.allOf(cf1, cf2).join();
    }

    service.shutdown();
    service.awaitTermination(1, TimeUnit.MINUTES);
  }
}
