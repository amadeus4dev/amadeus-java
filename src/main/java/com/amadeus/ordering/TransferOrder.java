package com.amadeus.ordering;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.ordering.transferOrders.Transfers;
import com.amadeus.resources.Resource;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v2/shopping/hotel-offers/:offer_id</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder(API_KEY, API_SECRET).build();
 * amadeus.shopping.HotelOffer(offerId);</pre>
 *
 * @hide
 */
public class TransferOrder {
  public Amadeus client;
  public String orderId;
  public Transfers transfers;

  /**
   * Constructor.
   * @hide
   */
  public TransferOrder(Amadeus client, String orderId) {
    this.orderId = orderId;
    this.client = client;
    this.transfers = new Transfers(client, orderId);
  }

}

  