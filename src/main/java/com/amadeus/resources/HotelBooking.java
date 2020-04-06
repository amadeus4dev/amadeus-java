package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * An HotelBooking object as returned by the Hotel Booking API.
 * @see com.amadeus.booking.HotelBookings#get()
 */
@ToString
public class HotelBooking extends Resource {
  protected HotelBooking() {}

  private @Getter String type;
  private @Getter String id;
  private @Getter String providerConfirmationId;
  private @Getter AssociatedRecord[] associatedRecords;

  @ToString
  public class AssociatedRecord {
    protected AssociatedRecord() {
    }

    private @Getter String reference;
    private @Getter String originSystemCode;
  }

}
