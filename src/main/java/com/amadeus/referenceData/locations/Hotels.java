package com.amadeus.referenceData.locations;

import com.amadeus.Amadeus;
import com.amadeus.referenceData.locations.hotels.ByCity;
import com.amadeus.referenceData.locations.hotels.ByGeocode;
import com.amadeus.referenceData.locations.hotels.ByHotels;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/reference-data/locations/hotels</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.referenceData.locations.hotels;</pre>
 */
public class Hotels {
  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/reference-data/locations/hotels/by-city</code> endpoints.
   * </p>
   */
  public ByCity byCity;

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/reference-data/locations/hotels/by-hotels</code> endpoints.
   * </p>
   */
  public ByHotels byHotels;

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/reference-data/locations/hotels/by-geocode</code> endpoints.
   * </p>
   */
  public ByGeocode byGeocode;

  /**
   * Constructor.
   * @hide
   */
  public Hotels(Amadeus client) {
    this.byCity = new ByCity(client);
    this.byHotels = new ByHotels(client);
    this.byGeocode = new ByGeocode(client);
  }
}
