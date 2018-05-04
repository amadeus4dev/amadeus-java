package com.amadeus.travel.analytics.airTraffic;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/travel/analytics/air-traffic/traveled</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.travel.analytics.airTraffis.traveled;</pre>
 */
public class Traveled {
  private Amadeus client;

  /**
   * Constructor.
   * @hide
   */
  public Traveled(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   *   Returns a list of air traffic reports.
   * </p>
   *
   * <pre>
   * amadeus.travel.analytics.airTraffic.traveled.get(Params
   *   .with("origin", "LHR")
   *   .with("period", "2017-03");</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public Response get(Params params) throws ResponseException {
    return client.get("/v1/travel/analytics/air-traffic/traveled", params);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see Traveled#get()
   */
  public Response get() throws ResponseException {
    return get(null);
  }
}
