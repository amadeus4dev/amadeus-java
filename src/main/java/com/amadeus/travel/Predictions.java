package com.amadeus.travel.predictions;

import com.amadeus.Amadeus;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/travel/predictions</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.travel.predictions;</pre>
 *
 * @hide
 */
public class Predictions {
  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/travel/predictions/flight-delay</code> endpoints.
   * </p>
   */
  public FlightDelay flightDelay;


  /**
   * Constructor.
   * @hide
   */
  public Predictions(Amadeus client) {
    this.flightDelay = new FlightDelay(client);
  }
}
