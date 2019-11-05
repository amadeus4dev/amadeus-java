package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

@ToString
public class FlightPrice extends Resource {

  private @Getter String type;
  private @Getter FlightOfferSearch[] flightOffers;
  private @Getter Object flightRequirements;

}
