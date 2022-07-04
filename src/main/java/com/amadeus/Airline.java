package com.amadeus;

import com.amadeus.airline.Destinations;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/airline</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.airline</pre>
 *
 * @hide
 */
public class Airline {
  /**
   * Constructor.
   * @hide
   */
  public Airline(Amadeus client) {
    this.destinations = new Destinations(client);
  }

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/airline/destinations</code> endpoints.
   * </p>
   */
  public Destinations destinations;
}
