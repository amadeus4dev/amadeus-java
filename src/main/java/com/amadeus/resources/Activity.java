package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * An Activity object as returned by the Tours and Activities API.
 * @see com.amadeus.shopping.Activity#get()
 */
@ToString
public class Activity extends Resource {
  protected Activity() {}

  private @Getter String type;
  private @Getter String id;
  private @Getter String name;
  private @Getter String shortDescription;
  private @Getter String description;
  private @Getter GeoCode geoCode;
  private @Getter String rating;
  private @Getter String bookingLink;
  private @Getter String minimumDuration;
  private @Getter ElementaryPrice price;
  private @Getter String[] pictures;


  /**
   * An Activity-related object as returned by the Tours and Activities API.
   * @see com.amadeus.shopping.Activity#get()
   */
  @ToString
  public class GeoCode {
    protected GeoCode() {}

    private @Getter double latitude;
    private @Getter double longitude;
  }

  @ToString
  public class ElementaryPrice {
    protected ElementaryPrice() {}

    private @Getter String amount;
    private @Getter String currencyCode;
  }
}
