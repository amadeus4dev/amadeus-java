package com.amadeus;

import com.amadeus.shopping.Activities;
import com.amadeus.shopping.Activity;
import com.amadeus.shopping.Availability;
import com.amadeus.shopping.FlightDates;
import com.amadeus.shopping.FlightDestinations;
import com.amadeus.shopping.FlightOffers;
import com.amadeus.shopping.FlightOffersSearch;
import com.amadeus.shopping.HotelOffer;
import com.amadeus.shopping.HotelOffers;
import com.amadeus.shopping.SeatMaps;


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
   *   <code>/v2/shopping/flight-offers</code> endpoints.
   * </p>
   */
  public FlightOffersSearch flightOffersSearch;

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v3/shopping/hotel-offers</code> endpoints.
   * </p>
   */
  public HotelOffers hotelOffers;

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/shopping/seatmaps</code> endpoints.
   * </p>
   */
  public SeatMaps seatMaps;

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/shopping/activities</code> endpoints.
   * </p>
   */

  public Activity activity;
  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/shopping/activities</code> endpoints.
   * </p>
   */
  public Activities activities;

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/shopping/availability</code> endpoints.
   * </p>
   */
  public Availability availability;

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
    this.flightOffersSearch = new FlightOffersSearch(client);
    this.seatMaps = new SeatMaps(client);
    this.activities = new Activities(client);
    this.availability = new Availability(client);
  }

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v3/shopping/hotel-offers/:offer_id</code> endpoints.
   * </p>
   */
  public HotelOffer hotelOffer(String offerId) {
    return new HotelOffer(client, offerId);
  }

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/shopping/activities/:activity_id</code> endpoints.
   * </p>
   */
  public Activity activity(String activityId) {
    return new Activity(client, activityId);
  }
}
