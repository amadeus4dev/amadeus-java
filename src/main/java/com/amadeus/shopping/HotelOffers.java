package com.amadeus.shopping;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.HotelOffer;
import com.amadeus.resources.Resource;
import com.google.gson.Gson;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/shopping/hotel-offers</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.shopping.hotelOffers;</pre>
 */
public class HotelOffers {
  private Amadeus client;

  /**
   * Constructor.
   * @hide
   */
  public HotelOffers(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   *   SearchedDestination for hotels and retrieve availability and rates information.
   * </p>
   *
   * <pre>
   * amadeus.shopping.hotelOffers.get(Params
   *   .with("cityCode", "PAR"));</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public HotelOffer[] get(Params params) throws ResponseException {
    Response response = client.get("/v1/shopping/hotel-offers", params);
    return (HotelOffer[]) Resource.fromArray(response, HotelOffer[].class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see HotelOffers#get()
   */
  public HotelOffer[] get() throws ResponseException {
    return get(null);
  }
}
