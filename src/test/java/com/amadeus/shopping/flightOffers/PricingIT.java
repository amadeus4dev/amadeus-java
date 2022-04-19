package com.amadeus.shopping.flightOffers;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.BDDAssertions.then;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.FlightPayment;
import com.amadeus.resources.FlightPrice;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PricingIT {

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
  public void given_client_when_call_create_flight_order_with_params_then_ok()
      throws ResponseException, IOException {

    //Given
    String address = "/v1/shopping/flight-offers/pricing?include=detailed-fare-rules";
    wireMockServer.stubFor(post(urlEqualTo(address))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBodyFile("flight_search_offer_pricing_response_ok.json")));

    JsonObject request = getRequestFromResources("flight_search_offer_response_ok.json");

    Gson gson = new Gson();
    FlightOfferSearch flightOffersSearches = gson.fromJson(request.toString(),
        FlightOfferSearch.class);
    Params params = Params.with("include", "detailed-fare-rules");

    //When
    FlightPrice result = amadeus.shopping.flightOffersSearch.pricing.post(
        flightOffersSearches, params);

    //Then
    then(result).isNotNull();
  }

  @Test
  public void given_client_when_call_create_flight_order_with_params_then_ok5()
      throws ResponseException, IOException {

    //Given
    String address = "/v1/shopping/flight-offers/pricing?include=detailed-fare-rules";
    wireMockServer.stubFor(post(urlEqualTo(address))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBodyFile("flight_search_offer_pricing_response_ok.json")));

    JsonObject request = getRequestFromResources("flight_search_offer_response_ok.json");

    Gson gson = new Gson();
    FlightOfferSearch flightOffersSearches = gson.fromJson(request.toString(),
        FlightOfferSearch.class);
    Params params = Params.with("include", "detailed-fare-rules");
    FlightOfferSearch[] array = new FlightOfferSearch[1];
    array[0] = flightOffersSearches;

    //When
    FlightPrice result = amadeus.shopping.flightOffersSearch.pricing.post(
        array, params);

    //Then
    then(result).isNotNull();
  }

  @Test
  public void given_client_when_call_create_flight_order_with_params_then_ok2()
      throws ResponseException, IOException {

    //Given
    String address = "/v1/shopping/flight-offers/pricing";
    wireMockServer.stubFor(post(urlEqualTo(address))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBodyFile("flight_search_offer_pricing_response_ok.json")));

    JsonObject request = getRequestFromResources("flight_search_offer_response_ok.json");

    //When
    FlightPrice result = amadeus.shopping.flightOffersSearch.pricing.post(request);

    //Then
    then(result).isNotNull();
  }

  @Test
  public void given_client_when_call_create_flight_order_with_params_then_ok3()
      throws ResponseException, IOException {

    //Given
    String address = "/v1/shopping/flight-offers/pricing?include=detailed-fare-rules";
    wireMockServer.stubFor(post(urlEqualTo(address))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBodyFile("flight_search_offer_pricing_response_ok.json")));

    JsonObject request = getRequestFromResources("flight_search_offer_response_ok.json");
    Params params = Params.with("include", "detailed-fare-rules");

    //When
    FlightPrice result = amadeus.shopping.flightOffersSearch.pricing.post(request, params);

    //Then
    then(result).isNotNull();
  }

  @Test
  public void given_client_when_call_create_flight_order_with_params_then_ok4()
      throws ResponseException, IOException {

    //Given
    String address = "/v1/shopping/flight-offers/pricing?include=detailed-fare-rules";
    wireMockServer.stubFor(post(urlEqualTo(address))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBodyFile("flight_search_offer_pricing_response_ok.json")));

    JsonObject request = getRequestFromResources("flight_search_offer_response_ok.json");
    Params params = Params.with("include", "detailed-fare-rules");

    //When
    FlightPrice result = amadeus.shopping.flightOffersSearch.pricing.post(
        request.toString(), params);

    //Then
    then(result).isNotNull();
  }

  @Test
  public void given_client_when_call_create_flight_order_with_params_then_ok6()
      throws ResponseException, IOException {

    //Given
    String address = "/v1/shopping/flight-offers/pricing";
    wireMockServer.stubFor(post(urlEqualTo(address))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBodyFile("flight_search_offer_pricing_response_ok.json")));

    JsonObject request = getRequestFromResources("flight_search_offer_response_ok.json");

    Gson gson = new Gson();
    FlightOfferSearch flightOffersSearches = gson.fromJson(request.toString(),
        FlightOfferSearch.class);
    FlightOfferSearch[] array = new FlightOfferSearch[1];
    array[0] = flightOffersSearches;

    //TODO: This object has a design issue
    JsonObject request2 = getRequestFromResources("flightPayment_ok.json");
    FlightPayment flightPayment = gson.fromJson(request2.toString(),
        FlightPayment.class);

    //When
    FlightPrice result = amadeus.shopping.flightOffersSearch.pricing.post(
        array, flightPayment);

    //Then
    then(result).isNotNull();
  }

  @Test
  public void given_client_when_call_create_flight_order_with_params_then_ok7()
      throws ResponseException, IOException {

    //Given
    String address = "/v1/shopping/flight-offers/pricing";
    wireMockServer.stubFor(post(urlEqualTo(address))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBodyFile("flight_search_offer_pricing_response_ok.json")));

    JsonObject request = getRequestFromResources("flight_search_offer_response_ok.json");

    Gson gson = new Gson();
    FlightOfferSearch flightOffersSearch = gson.fromJson(request.toString(),
        FlightOfferSearch.class);

    //TODO: This object has a design issue
    JsonObject request2 = getRequestFromResources("flightPayment_ok.json");
    FlightPayment flightPayment = gson.fromJson(request2.toString(),
        FlightPayment.class);

    //When
    FlightPrice result = amadeus.shopping.flightOffersSearch.pricing.post(
        flightOffersSearch, flightPayment);

    //Then
    then(result).isNotNull();
  }

  private JsonObject getRequestFromResources(String jsonFile) throws IOException {

    final String folder = "__files/";

    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource(folder + jsonFile).getFile());
    String jsonString = new String(Files.readAllBytes(file.toPath()));

    return new JsonParser().parse(jsonString).getAsJsonObject();
  }

}
