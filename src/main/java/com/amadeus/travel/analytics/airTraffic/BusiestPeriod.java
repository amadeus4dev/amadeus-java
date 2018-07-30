package com.amadeus.travel.analytics.airTraffic;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Period;
import com.amadeus.resources.Resource;
import com.google.gson.Gson;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/travel/analytics/air-traffic/busiest-period</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.travel.analytics.airTraffis.busiestPeriod;</pre>
 */
public class BusiestPeriod {
  private Amadeus client;
  public static String ARRIVING = "ARRIVING";
  public static String DEPARTING = "DEPARTING";

  /**
   * Constructor.
   * @hide
   */
  public BusiestPeriod(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   *   Returns a list of busiest periods reports.
   * </p>
   *
   * <pre>
   * amadeus.travel.analytics.airTraffic.busiestPeriod.get(Params
   *   .with("cityCode", "PAR")
   *   .and("period", "2017"));</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public Period[] get(Params params) throws ResponseException {
    Response response = client.get("/v1/travel/analytics/air-traffic/busiest-period", params);
    return (Period[]) Resource.fromArray(response, Period[].class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see Traveled#get()
   */
  public Period[] get() throws ResponseException {
    return get(null);
  }
}
