package com.amadeus.shopping;

import com.amadeus.Amadeus;
import com.amadeus.shopping.hotel.HotelOffers;
import com.amadeus.shopping.hotel.Offer;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/shopping/hotels</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.shopping.hotel("SMPARCOL");</pre>
 */
public class Hotel {
  private Amadeus client;
  private String hotelId;

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/shopping/hotel/hotel-offers</code> endpoints.
   * </p>
   */
  public HotelOffers hotelOffers;

  /**
   * Constructor.
   * @hide
   */
  public Hotel(Amadeus client, String hotelId) {
    this.client = client;
    this.hotelId = hotelId;
    this.hotelOffers = new HotelOffers(client, hotelId);
  }

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/shopping/hotel/:hotel_id/offer</code> endpoints.
   * </p>
   */
  public Offer offer(String offerId) {
    return new Offer(client, hotelId, offerId);
  }
}
