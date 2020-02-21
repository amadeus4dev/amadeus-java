package com.amadeus;

import com.amadeus.booking.FlightOrder;

public class Booking {
  private Amadeus client;

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/booking/flightOrder</code> endpoints.
   * </p>
   */
  public FlightOrder flightOrder;

  public Booking(Amadeus client) {
    this.client = client;
  }

  public FlightOrder flightOrder(String flightOrderId) {
    return new FlightOrder(client, flightOrderId);
  }
}
