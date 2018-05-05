package com.amadeus;

import com.amadeus.shopping.FlightDates;
import com.amadeus.shopping.FlightDestinations;
import com.amadeus.shopping.FlightOffers;
import com.amadeus.shopping.Hotel;
import com.amadeus.shopping.HotelOffers;

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
public class Shopping {
  private Amadeus client;

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/shopping/flight-dates</code> endpoints.
   * </p>
   */
  public FlightDates flightDates;

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/shopping/flight-destinations</code> endpoints.
   * </p>
   */
  public FlightDestinations flightDestinations;

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/shopping/flight-offers</code> endpoints.
   * </p>
   */
  public FlightOffers flightOffers;

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/shopping/hotel-offers</code> endpoints.
   * </p>
   */
  public HotelOffers hotelOffers;

  /**
   * Constructor.
   * @hide
   */
  public Shopping(Amadeus client) {
    this.client = client;
    this.flightDates = new FlightDates(client);
    this.flightDestinations = new FlightDestinations(client);
    this.flightOffers = new FlightOffers(client);
    this.hotelOffers = new HotelOffers(client);
  }

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/shopping/hotel/:hotel_id</code> endpoints.
   * </p>
   */
  public Hotel hotel(String hotelId) {
    return new Hotel(client, hotelId);
  }
}
