package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * An Period object as returned by the BusiestPeriod API.
 * @see Traveled#get()
 */
@ToString
public class Period extends Resource {
  protected Period() {}

  private @Getter String type;
  private @Getter String period;
  private @Getter Analytics analytics;

  /**
   * An Period-related object as returned by the Busiest Period API.
   * @see Traveled#get()
   */
  @ToString
  public class Analytics {
    protected Analytics() {}

    private @Getter Travelers travelers;

    /**
     * An Period-related object as returned by the BusiestPeriod API.
     * @see Traveled#get()
     */
    @ToString
    public class Travelers {
      protected Travelers() {}

      private @Getter Double score;
    }
  }
}
