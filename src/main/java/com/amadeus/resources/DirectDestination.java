package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * An DirectDestination object as returned by the DirectDestinations API.
 * @see com.amadeus.airport.DirectDestinations#get()
 */

@ToString
public class DirectDestination extends Resource {

  protected DirectDestination() {}

  private @Getter String type;
  private @Getter String subtype;
  private @Getter String name;
  private @Getter String iataCode;
}
