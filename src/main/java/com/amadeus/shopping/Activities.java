package com.amadeus.shopping;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Activity;
import com.amadeus.resources.Resource;
import com.amadeus.shopping.activities.BySquare;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/shopping/activities</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.shopping.activities;</pre>
 */
public class Activities {
  private Amadeus client;


  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/shopping/activities/by-square</code> endpoints.
   * </p>
   */
  public BySquare bySquare;

  /**
   * Constructor.
   * @hide
   */
  public Activities(Amadeus client) {
    this.client = client;
    this.bySquare = new BySquare(client);
  }


  /**
   * <p>
   *   Returns a list of activities near to a given point.
   * </p>
   *
   * <pre>
   * amadeus.amadeus.shopping.activities.get(Params
   *   .with("longitude", 2.160873)
   *   .and("latitude", 41.397158));</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public Activity[] get(Params params) throws ResponseException {
    Response response = client.get("/v1/shopping/activities", params);
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
