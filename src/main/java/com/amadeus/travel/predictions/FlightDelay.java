package com.amadeus.travel.predictions;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Delay;
import com.amadeus.resources.Resource;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/travel/predictions/flight-delay</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.travel.predictions.flightDelay;</pre>
 */
public class FlightDelay {
  private Amadeus client;

  /**
   * Constructor.
   * @hide
   */
  public FlightDelay(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   *   Predicts delay of a given flight.
   * </p>
   *
   * <pre>
   * Delay[] flightDelay = amadeus.travel.predictions.flightDelay.get(Params
   *     .with("originLocationCode", "NCE")
   *     .and("destinationLocationCode", "IST")
   *     .and("departureDate", "2020-08-01")
   *     .and("departureTime", "18:20:00"))
   *     .and("arrivalDate", "2020-08-01")
   *     .and("arrivalTime", "22:15:00")
   *     .and("aircraftCode", "321"))
   *     .and("carrierCode", "TK")
   *     .and("flightNumber", "1816")
   *     .and("duration", "PT31H10M"));
   * </pre>
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public Delay[] get(Params params) throws ResponseException {
    Response response = client.get("/v1/travel/predictions/flight-delay", params);
    return (Delay[]) Resource.fromArray(response, Delay[].class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see FlightDelay#get()
   */
  public Delay[] get() throws ResponseException {
    return get(null);
  }
}
