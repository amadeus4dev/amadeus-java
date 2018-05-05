package com.amadeus.resources;

import com.amadeus.travel.analytics.airTraffic.Traveled;
import lombok.Getter;
import lombok.ToString;

/**
 * An AirTraffic object as returned by the AirTraffic API.
 * @see Traveled#get()
 */
@ToString
public class AirTraffic extends Resource {
  protected AirTraffic() {}

  private @Getter String type;
  private @Getter String subType;
  private @Getter String destination;
  private @Getter Analytics analytics;

  /**
   * An AirTraffic-related object as returned by the AirTraffic API.
   * @see Traveled#get()
   */
  @ToString
  public class Analytics {
    protected Analytics() {}

    private @Getter Flights flights;
    private @Getter Travellers travellers;

    /**
     * An AirTraffic-related object as returned by the AirTraffic API.
     * @see Traveled#get()
     */
    @ToString
    public class Flights {
      protected Flights() {}

      private @Getter Double score;
    }

    /**
     * An AirTraffic-related object as returned by the AirTraffic API.
     * @see Traveled#get()
     */
    @ToString
    public class Travellers {
      protected Travellers() {}

      private @Getter Double score;
    }
  }
}
