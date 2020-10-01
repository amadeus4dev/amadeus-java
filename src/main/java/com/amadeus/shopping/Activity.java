package com.amadeus.shopping;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Resource;

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
 * amadeus.shopping.activity;</pre>
 */
public class Activity {
  private Amadeus client;
  private String id;


  /**
   * Constructor.
   * @hide
   */
  public Activity(Amadeus client, String id) {
    this.client = client;
    this.id = id;
  }

  /**
   * <p>
   *   Returns a single activity from a given id.
   * </p>
   *
   * <pre>
   * amadeus.shopping.activity.("4615").get();</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public com.amadeus.resources.Activity get(Params params) throws ResponseException {
    String path = String.format("/v1/shopping/activities/%s", id);
    Response response = client.get(path, params);
    return (com.amadeus.resources.Activity) Resource.fromObject(
      response, com.amadeus.resources.Activity.class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see Activity#get()
   */
  public com.amadeus.resources.Activity get() throws ResponseException {
    return get(null);
  }
}
