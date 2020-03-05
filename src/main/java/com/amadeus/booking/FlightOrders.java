package com.amadeus.booking;

import com.amadeus.Amadeus;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.FlightOrder;
import com.amadeus.resources.Resource;
import com.amadeus.resources.Traveler;
import com.google.gson.JsonObject;

/**
 * <p>
 * A namespaced client for the
 * <code>/v1/booking/flight-orders</code> endpoints.
 * </p>
 *
 * <p>
 * Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder(API_KEY, API_SECRET).build();
 * amadeus.booking.flightOrders;</pre>
 */
public class FlightOrders {
  private Amadeus client;

  /**
   * Constructor.
   *
   * @hide
   */
  public FlightOrders(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   * The Flight Create Orders API allows you to perform flight booking.
   * </p>
   *
   * <pre>
   * amadeus.booking.flightOrders.post(body);</pre>
   *
   * @param body the parameters to send to the API as a JSonObject
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public FlightOrder post(JsonObject body) throws ResponseException {
    Response response = client.post("/v1/booking/flight-orders", body);
    return (FlightOrder) Resource.fromObject(response, FlightOrder.class);
  }

  /**
   * <p>
   * The Flight Create Orders API allows you to perform flight booking.
   * </p>
   *
   * <pre>
   * amadeus.booking.flightOrders.post(body);</pre>
   *
   * @param body the parameters to send to the API as a String
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public FlightOrder post(String body) throws ResponseException {
    Response response = client.post("/v1/booking/flight-orders", body);
    return (FlightOrder) Resource.fromObject(response, FlightOrder.class);
  }

  /**
   * <p>
   * The Flight Create Orders API allows you to perform flight booking.
   * </p>
   *
   * <pre>
   * amadeus.booking.flightOrders.post(body);</pre>
   *
   * @param flightOffersSearches List of flight-offers as FlightOfferSearch[]
   * @param travelers List of travelers as Traveler[]
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public FlightOrder post(FlightOfferSearch[] flightOffersSearches, 
      Traveler[] travelers) throws ResponseException {
    JsonObject typeObject = new JsonObject();
    typeObject.addProperty("type", "flight-order");
    typeObject.add("flightOffers", flightOffersSearches[0].getResponse().getData());
    typeObject.add("travelers", travelers[0].getResponse().getData());


    JsonObject jsonObject = new JsonObject();
    jsonObject.add("data", typeObject);

    Response response = client.post("/v1/booking/flight-orders", jsonObject);
    return (FlightOrder) Resource.fromObject(response, FlightOrder.class);
  }

  /**
   * Convenience method for calling <code>post</code> without any parameters.
   *
   * @see FlightOrders#post()
   */
  public FlightOrder post() throws ResponseException {
    return post((String) null);
  }
}
