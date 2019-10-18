package com.amadeus;

import com.amadeus.ereputation.HotelSentiments;

public class EReputation {
  private Amadeus client;

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v2/e-reputation/hotel-sentiments</code> endpoints.
   * </p>
   */
  public HotelSentiments hotelSentiments;

  public EReputation(Amadeus client) {
    this.client = client;
    this.hotelSentiments = new HotelSentiments(client);
  }
}
