package com.amadeus;

import java.lang.IllegalArgumentException;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * The configuration for the Amadeus API client.
 */
@Accessors(chain = true)
public class Configuration {
  /**
   * The client ID used to authenticate the API calls.
   * @param clientId The client ID
   * @return The client ID
   */
  private @Getter @Setter String clientId;
  /**
   * The client secret used to authenticate the API calls.
   * @param clientSecret The client secret
   * @return The client secret
   */
  private @Getter @Setter String clientSecret;

  protected Configuration() {}

  /**
   * Builds an Amadeus client using the given documentation.
   *
   * @return an Amadeus client
   * @throws IllegalArgumentException when a client ID or secret are missing
   */
  public Amadeus build() throws IllegalArgumentException {
    ensureRequired("clientId", clientId);
    ensureRequired("clientSecret", clientSecret);
    return new Amadeus(this);
  }

  private void ensureRequired(String key, String value) throws IllegalArgumentException {
    if (value == null) {
      String message = String.format("Missing required argument: %s", key);
      throw new IllegalArgumentException(message);
    }
  }
}
