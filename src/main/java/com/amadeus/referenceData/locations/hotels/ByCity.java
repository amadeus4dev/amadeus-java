package com.amadeus.referenceData.locations.hotels;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Hotel;
import com.amadeus.resources.Resource;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/reference-data/locations/hotels/by-city</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.referenceData.locations.hotels.byCity;</pre>
 */
public class ByCity {
  private Amadeus client;

  /**
   * Constructor.
   * @hide
   */
  public ByCity(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   *   Returns a list of relevant hotels inside a city.
   * </p>
   *
   * <pre>
   * amadeus.referenceData.locations.hotels.byCity.get(Params
   *   .with("cityCode", "PAR"));</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public Hotel[] get(Params params) throws ResponseException {
    Response response = client.get("/v1/reference-data/locations/hotels/by-city", params);
    return (Hotel[]) Resource.fromArray(response, Hotel[].class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see ByCity#get()
   */
  public Hotel[] get() throws ResponseException {
    return get(null);
  }
}
