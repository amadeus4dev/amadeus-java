package com.amadeus.referenceData;

import com.amadeus.Amadeus;
import com.amadeus.referenceData.urls.CheckinLinks;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v2/reference-data/urls</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.referenceData.urls;</pre>
 */
public class Urls {
  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v2/reference-data/urls/checkin-links</code> endpoints.
   * </p>
   */
  public CheckinLinks checkinLinks;

  /**
   * Constructor.
   * @hide
   */
  public Urls(Amadeus client) {
    this.checkinLinks = new CheckinLinks(client);
  }
}
