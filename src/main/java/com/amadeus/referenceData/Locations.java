package com.amadeus.referenceData;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.referenceData.locations.Airports;
import com.amadeus.referenceData.urls.CheckinLinks;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v2/reference-data/locations</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.referenceData.locations;</pre>
 *
 * @hide
 */
public class Locations {
  public static String ANY = "AIRPORT,CITY";
  public static String AIRPORT = "AIRPORT";
  public static String CITY = "CITY";

  private Amadeus client;

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v2/reference-data/urls/checkin-links</code> endpoints.
   * </p>
   */
  public Airports airports;

  /**
   * Constructor.
   * @hide
   */
  public Locations(Amadeus client) {
    this.client = client;
    this.airports = new Airports(client);
  }

  /**
   * <p>
   *   Returns a list of airports and cities matching a given keyword.
   * </p>
   *
   * <pre>
   * amadeus.referenceData.locations.get(Params
   *   .with("keyword", "lon)
   *   .and("subType", Locations.ANY));</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public Response get(Params params) throws ResponseException {
    return client.get("/v1/reference-data/locations", params);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see Airports#get()
   */
  public Response get() throws ResponseException {
    return get(null);
  }
}
