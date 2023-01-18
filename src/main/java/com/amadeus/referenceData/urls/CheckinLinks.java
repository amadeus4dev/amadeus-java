package com.amadeus.referencedata.urls;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.CheckinLink;
import com.amadeus.resources.Resource;
import com.google.gson.Gson;

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
 * Amadeus amadeus = Amadeus.builder(API_KEY, API_SECRET).build();
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
   * amadeus.referenceData.urls.checkinLinks.get(Params.with("airlineCode", "BA"));</pre>
   *
   * @param params the parameters to send to the API
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public CheckinLink[] get(Params params) throws ResponseException {
    Response response = client.get("/v2/reference-data/urls/checkin-links", params);
    return (CheckinLink[]) Resource.fromArray(response, CheckinLink[].class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see CheckinLinks#get()
   */
  public CheckinLink[] get() throws ResponseException {
    return get(null);
  }
}
