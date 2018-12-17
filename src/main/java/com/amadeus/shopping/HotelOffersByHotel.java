package com.amadeus.shopping;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.HotelOffer;
import com.amadeus.resources.Resource;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v2/shopping/hotel-offers/by-hotel</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.shopping.HotelOffersByHotel;</pre>
 */
public class HotelOffersByHotel {
  private Amadeus client;

  /**
   * Constructor.
   * @hide
   */
  public HotelOffersByHotel(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   *   Get all offers for a dedicated hotel.
   * </p>
   *
   * <pre>
   * amadeus.shopping.HotelOffersByHotel.get(Params
   *   .with("hotelId", "XKPARC12"));</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public HotelOffer get(Params params) throws ResponseException {
    Response response = client.get("/v2/shopping/hotel-offers/by-hotel", params);
    return (HotelOffer) Resource.fromObject(response, HotelOffer.class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see HotelOffersByHotel#get()
   */
  public HotelOffer get() throws ResponseException {
    return get(null);
  }
}
