package com.amadeus;

import com.amadeus.client.Configuration;
import com.amadeus.client.HTTPClient;
import lombok.ToString;

/**
 * <p>The Amadeus API client. To initialize, use the builder as follows:</p>
 *
 * <pre>
 *   Amadeus amadeus = Amadeus.builder("CLIENT_ID", "CLIENT_SECRET").build();
 * </pre>
 *
 * <p>Or pass in environment variables directly:</p>
 *
 * <pre>
 *   Amadeus.builder(System.getenv()).build();
 * </pre>
 */
@ToString
public class Amadeus extends HTTPClient {
  /**
   * The API version
   */
  public static final String VERSION = "1.0.0";

  /**
   * Construct a new Amadeus client with a given configuration.
   *
   * @hide as we prefer to use the `build` methods.
   */
  public Amadeus(Configuration configuration) {
    super(configuration);
  }
}
