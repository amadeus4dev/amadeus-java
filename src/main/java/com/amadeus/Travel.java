package com.amadeus;

import com.amadeus.travel.analytics.Analytics;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v2/travel</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.travel;</pre>
 *
 * @hide
 */
public class Travel {
  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v2/travel/analytics</code> endpoints.
   * </p>
   */
  public Analytics analytics;

  /**
   * Constructor.
   * @hide
   */
  public Travel(Amadeus client) {
    this.analytics = new Analytics(client);
  }
}
