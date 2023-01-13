package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * An Period object as returned by the BusiestPeriod API.
 * @see Traveled#get()
 */
@ToString
public class Period extends Resource {
  private @Getter String type;
  private @Getter String period;
  private @Getter Analytics analytics;

  protected Period() {}

  /**
   * An Period-related object as returned by the Busiest Period API.
   * @see Traveled#get()
   */
  @ToString
  public class Analytics {
    private @Getter Travelers travelers;

    protected Analytics() {}

    /**
     * An Period-related object as returned by the BusiestPeriod API.
     * @see Traveled#get()
     */
    @ToString
    public class Travelers {
      private @Getter Double score;

      protected Travelers() {}
    }
  }
}
