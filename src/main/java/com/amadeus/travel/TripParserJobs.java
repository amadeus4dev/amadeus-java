package com.amadeus.travel;

import com.amadeus.Amadeus;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Resource;
import com.amadeus.resources.TripParser;
import com.google.gson.JsonObject;

/**
 * <p>
 * A namespaced client for the
 * <code>//v2/travel/trip-parser-jobs</code> endpoints.
 * </p>
 *
 * <p>
 * Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder(API_KEY, API_SECRET).build();
 * amadeus.travel.tripParserJobs;</pre>
 */
public class TripParserJobs {
  private Amadeus client;

  /**
   * Constructor.
   *
   * @hide
   */
  public TripParserJobs(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   * Sends the content of your booking and triggers the parsing job.
   * </p>
   *
   * <pre>
   * amadeus.travel.tripParserJobs.post(body);</pre>
   *
   * @param body the parameters to send to the API as a JSonObject
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public TripParser post(JsonObject body) throws ResponseException {
    Response response = client.post("/v2/travel/trip-parser-jobs", body);
    return (TripParser) Resource.fromObject(response, TripParser.class);
  }

  /**
   * <p>
   * Sends the content of your booking and triggers the parsing job.
   * </p>
   *
   * <pre>
   * amadeus.travel.tripParserJobs.post(body);</pre>
   *
   * @param body the parameters to send to the API as a String
   * @return an API resource
   * @throws ResponseException when an exception occurs
   */
  public TripParser post(String body) throws ResponseException {
    Response response = client.post("/v2/travel/trip-parser-jobs", body);
    return (TripParser) Resource.fromObject(response, TripParser.class);
  }

  /**
   * Convenience method for calling <code>post</code> without any parameters.
   *
   * @see TripParserJobs#post()
   */
  public TripParser post() throws ResponseException {
    return post((String) null);
  }
}
