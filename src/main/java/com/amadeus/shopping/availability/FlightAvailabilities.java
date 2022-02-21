package com.amadeus.shopping.availability;

import com.amadeus.Amadeus;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightAvailability;
import com.amadeus.resources.Resource;
import com.google.gson.JsonObject;

/**
 * <p>
 * A namespaced client for the
 * <code>/v1/shopping/availability/flight-availabilities</code> endpoints.
 * </p>
 *
 * <p>
 * Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder(API_KEY, API_SECRET).build();
 * amadeus.shopping.availability.flightAvailabilities;</pre>
 */
public class FlightAvailabilities {
  private Amadeus client;

  /**
   * Constructor.
   *
   * @hide
   */
  public FlightAvailabilities(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   *   The Amadeus Flight Availability API provides a list of flights with seats for sale,
   *   and the quantity of seats available in different fare classes on a given itinerary.
   *   Additional information such as carrier and aircraft information,
   *   the departure and arrival terminals, schedule, and route are also provided.
   * </p>
   *
   * <pre>
   * amadeus.shopping.availability.flightAvailabilities.post(body);</pre>
   *
   * @param body the parameters to send to the API as a JsonObject
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public FlightAvailability[] post(JsonObject body) throws ResponseException {
    Response response = client.post("/v1/shopping/availability/flight-availabilities", body);
    return
      (FlightAvailability[]) Resource.fromArray(response, FlightAvailability[].class);
  }

  /**
   * <p>
   *   The Amadeus Flight Availability API provides a list of flights with seats for sale,
   *   and the quantity of seats available in different fare classes on a given itinerary.
   *   Additional information such as carrier and aircraft information,
   *   the departure and arrival terminals, schedule, and route are also provided.
   * </p>
   *
   * <pre>
   * amadeus.shopping.availability.flightAvailabilities.post(body);</pre>
   *
   * @param body the parameters to send to the API as a String
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public FlightAvailability[] post(String body) throws ResponseException {
    Response response = client.post("/v1/shopping/availability/flight-availabilities", body);
    return
      (FlightAvailability[]) Resource.fromArray(response, FlightAvailability[].class);
  }

  /**
  * Convenience method for calling <code>post</code> without any parameters.
  *
  * @see FlightAvailabilities#post()
  */
  public FlightAvailability[] post() throws ResponseException {
    return post((String) null);
  }
}
