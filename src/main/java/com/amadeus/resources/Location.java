package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

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

  @ToString
  private class GeoCode {
    private @Getter double latitude;
    private @Getter double longitude;
  }

  @ToString
  private class Address {
    private @Getter String cityName;
    private @Getter String cityCode;
    private @Getter String countryName;
    private @Getter String countryCode;
    private @Getter String regionCode;
  }

  @ToString
  private class Distance {
    private @Getter Double value;
    private @Getter String unit;
  }

  @ToString
  private class Analytics {
    private @Getter Flights flights;
    private @Getter Travellers travellers;

    @ToString
    private class Flights {
      private @Getter Double score;
    }

    @ToString
    private class Travellers {
      private @Getter Double score;
    }
  }
}
