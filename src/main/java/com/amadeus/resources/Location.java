package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * An Location object as returned by the Locaion API.
 * @see com.amadeus.referenceData.Location#get()
 */
@ToString
public class Location extends Resource {
  private @Getter String type;
  private @Getter String subType;
  private @Getter String name;
  private @Getter String detailedName;
  private @Getter String timeZoneOffset;
  private @Getter String iataCode;
  private @Getter GeoCode geoCode;
  private @Getter Address address;
  private @Getter Distance distance;
  private @Getter Analytics analytics;
  private @Getter Double relevance;

  protected Location() {}

  /**
   * An Location-related object as returned by the Location API.
   * @see com.amadeus.referenceData.Location#get()
   */
  @ToString
  public class GeoCode {
    private @Getter double latitude;
    private @Getter double longitude;

    protected GeoCode() {}
  }

  /**
   * An Location-related object as returned by the Location API.
   * @see com.amadeus.referenceData.Location#get()
   */
  @ToString
  public class Address {
    private @Getter String cityName;
    private @Getter String cityCode;
    private @Getter String countryName;
    private @Getter String countryCode;
    private @Getter String regionCode;

    protected Address() {}
  }

  /**
   * An Location-related object as returned by the Location API.
   * @see com.amadeus.referenceData.Location#get()
   */
  @ToString
  public class Distance {
    private @Getter Double value;
    private @Getter String unit;

    protected Distance() {}
  }

  /**
   * An Location-related object as returned by the Location API.
   * @see com.amadeus.referenceData.Location#get()
   */
  @ToString
  public class Analytics {
    private @Getter Flights flights;
    private @Getter Travelers travelers;

    protected Analytics() {}

    /**
     * An Location-related object as returned by the Location API.
     * @see com.amadeus.referenceData.Location#get()
     */
    @ToString
    public class Flights {
      private @Getter Double score;

      protected Flights() {}
    }

    /**
     * An Location-related object as returned by the Location API.
     * @see com.amadeus.referenceData.Location#get()
     */
    @ToString
    public class Travelers {
      private @Getter Double score;

      protected Travelers() {}
    }
  }
}
