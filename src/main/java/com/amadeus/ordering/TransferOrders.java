package com.amadeus.ordering;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Resource;
import com.amadeus.resources.TransferOrder;
import com.google.gson.JsonObject;

/**
 * <p>
 * A namespaced client for the
 * <code>/v1/ordering/transfer-orders</code> endpoints.
 * </p>
 *
 * <p>
 * Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder(API_KEY, API_SECRET).build();
 * amadeus.ordering.transferOrders;</pre>
 */
public class TransferOrders {
  private Amadeus client;
  private static final String TRANSFER_ORDERS_URL = "/v1/ordering/transfer-orders";

  /**
   * Constructor.
   *
   * @hide
   */
  public TransferOrders(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   *   The Amadeus Transfer Offers API allows travelers to book private transfers.
   * </p>
   *
   * <pre>
   * amadeus.ordering.transferOrders.post(body);</pre>
   *
   * @param body the parameters to send to the API as a JsonObject
   * @param params URL parameters
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public TransferOrder post(JsonObject body, Params params) throws ResponseException {
    Response response = client.post(TRANSFER_ORDERS_URL, params, body);
    return (TransferOrder) Resource.fromObject(response, TransferOrder.class);
  }

  /**
   * <p>
   *   The Amadeus Transfer Offers API allows travelers to book private transfers.
   * </p>
   *
   * <pre>
   * amadeus.ordering.transferOrders.post(body);</pre>
   *
   * @param body the parameters to send to the API as a String
   * @param params URL parameters
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public TransferOrder post(String body, Params params) throws ResponseException {
    Response response = client.post(TRANSFER_ORDERS_URL, params, body);
    return (TransferOrder) Resource.fromObject(response, TransferOrder.class);
  }

}
