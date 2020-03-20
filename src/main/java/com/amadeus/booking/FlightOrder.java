package com.amadeus.booking;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Resource;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/booking/flight-orders/:flightOrderId</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.booking.flightOrder;</pre>
 */
public class FlightOrder {
  private Amadeus client;
  private String flightOfferId;

  /**
   * Constructor.
   * @hide
   */
  public FlightOrder(Amadeus client, String flightOfferId) {
    this.client = client;
    this.flightOfferId = flightOfferId;
  }

  /**
   * <p>
   *   Allows you to manipulate a flight order. The flightOfferId
   *   used is an example for educational purposes. In test enviromnent 
   *   it's temporary.
   * </p>
   *
   * <pre>
   * FlightOrder order = amadeus.booking.flightOrder.(
   * "eJzTd9f3NjIJdzUGAAp%2fAiY=").get();
   * </pre>
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */

  public com.amadeus.resources.FlightOrder get(Params params) throws ResponseException {
    String path = String.format("/v1/booking/flight-orders/%s", flightOfferId);
    Response response = client.get(path, params);
    return (com.amadeus.resources.FlightOrder) Resource.fromObject(
        response, com.amadeus.resources.FlightOrder.class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see com.amadeus.booking.FlightOrder#get()
   */
  public com.amadeus.resources.FlightOrder get() throws ResponseException {
    return get(null);
  }

  /**
   * <p>
   *   Allows you to cancel a flight order. The flightOfferId
   *   used is an example for educational purposes. In test enviromnent 
   *   it's temporary.
   * </p>
   *
   * <pre>
   * FlightOrder order = amadeus.booking.flightOrder.(
   * "eJzTd9f3NjIJdzUGAAp%2fAiY=").get();
   * </pre>
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */

  public com.amadeus.resources.FlightOrder delete(Params params) throws ResponseException {
    String path = String.format("/v1/booking/flight-orders/%s", flightOfferId);
    Response response = client.delete(path, params);
    return (com.amadeus.resources.FlightOrder) Resource.fromObject(
        response, com.amadeus.resources.FlightOrder.class);
  }
  
  /**
   * Convenience method for calling <code>delete</code> without any parameters.
   * @see com.amadeus.booking.FlightOrder#delete()
   */
  public com.amadeus.resources.FlightOrder delete() throws ResponseException {
    return delete(null);
  }
}
