package com.amadeus.airport;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Destination;
import com.amadeus.resources.Resource;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/airport/direct-destinations</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.airport.directDestinations;</pre>
 */
public class DirectDestinations {
  private final Amadeus client;

  /**
   * Constructor.
   * @hide
   */
  public DirectDestinations(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   *    Find all destinations served by a given airport.
   * </p>
   *
   * <pre>
   * amadeus.airport.directDestinations.get(Params.with("departureAirportCode", "MAD").and("max","2"));
   * </pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public Destination[] get(Params params) throws ResponseException {
    Response response = client.get("/v1/airport/direct-destinations", params);
    return (Destination[]) Resource.fromArray(response, Destination[].class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see DirectDestinations#get()
   */
  public Destination[] get() throws ResponseException {
    return get(null);
  }
}
