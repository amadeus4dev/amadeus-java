package com.amadeus.airline;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ClientException;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Destination;
import com.github.tomakehurst.wiremock.WireMockServer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// https://developers.amadeus.com/self-service/category/air/api-doc/airline-routes/api-reference
public class DestinationsIT {
  WireMockServer wireMockServer;

  private Amadeus amadeus;

  /**
   * In every test, we will authenticate.
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

  @Test
  public void given_client_when_call_airline_destinations_with_mandatory_params_then_ok()
      throws ResponseException {

    //Given
    String address = "/v1/airline/destinations"
        + "?airlineCode=BA";
    wireMockServer.stubFor(get(urlEqualTo(address))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBodyFile("airline_routes_response_ok.json")));

    //When
    Destination[] result = amadeus.airline.destinations.get(
      Params.with("airlineCode", "BA")
    );

    //Then
    assertNotEquals(0, result.length);
  }

  @Test
  public void given_client_when_call_airline_destinations_with_optional_params_then_ok()
      throws ResponseException {

    //Given
    String address = "/v1/airline/destinations"
        + "?max=2"
        + "&airlineCode=BA";
    wireMockServer.stubFor(get(urlEqualTo(address))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBodyFile("airline_routes_response_ok2.json")));

    //When
    Destination[] result = amadeus.airline.destinations.get(
      Params.with("airlineCode", "BA")
        .and("max", 2)
    );

    //Then
    assertEquals(2, result.length);
  }

  //TODO Review with the team to upgrade the behaviour.
  @Test
  public void given_client_when_call_airline_destinations_without_params_then_ok() {

    //Given
    String address = "/v1/airline/destinations";
    wireMockServer.stubFor(get(urlEqualTo(address))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(400)
        .withBody("")));

    //When
    //Then
    assertThatThrownBy(() -> {
      amadeus.airline.destinations.get();
    }).isInstanceOf(ClientException.class);
  }
}
