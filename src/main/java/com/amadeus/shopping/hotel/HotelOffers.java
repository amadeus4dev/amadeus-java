package com.amadeus.shopping.hotel;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/shopping/hotels/:hotel_id/hotel-offers</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.shopping.hotel(hotelId).hotelOffers;</pre>
 */
public class HotelOffers {
  private Amadeus client;
  private String hotelId;

  /**
   * Constructor.
   * @hide
   */
  public HotelOffers(Amadeus client, String hotelId) {
    this.client = client;
    this.hotelId = hotelId;
  }

  /**
   * <p>
   *   Get one hotel and its available offers.
   * </p>
   *
   * <pre>
   * amadeus.shopping.hotel("SMPARCOL").hotelOffers.get();</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public Response get(Params params) throws ResponseException {
    String path = String.format("/v1/shopping/hotels/%s/hotel-offers", hotelId);
    return client.get(path, params);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see HotelOffers#get()
   */
  public Response get() throws ResponseException {
    return get(null);
  }
}
