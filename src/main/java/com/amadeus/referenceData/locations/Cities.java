package com.amadeus.referenceData.locations;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.City;
import com.amadeus.resources.Resource;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/reference-data/locations/cities</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.referenceData.locations.cities;</pre>
 */
public class Cities {
  private Amadeus client;

  /**
   * Constructor.
   * @hide
   */
  public Cities(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   *   Returns a list of relevant cities that match a specific word or string of letters.
   * </p>
   *
   * <pre>
   * amadeus.referenceData.locations.cities.get(Params
   *   .with("keyword", "PARIS");</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public City[] get(Params params) throws ResponseException {
    Response response = client.get("/v1/reference-data/locations/cities", params);
    return (City[]) Resource.fromArray(response, City[].class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see Cities#get()
   */
  public City[] get() throws ResponseException {
    return get(null);
  }
}

