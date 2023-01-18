package com.amadeus.shopping.flightoffers;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.FlightPayment;
import com.amadeus.resources.FlightPrice;
import com.amadeus.resources.Resource;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * <p>
 * A namespaced client for the
 * <code>/v1/shopping/flight-offers/pricing</code> endpoints.
 * </p>
 *
 * <p>
 * Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder(API_KEY, API_SECRET).build();
 * amadeus.shopping.flightOffers.pricing;</pre>
 */
public class Pricing {

  private Amadeus client;
  private static final String PRICING_URL = "/v1/shopping/flight-offers/pricing";

  /**
   * Constructor.
   *
   * @hide
   */
  public Pricing(Amadeus client) {
    this.client = client;
  }

  /**
   * Build the FlightOffers JSON.
   * @param flightOffersSearches list of FlightOfferSearch to price
   * @return a JsonArray representation of the object FlightOffersSearch
   */
  private JsonArray buildFlightOffersJSON(FlightOfferSearch[] flightOffersSearches) {
    Gson gson = new GsonBuilder().create();
    JsonArray flightOffersArray = new JsonArray();
    // Add each flightOffersSearch to the array
    for (int i = 0; i < flightOffersSearches.length; i++) {
      JsonElement flightOffer = gson.toJsonTree(flightOffersSearches[i], FlightOfferSearch.class);
      flightOffersArray.add(flightOffer);
    }
    return flightOffersArray;
  }

  /**
   * Build the Flight Payment JSON.
   * @param flightPayment FlightPayment information
   * @return JsonArray representation of the flightPayment
   */
  private JsonArray buildPaymentJSON(FlightPayment flightPayment) {
    Gson gson = new GsonBuilder().create();
    JsonArray paymentArray = new JsonArray();

    JsonElement payment = gson.toJsonTree(flightPayment, FlightPayment.class);
    paymentArray.add(payment);

    return paymentArray;
  }

