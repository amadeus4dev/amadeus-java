package com.amadeus.referenceData.locations.pointsOfInterest;

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
import com.amadeus.resources.PointOfInterest;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//https://developers.amadeus.com/self-service/category/destination-content/api-doc/points-of-interest/api-reference
public class BySquareIT {

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
  public void givenClientWhenCallPointsOfInterestBySquareWithParamsThenOK()
      throws ResponseException {

    //Given
    String address = "/v1/reference-data/locations/pois/by-square"
        + "?east=2.177181&south=41.394582&north=41.397158&west=2.160873";
    wireMockServer.stubFor(get(urlEqualTo(address))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBodyFile("pois_by_square_response_ok.json")));

    Params params = Params
        .with("north", "41.397158")
        .and("west", "2.160873")
        .and("south", "41.394582")
        .and("east", "2.177181");

    //When
    PointOfInterest[] result = amadeus.referenceData.locations
        .pointsOfInterest.bySquare.get(params);

    //Then
    then(result.length).isNotEqualTo(0);
  }

  //TODO Review with the team to upgrade the behaviour.
  @Test
  public void givenClientWhenCallPointsOfInterestBySquareWithoutParamsThenOK()
      throws ResponseException {

    //Given
    String address = "/v1/reference-data/locations/pois/by-square";
    wireMockServer.stubFor(get(urlEqualTo(address))
          .willReturn(aResponse().withHeader("Content-Type", "application/json")
          .withStatus(400)
          .withBody("")));

    //When
    //Then
    assertThatThrownBy(() -> {
      amadeus.referenceData.locations.pointsOfInterest.bySquare.get();
    }).isInstanceOf(ClientException.class);
  }

}
