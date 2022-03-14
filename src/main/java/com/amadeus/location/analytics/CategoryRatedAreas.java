package com.amadeus.location.analytics;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Resource;
import com.amadeus.resources.ScoredLocation;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/location/analytics/category-rated-areas</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.location.analytics.categoryRatedAreas;</pre>
 */
public class CategoryRatedAreas {
  private Amadeus client;

  /**
   * Constructor.
   * @hide
   */
  public CategoryRatedAreas(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   *    Provides a popularity scores
   *    for a given latitude and longitude.
   * </p>
   *
   * <pre>
   * amadeus.location.analytics.categoryRatedAreas.get(Params
   *     .with("latitude", "41.397158")
   *     .and("longitude", "2.160873");
   * </pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public ScoredLocation[] get(Params params) throws ResponseException {
    Response response = client.get("/v1/location/analytics/category-rated-areas", params);
    return (ScoredLocation[]) Resource.fromArray(response, ScoredLocation[].class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see CategoryRatedAreas#get()
   */
  public ScoredLocation[] get() throws ResponseException {
    return get(null);
  }
}
