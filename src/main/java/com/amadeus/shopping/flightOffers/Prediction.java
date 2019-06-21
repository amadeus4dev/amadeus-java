package com.amadeus.shopping.flightOffers;

import com.amadeus.Amadeus;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOffer;
import com.amadeus.resources.Resource;

import com.google.gson.JsonObject;





/**
 * <p>
 * A namespaced client for the
 * <code>/v1/shopping/flight-offers/prediction</code> endpoints.
 * </p>
 *
 * <p>
 * Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder(API_KEY, API_SECRET).build();
 * amadeus.shopping.flightOffers.prediction;</pre>
 */
public class Prediction {

  private Amadeus client;

  /**
   * Constructor.
   *
   * @hide
   */
  public Prediction(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   * This machine learning API is based on a prediction model that takes the response of a flight
   * search as input (Flight Low-fare Search) and predict, for each itinerary, the probably for a
   * travel to select it.
   * </p>
   *
   * <pre>
   * amadeus.shopping.flightOffers.prediction.post(body);</pre>
   *
   * @param body the parameters to send to the API as a JSonObject
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public FlightOffer[] post(JsonObject body) throws ResponseException {
    Response response = client.post("/v1/shopping/flight-offers/prediction", body);
    return (FlightOffer[]) Resource.fromArray(response, FlightOffer[].class);
  }

  /**
   * <p>
   * This machine learning API is based on a prediction model that takes the response of a flight
   * search as input (Flight Low-fare Search) and predict, for each itinerary, the probably for a
   * travel to select it.
   * </p>
   *
   * <pre>
   * amadeus.shopping.flightOffers.prediction.post(body);</pre>
   *
   * @param body the parameters to send to the API as a String
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public FlightOffer[] post(String body) throws ResponseException {
    Response response = client.post("/v1/shopping/flight-offers/prediction", body);
    return (FlightOffer[]) Resource.fromArray(response, FlightOffer[].class);
  }

  /**
   * Convenience method for calling <code>post</code> without any parameters.
   *
   * @see Prediction#post()
   */
  public FlightOffer[] post() throws ResponseException {
    return post((String) null);
  }
}
