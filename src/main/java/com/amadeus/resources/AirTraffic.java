package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

@ToString
public class AirTraffic extends Resource {
  private @Getter String type;
  private @Getter String subType;
  private @Getter String destination;
  private @Getter Analytics analytics;

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
