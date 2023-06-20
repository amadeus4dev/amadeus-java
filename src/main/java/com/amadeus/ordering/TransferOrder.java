package com.amadeus.ordering;

import com.amadeus.Amadeus;
import com.amadeus.ordering.transferOrders.Transfers;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/ordering/transfer-orders/:orderId</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder(API_KEY, API_SECRET).build();
 * amadeus.ordering.transferOrder(orderId);</pre>
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

  