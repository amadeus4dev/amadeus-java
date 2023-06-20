package com.amadeus;

import com.amadeus.ordering.TransferOrder;
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
  private Amadeus client;

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/ordering/transfer-orders</code> endpoints.
   * </p>
   */
  public TransferOrders transferOrders;

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/ordering/transafer-orders/:orderId</code> endpoints.
   * </p>
   */
  public TransferOrder transferOrder(String orderId) {
    return new TransferOrder(client, orderId);
  }

  /**
   * Constructor.
   * @hide
   */
  public Ordering(Amadeus client) {
    this.transferOrders = new TransferOrders(client);
    this.client = client;
  }
}
