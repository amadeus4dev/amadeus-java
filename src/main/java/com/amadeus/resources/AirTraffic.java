/*NOSONAR*/

package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;



/**
 * An AirTraffic object as returned by the AirTraffic API.
 * @see Traveled#get()
 */
@ToString
public class AirTraffic extends Resource {
  private @Getter String type;
  private @Getter String subType;
  private @Getter String destination;
  private @Getter Analytics analytics;

  protected AirTraffic() {}

  /**
   * An AirTraffic-related object as returned by the AirTraffic API.
   * @see Traveled#get()
   */
  @ToString
  public class Analytics {
    private @Getter Flights flights;
    private @Getter Travelers travelers;

    protected Analytics() {}

    /**
     * An AirTraffic-related object as returned by the AirTraffic API.
     * @see Traveled#get()
     */
    @ToString
    public class Flights {
      private @Getter Double score;

      protected Flights() {}
    }

    /**
     * An AirTraffic-related object as returned by the AirTraffic API.
     * @see Traveled#get()
     */
    @ToString
    public class Travelers {
      private @Getter Double score;

      protected Travelers() {} // NOSONAR
    }
  }
}
