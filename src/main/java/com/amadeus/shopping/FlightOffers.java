package com.amadeus.shopping;

import com.amadeus.Amadeus;
import com.amadeus.shopping.flightOffers.Prediction;

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
  public Prediction prediction;

  /**
   * Constructor.
   * @hide
   */
  public FlightOffers(Amadeus client) {
    this.client = client;
    this.prediction = new Prediction(client);
  }

}
