package com.amadeus.resources;

import java.util.HashMap;
import lombok.Getter;
import lombok.ToString;

@ToString
public class FareSearch extends Resource {
  private @Getter String type;
  private @Getter String period;
  private @Getter String origin;
  private @Getter String sourceCountry;
  private @Getter NumberOfSearches numberOfSearches;

  @ToString
  private class NumberOfSearches {
    private @Getter HashMap<String, String> perDestination;
    private @Getter HashMap<String, Integer> perTripDuration;
    private @Getter HashMap<String, Integer> perDaysInAdvance;
  }
}
