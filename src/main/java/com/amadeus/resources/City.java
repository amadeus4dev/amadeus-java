package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * A City object as returned by the City Search API.
 * @see com.amadeus.referencedata.locations.Cities#get()
 */
@ToString
public class City extends Resource {
  private @Getter String type;
  private @Getter Relationship[] relationships;
  private @Getter String subType;
  private @Getter String name;
  private @Getter String iataCode;
  private @Getter Address address;
  private @Getter Location.GeoCode geoCode;

  protected City() {}

  @ToString
  public class Relationship {
    private @Getter String id;
    private @Getter String type;
    private @Getter String href;

    protected Relationship() {}
  }

  @ToString
  public class Address {
    private @Getter String postalCode;
    private @Getter String countryCode;
    private @Getter String stateCode;

    protected Address() {}
  }
}
