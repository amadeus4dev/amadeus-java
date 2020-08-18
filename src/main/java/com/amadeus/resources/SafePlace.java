package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * A SafePlace object as returned by the Safe Place API.
 * @see com.amadeus.safety.safety_rated_locations.SafePlace#get()
 */
@ToString
public class SafePlace extends Resource {
  protected SafePlace() {}

  private @Getter String type;
  private @Getter String id;
  private @Getter String subType;
  private @Getter String name;
  private @Getter GeoCode geoCode;
  private @Getter SafetyScores safetyScores;


  /**
   * An SafePlace-related object as returned by the SafePlace API.
   * @see com.amadeus.safety.safety_rated_locations.SafePlace#get()
   */
  @ToString
  public class GeoCode {
    protected GeoCode() {}

    private @Getter double latitude;
    private @Getter double longitude;
  }

  /**
   * An SafePlace-related object as returned by the SafePlace API.
   * @see com.amadeus.safety.safety_rated_locations.SafePlace#get()
   */
  @ToString
  public class SafetyScores {
    protected SafetyScores() {}

    private @Getter int women;
    private @Getter int physicalHarm;
    private @Getter int theft;
    private @Getter int politicalFreedom;
    private @Getter int lgbtq;
    private @Getter int medical;
    private @Getter int overall;

  }

}
