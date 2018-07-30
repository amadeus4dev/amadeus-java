package com.amadeus;

import com.amadeus.referenceData.Airlines;
import com.amadeus.referenceData.Location;
import com.amadeus.referenceData.Locations;
import com.amadeus.referenceData.Urls;

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
   * Constructor.
   * @hide
   */
  public ReferenceData(Amadeus client) {
    this.client = client;
    this.urls = new Urls(client);
    this.locations = new Locations(client);
    this.airlines = new Airlines(client);
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
