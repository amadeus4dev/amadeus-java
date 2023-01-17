package com.amadeus.travel.analytics;

import com.amadeus.Amadeus;
import com.amadeus.travel.analytics.airtraffic.Booked;
import com.amadeus.travel.analytics.airtraffic.BusiestPeriod;
import com.amadeus.travel.analytics.airtraffic.Traveled;

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
   * <p>
   *   A namespaced client for the
   *   <code>/v1/travel/analytics/air-traffic/booked</code> endpoints.
   * </p>
   */
  public Booked booked;

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/travel/analytics/air-traffic/busiest-period</code> endpoints.
   * </p>
   */
  public BusiestPeriod busiestPeriod;

  /**
   * Constructor.
   * @hide
   */
  public AirTraffic(Amadeus client) {
    this.traveled = new Traveled(client);
    this.booked = new Booked(client);
    this.busiestPeriod = new BusiestPeriod(client);
  }
}
