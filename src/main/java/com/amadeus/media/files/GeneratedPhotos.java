package com.amadeus.media.files;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.GeneratedPhoto;
import com.amadeus.resources.Resource;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v2/media/files/generated-photos</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.media.files.generatedPhotos;</pre>
 */
public class GeneratedPhotos {
  private Amadeus client;

  /**
   * Constructor.
   * @hide
   */
  public GeneratedPhotos(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   *   Returns a link to download a rendered image of a landscape.
   * </p>
   *
   * <pre>
   * amadeus.media.files.generatedPhotos.get(Params
   *   .with("category", "BEACH"));</pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public GeneratedPhoto get(Params params) throws ResponseException {
    Response response = client.get("/v2/media/files/generated-photos", params);
    return (GeneratedPhoto) Resource.fromObject(response, GeneratedPhoto.class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see GeneratedPhotos#get()
   */
  public GeneratedPhoto get() throws ResponseException {
    return get(null);
  }
}
