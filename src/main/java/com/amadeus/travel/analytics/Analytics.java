package com.amadeus.travel.analytics;

import com.amadeus.Amadeus;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/travel/analytics</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.travel.analytics;</pre>
 *
 * @hide
 */
public class Analytics {
  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/travel/analytics/air-traffics</code> endpoints.
   * </p>
   */
  public AirTraffic airTraffic;


  /**
   * Constructor.
   * @hide
   */
  public Analytics(Amadeus client) {
    this.airTraffic = new AirTraffic(client);
  }
}
