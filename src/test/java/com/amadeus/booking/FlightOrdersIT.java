package com.amadeus.booking;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.BDDAssertions.then;

import com.amadeus.Amadeus;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.FlightOrder;
import com.amadeus.resources.FlightOrder.Contact;
import com.amadeus.resources.FlightOrder.Document;
import com.amadeus.resources.FlightOrder.Name;
import com.amadeus.resources.FlightOrder.Phone;
import com.amadeus.resources.FlightOrder.Traveler;
import com.amadeus.resources.FlightPrice;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//https://developers.amadeus.com/self-service/category/air/api-doc/flight-create-orders/api-reference
public class FlightOrdersIT {

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
  public void given_client_when_call_flight_offers_with_params_then_ok()
      throws ResponseException, IOException {

    //Given
    String address = "/v2/shopping/flight-offers"; //"/v1/shopping/flight-offers/pricing"; //
    wireMockServer.stubFor(post(urlEqualTo(address))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBodyFile("flight_search_offer_response_ok.json")));

    String address2 = "/v1/shopping/flight-offers/pricing";
    wireMockServer.stubFor(post(urlEqualTo(address2))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBodyFile("flight_search_offer_pricing_response_ok.json")));

    String address3 = "/v1/booking/flight-orders";
    wireMockServer.stubFor(post(urlEqualTo(address3))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBodyFile("flight_create_order_response.json")));

    Traveler[] travelerArray = getTravelerData();

    JsonObject request = getRequestFromResources("flight_search_offer_request_ok.json");

    FlightOfferSearch[] flightOffersSearches = amadeus.shopping.flightOffersSearch.post(request);

    // We price the 2nd flight of the list to confirm the price and the availability
    FlightPrice flightPricing = amadeus.shopping.flightOffersSearch.pricing.post(
        flightOffersSearches[1]);

    //When
    FlightOrder result = amadeus.booking.flightOrders.post(flightPricing, travelerArray);

    //Then
    then(result).isNotNull();
  }

  private Traveler[] getTravelerData() {
    Traveler traveler = new Traveler();

    traveler.setId("1");
    traveler.setDateOfBirth("2000-04-14");
    traveler.setName(new Name("JORGE", "GONZALES"));

    Phone[] phone = new Phone[1];
    phone[0] = new Phone();
    phone[0].setCountryCallingCode("33");
    phone[0].setNumber("675426222");

    Contact contact = new Contact();
    contact.setPhones(phone);
    traveler.setContact(contact);

    Document[] document = new Document[1];
    document[0] = new Document();
    document[0].setDocumentType("PASSPORT");
    document[0].setNumber("480080076");
    document[0].setExpiryDate("2022-10-11");
    document[0].setIssuanceCountry("ES");
    document[0].setNationality("ES");
    document[0].setHolder(true);
    traveler.setDocuments(document);

    Traveler[] travelerArray = new Traveler[1];
    return  travelerArray;
  }

  @Test
  public void given_client_when_call_flight_offers_with_params_alternative_2_then_ok()
      throws ResponseException, IOException {

    //Given
    String address = "/v2/shopping/flight-offers"; //"/v1/shopping/flight-offers/pricing"; //
    wireMockServer.stubFor(post(urlEqualTo(address))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBodyFile("flight_search_offer_response_ok.json")));

    String address3 = "/v1/booking/flight-orders";
    wireMockServer.stubFor(post(urlEqualTo(address3))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBodyFile("flight_create_order_response.json")));

    Traveler[] travellers = getTravelerData();

    JsonObject request = getRequestFromResources("flight_search_offer_request_ok.json");

    FlightOfferSearch[] flightOffersSearches = amadeus.shopping.flightOffersSearch.post(request);

    //When
    FlightOrder result = amadeus.booking.flightOrders.post(flightOffersSearches, travellers);

    //Then
    then(result).isNotNull();
  }

  @Test
  public void given_client_when_call_flight_offers_with_params_alternative_3_then_ok()
      throws ResponseException, IOException {

    //Given
    String address = "/v2/shopping/flight-offers"; //"/v1/shopping/flight-offers/pricing"; //
    wireMockServer.stubFor(post(urlEqualTo(address))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBodyFile("flight_search_offer_response_ok.json")));

    String address3 = "/v1/booking/flight-orders";
    wireMockServer.stubFor(post(urlEqualTo(address3))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBodyFile("flight_create_order_response.json")));

    Traveler[] travellers = getTravelerData();

    JsonObject request = getRequestFromResources("flight_search_offer_request_ok.json");

    FlightOfferSearch[] flightOffersSearches = amadeus.shopping.flightOffersSearch.post(request);

    //When
    FlightOrder result = amadeus.booking.flightOrders.post(flightOffersSearches[0], travellers);

    //Then
    then(result).isNotNull();
  }

  @Test
  public void given_client_when_call_flight_offers_with_params_alternative_4_then_ok()
      throws ResponseException, IOException {

    //Given
    String address = "/v1/booking/flight-orders";
    wireMockServer.stubFor(post(urlEqualTo(address))
        .willReturn(aResponse().withHeader("Content-Type", "application/json")
        .withStatus(200)
        .withBodyFile("flight_create_order_response.json")));

    JsonObject request = getRequestFromResources("flight_create_order_request.json");

    //When
    FlightOrder result = amadeus.booking.flightOrders.post(request);

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
