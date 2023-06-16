package com.amadeus.ordering.transferOrders.transfers;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.TransferCancellation;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// https://developers.amadeus.com/self-service/category/cars-and-transfers/api-doc/transfer-management
public class CancellationIT {

  WireMockServer wireMockServer;

  private Amadeus amadeus;

  /**
   * Authentication is conducted for each test.
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
  public void givenClientWhenCallTransferOrdersWithParamsThenOK()
      throws ResponseException, IOException {

    //Given
    String address = "/v1/ordering/transfer-orders/123456/transfers/cancellation" +
     "?confirmNmb=12029761";
    wireMockServer.stubFor(post(urlEqualTo(address))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBodyFile("transfer_orders_management_response_ok.json")));
    Params params = Params.with("confirmNmb", "12029761");

    //When
    TransferCancellation result = amadeus.ordering
        .transferOrder("123456").transfers.cancellation.post(params);

    //Then
    assertNotNull(result);
  }

}
