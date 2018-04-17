package com.amadeus;

import java.lang.NullPointerException;
import java.util.Map;
import java.util.logging.Logger;

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
  /**
   * The logger that will be used to debug or warn to.
   * @param logger The logger object
   * @return The logger object
   */
  private @Getter @Setter Logger logger;
  /**
   * The log level. Can be 'silent', 'warn', or 'debug'.
   * Defaults to 'silent'.
   *
   * @param logLevel The log level for the logger
   * @return The log level for the logger
   */
  private @Getter @Setter String logLevel;
  /**
   * The the name of the server API calls are made to, 'production' or 'test'.
   * Defaults to 'test'
   *
   * @param hostname The name of the server API calls are made to
   * @return The name of the server API calls are made to
   */
  private @Getter @Setter String hostname;
  /**
   * The optional custom host domain to use for API calls.
   * Defaults to internal value for 'hostname'.
   *
   * @param host The optional custom host domain to use for API calls.
   * @return The optional custom host domain to use for API calls.
   */
  private @Getter @Setter String host;
  /**
   * Wether to use SSL. Defaults to True
   *
   * @param ssl A boolean specifying if the connection should use SSL
   * @return A boolean specifying if the connection should use SSL
   */
  private @Getter @Setter boolean ssl;
  /**
   * The port to use. Defaults to 443 for an SSL connection, and 80 for
   * a non SSL connection.
   *
   * @param port The port to use for the connection
   * @return The port to use for the connection
   */
  private @Getter @Setter int port;

  // A protected override for the system environment
  protected @Setter Map<String, String> environment;

  protected Configuration() {
    this.environment = System.getenv();
    this.logger = Logger.getLogger("Amadeus");
    this.logLevel = "silent";
    this.hostname = "test";
    this.host = "test.api.amadeus.com";
    this.ssl = true;
    this.port = 443;
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
    this.setEnvironment(null);
  }

  // Checks if a required value is present
  private void ensureRequired(String key, String value) throws NullPointerException {
    if (value == null) {
      String message = String.format("Missing required argument: %s", key);
      throw new NullPointerException(message);
    }
  }
}
