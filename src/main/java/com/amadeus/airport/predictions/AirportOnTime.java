package com.amadeus.airport.predictions;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.OnTime;
import com.amadeus.resources.Resource;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/airport/predictions/on-time</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.airport.predictions.onTime;</pre>
 */
public class AirportOnTime {
  private Amadeus client;

  /**
   * Constructor.
   * @hide
   */
  public AirportOnTime(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   *   Returns a percentage of on-time flight from a given airport.
   * </p>
   *
   * <pre>
   * OnTime airportOnTime = amadeus.airport.predictions.onTime.get(Params
   *     .with("airportCode", "NCE")
   *     .and("date", "2020-09-01"));
   * </pre>
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public OnTime get(Params params) throws ResponseException {
    Response response = client.get("/v1/airport/predictions/on-time", params);
    return (OnTime) Resource.fromObject(response, OnTime.class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see AirportOnTime#get()
   */
  public OnTime get() throws ResponseException {
    return get(null);
  }
}