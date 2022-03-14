package com.amadeus;

import com.amadeus.location.Analytics;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/location</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.location;</pre>
 *
 * @hide
 */
public class Location {
  private Amadeus client;

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/location/analytics</code> endpoints.
   * </p>
   */
  public Analytics analytics;

  /**
   * Constructor.
   * @hide
   */
  public Location(Amadeus client) {
    this.client = client;
    this.analytics = new Analytics(client);
  }
}
