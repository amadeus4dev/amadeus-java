package com.amadeus.shopping;

import com.amadeus.Amadeus;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Resource;
import com.amadeus.resources.TransferOffersPost;
import com.google.gson.JsonObject;

/**
 * <p>
 * A namespaced client for the
 * <code>/v1/shopping/transfer-offers</code> endpoints.
 * </p>
 *
 * <p>
 * Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder(API_KEY, API_SECRET).build();
 * amadeus.shopping.transferOffers;</pre>
 */
public class TransferOffers {
  private Amadeus client;

  /**
   * Constructor.
   *
   * @hide
   */
  public TransferOffers(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   *   The Amadeus Transfer Offers API allows travelers to search and bookig private transfers.
   * </p>
   *
   * <pre>
   * amadeus.shopping.transferOffers.post(body);</pre>
   *
   * @param body the parameters to send to the API as a JsonObject
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public TransferOffersPost[] post(JsonObject body) throws ResponseException {
    Response response = client.post("/v1/shopping/transfer-offers", body);
    return
      (TransferOffersPost[]) Resource.fromArray(response, TransferOffersPost[].class);
  }

  /**
   * <p>
   *   The Amadeus Transfer Offers API allows travelers to search and bookig private transfers.
   * </p>
   *
   * <pre>
   * amadeus.shopping.transferOffers.post(body);</pre>
   *
   * @param body the parameters to send to the API as a String
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public TransferOffersPost[] post(String body) throws ResponseException {
    Response response = client.post("/v1/shopping/transfer-offers", body);
    return
      (TransferOffersPost[]) Resource.fromArray(response, TransferOffersPost[].class);
  }

  /**
   * Convenience method for calling <code>post</code> without any parameters.
   *
   * @see TransferOffersPost#post()
   */
  public TransferOffersPost[] post() throws ResponseException {
    return post((String) null);
  }
}
