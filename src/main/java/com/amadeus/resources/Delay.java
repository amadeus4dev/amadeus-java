package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * A Delay object as returned by the FlightDelay API.
 * @see com.amadeus.travel.predictions.FlightDelay#get()
 */
@ToString
public class Delay extends Resource {
  protected Delay() {}

  private @Getter String id;
  private @Getter String probability;
  private @Getter String result;
  private @Getter String subType;
  private @Getter String type;
}
