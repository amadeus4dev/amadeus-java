package com.amadeus.shopping.flightOffers;

import com.amadeus.Amadeus;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.Resource;
import com.google.gson.JsonObject;

/**
 * <p>
 * A namespaced client for the
 * <code>/v1/shopping/availability/flight-availabilities</code> endpoints.
 * </p>
 *
 * <p>
 * Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder(API_KEY, API_SECRET).build();
 * amadeus.shopping.availability.flightOffers.upselling;</pre>
 */
public class Upselling {

  private Amadeus client;

  /**
   * Constructor.
   *
   * @hide
   */
  public Upselling(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   * Branded Fares Upsell API is easily integrated into the Amadeus REST/JSON flight booking engine
   * and provides branded fare options for flights returned by the Flight Offers Search API.
   * </p>
   *
   * <pre>
   * amadeus.shopping.flightOffers.upselling.post(body);</pre>
   *
   * @param body the parameters to send to the API as a JSonObject
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public FlightOfferSearch[] post(JsonObject body) throws ResponseException {
    Response response = client.post("/v1/shopping/flight-offers/upselling", body);
    return (FlightOfferSearch[]) Resource.fromArray(response, FlightOfferSearch.class);
  }

  /**
   * <p>
   * Branded Fares Upsell API is easily integrated into the Amadeus REST/JSON flight booking engine
   * and provides branded fare options for flights returned by the Flight Offers Search API.
   * </p>
   *
   * <pre>
   * amadeus.shopping.flightOffers.upselling.post(body);</pre>
   *
   * @param body the parameters to send to the API as a String
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public FlightOfferSearch[] post(String body) throws ResponseException {
    Response response = client.post("/v1/shopping/flight-offers/upselling", body);
    return (FlightOfferSearch[]) Resource.fromArray(response, FlightOfferSearch[].class);
  }

  /**
   * Convenience method for calling <code>post</code> without any parameters.
   *
   * @see Upselling#post()
   */
  public FlightOfferSearch[] post() throws ResponseException {
    return post((String) null);
  }

}
