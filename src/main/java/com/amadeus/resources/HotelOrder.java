package com.amadeus.resources;

import com.amadeus.resources.HotelOfferSearch.Offer;
import lombok.Getter;
import lombok.ToString;

/**
 * An HotelOrder object as returned by the Hotel Booking v2 API.
 * @see com.amadeus.booking.HotelOrders#get()
 */
@ToString
public class HotelOrder extends Resource {
  private @Getter String self;
  private @Getter String type;
  private @Getter String id;
  private @Getter HotelBooking[] hotelBookings;
  private @Getter AssociatedRecord[] associatedRecords;
  private @Getter Guest[] guests;

  protected HotelOrder() {}

  @ToString
  public static class HotelBooking {
    private @Getter String type;
    private @Getter String id;
    private @Getter String bookingStatus;
    private @Getter RoomAssociation[] roomAssociations;
    private @Getter Offer hotelOffer;
    private @Getter Hotel hotel;

    protected HotelBooking() {}
  }

  @ToString
  public static class RoomAssociation {
    private @Getter String hotelOfferId;
    private GuestReference[] guestReferences;
    private @Getter String specialRequest;

    protected RoomAssociation() {}
  }

  @ToString
  public static class GuestReference {
    private @Getter String guestReference;
    private @Getter String hotelLoyaltyId;

    protected GuestReference() {}
  }

  @ToString
  public static class Guest {
    private @Getter int tid;
    private @Getter int id;
    private @Getter FrequentTraveler[] frequentTraveler;
    private @Getter String phone;
    private @Getter String email;
    private @Getter String title;
    private @Getter String firstName;
    private @Getter String lastName;
    private @Getter Integer childAge;

    protected Guest() {}
  }

  @ToString
  public static class FrequentTraveler {
    private @Getter String airlineCode;
    private @Getter String frequentTravelerId;

    protected FrequentTraveler() {}
  }

  @ToString
  public static class AssociatedRecord {
    private @Getter String reference;
    private @Getter String originSystemCode;

    protected AssociatedRecord() {}
  }

  @ToString
  public static class Hotel {
    private @Getter String hotelId;
    private @Getter String chainCode;
    private @Getter String name;
    private @Getter String self;

    protected Hotel() {}
  }
}
