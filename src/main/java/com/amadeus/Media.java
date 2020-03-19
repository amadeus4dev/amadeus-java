package com.amadeus;

import com.amadeus.media.Files;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v2/media</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.media;</pre>
 *
 * @hide
 */
public class Media {
  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v2/media/files</code> endpoints.
   * </p>
   */
  public Files files;

  /**
   * Constructor.
   * @hide
   */
  public Media(Amadeus client) {
    this.files = new Files(client);
  }
}