package com.amadeus.travel.predictions;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Prediction;
import com.amadeus.resources.Resource;


/**
 * <p>
 * A namespaced client for the
 * <code>/v1/travel/predictions/trip-purpose</code> endpoints.
 * </p>
 *
 * <p>
 * Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.travel.predictions.tripPurpose;</pre>
 */
public class TripPurpose {
  private Amadeus client;

  /**
   * Constructor.
   *
   * @hide
   */
  public TripPurpose(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   * Returns a trip purpose prediction.
   * </p>
   *
   * <pre>
   * amadeus.travel.predictions.tripPurpose.get(Params
   *   .with("originLocationCode", "NYC")
   *   .with("destinationLocationCode", "MAD")
   *   .with("departureDate", "2020-08-01")
   *   .and("returnDate", "2020-08-12"));
   *   </pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public Prediction get(Params params) throws ResponseException {
    Response response = client.get("/v1/travel/predictions/trip-purpose", params);
    return (Prediction) Resource.fromObject(response, Prediction.class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   *
   * @see TripPurpose#get()
   */
  public Prediction get() throws ResponseException {
    return get(null);
  }
}
