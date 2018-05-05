package com.amadeus.shopping;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightDestination;
import com.amadeus.resources.Resource;
import com.google.gson.Gson;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/shopping/flight-destinations</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.shopping.flightDestinations;</pre>
 */
public class FlightDestinations {
  private Amadeus client;

  /**
   * Constructor.
   * @hide
   */
  public FlightDestinations(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   *   Find the cheapest destinations where
   *   you can fly to.
   * </p>
   *
   * <pre>
   * amadeus.shopping.flightDestinations.get(Params
   *   .with("origin", "LHR"));</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public FlightDestination[] get(Params params) throws ResponseException {
    Response response = client.get("/v1/shopping/flight-destinations", params);
    return (FlightDestination[]) Resource.fromArray(response, FlightDestination[].class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see FlightDestinations#get()
   */
  public FlightDestination[] get() throws ResponseException {
    return get(null);
  }
}
