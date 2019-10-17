package com.amadeus.resources;

import lombok.Getter;

public class HotelRating extends Resource {
  protected HotelRating() {}

  private @Getter String hotelId;
  private @Getter String type;
  private @Getter int overallRating;
  private @Getter int numberOfReviews;
  private @Getter Sentiment sentiments;

  public class Sentiment {
    protected Sentiment() {}

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
  }

}
