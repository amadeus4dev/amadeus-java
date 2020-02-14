package com.amadeus.airport.predictions;

import com.amadeus.Amadeus;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/airport/predictions</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.airport.predictions;</pre>
 *
 * @hide
 */
public class Predictions {
  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/airport/predictions/on-time</code> endpoints.
   * </p>
   */
  public AirportOnTime onTime;


  /**
   * Constructor.
   * @hide
   */
  public Predictions(Amadeus client) {
    this.onTime = new AirportOnTime(client);
  }
}