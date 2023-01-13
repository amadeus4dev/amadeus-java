package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * An Airline object as returned by the Airline Code LookUp API.
 * @see com.amadeus.referenceData.airlines#get()
 */
@ToString
public class Airline extends Resource {
  private @Getter String type;
  private @Getter String iataCode;
  private @Getter String icaoCode;
  private @Getter String businessName;
  private @Getter String commonName;

  protected Airline() {}
}
