package com.amadeus.resources;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * An Airline object as returned by the Airline Code LookUp API.
 * @see com.amadeus.booking.FlightOrder#get()
 */
@ToString
public class FlightOrder extends Resource {
  private @Getter String type;
  private @Getter String id;
  private @Getter String queuingOfficeId;
  private @Getter AssociatedRecord[] associatedRecords;
  private @Getter Traveler[] travelers;
  private @Getter FlightOfferSearch[] flightOffers;

  protected FlightOrder() {}

  @ToString
  public class AssociatedRecord {
    private @Getter String reference;
    private @Getter String creationDateTime;
    private @Getter String originSystemCode;
    private @Getter String flightOfferId;

    protected AssociatedRecord() {}

  }

  @AllArgsConstructor
  @NoArgsConstructor
  @ToString
  public static class Traveler {

    private @Getter @Setter String id;
    private @Getter @Setter String dateOfBirth;
    private @Getter @Setter String gender;
    private @Getter @Setter Name name;
    private @Getter @Setter Contact contact;
    private @Getter @Setter Document[] documents;
  }

  @AllArgsConstructor
  @NoArgsConstructor
  
  @ToString
  public static class Name {

    private @Getter @Setter String firstName;
    private @Getter @Setter String lastName;
    private @Getter @Setter String middleName;

    // Constructor with firstName and lastName only
    public Name(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
    }
  }

  @AllArgsConstructor
  @NoArgsConstructor
  @ToString
  public static class Contact {

    private @Getter @Setter Phone[] phones;
  }

  @AllArgsConstructor
  @NoArgsConstructor
  @ToString
  public static class Document {

    private @Getter @Setter DocumentType documentType;
    private @Getter @Setter String number;
    public @Getter @Setter String expiryDate;
    private @Getter @Setter String issuanceCountry;
    private @Getter @Setter String nationality;
    private @Getter @Setter boolean holder;

    public enum DocumentType {
      VISA,
      PASSPORT,
      IDENTITY_CARD,
      KNOWN_TRAVELER,
      REDRESS
    }
  }

  @AllArgsConstructor
  @NoArgsConstructor
  @ToString
  public static class Phone {

    private @Getter @Setter String countryCallingCode;
    private @Getter @Setter String number;
    private @Getter @Setter DeviceType deviceType;

    public enum DeviceType {
      MOBILE,
      LANDLINE,
      FAX
    }
  }

}
