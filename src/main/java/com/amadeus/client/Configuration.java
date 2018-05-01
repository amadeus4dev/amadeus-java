package com.amadeus.client;

import com.amadeus.Amadeus;
import com.amadeus.Params;
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
  private static final Params HOSTS = Params
          .build("production", "api.amadeus.com")
          .put("test", "test.api.amadeus.com");

  /**
   * The client ID used to authenticate the API calls.
   *
   * @return The client ID
   */
  private @Getter String clientId;
  /**
   * The client secret used to authenticate the API calls.
   *
   * @return The client secret
   */
  private @Getter String clientSecret;
  /**
   * The logger that will be used to debug or warn to.
   *
   * @param logger The logger object
   * @return The logger object
   */
  private @Getter @Setter Logger logger = Logger.getLogger("Amadeus");
  /**
   * The log level. Can be 'silent', 'warn', or 'debug'.
   * Defaults to 'silent'.
   *
   * @param logLevel The log level for the logger
   * @return The log level for the logger
   */
  private @Getter @Setter String logLevel = "silent";
  /**
   * The the name of the server API calls are made to, 'production' or 'test'.
   * Defaults to 'test'
   *
   * @param hostname The name of the server API calls are made to
   * @return The name of the server API calls are made to
   */
  private @Getter String hostname = "test";
  /**
   * The optional custom host domain to use for API calls.
   * Defaults to internal value for 'hostname'.
   *
   * @param host The optional custom host domain to use for API calls.
   * @return The optional custom host domain to use for API calls.
   */
  private @Getter @Setter String host = "test.api.amadeus.com";
  /**
   * Wether to use SSL. Defaults to True
   *
   * @param ssl A boolean specifying if the connection should use SSL
   * @return A boolean specifying if the connection should use SSL
   */
  private @Getter boolean ssl = true;
  /**
   * The port to use. Defaults to 443 for an SSL connection, and 80 for
   * a non SSL connection.
   *
   * @param port The port to use for the connection
   * @return The port to use for the connection
   */
  private @Getter @Setter int port = 443;
  /**
   * An optional custom App ID to be passed in the User Agent to the
   * server (Defaults to null).
   *
   * @param customAppId An optional custom App ID
   * @return The optional custom App ID
   */
  private @Getter @Setter String customAppId;
  /**
   * An optional custom App version to be passed in the User Agent to the
   * server (Defaults to null).
   *
   * @param customAppVersion An optional custom App version
   * @return The optional custom App version
   */
  private @Getter @Setter String customAppVersion;

  protected Configuration(String clientId, String clientSecret) {
    this.clientId = clientId;
    this.clientSecret = clientSecret;
  }

  // Parses environment variables and initializes the values
  protected Configuration parseEnvironment(Map<String, String> environment) {
    setHostname(getOrDefault(environment, "HOSTNAME", hostname));
    setHost(getOrDefault(environment, "HOOST", host));
    setLogLevel(getOrDefault(environment, "LOG_LEVEL", logLevel));
    setSsl(Boolean.parseBoolean(getOrDefault(environment, "SSL", String.valueOf(ssl))));
    setPort(Integer.parseInt(getOrDefault(environment, "PORT", String.valueOf(port))));
    setCustomAppId(getOrDefault(environment, "CUSTOM_APP_ID", customAppId));
    setCustomAppVersion(getOrDefault(environment, "CUSTOM_APP_VERSION", customAppVersion));
    return this;
  }

  // Helper method for Java 7, as it's missing the getOrDefault method for Maps
  private String getOrDefault(Map<String, String> environment, String key, String defaultValue) {
    String value = environment.get(String.format("AMADEUS_%s", key));
    return (value == null) ? defaultValue : value;
  }

  /**
   * Builds an Amadeus client using the given documentation.
   *
   * @return an Amadeus client
   * @throws NullPointerException when a client ID or secret are missing
   */
  public Amadeus build() throws NullPointerException {
    return new Amadeus(this);
  }

  /**
   * The the name of the server API calls are made to, 'production' or 'test'.
   * Defaults to 'test'.
   *
   * @param hostname The name of the server API calls are made to
   * @return The name of the server API calls are made to
   */
  public Configuration setHostname(String hostname) {
    if (!HOSTS.containsKey(hostname)) {
      throw new IllegalArgumentException(
              String.format("Hostname %s not found in %s", hostname, HOSTS.keySet().toString()));
    }
    this.hostname = hostname;
    this.host = HOSTS.get(hostname);
    return this;
  }

  /**
   * Wether to use SSL. Defaults to True.
   *
   * @param ssl A boolean specifying if the connection should use SSL
   * @return A boolean specifying if the connection should use SSL
   */
  public Configuration setSsl(Boolean ssl) {
    this.ssl = ssl;
    if (!ssl && port == 443) {
      setPort(80);
    }
    return this;
  }
}
