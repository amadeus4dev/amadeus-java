package com.amadeus;

import com.amadeus.analytics.ItineraryPriceMetrics;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/analytics</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.analytics;</pre>
 *
 * @hide
 */
public class Analytics {
  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/analytics/itineraryPriceMetrics</code> endpoints.
   * </p>
   */
  public ItineraryPriceMetrics itineraryPriceMetrics;

  /**
   * Constructor.
   * @hide
   */
  public Analytics(Amadeus client) {
    this.itineraryPriceMetrics = new ItineraryPriceMetrics(client);
  }
}
