package com.amadeus.shopping;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOffer;
import com.google.gson.Gson;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/shopping/flight-offers</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.shopping.flightOffers;</pre>
 */
public class FlightOffers {
  private Amadeus client;

  /**
   * Constructor.
   * @hide
   */
  public FlightOffers(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   *   Find the cheapest bookable flights.
   * </p>
   *
   * <pre>
   * amadeus.shopping.flightOffers.get(Params
   *   .with("origin", "LHR")
   *   .and("destination", "LAX")
   *   .and("departureDate", "2017-12-24"));</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public FlightOffer[] get(Params params) throws ResponseException {
    Response response = client.get("/v1/shopping/flight-offers", params);
    return new Gson().fromJson(response.getData(), FlightOffer[].class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see FlightOffers#get()
   */
  public FlightOffer[] get() throws ResponseException {
    return get(null);
  }
}
