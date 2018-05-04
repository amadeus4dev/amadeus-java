package com.amadeus;

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
 */
public class ReferenceData {
  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v2/reference-data/urls</code> endpoints.
   * </p>
   */
  public Urls urls;

  /**
   * Constructor.
   * @hide
   */
  public ReferenceData(Amadeus client) {
    this.urls = new Urls(client);
  }
}
