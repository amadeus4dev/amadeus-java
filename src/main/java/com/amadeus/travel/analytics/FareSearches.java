package com.amadeus.travel.analytics;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FareSearch;
import com.amadeus.resources.Resource;
import com.google.gson.Gson;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/travel/analytics/fare-searches</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.travel.analytics.fareSearches;</pre>
 */
public class FareSearches {
  private Amadeus client;

  /**
   * Constructor.
   * @hide
   */
  public FareSearches(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   *   The Fare Search History API allows to find the number of
   *   estimated searches from an origin, optionally a destination,
   *   within a time period when travelers are performing the searches.
   * </p>
   *
   * <pre>
   * amadeus.travel.analytics.fareSearches.get(Params
   *   .with("origin", "LHR")
   *   .and("sourceCountry", "FR")
   *   .and("period", 2011));</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public FareSearch[] get(Params params) throws ResponseException {
    Response response = client.get("/v1/travel/analytics/fare-searches", params);
    return (FareSearch[]) Resource.fromArray(response, FareSearch[].class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see FareSearches#get()
   */
  public FareSearch[] get() throws ResponseException {
    return get(null);
  }
}
