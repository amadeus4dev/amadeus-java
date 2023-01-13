package com.amadeus.resources;

import java.util.Date;
import lombok.Getter;
import lombok.ToString;

/**
 * An FlightDate object as returned by the FlightDates API.
 * @see com.amadeus.shopping.FlightDates#get()
 */
@ToString
public class FlightDate extends Resource {
  private @Getter String type;
  private @Getter String origin;
  private @Getter String destination;
  private @Getter Date departureDate;
  private @Getter Date returnDate;
  private @Getter Price price;

  protected FlightDate() {}

  /**
   * An FlightDate-related object as returned by the FlightDates API.
   * @see com.amadeus.shopping.FlightDates#get()
   */
  @ToString
  public class Price {
    private @Getter double total;

    protected Price() {}
  }
}
