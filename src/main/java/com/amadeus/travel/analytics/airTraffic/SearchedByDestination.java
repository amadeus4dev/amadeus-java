package com.amadeus.travel.analytics.airTraffic;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Resource;
import com.amadeus.resources.SearchedDestination;

/**
 * <p>
 * A namespaced client for the
 * <code>/v1/travel/analytics/air-traffic/searched/by-destination</code> endpoints.
 * </p>
 *
 * <p>
 * Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("API_KEY", "API_SECRET").build();
 * amadeus.travel.analytics.airTraffis.SearchedByDestination;</pre>
 */
public class SearchedByDestination {

  private Amadeus client;

  /**
   * Constructor.
   *
   * @hide
   */
  public SearchedByDestination(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   * Returns a air traffic report based on the number of searches.
   * </p>
   *
   * <pre>
   * amadeus.travel.analytics.airTraffic.searchedByDestination.get(Params
   *   .with("originCityCode", "MAD")
   *   .and("destinationCityCode", "NYC")
   *   .and("searchPeriod", "2017-08")
   *   .and("marketCountryCode", "ES"));</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public SearchedDestination get(Params params) throws ResponseException {
    Response response = client
        .get("/v1/travel/analytics/air-traffic/searched/by-destination", params);
    return (SearchedDestination) Resource.fromObject(response, SearchedDestination.class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   *
   * @see SearchedByDestination#get()
   */
  public SearchedDestination get() throws ResponseException {
    return get(null);
  }
}
