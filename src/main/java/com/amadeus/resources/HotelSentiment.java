package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * An HotelSentiment object as returned by the Hotel Ratings API.
 * @see HotelSentiments#get()
 */

@ToString
public class HotelSentiment extends Resource {
  private @Getter String hotelId;
  private @Getter String type;
  private @Getter int overallRating;
  private @Getter int numberOfReviews;
  private @Getter Sentiment sentiments;

  protected HotelSentiment() {}

  @ToString
  public class Sentiment {
    private @Getter int staff;
    private @Getter int location;
    private @Getter int service;
    private @Getter int roomComforts;
    private @Getter int sleepQuality;
    private @Getter int swimmingPool;
    private @Getter int valueForMoney;
    private @Getter int facilities;
    private @Getter int catering;
    private @Getter int pointsOfInterest;

    protected Sentiment() {}
  }

}