  /**
   * <p>
   * The Flight Offers Price API allows the user to get or confirm the price of a flight
   * and obtain information about taxes and fees to be applied to the entire journey.
   * It is usually used after the Flight Offers Search API.
   * It also retrieves ancillary information and the payment information details.
   * </p>
   *
   * <pre>
   * amadeus.shopping.flightOffers.pricing.post(body, params);</pre>
   *
   * @param body   JSON body of flight-offers as JsonObject to price
   * @param params URL parameters such as include or forceClass
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public FlightPrice post(JsonObject body, Params params) throws ResponseException {
    Response response = client.post(PRICING_URL, params, body);
    return (FlightPrice) Resource.fromObject(response, FlightPrice.class);
  }

  /**
   * <p>
   * The Flight Offers Price API allows the user to get or confirm the price of a flight
   * and obtain information about taxes and fees to be applied to the entire journey.
   * It is usually used after the Flight Offers Search API.
   * It also retrieves ancillary information and the payment information details.
   * </p>
   *
   * <pre>
   * amadeus.shopping.flightOffersSearch.pricing.post(body, params);</pre>
   *
   * @param body   JSON body of flight-offers as String to price
   * @param params URL parameters such as include or forceClass
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public FlightPrice post(String body, Params params) throws ResponseException {
    Response response = client.post(PRICING_URL, params, body);
    return (FlightPrice) Resource.fromObject(response, FlightPrice.class);
  }

  /**
   * <p>
   * The Flight Offers Price API allows the user to get or confirm the price of a flight
   * and obtain information about taxes and fees to be applied to the entire journey.
   * It is usually used after the Flight Offers Search API.
   * It also retrieves ancillary information and the payment information details.
   * </p>
   *
   * <pre>
   * amadeus.shopping.flightOffersSearch.pricing.post(body);</pre>
   *
   * @param body JSON body of flight-offers as JsonObject to price
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public FlightPrice post(JsonObject body) throws ResponseException {
    Response response = client.post(PRICING_URL, body);
    return (FlightPrice) Resource.fromObject(response, FlightPrice.class);
  }

  /**
   * <p>
   * The Flight Offers Price API allows the user to get or confirm the price of a flight
   * and obtain information about taxes and fees to be applied to the entire journey.
   * It is usually used after the Flight Offers Search API.
   * It also retrieves ancillary information and the payment information details.
   * </p>
   *
   * <pre>
   * amadeus.shopping.flightOffersSearch.pricing.post(body);</pre>
   *
   * @param body JSON body of flight-offers as String to price
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public FlightPrice post(String body) throws ResponseException {
    Response response = client.post(PRICING_URL, body);
    return (FlightPrice) Resource.fromObject(response, FlightPrice.class);
  }

  /**
   * <p>
   * The Flight Offers Price API allows the user to get or confirm the price of a flight
   * and obtain information about taxes and fees to be applied to the entire journey.
   * It is usually used after the Flight Offers Search API.
   * It also retrieves ancillary information and the payment information details.
   * </p>
   *
   * <pre>
   * amadeus.shopping.flightOffersSearch.pricing.post(flightOffersSearches);</pre>
   *
   * @param flightOffersSearches List of flight-offers as FlightOfferSearch[] object to price
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public FlightPrice post(FlightOfferSearch[] flightOffersSearches) throws ResponseException {
    return post(flightOffersSearches, (Params) null);
  }

  /**
   * <p>
   * The Flight Offers Price API allows the user to get or confirm the price of a flight
   * and obtain information about taxes and fees to be applied to the entire journey.
   * It is usually used after the Flight Offers Search API.
   * It also retrieves ancillary information and the payment information details.
   * </p>
   *
   * <pre>
   * amadeus.shopping.flightOffersSearch.pricing.post(flightOffersSearches);</pre>
   *
   * @param flightOffersSearch a flight-offers as FlightOfferSearch object to price
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public FlightPrice post(FlightOfferSearch flightOffersSearch) throws ResponseException {
    FlightOfferSearch[] flightOffersSearchArray = new FlightOfferSearch[1];
    flightOffersSearchArray[0] = flightOffersSearch;

    return post(flightOffersSearchArray);
  }

  /**
   * <p>
   * The Flight Offers Price API allows the user to get or confirm the price of a flight
   * and obtain information about taxes and fees to be applied to the entire journey.
   * It is usually used after the Flight Offers Search API.
   * It also retrieves ancillary information and the payment information details.
   * </p>
   *
   * <pre>
   * amadeus.shopping.flightOffersSearch.pricing.post(flightOffersSearches);</pre>
   *
   * @param flightOffersSearches List of flight-offers as FlightOfferSearch[] object to price
   * @param params               URL parameters such as include or forceClass
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public FlightPrice post(FlightOfferSearch[] flightOffersSearches,
                          Params params) throws ResponseException {
    JsonObject typeObject = new JsonObject();
    typeObject.addProperty("type", "flight-offers-pricing");

    JsonArray flightOffersArray = buildFlightOffersJSON(flightOffersSearches);
    typeObject.add("flightOffers", flightOffersArray);

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("data", typeObject);

    Response response;

    // Is it a call with param or without param?
    if (params != null) {
      response = client.post(
        PRICING_URL, params, jsonObject);
    } else {
      response = client.post(PRICING_URL, jsonObject);
    }
    return (FlightPrice) Resource.fromObject(response, FlightPrice.class);
  }

  /**
   * <p>
   * The Flight Offers Price API allows the user to get or confirm the price of a flight
   * and obtain information about taxes and fees to be applied to the entire journey.
   * It is usually used after the Flight Offers Search API.
   * It also retrieves ancillary information and the payment information details.
   * </p>
   *
   * <pre>
   * amadeus.shopping.flightOffersSearch.pricing.post(flightOffersSearches);</pre>
   *
   * @param flightOffersSearch a flight-offers as FlightOfferSearch object to price
   * @param params             URL parameters such as include or forceClass
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public FlightPrice post(FlightOfferSearch flightOffersSearch,
                          Params params) throws ResponseException {
    FlightOfferSearch[] flightOffersSearchArray = new FlightOfferSearch[1];
    flightOffersSearchArray[0] = flightOffersSearch;

    return post(flightOffersSearchArray, params);
  }

  /**
   * <p>
   * The Flight Offers Price API allows the user to get or confirm the price of a flight
   * and obtain information about taxes and fees to be applied to the entire journey.
   * It is usually used after the Flight Offers Search API.
   * It also retrieves ancillary information and the payment information details.
   * </p>
   *
   * <pre>
   * amadeus.shopping.flightOffersSearch.pricing.post(flightOffersSearches);</pre>
   *
   * @param flightOffersSearches List of flight-offers as FlightOfferSearch[] object to price
   * @param flightPayment        payment information object
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public FlightPrice post(FlightOfferSearch[] flightOffersSearches,
                          FlightPayment flightPayment) throws ResponseException {
    JsonObject typeObject = new JsonObject();
    typeObject.addProperty("type", "flight-offers-pricing");

    typeObject.add("payment", buildPaymentJSON(flightPayment));

    JsonArray flightOffersArray = buildFlightOffersJSON(flightOffersSearches);
    typeObject.add("flightOffers", flightOffersArray);

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("data", typeObject);

    Response response = client.post(PRICING_URL, jsonObject);
    return (FlightPrice) Resource.fromObject(response, FlightPrice.class);
  }

  /**
   * <p>
   * The Flight Offers Price API allows the user to get or confirm the price of a flight
   * and obtain information about taxes and fees to be applied to the entire journey.
   * It is usually used after the Flight Offers Search API.
   * It also retrieves ancillary information and the payment information details.
   * </p>
   *
   * <pre>
   * amadeus.shopping.flightOffersSearch.pricing.post(flightOffersSearches);</pre>
   *
   * @param flightOffersSearch a flight-offers as FlightOfferSearch object to price
   * @param flightPayment      payment information object
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public FlightPrice post(FlightOfferSearch flightOffersSearch,
                          FlightPayment flightPayment) throws ResponseException {
    FlightOfferSearch[] flightOffersSearchArray = new FlightOfferSearch[1];
    flightOffersSearchArray[0] = flightOffersSearch;

    return post(flightOffersSearchArray, flightPayment);
  }

  public FlightPrice post() throws ResponseException {
    return post((String) null);
  }
}
