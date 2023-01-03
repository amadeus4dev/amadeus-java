package com.amadeus.referenceData.locations;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.BDDAssertions.then;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Hotel;

import com.github.tomakehurst.wiremock.WireMockServer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class HotelIT {

  WireMockServer wireMockServer;

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

  @Test
  public void given_client_when_call_hotel_with_mandatory_parameters_then_returns_ok()
      throws ResponseException {

    //Given
    Params params = Params
        .with("keyword", "PARI")
        .and("subType", "HOTEL_GDS");

    String urlParams = "?subType=HOTEL_GDS&keyword=PARI";
    String address = "/v1/reference-data/locations/hotel" + urlParams;
    wireMockServer.stubFor(get(urlEqualTo(address))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBodyFile("reference_data_hotel_default_response_ok.json")));

    //When
    Hotel[] result = amadeus.referenceData.locations.hotel.get(params);

    //Then
    assertNotNull(result);
    assertTrue(result.length > 1);
  }

  @Test
  public void given_client_when_call_hotel_then_returns_single_hotel_response_ok()
      throws ResponseException {

    //Given
    Params params = Params
        .with("keyword", "PARI")
        .and("subType", "HOTEL_GDS")
        .and("max", "1");

    String urlParams = "?max=1&subType=HOTEL_GDS&keyword=PARI";
    String address = "/v1/reference-data/locations/hotel" + urlParams;
    wireMockServer.stubFor(get(urlEqualTo(address))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBodyFile("reference_data_hotel_single_hotel_response_ok.json")));

    //When
    Hotel[] result = amadeus.referenceData.locations.hotel.get(params);

    //Then
    assertNotNull(result);
    assertEquals(1, result.length);
  }

  @Test
  public void given_client_when_call_hotel_then_returns_multiple_hotel_response_ok()
      throws ResponseException {

    //Given
    Params params = Params
        .with("keyword", "PARI")
        .and("subType", "HOTEL_GDS")
        .and("max", "5");

    String urlParams = "?max=5&subType=HOTEL_GDS&keyword=PARI";
    String address = "/v1/reference-data/locations/hotel" + urlParams;
    wireMockServer.stubFor(get(urlEqualTo(address))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBodyFile("reference_data_hotel_multiple_hotel_response_ok.json")));

    //When
    Hotel[] result = amadeus.referenceData.locations.hotel.get(params);

    //Then
    assertNotNull(result);
    assertEquals(5, result.length);
  }

  @Test
  public void given_client_when_call_hotel_with_all_parameters_then_response_ok()
      throws ResponseException {

    //Given
    Params params = Params
        .with("keyword", "PARI")
        .and("subType", "HOTEL_GDS")
        .and("countryCode", "FR")
        .and("lang", "EN")
        .and("max", "20");

    String urlParams = "?max=20&countryCode=FR&subType=HOTEL_GDS&keyword=PARI&lang=EN";
    String address = "/v1/reference-data/locations/hotel" + urlParams;
    wireMockServer.stubFor(get(urlEqualTo(address))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBodyFile("reference_data_hotel_default_response_ok.json")));

    //When
    Hotel[] result = amadeus.referenceData.locations.hotel.get(params);

    //Then
    assertTrue(result.length > 1);
  }
}
