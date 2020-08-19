package com.amadeus.safety;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Resource;
import com.amadeus.resources.SafePlace;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/safety/safety-rated-locations</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.safety.safetyRatedLocations;</pre>
 */
public class SafetyRatedLocation {
  private Amadeus client;
  private String safetyRatedLocationId;

  /**
   * Constructor.
   * @hide
   */
  public SafetyRatedLocation(Amadeus client, String safetyRatedLocationId) {
    this.client = client;
    this.safetyRatedLocationId = safetyRatedLocationId;
  }


  /**
   * <p>
   *   Returns safety information of a location based on it's Id.
   * </p>
   *
   * <pre>
   * amadeus.safety.safetyRatedLocation("Q930402719").get();</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public SafePlace get(Params params) throws ResponseException {
    String path = String.format("/v1/safety/safety-rated-locations/%s", safetyRatedLocationId);
    Response response = client.get(path, params);
    return (SafePlace) Resource.fromObject(
      response, com.amadeus.resources.SafePlace.class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see SafetyRatedLocation#get()
   */
  public SafePlace get() throws ResponseException {
    return get(null);
  }
}
