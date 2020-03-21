package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * An FlightPayment object as returned by the Flight Offers Price API.
 * @see amadeus.shopping.flightOffersSearch.pricing#post()
 */
@ToString
public class FlightPayment extends Resource {
  protected FlightPayment() {}

  private @Getter String brand;
  private @Getter Integer binNumber;
  private @Getter String[] flightOfferIds;
}
