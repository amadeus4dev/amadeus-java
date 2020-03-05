package com.amadeus;

import com.amadeus.booking.FlightOrder;
import com.amadeus.booking.FlightOrders;

public class Booking {
  private Amadeus client;

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/booking/flightOrders</code> endpoints.
   * </p>
   */
  public FlightOrders flightOrders;

  public Booking(Amadeus client) {
    this.client = client;
    this.flightOrders = new FlightOrders(client);
  }

  public FlightOrder flightOrder(String flightOrderId) {
    return new FlightOrder(client, flightOrderId);
  }
}
