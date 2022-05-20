package com.amadeus.shopping;

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
import com.amadeus.resources.HotelOffer;
import com.github.tomakehurst.wiremock.WireMockServer;
import java.io.IOException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// https://developers.amadeus.com/self-service/category/hotel/api-doc/hotel-search/api-reference
public class HotelOffersIT {
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
  public void given_client_when_call_hotel_offers_with_params_then_ok()
      throws ResponseException, IOException {

    //Given
    String address = "/v3/shopping/hotel-offers"
        + "?hotelIds=MCLONGHM"
        + "&roomQuantity=1"
        + "&adults=1"
        + "&checkInDate=2022-11-22"
        + "&paymentPolicy=NONE"
        + "&bestRateOnly=true";
    wireMockServer.stubFor(get(urlEqualTo(address))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBodyFile("hotel_offers_response_ok.json")));

    //When
    HotelOffer[] result = amadeus.shopping.hotelOffers.get(
        Params.with("hotelIds", "MCLONGHM")
            .and("adults", 1)
            .and("checkInDate", "2022-11-22")
            .and("roomQuantity", 1)
            .and("paymentPolicy", "NONE")
            .and("bestRateOnly", true)
    );

    //Then
    then(result.length).isNotEqualTo(0);
  }

  //TODO Review with the team to upgrade the behaviour.
  @Test
  public void given_client_when_call_hotel_offers_without_params_then_ok()
      throws ResponseException {

    //Given
    String address = "/v3/shopping/hotel-offers";
    wireMockServer.stubFor(get(urlEqualTo(address))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(400)
        .withBody("")));

    //When
    //Then
    assertThatThrownBy(() -> {
      amadeus.shopping.hotelOffers.get();
    }).isInstanceOf(ClientException.class);
  }
}
