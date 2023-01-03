package com.amadeus.referenceData.locations.hotels;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.BDDAssertions.then;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ClientException;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Hotel;
import com.github.tomakehurst.wiremock.WireMockServer;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// https://developers.amadeus.com/self-service/category/hotel/api-doc/hotel-list/api-reference
public class ByGeocodeIT {
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
  public void given_client_when_call_hotels_by_geocode_with_params_then_ok()
      throws ResponseException {

    //Given
    String address = "/v1/reference-data/locations/hotels/by-geocode?"
        + "hotelSource=ALL&latitude=41.397158&radius=5&radiusUnit=KM&longitude=2.160873";
    wireMockServer.stubFor(get(urlEqualTo(address))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBodyFile("hotels_by_geocode_response_ok.json")));

    Params params = Params
        .with("latitude", 41.397158)
        .and("longitude", 2.160873)
        .and("radius", 5)
        .and("radiusUnit", "KM")
        .and("hotelSource", "ALL");

    //When
    Hotel[] result = amadeus.referenceData.locations
      .hotels.byGeocode.get(params);

    //Then
    assertNotEquals(0, result.length);
  }

  //TODO Review with the team to upgrade the behaviour.
  @Test
  public void given_client_when_call_hotels_by_geocode_without_params_then_ok()
      throws ResponseException {

    //Given
    String address = "/v1/reference-data/locations/hotels/by-geocode";
    wireMockServer.stubFor(get(urlEqualTo(address))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(400)
        .withBody("")));

    //When
    //Then
    assertThatThrownBy(() -> {
      amadeus.referenceData.locations.hotels.byGeocode.get();
    }).isInstanceOf(ClientException.class);
  }
}
