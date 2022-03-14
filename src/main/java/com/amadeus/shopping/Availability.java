package com.amadeus.shopping;

import com.amadeus.Amadeus;
import com.amadeus.shopping.availability.FlightAvailabilities;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/shopping/availability</code> endpoints.
 * </p>
 */
public class Availability {
  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/shopping/availability/flight-availabilities</code> endpoints.
   * </p>
   */
  public FlightAvailabilities flightAvailabilities;

  /**
   * Constructor.
   * @hide
   */
  public Availability(Amadeus client) {
    this.flightAvailabilities = new FlightAvailabilities(client);
  }
}
