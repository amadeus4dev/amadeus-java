package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * An DirectDestination object as returned by the DirectDestinations API.
 * @see com.amadeus.airport.DirectDestinations#get()
 */

@ToString
public class Destination extends Resource {

  protected Destination() {}

  private @Getter String type;
  private @Getter String subtype;
  private @Getter String name;
  private @Getter String iataCode;
}
