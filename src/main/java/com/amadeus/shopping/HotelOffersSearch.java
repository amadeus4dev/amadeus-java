package com.amadeus.shopping;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.HotelOfferSearch;
import com.amadeus.resources.Resource;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v3/shopping/hotel-offers</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.shopping.hotelOffersSearch;</pre>
 */
public class HotelOffersSearch {
  private Amadeus client;

  /**
   * Constructor.
   * @hide
   */
  public HotelOffersSearch(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   *   Search for hotels and retrieve availability and rates information.
   * </p>
   *
   * <pre>
   * amadeus.shopping.hotelOffers.get(Params
   *   .with("hotelIds", "MCLONGHM")
   *   .and("adults", 1)
   *   .and("checkInDate", "2022-11-22")
   *   .and("roomQuantity", 1)
   *   .and("paymentPolicy", "NONE")
   *   .and("bestRateOnly", true)); </pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public HotelOfferSearch[] get(Params params) throws ResponseException {
    Response response = client.get("/v3/shopping/hotel-offers", params);
    return (HotelOfferSearch[]) Resource.fromArray(response, HotelOfferSearch[].class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see HotelOffersSearch#get()
   */
  public HotelOfferSearch[] get() throws ResponseException {
    return get(null);
  }
}
