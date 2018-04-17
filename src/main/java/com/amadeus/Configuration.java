package com.amadeus;

import java.lang.NullPointerException;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * The configuration for the Amadeus API client.
 */
@Accessors(chain = true)
@ToString
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

  // A protected override for the system environment
  protected @Getter @Setter Map<String, String> environment;

  protected Configuration() {
    this.environment = System.getenv();
    // this.logger =
    // this.logLevel =
    // this.hostname =
    // this.host =
    // this.ssl = true;
    // this.port = 443;
    // this.customAppId = null;
    // this.customAppVersion = null;
    // this.http =   
  }

  /**
   * Builds an Amadeus client using the given documentation.
   *
   * @return an Amadeus client
   * @throws NullPointerException when a client ID or secret are missing
   */
  public Amadeus build() throws NullPointerException {
    parseEnvironment();
    ensureRequired("clientId", getClientId());
    ensureRequired("clientSecret", getClientSecret());
    return new Amadeus(this);
  }

  // Parses the environment
  private void parseEnvironment() {
    this.clientId = environment.getOrDefault("AMADEUS_CLIENT_ID", clientId);
    this.clientSecret = environment.getOrDefault("AMADEUS_CLIENT_SECRET", clientSecret);
  }

  // Checks if a required value is present
  private void ensureRequired(String key, String value) throws NullPointerException {
    if (value == null) {
      String message = String.format("Missing required argument: %s", key);
      throw new NullPointerException(message);
    }
  }
}
