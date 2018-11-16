package com.amadeus.travel.analytics.airTraffic;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Resource;
import com.amadeus.resources.Search;


/**
 * <p>
 * A namespaced client for the
 * <code>/v1/travel/analytics/air-traffic/searched</code> endpoints.
 * </p>
 *
 * <p>
 * Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("API_KEY", "API_SECRET").build();
 * amadeus.travel.analytics.airTraffis.Searched;</pre>
 */
public class Searched {

  private Amadeus client;

  /**
   * Constructor.
   *
   * @hide
   */
  public Searched(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   * Returns a list of air traffic reports based on the number of searches.
   * </p>
   *
   * <pre>
   * amadeus.travel.analytics.airTraffic.searched.get(Params
   *   .with("originCityCode", "MAD")
   *   .and("searchPeriod", "2017-08")
   *   .and("marketCountryCode", "ES"));</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public Search[] get(Params params) throws ResponseException {
    Response response = client.get("/v1/travel/analytics/air-traffic/searched", params);
    return (Search[]) Resource.fromArray(response, Search[].class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   *
   * @see Searched#get()
   */
  public Search[] get() throws ResponseException {
    return get(null);
  }
}
