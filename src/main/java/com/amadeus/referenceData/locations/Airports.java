package com.amadeus.referenceData.locations;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/reference-data/locations/airports</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.referenceData.locations.airports;</pre>
 */
public class Airports {
  private Amadeus client;

  /**
   * Constructor.
   * @hide
   */
  public Airports(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   *   Returns a list of relevant airports near to a given point.
   * </p>
   *
   * <pre>
   * amadeus.referenceData.locations.airports.get(Params
   *   .with("longitude", 49.0000)
   *   .and("latitude", 2.55));</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public Response get(Params params) throws ResponseException {
    return client.get("/v1/reference-data/locations/airports", params);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see Airports#get()
   */
  public Response get() throws ResponseException {
    return get(null);
  }
}
