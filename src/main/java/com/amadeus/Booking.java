package com.amadeus;

import com.amadeus.booking.FlightOrder;
import com.amadeus.booking.FlightOrders;
import com.amadeus.booking.HotelBookings;

public class Booking {
  private Amadeus client;

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/booking/flightOrder</code> endpoints.
   * </p>
   */
  public FlightOrder flightOrder;

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/booking/flightOrders</code> endpoints.
   * </p>
   */
  public FlightOrders flightOrders;

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/booking/hotelBookings</code> endpoints.
   * </p>
   */
  public HotelBookings hotelBookings;

  /**
   * Constructor.
   * @hide
   */
  public Booking(Amadeus client) {
    this.client = client;
    this.flightOrders = new FlightOrders(client);
    this.hotelBookings = new HotelBookings(client);
  }

  public FlightOrder flightOrder(String flightOrderId) {
    return new FlightOrder(client, flightOrderId);
  }
}
