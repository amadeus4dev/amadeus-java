package com.amadeus.shopping.flightOffers;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightPrice;
import com.amadeus.resources.Resource;
import com.google.gson.JsonObject;

/**
 * <p>
 * A namespaced client for the
 * <code>/v1/shopping/flight-offers/pricing</code> endpoints.
 * </p>
 *
 * <p>
 * Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder(API_KEY, API_SECRET).build();
 * amadeus.shopping.flightOffers.pricing;</pre>
 */
public class Pricing {

  private Amadeus client;

  /**
   * Constructor.
   *
   * @hide
   */
  public Pricing(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   * The Flight Offers Price REST/JSON API is an open price API that enables
   * you to get or confirm the price of a flight and obtain information
   * about taxes and fees to be applied to the entire journey.
   * It is usually used after the Flight Offers Search API. It also retrieves
   * ancillary information (e.g. additional bag or extra legroom seats pricing)
   * and the payment information details requested at booking time.
   * </p>
   *
   * <pre>
   * amadeus.shopping.flightOffers.pricing.post(body, params);</pre>
   *
   * @param body the parameters to send to the API as a String
   * @param params the parameters to send to the API
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public FlightPrice[] post(JsonObject body, Params params) throws ResponseException {
    Response response = client.post("/v1/shopping/flight-offers/pricing", params, body);
    return (FlightPrice[]) Resource.fromArray(response, FlightPrice[].class);
  }

  public FlightPrice[] post(String body, Params params) throws ResponseException {
    Response response = client.post("/v1/shopping/flight-offers/pricing", params, body);
    return (FlightPrice[]) Resource.fromArray(response, FlightPrice[].class);
  }


  public FlightPrice[] post(JsonObject body) throws ResponseException {
    Response response = client.post("/v1/shopping/flight-offers/pricing", body);
    return (FlightPrice[]) Resource.fromArray(response, FlightPrice[].class);
  }

  public FlightPrice[] post(String body) throws ResponseException {
    Response response = client.post("/v1/shopping/flight-offers/pricing", body);
    return (FlightPrice[]) Resource.fromArray(response, FlightPrice[].class);
  }

  public FlightPrice[] post() throws ResponseException {
    return post((String) null);
  }
}
