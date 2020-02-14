package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * An OnTime object as returned by the AirportOnTime API.
 * @see com.amadeus.airport.predictions.AirportOnTime#get()
 */
@ToString
public class OnTime extends Resource {
  protected OnTime() {}

  private @Getter String id;
  private @Getter String probability;
  private @Getter String result;
  private @Getter String subType;
  private @Getter String type;
}