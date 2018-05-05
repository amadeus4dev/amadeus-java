package com.amadeus.resources;

import java.util.HashMap;
import lombok.Getter;
import lombok.ToString;

/**
 * An FareSearch object as returned by the FareSearch API.
 * @see com.amadeus.travel.analytics.FareSearches#get()
 */
@ToString
public class FareSearch extends Resource {
  protected FareSearch() {}

  private @Getter String type;
  private @Getter String period;
  private @Getter String origin;
  private @Getter String sourceCountry;
  private @Getter NumberOfSearches numberOfSearches;

  /**
   * An FareSearch-related object as returned by the FareSearch API.
   * @see com.amadeus.travel.analytics.FareSearches#get()
   */
  @ToString
  public class NumberOfSearches {
    protected NumberOfSearches() {}

    private @Getter HashMap<String, String> perDestination;
    private @Getter HashMap<String, Integer> perTripDuration;
    private @Getter HashMap<String, Integer> perDaysInAdvance;
  }
}
