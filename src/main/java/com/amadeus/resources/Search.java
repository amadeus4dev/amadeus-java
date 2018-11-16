package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

@ToString
public class Search extends Resource {
  protected Search() { }

  private @Getter String subType;
  private @Getter String destination;
  private @Getter Analytics analytics;

  /**
   * An Search-related object as returned by the AirTraffic API.
   *
   * @see Searched#get()
   */
  @ToString
  public class Analytics {
    protected Analytics() {}

    private @Getter Searches searches;
  }

  /**
   * An Search-related object as returned by the AirTraffic API.
   *
   * @see Searched#get()
   */
  @ToString
  public class Searches {
    protected Searches() {}

    private @Getter Double score;
  }
}
