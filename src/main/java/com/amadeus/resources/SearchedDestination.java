package com.amadeus.resources;

import java.util.HashMap;
import lombok.Getter;
import lombok.ToString;

/**
 * An SearchedDestination object as returned by the SearchedByDestination API.
 * @see com.amadeus.travel.analytics.airTraffic.SearchedByDestination#get()
 */
@ToString
public class SearchedDestination extends Resource {
  protected SearchedDestination() {}

  private @Getter String destination;
  private @Getter String subType;
  private @Getter Analytics analytics;

  /**
   * An AirTraffic-related object as returned by the AirTraffic API.
   * @see SearchedByDestination#get()
   */
  @ToString
  public class Analytics {
    protected Analytics() {
    }

    private @Getter Searches searches;
  }

  /**
   * An AirTraffic-related object as returned by the AirTraffic API.
   * @see SearchedByDestination#get()
   */
  @ToString
  public class Searches {
    protected Searches() {}

    private @Getter NumberOfSearches numberOfSearches;
  }

  /**
   * An SearchedDestination-related object as returned by the SearchedByDestination API.
   * @see SearchedByDestination#get()
   */
  @ToString
  public class NumberOfSearches {
    protected NumberOfSearches() {}

    private @Getter HashMap<String, Integer> perTripDuration;
    private @Getter HashMap<String, Integer> perDaysInAdvance;
  }
}
