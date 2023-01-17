package com.amadeus.travel.analytics.airtraffic;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.AirTraffic;
import com.amadeus.resources.Resource;
import com.google.gson.Gson;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/travel/analytics/air-traffic/booked</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.travel.analytics.airTraffis.booked;</pre>
 */
public class Booked {
  private Amadeus client;

  /**
   * Constructor.
   * @hide
   */
  public Booked(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   *   Returns a list of air traffic reports.
   * </p>
   *
   * <pre>
   * amadeus.travel.analytics.airTraffic.booked.get(Params
   *   .with("originCityCode", "LHR")
   *   .and("period", "2017-03"));</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public AirTraffic[] get(Params params) throws ResponseException {
    Response response = client.get("/v1/travel/analytics/air-traffic/booked", params);
    return (AirTraffic[]) Resource.fromArray(response, AirTraffic[].class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see Booked#get()
   */
  public AirTraffic[] get() throws ResponseException {
    return get(null);
  }
}
