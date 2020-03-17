package com.amadeus.media;

import com.amadeus.Amadeus;
import com.amadeus.media.files.GeneratedPhotos;

/**
 * <p>
 * A namespaced client for the
 * <code>/v2/media/files</code> endpoints.
 * </p>
 *
 * <p>
 * Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.media.files;</pre>
 *
 * @hide
 */
public class Files {
  /**
   * <p>
   * A namespaced client for the
   * <code>/v2/media/files/generated-photos</code> endpoints.
   * </p>
   */
  public GeneratedPhotos generatedPhotos;

  /**
   * Constructor.
   *
   * @hide
   */
  public Files(Amadeus client) {
    this.generatedPhotos = new GeneratedPhotos(client);
  }
}
