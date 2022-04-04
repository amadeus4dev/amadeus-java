package com.amadeus.safety;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Java6BDDAssertions.then;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.SafePlace;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SafetyIT {

  WireMockServer wireMockServer;

  private Amadeus client;

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

    client = Amadeus
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
  public void given_client_when_call_safety_rate_location_by_square_with_params_then_ok()
      throws ResponseException {

    //Given
    //https://developers.amadeus.com/blog/announcing-safe-place-api-geosure
    String address = "/v1/safety/safety-rated-locations/by-square"
        + "?east=2.177181&south=41.394582&north=41.397158&west=2.160873";
    wireMockServer.stubFor(get(urlEqualTo(address))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBodyFile("safety_rate_location_by_square_ok.json")));

    Params params = Params
        .with("north", "41.397158")
        .and("west", "2.160873")
        .and("south", "41.394582")
        .and("east", "2.177181");

    //When
    SafePlace[] result = client.safety.safetyRatedLocations.bySquare.get(params);

    //Then
    then(result.length).isNotEqualTo(0);
  }

  @Test
  public void given_client_when_call_safety_rate_location_by_square_without_params_then_ok()
      throws ResponseException {

    //Given
    wireMockServer.stubFor(get(urlEqualTo("/v1/safety/safety-rated-locations/by-square"))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBodyFile("safety_rate_location_by_square_ok.json")));

    //When
    SafePlace[] result = client.safety.safetyRatedLocations.bySquare.get();

    //Then
    then(result.length).isNotEqualTo(0);
  }

  @Test
  public void given_client_when_call_safety_rate_location_then_ok() throws ResponseException {

    //Given
    //https://developers.amadeus.com/blog/announcing-safe-place-api-geosure
    wireMockServer.stubFor(get(urlEqualTo("/v1/safety/safety-rated-locations"
        + "?latitude=41.39715&longitude=2.160873"))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBodyFile("safety_rate_location_by_square_ok.json")));

    Params params = Params
        .with("latitude", "41.39715")
        .and("longitude", "2.160873");

    //When
    SafePlace[] result = client.safety.safetyRatedLocations.get(params);

    //Then
    then(result.length).isNotEqualTo(0);
  }

  @Test
  public void given_client_when_call_safety_rate_location_by_id_then_ok() throws ResponseException {

    //Given
    //https://developers.amadeus.com/blog/announcing-safe-place-api-geosure
    wireMockServer.stubFor(get(urlEqualTo("/v1/safety/safety-rated-locations/Q930402719"))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBodyFile("safety_rated_location_id_ok.json")));

    String id = "Q930402719";

    //When
    SafePlace result = client.safety.safetyRatedLocation(id).get();

    //Then
    then(result).isNotNull();
  }

}
