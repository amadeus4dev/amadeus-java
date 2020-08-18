package com.amadeus;

import com.amadeus.safety.SafetyRatedLocation;
import com.amadeus.safety.SafetyRatedLocations;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/safety</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.safety;</pre>
 *
 * @hide
 */
public class Safety {
  private Amadeus client;

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/safety/safety-rated-locations</code> endpoints.
   * </p>
   */
  public SafetyRatedLocations safetyRatedLocations;

  /**
   * Constructor.
   * @hide
   */
  public Safety(Amadeus client) {
    this.client = client;
    this.safetyRatedLocations = new SafetyRatedLocations(client);
  }

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/safety/safety-rated-locations/:safetyRatedLocationId</code> endpoints.
   * </p>
   */
  public SafetyRatedLocation safetyRatedLocation(String safetyRatedLocationId) {
    return new SafetyRatedLocation(client, safetyRatedLocationId);
  }
}
