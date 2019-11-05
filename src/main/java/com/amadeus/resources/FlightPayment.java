package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * An Airline object as returned by the Airline Code LookUp API.
 * @see amadeus.shopping.flightOffersSearch.pricing#post()
 */
@ToString
public class FlightPayment extends Resource {
  protected FlightPayment() {}

  private @Getter String brand;
  private @Getter Integer binNumber;
  private @Getter String[] flightOfferIds;
}
