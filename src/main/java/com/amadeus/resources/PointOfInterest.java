package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * A PointOfInterest object as returned by the Location API.
 * @see com.amadeus.referenceData.locations.PointOfInterest#get()
 */
@ToString
public class PointOfInterest extends Resource {
  private @Getter String type;
  private @Getter String subType;
  private @Getter String name;
  private @Getter GeoCode geoCode;
  private @Getter String category;
  private @Getter String[] tags;

  protected PointOfInterest() {}

  /**
   * An PointOfInterest-related object as returned by the PointOfInterest API.
   * @see com.amadeus.referenceData.locations.PointOfInterest#get()
   */
  @ToString
  public class GeoCode {
    private @Getter double latitude;
    private @Getter double longitude;

    protected GeoCode() {}
  }

}
