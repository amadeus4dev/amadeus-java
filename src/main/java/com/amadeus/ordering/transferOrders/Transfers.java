package com.amadeus.ordering.transferOrders;

import com.amadeus.Amadeus;
import com.amadeus.ordering.transferOrders.transfers.Cancellation;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/ordering/transfer-orders/{orderId}/transfers/cancellation</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.ordering.transferOrders(orderId).urls;</pre>
 *
 * @hide
 */
public class Transfers {
  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/ordering/transfer-orders/{orderId}/transfers/cancellation</code> endpoints.
   * </p>
   */
  public Cancellation cancellation;

  /**
   * Constructor.
   * @hide
   */
  public Transfers(Amadeus client, String orderId) {
    this.cancellation = new Cancellation(client, orderId);
  }
}
