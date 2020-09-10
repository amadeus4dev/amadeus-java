package com.amadeus;

import com.amadeus.schedule.Flights;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v2/schedule</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.schedule;</pre>
 *
 * @hide
 */
public class Schedule {
  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v2/schedule/flights</code> endpoints.
   * </p>
   */
  public Flights flights;

  /**
   * Constructor.
   * @hide
   */
  public Schedule(Amadeus client) {
    this.flights = new Flights(client);
  }
}
