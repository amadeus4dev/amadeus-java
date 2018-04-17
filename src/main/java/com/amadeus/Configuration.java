package com.amadeus;

import java.lang.IllegalArgumentException;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
public class Configuration {
  private @Getter @Setter String clientId;
  private @Getter @Setter String clientSecret;

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
