package com.amadeus.analytics;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.ItineraryPriceMetric;
import com.amadeus.resources.Resource;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/analytics/itinerary-price-metrics</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.analytics.itineraryPriceMetrics;</pre>
 */
public class ItineraryPriceMetrics {
  private Amadeus client;

  /**
   * Constructor.
   * @hide
   */
  public ItineraryPriceMetrics(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   *   Retrieves itinerary price metrics.
   * </p>
   *
   * <pre>
   * amadeus.analytics.itineraryPriceMetrics.get(Params
   *     .with("originIataCode", "MAD")
   *     .and("destinationIataCode", "CDG")
   *     .and("departureDate", "2021-03-21"));</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public ItineraryPriceMetric[] get(Params params) throws ResponseException {
    Response response = client.get("/v1/analytics/itinerary-price-metrics", params);
    return (ItineraryPriceMetric[]) Resource.fromArray(response, ItineraryPriceMetric[].class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see ItineraryPriceMetric#get()
   */
  public ItineraryPriceMetric[] get() throws ResponseException {
    return get(null);
  }
}
