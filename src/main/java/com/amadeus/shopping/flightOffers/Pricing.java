package com.amadeus.shopping.flightOffers;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.FlightPayment;
import com.amadeus.resources.FlightPrice;
import com.amadeus.resources.Resource;
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

  /**
   * Constructor.
   *
   * @hide
   */
  public Pricing(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   * The Flight Offers Price API allows the user to get or confirm the price of a flight
   *  and obtain information about taxes and fees to be applied to the entire journey.
   *  It is usually used after the Flight Offers Search API.
   *  It also retrieves ancillary information and the payment information details.
   * </p>
   *
   * <pre>
   * amadeus.shopping.flightOffers.pricing.post(body, params);</pre>
   *
   * @param body JSON body of flight-offers as JsonObject to price
   * @param params URL parameters such as include or forceClass
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public FlightPrice post(JsonObject body, Params params) throws ResponseException {
    Response response = client.post("/v1/shopping/flight-offers/pricing", params, body);
    return (FlightPrice) Resource.fromObject(response, FlightPrice.class);
  }

  /**
   * <p>
   * The Flight Offers Price API allows the user to get or confirm the price of a flight
   *  and obtain information about taxes and fees to be applied to the entire journey.
   *  It is usually used after the Flight Offers Search API.
   *  It also retrieves ancillary information and the payment information details.
   * </p>
   *
   * <pre>
   * amadeus.shopping.flightOffersSearch.pricing.post(body, params);</pre>
   *
   * @param body JSON body of flight-offers as String to price
   * @param params URL parameters such as include or forceClass
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public FlightPrice post(String body, Params params) throws ResponseException {
    Response response = client.post("/v1/shopping/flight-offers/pricing", params, body);
    return (FlightPrice) Resource.fromObject(response, FlightPrice.class);
  }

  /**
   * <p>
   * The Flight Offers Price API allows the user to get or confirm the price of a flight
   *  and obtain information about taxes and fees to be applied to the entire journey.
   *  It is usually used after the Flight Offers Search API.
   *  It also retrieves ancillary information and the payment information details.
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
    Response response = client.post("/v1/shopping/flight-offers/pricing", body);
    return (FlightPrice) Resource.fromObject(response, FlightPrice.class);
  }

  /**
   * <p>
   * The Flight Offers Price API allows the user to get or confirm the price of a flight
   *  and obtain information about taxes and fees to be applied to the entire journey.
   *  It is usually used after the Flight Offers Search API.
   *  It also retrieves ancillary information and the payment information details.
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
    Response response = client.post("/v1/shopping/flight-offers/pricing", body);
    return (FlightPrice) Resource.fromObject(response, FlightPrice.class);
  }

  /**
   * <p>
   * The Flight Offers Price API allows the user to get or confirm the price of a flight
   *  and obtain information about taxes and fees to be applied to the entire journey.
   *  It is usually used after the Flight Offers Search API.
   *  It also retrieves ancillary information and the payment information details.
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
    JsonObject typeObject = new JsonObject();
    typeObject.addProperty("type", "flight-offers-pricing");
    typeObject.add("flightOffers", flightOffersSearches[0].getResponse().getData());

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("data", typeObject);

    Response response = client.post("/v1/shopping/flight-offers/pricing", jsonObject);
    return (FlightPrice) Resource.fromObject(response, FlightPrice.class);
  }

  /**
   * <p>
   * The Flight Offers Price API allows the user to get or confirm the price of a flight
   *  and obtain information about taxes and fees to be applied to the entire journey.
   *  It is usually used after the Flight Offers Search API.
   *  It also retrieves ancillary information and the payment information details.
   * </p>
   *
   * <pre>
   * amadeus.shopping.flightOffersSearch.pricing.post(flightOffersSearches);</pre>
   *
   * @param flightOffersSearches List of flight-offers as FlightOfferSearch[] object to price
   * @param params URL parameters such as include or forceClass
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public FlightPrice post(FlightOfferSearch[] flightOffersSearches,
                          Params params) throws ResponseException {
    JsonObject typeObject = new JsonObject();
    typeObject.addProperty("type", "flight-offers-pricing");
    typeObject.add("flightOffers", flightOffersSearches[0].getResponse().getData());

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("data", typeObject);

    Response response = client.post(
            "/v1/shopping/flight-offers/pricing", params, jsonObject);
    return (FlightPrice) Resource.fromObject(response, FlightPrice.class);
  }

  /**
   * <p>
   * The Flight Offers Price API allows the user to get or confirm the price of a flight
   *  and obtain information about taxes and fees to be applied to the entire journey.
   *  It is usually used after the Flight Offers Search API.
   *  It also retrieves ancillary information and the payment information details.
   * </p>
   *
   * <pre>
   * amadeus.shopping.flightOffersSearch.pricing.post(flightOffersSearches);</pre>
   *
   * @param flightOffersSearches List of flight-offers as FlightOfferSearch[] object to price
   * @param flightPayment List of flight-offers as FlightOfferSearch[] object to price
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public FlightPrice post(FlightOfferSearch[] flightOffersSearches,
                          FlightPayment flightPayment) throws ResponseException {
    JsonObject typeObject = new JsonObject();
    typeObject.addProperty("type", "flight-offers-pricing");
    typeObject.add("flightOffers", flightOffersSearches[0].getResponse().getData());

    JsonObject paymentObject = new JsonObject();
    paymentObject.addProperty("brand", flightPayment.getBrand().toString());
    paymentObject.addProperty("binNumber", flightPayment.getBinNumber().toString());
    paymentObject.addProperty("flightOffersIds", flightPayment.getFlightOfferIds().toString());

    typeObject.add("payment", flightOffersSearches[0].getResponse().getData());

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("data", typeObject);

    Response response = client.post("/v1/shopping/flight-offers/pricing", jsonObject);
    return (FlightPrice) Resource.fromObject(response, FlightPrice.class);
  }

  public FlightPrice post() throws ResponseException {
    return post((String) null);
  }
}
