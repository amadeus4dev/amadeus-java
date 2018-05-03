package com.amadeus.client;

import com.amadeus.Amadeus;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;


public class ConfigurableClient {
  /**
   * All the config for the API com.amadeus.client.
   *
   * @hide
   *
   * @return The config for this API com.amadeus.client
   */
  private final @Getter Configuration configuration;

  public ConfigurableClient(Configuration configuration) {
    this.configuration = configuration;
  }

  /**
   * Creates a builder object that can be used to build
   * an Amadeus com.amadeus.client.
   *
   * <pre>
   * Amadeus amadeus = Amadeus.builder("CLIENT_ID", "CLIENT_SECRET").build();
   * </pre>
   *
   * @param clientId Your API com.amadeus.client credential ID
   * @param clientSecret Your API com.amadeus.client credential secret
   * @return a Configuration object
   */
  public static Configuration builder(@NonNull String clientId, @NonNull String clientSecret) {
    return new Configuration(clientId, clientSecret);
  }

  /**
   * Creates a builder object initialized with the environment variables that can be used to
   * build an Amadeus API com.amadeus.client.
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
