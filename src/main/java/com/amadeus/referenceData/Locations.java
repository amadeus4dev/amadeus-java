package com.amadeus.referenceData;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.referenceData.locations.Airports;
import com.amadeus.referenceData.locations.Cities;
import com.amadeus.referenceData.locations.Hotel;
import com.amadeus.referenceData.locations.Hotels;
import com.amadeus.referenceData.locations.PointOfInterest;
import com.amadeus.referenceData.locations.PointsOfInterest;
import com.amadeus.resources.Location;
import com.amadeus.resources.Resource;

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
   *   <code>/v2/reference-data/locations/airports</code> endpoints.
   * </p>
   */
  public Airports airports;

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v2/reference-data/locations/pois</code> endpoints.
   * </p>
   */
  public PointsOfInterest pointsOfInterest;

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v2/reference-data/locations/pois</code> endpoints.
   * </p>
   */
  public PointOfInterest pointOfInterest;

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/reference-data/locations/hotels</code> endpoints.
   * </p>
   */
  public Hotels hotels;

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/reference-data/locations/hotel</code> endpoints.
   * </p>
   */
  public Hotel hotel;
  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/reference-data/locations/cities</code> endpoints.
   * </p>
   */
  public Cities cities;

  /**
   * Constructor.
   * @hide
   */
  public Locations(Amadeus client) {
    this.client = client;
    this.airports = new Airports(client);
    this.pointsOfInterest = new PointsOfInterest(client);
    this.hotels = new Hotels(client);
    this.hotel = new Hotel(client);
    this.cities = new Cities(client);
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
  public Location[] get(Params params) throws ResponseException {
    Response response = client.get("/v1/reference-data/locations", params);
    return (Location[]) Resource.fromArray(response, Location[].class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see Locations#get()
   */
  public Location[] get() throws ResponseException {
    return get(null);
  }

  public PointOfInterest pointOfInterest(String id) {
    return new PointOfInterest(client, id);
  }
}
