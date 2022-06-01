package com.amadeus.referenceData.locations;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Resource;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/reference-data/locations/hotel</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.referenceData.locations.hotel;</pre>
 */
public class Hotel {
  private Amadeus client;

  /**
   * Constructor.
   * @hide
   */
  public Hotel(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   *   Returns a list of relevant hotels inside a city.
   * </p>
   *
   * <pre>
   * amadeus.referenceData.locations.hotel.get(Params
   *   .with("cityCode", "PAR"));</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public com.amadeus.resources.Hotel[] get(Params params) throws ResponseException {
    Response response = client.get("/v1/reference-data/locations/hotel", params);
    return (com.amadeus.resources.Hotel[])
      Resource.fromArray(response, com.amadeus.resources.Hotel[].class);
  }
}
