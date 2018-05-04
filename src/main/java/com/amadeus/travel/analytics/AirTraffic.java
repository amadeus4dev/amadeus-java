package com.amadeus.travel.analytics;

import com.amadeus.Amadeus;
import com.amadeus.travel.analytics.airTraffic.Traveled;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/travel/analytics/air-traffic</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.travel.analytics.airTraffic;</pre>
 *
 * @hide
 */
public class AirTraffic {
  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/travel/analytics/air-traffic/traveled</code> endpoints.
   * </p>
   */
  public Traveled traveled;

  /**
   * Constructor.
   * @hide
   */
  public AirTraffic(Amadeus client) {
    this.traveled = new Traveled(client);
  }
}
