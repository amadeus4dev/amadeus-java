package com.amadeus.referenceData;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Location;
import com.amadeus.resources.Resource;
import com.google.gson.Gson;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/reference-data/recommended-locations</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.referenceData.locations.recommendedLocations;</pre>
 */
public class RecommendedLocations {
  private Amadeus client;

  /**
   * Constructor.
   * @hide
   */
  public RecommendedLocations(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   *   Returns a list of destination recommendations.
   * </p>
   *
   * <pre>
   * amadeus.referenceData.locations.recommendedLocations.get(Params
   *   .with("cityCodes", "PAR")
   *   .and("travelerCountryCode", "FR"));</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public Location[] get(Params params) throws ResponseException {
    Response response = client.get("/v1/reference-data/recommended-locations", params);
    return (Location[]) Resource.fromArray(response, Location[].class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see Location#get()
   */
  public Location[] get() throws ResponseException {
    return get(null);
  }
}
