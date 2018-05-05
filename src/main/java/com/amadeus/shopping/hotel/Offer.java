package com.amadeus.shopping.hotel;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/shopping/hotel/:hotel_id/offers</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.shopping.hotel(hotelId).offers;</pre>
 */
public class Offer {
  private Amadeus client;
  private String hotelId;
  private String offerId;

  /**
   * Constructor.
   * @hide
   */
  public Offer(Amadeus client, String hotelId, String offerId) {
    this.client = client;
    this.hotelId = hotelId;
    this.offerId = offerId;
  }

  /**
   * <p>
   *   Get room and rate details.
   * </p>
   *
   * <pre>
   * amadeus.shopping.hotel("SMPARCOL")
   *   .offer("AC7D4DA2C322A73AF0824318A4965DA2805A3FC2")
   *   .get();</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public Response get(Params params) throws ResponseException {
    String path = String.format("/v1/shopping/hotels/%s/offers/%s", hotelId, offerId);
    return client.get(path, params);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see Offer#get()
   */
  public Response get() throws ResponseException {
    return get(null);
  }
}
