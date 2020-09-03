package com.amadeus.schedule;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.DatedFlight;
import com.amadeus.resources.Resource;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v2/schedule/flights</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.schedule.flights;</pre>
 */
public class Flights {
  private Amadeus client;

  /**
   * Constructor.
   * @hide
   */
  public Flights(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   *   Retrieves status of a given flight.
   * </p>
   *
   * <pre>
   * amadeus.schedule.flights.get(Params
   *     .with("carrierCode", "AZ")
   *     .and("flightNumber", "319")
   *     .and("scheduledDepartureDate", "2021-03-13"));</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public DatedFlight[] get(Params params) throws ResponseException {
    Response response = client.get("/v2/schedule/flights", params);
    return (DatedFlight[]) Resource.fromArray(response, DatedFlight[].class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see DatedFlight#get()
   */
  public DatedFlight[] get() throws ResponseException {
    return get(null);
  }
}
