package com.amadeus.booking;

import com.amadeus.Amadeus;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.FlightOrder;
import com.amadeus.resources.FlightOrder.Traveler;
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
 * <code>/v1/booking/flight-orders</code> endpoints.
 * </p>
 *
 * <p>
 * Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder(API_KEY, API_SECRET).build();
 * amadeus.booking.flightOrders;</pre>
 */
public class FlightOrders {
  private Amadeus client;
  private final String flightOrdersUrl = "/v1/booking/flight-orders";

  /**
   * Constructor.
   *
   * @hide
   */
  public FlightOrders(Amadeus client) {
    this.client = client;
  }

  /**
   * Build the JSON from the Travelers array.
   *
   * @param travelers array of Traveler
   * @return
   */
  private JsonArray buildTravelersJSON(Traveler[] travelers) {
    Gson gson = new GsonBuilder().create();
    JsonArray travelerArray = new JsonArray();

    for (int i = 0; i < travelers.length; i++) {
      JsonElement traveler = gson.toJsonTree(travelers[i], Traveler.class);
      travelerArray.add(traveler);
    }
    return travelerArray;
  }

  /**
   * Build the JSON from the Travelers array.
   *
   * @param flightOffers Array of FlightOfferSearch
   * @return JsonArray of the flightOffers
   */
  private JsonArray buildFlightOffersJSON(FlightOfferSearch[] flightOffers) {
    Gson gson = new GsonBuilder().create();
    JsonArray flightOffersArray = new JsonArray();

    for (int i = 0; i < flightOffers.length; i++) {
      JsonElement flightOffer = gson.toJsonTree(flightOffers[i], FlightOfferSearch.class);
      flightOffersArray.add(flightOffer);
    }
    return flightOffersArray;
  }


  /**
   * <p>
   * The Flight Create Orders API allows you to perform flight booking.
   * </p>
   *
   * <pre>
   * amadeus.booking.flightOrders.post(body);</pre>
   *
   * @param body the parameters to send to the API as a JSonObject
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public FlightOrder post(JsonObject body) throws ResponseException {
    Response response = client.post(flightOrdersUrl, body);
    return (FlightOrder) Resource.fromObject(response, FlightOrder.class);
  }

  /**
   * <p>
   * The Flight Create Orders API allows you to perform flight booking.
   * </p>
   *
   * <pre>
   * amadeus.booking.flightOrders.post(body);</pre>
   *
   * @param body the parameters to send to the API as a String
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public FlightOrder post(String body) throws ResponseException {
    Response response = client.post(flightOrdersUrl, body);
    return (FlightOrder) Resource.fromObject(response, FlightOrder.class);
  }

  /**
   * <p>
   * The Flight Create Orders API allows you to perform flight booking.
   * </p>
   *
   * <pre>
   * amadeus.booking.flightOrders.post(object);</pre>
   *
   * @param flightOffersSearches List of flight-offers as FlightOfferSearch[]
   * @param travelers            List of travelers as Traveler[]
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public FlightOrder post(FlightOfferSearch[] flightOffersSearches,
                          Traveler[] travelers) throws ResponseException {

    JsonObject typeObject = new JsonObject();
    typeObject.addProperty("type", "flight-order");

    // Prepare the Flight Offers JSON
    JsonArray flightOffersArray = buildFlightOffersJSON(flightOffersSearches);
    typeObject.add("flightOffers", flightOffersArray);

    // Prepare the TravelerJSON
    JsonArray travelerArray = buildTravelersJSON(travelers);
    typeObject.add("travelers", travelerArray);

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("data", typeObject);

    Response response = client.post(flightOrdersUrl, jsonObject);
    return (FlightOrder) Resource.fromObject(response, FlightOrder.class);
  }

  /**
   * <p>
   * The Flight Create Orders API allows you to perform flight booking.
   * </p>
   *
   * <pre>
   * amadeus.booking.flightOrders.post(flightOfferSearch, traveler);</pre>
   *
   * @param flightOffersSearch a flight-offer as FlightOfferSearch
   * @param travelers          List of travelers as Traveler[]
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public FlightOrder post(FlightOfferSearch flightOffersSearch,
                          Traveler[] travelers) throws ResponseException {
    FlightOfferSearch[] flightOffersSearchArray = new FlightOfferSearch[1];
    flightOffersSearchArray[0] = flightOffersSearch;

    return post(flightOffersSearchArray, travelers);
  }

  /**
   * <p>
   * The Flight Create Orders API allows you to perform flight booking.
   * </p>
   *
   * <pre>
   * amadeus.booking.flightOrders.post(flightOfferSearch, traveler);</pre>
   *
   * @param flightPrice a flight-offers-pricing as FlightPrice
   * @param travelers   List of travelers as Traveler[]
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public FlightOrder post(FlightPrice flightPrice,
                          Traveler[] travelers) throws ResponseException {

    JsonObject typeObject = new JsonObject();
    typeObject.addProperty("type", "flight-order");

    JsonArray flightOffersArray = buildFlightOffersJSON(flightPrice.getFlightOffers());
    typeObject.add("flightOffers", flightOffersArray);

    // Build Traveler JSON
    JsonArray travelerArray = buildTravelersJSON(travelers);
    typeObject.add("travelers", travelerArray);

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("data", typeObject);

    Response response = client.post(flightOrdersUrl, jsonObject);
    return (FlightOrder) Resource.fromObject(response, FlightOrder.class);
  }

  /**
   * Convenience method for calling <code>post</code> without any parameters.
   *
   * @see FlightOrders#post()
   */
  public FlightOrder post() throws ResponseException {
    return post((String) null);
  }
}
