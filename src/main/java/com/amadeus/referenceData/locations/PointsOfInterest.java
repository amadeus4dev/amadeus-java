package com.amadeus.referencedata.locations;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.referencedata.locations.pointsOfInterest.BySquare;
import com.amadeus.resources.PointOfInterest;
import com.amadeus.resources.Resource;
import com.google.gson.Gson;

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
 * amadeus.referenceData.locations.pointsOfInterest;</pre>
 */
public class PointsOfInterest {
  private Amadeus client;


  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/reference-data/locations/pois/by-square</code> endpoints.
   * </p>
   */
  public BySquare bySquare;

  /**
   * Constructor.
   * @hide
   */
  public PointsOfInterest(Amadeus client) {
    this.client = client;
    this.bySquare = new BySquare(client);
  }


  /**
   * <p>
   *   Returns a list of relevant point of interests near to a given point.
   * </p>
   *
   * <pre>
   * amadeus.referenceData.locations.pointsOfInterest.get(Params
   *   .with("longitude", 2.160873)
   *   .and("latitude", 41.397158));</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public PointOfInterest[] get(Params params) throws ResponseException {
    Response response = client.get("/v1/reference-data/locations/pois", params);
    return (PointOfInterest[]) Resource.fromArray(response, PointOfInterest[].class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see PointsOfInterest#get()
   */
  public PointOfInterest[] get() throws ResponseException {
    return get(null);
  }
}
