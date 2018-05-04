package com.amadeus.travel.analytics;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;

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
   *   .with("sourceCountry", "FR")
   *   .with("period", 2011);</pre>
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
   * @see FareSearches#get()
   */
  public Response get() throws ResponseException {
    return get(null);
  }
}
