package com.amadeus;

import java.util.Map;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;


/**
 * The Amadeus API client.
 */
@ToString public class Amadeus {
  // The version of the API.
  public static final String VERSION = "1.0.0";

  /**
   * All the config for the API client.
   * @return The config for this API client
   */
  private final @Getter Configuration configuration;

  protected Amadeus(Configuration configuration) {
    this.configuration = configuration;
  }

  /**
   * Creates a builder object that can be used to build
   * an Amadeus client.
   *
   * <pre>
   * Amadeus amadeus = Amadeus.builder("CLIENT_ID", "CLIENT_SECRET").build();
   * </pre>
   *
   * @param clientId Your API client credential ID
   * @param clientSecret Your API client credential secret
   * @return a Configuration object
   */
  public static Configuration builder(@NonNull String clientId, @NonNull String clientSecret) {
    return new Configuration(clientId, clientSecret);
  }

  /**
   * Creates a builder object initialized with the environment variables that can be used to
   * build an Amadeus API client.
   *
   * <pre>
   * Amadeus amadeus = Amadeus.builder(System.getenv()).build();
   * </pre>
   *
   * @param environment The system environment
   * @return a Configuration object
   */
  public static Configuration builder(Map<String, String> environment) {
    String clientId = environment.get("AMADEUS_CLIENT_ID");
    String clientSecret = environment.get("AMADEUS_CLIENT_ID");

    Configuration configuration = Amadeus.builder(clientId, clientSecret);
    configuration.parseEnvironment(environment);
    return configuration;
  }
}
