package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * An HotelBooking object as returned by the Hotel Booking API.
 * @see com.amadeus.booking.HotelBookings#get()
 */
@ToString
public class HotelBooking extends Resource {
  private @Getter String type;
  private @Getter String id;
  private @Getter String providerConfirmationId;
  private @Getter AssociatedRecord[] associatedRecords;

  protected HotelBooking() {}

  @ToString
  public class AssociatedRecord {
    private @Getter String reference;
    private @Getter String originSystemCode;

    protected AssociatedRecord() {}
  }

}
