package com.amadeus.shopping;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Resource;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v3/shopping/hotel-offers/:offer_id</code> endpoints.
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
public class HotelOffer {
  private Amadeus client;
  private String offerId;

  /**
   * Constructor.
   * @hide
   */
  public HotelOffer(Amadeus client, String offerId) {
    this.offerId = offerId;
    this.client = client;
  }

  /**
   * <p>
   *   Returns details for a specific offer.
   * </p>
   *
   * <pre>
   * amadeus.shopping.HotelOffer("XXX").get();</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public com.amadeus.resources.HotelOffer get(Params params) throws ResponseException {
    String path = String.format("/v3/shopping/hotel-offers/%s", offerId);
    Response response = client.get(path, params);
    return (com.amadeus.resources.HotelOffer) Resource.fromObject(
        response, com.amadeus.resources.HotelOffer.class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see HotelOffer#get()
   */
  public com.amadeus.resources.HotelOffer get() throws ResponseException {
    return get(null);
  }
}
