package com.amadeus.booking;

import com.amadeus.Amadeus;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.HotelOrder;
import com.amadeus.resources.Resource;
import com.google.gson.JsonObject;

/**
 * <p>
 * A namespaced client for the
 * <code>/v2/booking/hotel-orders</code> endpoints.
 * </p>
 *
 * <p>
 * Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder(API_KEY, API_SECRET).build();
 * amadeus.booking.HotelOrders;</pre>
 */
public class HotelOrders {
  private Amadeus client;

  /**
   * Constructor.
   *
   * @hide
   */
  public HotelOrders(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   * The Hotel Booking API allows you to perform hotel booking.
   * </p>
   *
   * <pre>
   * amadeus.booking.hotelOrders.post(body);</pre>
   *
   * @param body the parameters to send to the API as a JSonObject
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public HotelOrder post(JsonObject body) throws ResponseException {
    Response response = client.post("/v2/booking/hotel-orders", body);
    return (HotelOrder) Resource.fromObject(response, HotelOrder.class);
  }

  /**
   * <p>
   * The Hotel Booking API allows you to perform hotel booking.
   * </p>
   *
   * <pre>
   * amadeus.booking.hotelOrders.post(body);</pre>
   *
   * @param body the parameters to send to the API as a String
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public HotelOrder post(String body) throws ResponseException {
    Response response = client.post("/v2/booking/hotel-orders", body);
    return (HotelOrder) Resource.fromObject(response, HotelOrder.class);
  }

  /**
   * Convenience method for calling <code>post</code> without any parameters.
   *
   * @see HotelBookings#post()
   */
  public HotelOrder post() throws ResponseException {
    return post((String) null);
  }
}
