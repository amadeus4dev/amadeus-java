package com.amadeus;

import com.amadeus.referencedata.Airlines;
import com.amadeus.referencedata.Location;
import com.amadeus.referencedata.Locations;
import com.amadeus.referencedata.RecommendedLocations;
import com.amadeus.referencedata.Urls;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v2/reference-data</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.referenceData;</pre>
 *
 * @hide
 */
public class ReferenceData {
  private Amadeus client;

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v2/reference-data/urls</code> endpoints.
   * </p>
   */
  public Urls urls;

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v2/reference-data/locations</code> endpoints.
   * </p>
   */
  public Locations locations;

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v2/reference-data/airlines</code> endpoints.
   * </p>
   */
  public Airlines airlines;

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/reference-data/recommended-locations</code> endpoints.
   * </p>
   */
  public RecommendedLocations recommendedLocations;


  /**
   * Constructor.
   * @hide
   */
  public ReferenceData(Amadeus client) {
    this.client = client;
    this.urls = new Urls(client);
    this.locations = new Locations(client);
    this.airlines = new Airlines(client);
    this.recommendedLocations = new RecommendedLocations(client);
  }

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v2/reference-data/location/:hotel_id</code> endpoints.
   * </p>
   */
  public Location location(String locationId) {
    return new Location(client, locationId);
  }
}
