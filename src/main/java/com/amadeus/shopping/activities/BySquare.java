package com.amadeus.shopping.activities;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Activity;
import com.amadeus.resources.Resource;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/shopping/activities/by-square</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.shopping.activities.bySquare;</pre>
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
   *   Returns a list of activities within a square defined by
   *   cardinal points.
   * </p>
   *
   * <pre>
   * amadeus.shopping.activities.bySquare.get(Params
   *   .with("north", 41.397158)
   *   .and("west", 2.160873)
   *   .and("south", 41.394582)
   *   .and("east", 2.177181));</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public Activity[] get(Params params) throws ResponseException {
    Response response = client.get("/v1/shopping/activities/by-square", params);
    return (Activity[]) Resource.fromArray(response, Activity[].class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see Activities#get()
   */
  public Activity[] get() throws ResponseException {
    return get(null);
  }
}
