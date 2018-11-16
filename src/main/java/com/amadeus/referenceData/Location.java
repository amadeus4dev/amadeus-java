package com.amadeus.referenceData;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.referenceData.locations.Airports;
import com.amadeus.resources.Resource;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v2/reference-data/locations/:location_id</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder(API_KEY, API_SECRET).build();
 * amadeus.referenceData.location(locationId);</pre>
 *
 * @hide
 */
public class Location {
  private Amadeus client;
  private String locationId;

  /**
   * Constructor.
   * @hide
   */
  public Location(Amadeus client, String locationId) {
    this.locationId = locationId;
    this.client = client;
  }

  /**
   * <p>
   *   Returns details for a specific airport.
   * </p>
   *
   * <pre>
   * amadeus.referenceData.locations("ALHR').get();</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public com.amadeus.resources.Location get(Params params) throws ResponseException {
    String path = String.format("/v1/reference-data/locations/%s", locationId);
    Response response = client.get(path, params);
    return (com.amadeus.resources.Location)
            Resource.fromObject(response, com.amadeus.resources.Location.class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see Airports#get()
   */
  public com.amadeus.resources.Location get() throws ResponseException {
    return get(null);
  }
}
