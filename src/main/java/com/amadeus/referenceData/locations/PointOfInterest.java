package com.amadeus.referencedata.locations;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Resource;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/reference-data/locations/pois</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.referenceData.locations.pointOfInterest;</pre>
 */
public class PointOfInterest {
  private Amadeus client;
  private String id;


  /**
   * Constructor.
   * @hide
   */
  public PointOfInterest(Amadeus client, String id) {
    this.client = client;
    this.id = id;
  }

  /**
   * <p>
   *   Returns a single Point of Interest from a given id.
   * </p>
   *
   * <pre>
   * amadeus.referenceData.locations.pointOfInterest("9CB40CB5D0").get();</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public com.amadeus.resources.PointOfInterest get(Params params) throws ResponseException {
    String path = String.format("/v1/reference-data/locations/pois/%s", id);
    Response response = client.get(path, params);
    return (com.amadeus.resources.PointOfInterest) Resource.fromObject(
      response, com.amadeus.resources.PointOfInterest.class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see PointOfInterest#get()
   */
  public com.amadeus.resources.PointOfInterest get() throws ResponseException {
    return get(null);
  }
}
