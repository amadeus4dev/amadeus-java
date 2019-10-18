package com.amadeus;

import java.util.Map;
import lombok.NonNull;

/**
 * <p>
 * The Amadeus API client. To initialize, use the builder as follows:
 * </p>
 *
 * <pre>
 * Amadeus amadeus =
 *     Amadeus.builder("REPLACE_BY_YOUR_API_KEY", "REPLACE_BY_YOUR_API_SECRET").build();
 * </pre>
 *
 * <p>
 * Or pass in environment variables directly:
 * </p>
 *
 * <pre>
 * Amadeus.builder(System.getenv()).build();
 * </pre>
 */
public class Amadeus extends HTTPClient {
  /**
   * The API version.
   */
  public static final String VERSION = "3.3.0";

  /**
   * <p>
   * A namespaced client for the <code>/v2/reference-data</code> endpoints.
   * </p>
   */
  public ReferenceData referenceData;

  /**
   * <p>
   * A namespaced client for the <code>/v1/travel</code> endpoints.
   * </p>
   */
  public Travel travel;

  /**
   * <p>
   * A namespaced client for the <code>/v1/shopping</code> endpoints.
   * </p>
   */
  public Shopping shopping;

  /**
   * <p>
   * A namespaced client for the <code>/v2/e-reputation</code> endpoints.
   * </p>
   */
  public EReputation ereputation;

  protected Amadeus(Configuration configuration) {
    super(configuration);
    this.referenceData = new ReferenceData(this);
    this.travel = new Travel(this);
    this.shopping = new Shopping(this);
    this.ereputation = new EReputation(this);
  }

  /**
   * Creates a builder object that can be used to build an Amadeus com.amadeus.client.
   *
   * <pre>
   * Amadeus amadeus = Amadeus.builder("CLIENT_ID", "CLIENT_SECRET").build();
   * </pre>
   *
   * @param clientId     Your API com.amadeus.client credential ID
   * @param clientSecret Your API com.amadeus.client credential secret
   * @return a Configuration object
   */
  public static Configuration builder(@NonNull String clientId, @NonNull String clientSecret) {
    return new Configuration(clientId, clientSecret);
  }

  /**
   * Creates a builder object initialized with the environment variables that can be used to build
   * an Amadeus API com.amadeus.client.
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
    String clientSecret = environment.get("AMADEUS_CLIENT_SECRET");

    Configuration configuration = Amadeus.builder(clientId, clientSecret);
    configuration.parseEnvironment(environment);

    return configuration;
  }
}
