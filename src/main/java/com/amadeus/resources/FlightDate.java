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
  protected FlightDate() {}

  private @Getter String type;
  private @Getter String origin;
  private @Getter String destination;
  private @Getter Date departureDate;
  private @Getter Date returnDate;
  private @Getter Price price;

  /**
   * An FlightDate-related object as returned by the FlightDates API.
   * @see com.amadeus.shopping.FlightDates#get()
   */
  @ToString
  public class Price {
    protected Price() {}

    private @Getter double total;
  }
}
