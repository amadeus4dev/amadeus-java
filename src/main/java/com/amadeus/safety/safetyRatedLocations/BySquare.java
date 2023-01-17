package com.amadeus.safety.safetyratedlocations;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Resource;
import com.amadeus.resources.SafePlace;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/safety/safety-rated-locations/by-square</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.safety.safetyRatedLocations.bySquare;</pre>
 */
public class BySquare {
  private Amadeus client;

  /**
   * Constructor.
   * @hide
   */
  public BySquare(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   *   Returns a list of safety information within a square defined by
   *   cardinal points.
   * </p>
   *
   * <pre>
   * amadeus.safety.safetyRatedLocations.bySquare.get(Params
   *   .with("north", 41.397158)
   *   .and("west", 2.160873)
   *   .and("south", 41.394582)
   *   .and("east", 2.177181));</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public SafePlace[] get(Params params) throws ResponseException {
    Response response = client.get("/v1/safety/safety-rated-locations/by-square", params);
    return (SafePlace[]) Resource.fromArray(response, SafePlace[].class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see SafetyRatedLocations#get()
   */
  public SafePlace[] get() throws ResponseException {
    return get(null);
  }
}
