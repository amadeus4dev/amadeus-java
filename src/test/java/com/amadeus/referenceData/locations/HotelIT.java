package com.amadeus.referenceData.locations;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.BDDAssertions.then;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Hotel;
import com.amadeus.resources.HotelOfferSearch;
import com.github.tomakehurst.wiremock.WireMockServer;
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
  public void givenClientWhenCallHotelWithMandatoryParametersThenReturnsOK()
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
    then(result).isNotNull();
    then(result.length).isGreaterThan(1);
  }

  @Test
  public void givenClientWhenCallHotelThenReturnsSingleHotelResponseOK()
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
    then(result).isNotNull();
    then(result.length).isEqualTo(1);
  }

  @Test
  public void givenClientWhenCallHotelThenReturnsMultipleHotelResponseOK()
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
    then(result).isNotNull();
    then(result.length).isEqualTo(5);
  }

  @Test
  public void givenClientWhenCallHotelWithAllParametersThenResponseOK()
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
    then(result).isNotNull();
    then(result.length).isGreaterThan(1);
  }

  @Test
  public void givenClientWhenCallHotelOffersSearchWithParamsThenOK()
      throws ResponseException, IOException {

    //Given
    String input = URLEncoder.encode("MCLONGHM,WIMAD079", "UTF-8");
    String address = "/v3/shopping/hotel-offers"
        + "?hotelIds=" + input
        + "&roomQuantity=1"
        + "&adults=1"
        + "&checkInDate=2022-11-22"
        + "&paymentPolicy=NONE"
        + "&bestRateOnly=true";
    wireMockServer.stubFor(get(urlEqualTo(address))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBodyFile("hotel_offers_search_response_ok.json")));

    // ***** HERE *****
    List<String> ids = new ArrayList<String>();
    ids.add("MCLONGHM");
    ids.add("WIMAD079");
    String idsToStr1 = String.join(",", ids);
    // String idsToStr2 = ids.stream().map(String::valueOf).collect(Collectors.joining(","));

    //When
    HotelOfferSearch[] result = amadeus.shopping.hotelOffersSearch.get(
      Params.with("hotelIds", idsToStr1) // ***** HERE *****
        .and("adults", 1)
        .and("checkInDate", "2022-11-22")
        .and("roomQuantity", 1)
        .and("paymentPolicy", "NONE")
        .and("bestRateOnly", true)
    );

    //Then
    then(result.length).isNotEqualTo(0);
  }
}
