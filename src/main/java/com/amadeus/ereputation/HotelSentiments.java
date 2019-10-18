package com.amadeus.ereputation;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.HotelSentiment;
import com.amadeus.resources.Resource;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v2/e-reputation/hotel-sentiments</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.ereputation.hotelSentiments;</pre>
 */

public class HotelSentiments {
  private Amadeus client;

  /**
   * Constructor.
   * @hide
   */
  public HotelSentiments(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   *   Hotel ratings based on automated sentiment analysis algorithm
   *    applied on the online reviews.
   * </p>
   *
   * <pre>
   * amadeus.ereputation.hotelSentiments.get(Params
   *   .with("hotelIds", "ELONMFS,ADNYCCTB"));</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public HotelSentiment[] get(Params params) throws ResponseException {
    Response response = client.get("/v2/e-reputation/hotel-sentiments", params);
    return (HotelSentiment[]) Resource.fromArray(response, HotelSentiment[].class);
  }
}
