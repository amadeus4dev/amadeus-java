package com.amadeus.safety;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Resource;
import com.amadeus.resources.SafePlace;
import com.amadeus.safety.safetyRatedLocations.BySquare;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/safety/safety-rated-locations</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.safety.safetyRatedLocations;</pre>
 */
public class SafetyRatedLocations {
  private Amadeus client;


  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/safety/safety-rated-locations/by-square</code> endpoints.
   * </p>
   */
  public BySquare bySquare;

  /**
   * Constructor.
   * @hide
   */
  public SafetyRatedLocations(Amadeus client) {
    this.client = client;
    this.bySquare = new BySquare(client);
  }


  /**
   * <p>
   *   Returns a list of safety information near to a given point.
   * </p>
   *
   * <pre>
   * amadeus.safety.safetyRatedLocations.get(Params
   *   .with("longitude", 2.160873)
   *   .and("latitude", 41.397158));</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public SafePlace[] get(Params params) throws ResponseException {
    Response response = client.get("/v1/safety/safety-rated-locations", params);
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
