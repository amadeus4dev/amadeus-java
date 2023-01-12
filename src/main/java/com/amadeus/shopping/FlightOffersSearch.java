package com.amadeus.shopping;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.Resource;
import com.amadeus.shopping.flightOffers.Pricing;
import com.google.gson.JsonObject;

/**
 * <p>
 * A namespaced client for the
 * <code>/v2/shopping/flight-offers</code> endpoints.
 * </p>
 *
 * <p>
 * Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder(API_KEY, API_SECRET).build();
 * amadeus.shopping.flightOffersSearch;</pre>
 */
public class FlightOffersSearch {
  private Amadeus client;
  public Pricing pricing;
  private final static String flightOffersUrl = "/v2/shopping/flight-offers";

  /**
   * Constructor.
   *
   * @hide
   */
  public FlightOffersSearch(Amadeus client) {
    this.client = client;
    this.pricing = new Pricing(client);
  }

  /**
   * <p>
   * The Flight Offers Search API allows to get cheapest flight recommendations on a given journey.
   * It provides a list of flight recommendations and fares from a given origin,
   * for a given date and for a given list of passengers.
   * Additional information such as bag allowance,
   * first ancillary bag prices or fare details are also provided.
   * </p>
   *
   * <pre>
   * amadeus.shopping.flightOffersSearch.get(params);</pre>
   *
   * @param params the parameters to send to the API
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public FlightOfferSearch[] get(Params params) throws ResponseException {
    Response response = client.get(flightOffersUrl, params);
    return (FlightOfferSearch[]) Resource.fromArray(response, FlightOfferSearch[].class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see FlightOffersSearch#get()
   */
  public FlightOfferSearch[] get() throws ResponseException {
    return get(null);
  }

  /**
   * <p>
   * The Flight Offers Search API allows to get cheapest flight recommendations on a given journey.
   * It provides a list of flight recommendations and fares from a given origin,
   * for a given date and for a given list of passengers.
   * Additional information such as bag allowance,
   * first ancillary bag prices or fare details are also provided.
   * </p>
   *
   * <pre>
   * amadeus.shopping.flightOffersSearch.post(body);</pre>
   *
   * @param body the parameters to send to the API as a JSonObject
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public FlightOfferSearch[] post(JsonObject body) throws ResponseException {
    Response response = client.post(flightOffersUrl, body);
    return (FlightOfferSearch[]) Resource.fromArray(response, FlightOfferSearch[].class);
  }

  /**
   * <p>
   * The Flight Offers Search API allows to get cheapest flight recommendations on a given journey.
   * It provides a list of flight recommendations and fares from a given origin,
   * for a given date and for a given list of passengers.
   * Additional information such as bag allowance,
   * first ancillary bag prices or fare details are also provided.
   * </p>
   *
   * <pre>
   * amadeus.shopping.flightOffers.prediction.post(body);</pre>
   *
   * @param body the parameters to send to the API as a String
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public FlightOfferSearch[] post(String body) throws ResponseException {
    Response response = client.post(flightOffersUrl, body);
    return (FlightOfferSearch[]) Resource.fromArray(response, FlightOfferSearch[].class);
  }

  /**
   * Convenience method for calling <code>post</code> without any parameters.
   *
   * @see FlightOffersSearch#post()
   */
  public FlightOfferSearch[] post() throws ResponseException {
    return post((String) null);
  }
}
