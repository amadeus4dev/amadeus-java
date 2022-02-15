package com.amadeus;

import com.amadeus.airport.DirectDestinations;
import com.amadeus.airport.predictions.Predictions;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/airport</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.airport</pre>
 *
 * @hide
 */
public class Airport {
  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/airport/predictions</code> endpoints.
   * </p>
   */
  public Predictions predictions;

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/airport/direct-destinations</code> endpoints.
   * </p>
   */
  public DirectDestinations directDestinations;

  /**
   * Constructor.
   * @hide
   */
  public Airport(Amadeus client) {
    this.predictions = new Predictions(client);
    this.directDestinations = new DirectDestinations(client);
  }
}
