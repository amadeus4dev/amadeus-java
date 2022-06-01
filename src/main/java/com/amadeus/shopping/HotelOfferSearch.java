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
 * amadeus.shopping.HotelOfferSearch(offerId);</pre>
 *
 * @hide
 */
public class HotelOfferSearch {
  private Amadeus client;
  private String offerId;

  /**
   * Constructor.
   * @hide
   */
  public HotelOfferSearch(Amadeus client, String offerId) {
    this.offerId = offerId;
    this.client = client;
  }

  /**
   * <p>
   *   Returns details for a specific offer.
   * </p>
   *
   * <pre>
   * amadeus.shopping.HotelOfferSearch("XXX").get();</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public com.amadeus.resources.HotelOfferSearch get(Params params) throws ResponseException {
    String path = String.format("/v3/shopping/hotel-offers/%s", offerId);
    Response response = client.get(path, params);
    return (com.amadeus.resources.HotelOfferSearch) Resource.fromObject(
      response, com.amadeus.resources.HotelOfferSearch.class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see HotelOffer#get()
   */
  public com.amadeus.resources.HotelOfferSearch get() throws ResponseException {
    return get(null);
  }
}
