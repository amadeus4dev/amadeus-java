package com.amadeus;

import com.amadeus.travel.Predictions;
import com.amadeus.travel.TripParser;
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
   * <p>
   *   A namespaced client for the
   *   <code>/v1/travel/predictions</code> endpoints.
   * </p>
   */
  public Predictions predictions;
  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v3/travel/trip-parser</code> endpoints.
   * </p>
   */
  public TripParser tripParser;

  /**
   * Constructor.
   * @hide
   */
  public Travel(Amadeus client) {
    this.analytics = new Analytics(client);
    this.predictions = new Predictions(client);
    this.tripParser = new TripParser(client);
  }
}
