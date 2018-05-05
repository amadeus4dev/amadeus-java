package com.amadeus.resources;

import java.util.Date;
import lombok.Getter;
import lombok.ToString;

@ToString
public class FlightDestination extends Resource {
  private @Getter String type;
  private @Getter String origin;
  private @Getter String destination;
  private @Getter Date departureDate;
  private @Getter Date returnDate;
  private @Getter Price price;

  @ToString
  private class Price {
    private @Getter double total;
  }
}
