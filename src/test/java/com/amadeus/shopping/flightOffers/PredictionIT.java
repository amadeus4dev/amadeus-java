package com.amadeus.shopping.flightoffers;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.amadeus.Amadeus;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//https://developers.amadeus.com/self-service/category/air/api-doc/flight-offers-search/api-reference
public class PredictionIT {

  WireMockServer wireMockServer;

  private Amadeus amadeus;

  /**
   * In every tests, we will authenticate.
   */
  @BeforeEach
  public void setup() {
    wireMockServer = new WireMockServer(8080);
    wireMockServer.start();

    // https://developers.amadeus.com/self-service/apis-docs/guides/authorization-262
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

  @Test
  public void givenClientWhenCallFlightOrderPredictionThenOK()
      throws ResponseException, IOException {

    //Given
    String address = "/v2/shopping/flight-offers/prediction";
    wireMockServer.stubFor(post(urlEqualTo(address))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBodyFile("flight_search_offer_response_ok.json")));

    JsonObject request = getRequestFromResources("flight_search_offer_request_ok.json");

    //When
    FlightOfferSearch[] result = amadeus.shopping.flightOffers.prediction.post(request);

    //Then
    assertNotNull(result);
  }

  private JsonObject getRequestFromResources(String jsonFile) throws IOException {

    final String folder = "__files/";

    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource(folder + jsonFile).getFile());
    String jsonString = new String(Files.readAllBytes(file.toPath()));

    return new JsonParser().parse(jsonString).getAsJsonObject();
  }

}
