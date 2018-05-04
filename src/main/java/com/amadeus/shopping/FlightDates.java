package com.amadeus.shopping;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/shopping/flight-dates</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.shopping.flightDates;</pre>
 */
public class FlightDates {
  private Amadeus client;

  /**
   * Constructor.
   * @hide
   */
  public FlightDates(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   *   Find the cheapest flight dates from an
   *   origin to a destination.
   * </p>
   *
   * <pre>
   * amadeus.shopping.flightDates.get(Params
   *   .with("origin", "LHR")
   *   .and("destination", "PAR"));</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public Response get(Params params) throws ResponseException {
    return client.get("/v1/shopping/flight-dates", params);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see FlightDates#get()
   */
  public Response get() throws ResponseException {
    return get(null);
  }
}
