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
  public static final String VERSION = "6.3.0";

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

  /**
   * <p>
   * A namespaced client for the <code>/v1/airport</code> endpoints.
   * </p>
   */
  public Airport airport;

  /**
   * <p>
   * A namespaced client for the <code>/v1/booking</code> endpoints.
   * </p>
   */
  public Booking booking;

  /**
   * <p>
   * A namespaced client for the <code>/v2/media</code> endpoints.
   * </p>
   */
  public Media media;

  /**
   * <p>
   * A namespaced client for the <code>/v1/safety</code> endpoints.
   * </p>
   */
  public Safety safety;

  /**
   * <p>
   * A namespaced client for the <code>/v2/schedule</code> endpoints.
   * </p>
   */
  public Schedule schedule;

  /**
   * <p>
   * A namespaced client for the <code>/v1/analytics</code> endpoints.
   * </p>
   */
  public Analytics analytics;

  /**
   * <p>
   * A namespaced client for the <code>/v1/duty-of-care</code> endpoints.
   * </p>
   */
  public DutyOfCare dutyOfCare;

  /**
   * <p>
   * A namespaced client for the <code>/v1/location</code> endpoints.
   * </p>
   */
  public Location location;

  /**
   * <p>
   * A namespaced client for the <code>/v1/airline</code> endpoints.
   * </p>
   */
  public Airline airline;

  protected Amadeus(Configuration configuration) {
    super(configuration);
    this.referenceData = new ReferenceData(this);
    this.travel = new Travel(this);
    this.shopping = new Shopping(this);
    this.ereputation = new EReputation(this);
    this.airport = new Airport(this);
    this.booking = new Booking(this);
    this.media = new Media(this);
    this.safety = new Safety(this);
    this.schedule = new Schedule(this);
    this.analytics = new Analytics(this);
    this.dutyOfCare = new DutyOfCare(this);
    this.location = new Location(this);
    this.airline = new Airline(this);
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
