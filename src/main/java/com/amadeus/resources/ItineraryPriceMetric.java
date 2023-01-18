package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * A ItineraryPriceMetric object as returned by the Flight Price Analysis API.
 * @see com.amadeus.analytics.ItineraryPriceMetrics#get()
 */
@ToString
public class ItineraryPriceMetric extends Resource {
  private @Getter String type;
  private @Getter Location origin;
  private @Getter Location destination;
  private @Getter String departureDate;
  private @Getter String transportType;
  private @Getter String currencyCode;
  private @Getter Boolean oneWay;
  private @Getter PriceMetrics[] priceMetrics;

  protected ItineraryPriceMetric() {}

  @ToString
  public class Location {
    private @Getter String iataCode;

    protected Location() {}
  }

  @ToString
  public class PriceMetrics {
    private @Getter String amount;
    private @Getter String quartileRanking;

    protected PriceMetrics() {}
  }

}
