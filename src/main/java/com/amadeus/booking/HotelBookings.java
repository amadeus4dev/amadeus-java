package com.amadeus.booking;

import com.amadeus.Amadeus;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.HotelBooking;
import com.amadeus.resources.Resource;
import com.google.gson.JsonObject;

/**
 * <p>
 * A namespaced client for the
 * <code>/v1/booking/hotel-bookings</code> endpoints.
 * </p>
 *
 * <p>
 * Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder(API_KEY, API_SECRET).build();
 * amadeus.booking.hotelBookings;</pre>
 */
public class HotelBookings {
  private Amadeus client;

  /**
   * Constructor.
   *
   * @hide
   */
  public HotelBookings(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   * The Hotel Booking API allows you to perform hotel booking.
   * </p>
   *
   * <pre>
   * amadeus.booking.hotelBookings.post(body);</pre>
   *
   * @param body the parameters to send to the API as a JSonObject
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public HotelBooking post(JsonObject body) throws ResponseException {
    Response response = client.post("/v1/booking/hotel-bookings", body);
    return (HotelBooking) Resource.fromObject(response, HotelBooking.class);
  }

  /**
   * <p>
   * The Hotel Booking API allows you to perform hotel booking.
   * </p>
   *
   * <pre>
   * amadeus.booking.hotelBookings.post(body);</pre>
   *
   * @param body the parameters to send to the API as a String
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public HotelBooking post(String body) throws ResponseException {
    Response response = client.post("/v1/booking/hotel-bookings", body);
    return (HotelBooking) Resource.fromObject(response, HotelBooking.class);
  }

  /**
   * Convenience method for calling <code>post</code> without any parameters.
   *
   * @see HotelBookings#post()
   */
  public HotelBooking post() throws ResponseException {
    return post((String) null);
  }
}
