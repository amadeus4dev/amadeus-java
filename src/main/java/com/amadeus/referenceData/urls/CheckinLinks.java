package com.amadeus.referenceData.urls;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v2/reference-data/urls/checkin-links</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.referenceData.urls.checkinLinks;</pre>
 */
public class CheckinLinks {
  private Amadeus client;

  /**
   * Constructor.
   * @hide
   */
  public CheckinLinks(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   *   Returns the checkin links for an airline, for the
   *   language of your choice.
   * </p>
   *
   * <pre>
   * amadeus.referenceData.urls.checkinLinks.get(Params.with("airline", "1X"));</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public Response get(Params params) throws ResponseException {
    return client.get("/v2/reference-data/urls/checkin-links", params);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see CheckinLinks#get()
   */
  public Response get() throws ResponseException {
    return get(null);
  }
}
