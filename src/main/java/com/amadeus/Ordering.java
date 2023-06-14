package com.amadeus;

import com.amadeus.ordering.TransferOrders;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/ordering</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.ordering;</pre>
 *
 * @hide
 */
public class Ordering {
  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/ordering/transfer-orders</code> endpoints.
   * </p>
   */
  public TransferOrders tranferOrders;

  /**
   * Constructor.
   * @hide
   */
  public Ordering(Amadeus client) {
    this.tranferOrders = new TransferOrders(client);
  }
}
