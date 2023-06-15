package com.amadeus.ordering.transferOrders.transfers;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Resource;
import com.amadeus.resources.TransferCancellation;
import com.google.gson.JsonObject;

/**
 * <p>
 * A namespaced client for the
 * <code>/v1/ordering/transfer-orders/{orderId}/transfers/cancellation</code> endpoints.
 * </p>
 *
 * <p>
 * Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder(API_KEY, API_SECRET).build();
 * amadeus.ordering.transferOrder(orderId).transfers.cancellation;</pre>
 */
public class Cancellation {
  private Amadeus client;
  private String orderId;

  /**
   * Constructor.
   *
   * @hide
   */
  public Cancellation(Amadeus client, String orderId) {
    this.client = client;
    this.orderId = orderId;
  }

  /**
   * <p>
   *   The Amadeus Transfer Management API allows cancel private transfers.
   * </p>
   *
   * <pre>
   * amadeus.ordering.transferOrder(orderId).transfers.cancellation.post(params);</pre>
   *
   * @param params URL parameters
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public TransferCancellation post(Params params) throws ResponseException {
    String path = String.format("/v1/ordering/transfer-orders/%s/transfers/cancellation", orderId);
    Response response = client.post(path, params);
    return (TransferCancellation) Resource.fromObject(response, TransferCancellation.class);
  }

}
