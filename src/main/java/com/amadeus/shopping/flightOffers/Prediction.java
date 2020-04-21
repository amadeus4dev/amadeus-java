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
 * <code>/v2/shopping/flight-offers/prediction</code> endpoints.
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
   * This Machine Learning API is based on a prediction model that takes the response of a flight
   * search as input (Flight Offers Search) and predicts, for each itinerary, the probability to
   * be selected.
   * </p>
   *
   * <pre>
   * amadeus.shopping.flightOffers.prediction.post(body);</pre>
   *
   * @param body the parameters to send to the API as a JSonObject
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public FlightOfferSearch[] post(JsonObject body) throws ResponseException {
    Response response = client.post("/v2/shopping/flight-offers/prediction", body);
    return (FlightOfferSearch[]) Resource.fromArray(response, FlightOfferSearch[].class);
  }

  /**
   * <p>
   * This machine learning API is based on a prediction model that takes the response of a flight
   * search as input (Flight Offers Search) and predicts, for each itinerary, the probability to
   * be selected.
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
    Response response = client.post("/v2/shopping/flight-offers/prediction", body);
    return (FlightOfferSearch[]) Resource.fromArray(response, FlightOfferSearch[].class);
  }

  /**
   * Convenience method for calling <code>post</code> without any parameters.
   *
   * @see Prediction#post()
   */
  public FlightOfferSearch[] post() throws ResponseException {
    return post((String) null);
  }
}
