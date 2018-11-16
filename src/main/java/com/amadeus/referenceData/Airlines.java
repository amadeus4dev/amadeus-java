package com.amadeus.referenceData;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Airline;
import com.amadeus.resources.Resource;
import com.google.gson.Gson;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/reference-data/airlines</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.referenceData.airlines;</pre>
 */
public class Airlines {
  private Amadeus client;

  /**
   * Constructor.
   * @hide
   */
  public Airlines(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   *  Returns the airline name and code.
   * </p>
   *
   * <pre>
   * amadeus.referenceData.airlines.get(Params
   *   .with("airlineCodes", "BA"));</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public Airline[] get(Params params) throws ResponseException {
    Response response = client.get("/v1/reference-data/airlines", params);
    return (Airline[]) Resource.fromArray(response, Airline[].class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see Airlines#get()
   */
  public Airline[] get() throws ResponseException {
    return get(null);
  }
}
