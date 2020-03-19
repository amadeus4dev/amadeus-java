package com.amadeus.shopping;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Resource;
import com.amadeus.resources.SeatMap;
import com.google.gson.JsonObject;

/**
 * <p>
 * A namespaced client for the
 * <code>/v1/shopping/seatmaps</code> endpoints.
 * </p>
 *
 * <p>
 * Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder(API_KEY, API_SECRET).build();
 * amadeus.shopping.seatMaps;</pre>
 */
public class SeatMaps {
  private Amadeus client;

  /**
   * Constructor.
   *
   * @hide
   */
  public SeatMaps(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   * The SeatMap API allows you to retrieve the seat map of one or several
   * flights based on the flight-orderId returned by the Flight Create Orders API.
   * </p>
   *
   * <pre>
   * amadeus.shopping.seatMaps.get(params);</pre>
   *
   * @param params the parameters to send to the API
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public SeatMap[] get(Params params) throws ResponseException {
    Response response = client.get("/v1/shopping/seatmaps", params);
    return (SeatMap[]) Resource.fromArray(response, SeatMap[].class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see SeatMaps#get()
   */
  public SeatMap[] get() throws ResponseException {
    return get(null);
  }

  /**
   * <p>
   * The SeatMap API allows you to retrieve the seat map of one or several
   * Take the body of a flight offer search or flight offer price and pass
   * it in to this method to get a seatmap.
   * </p>
   *
   * <pre>
   * amadeus.shopping.seatMaps.post(body);</pre>
   *
   * @param body the parameters to send to the API as a JSonObject
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public SeatMap[] post(JsonObject body) throws ResponseException {
    Response response = client.post("/v1/shopping/seatmaps", body);
    return (SeatMap[]) Resource.fromArray(response, SeatMap[].class);
  }

  /**
   * <p>
   * The SeatMap API allows you to retrieve the seat map of one or several
   * Take the body of a flight offer search or flight offer price and pass
   * it in to this method to get a seatmap.
   * </p>
   *
   * <pre>
   * amadeus.shopping.seatMaps.post(body);</pre>
   *
   * @param body the parameters to send to the API as a String
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public SeatMap[] post(String body) throws ResponseException {
    Response response = client.post("/v1/shopping/seatmaps", body);
    return (SeatMap[]) Resource.fromArray(response, SeatMap[].class);
  }

  /**
   * Convenience method for calling <code>post</code> without any parameters.
   *
   * @see SeatMaps#post()
   */
  public SeatMap[] post() throws ResponseException {
    return post((String) null);
  }
}
