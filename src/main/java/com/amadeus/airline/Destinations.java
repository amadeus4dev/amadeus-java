package com.amadeus.airline;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Destination;
import com.amadeus.resources.Resource;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/airline/destinations</code> endpoint.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.airline.destinations;</pre>
 */
public class Destinations {
  private Amadeus client;

  /**
   * Constructor.
   * @hide
   */
  public Destinations(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   *    Get airline destinations.
   * </p>
   *
   * <pre>
   * amadeus.airline.destinations.get(Params
   *     .with("airlineCode", "BA")
   *     .and("max", 2));
   * </pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public Destination[] get(Params params) throws ResponseException {
    Response response = client.get("/v1/airline/destinations", params);
    return (Destination[]) Resource.fromArray(response, Destination[].class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see Destinations#get()
   */
  public Destination[] get() throws ResponseException {
    return get(null);
  }
}
