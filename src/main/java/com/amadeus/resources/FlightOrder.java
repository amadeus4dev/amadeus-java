package com.amadeus.resources;

import java.util.Date;
import lombok.Getter;
import lombok.ToString;

/**
 * An Airline object as returned by the Airline Code LookUp API.
 * @see com.amadeus.booking.flightOrder#get()
 */
@ToString
public class FlightOrder extends Resource {
  protected FlightOrder() {}

  private @Getter String type;
  private @Getter String id;
  private @Getter String queuingOfficeId;
  private @Getter AssociatedRecord[] associatedRecords;
  private @Getter Traveler[] travelers;
  private @Getter FlightOfferSearch[] flightOffers;

  @ToString
  public class AssociatedRecord {
    protected AssociatedRecord() {
    }

    private @Getter String reference;
    private @Getter String creationDateTime;
    private @Getter String originSystemCode;
    private @Getter String flightOfferId;
  }

  @ToString
  public class Traveler {
    protected Traveler() {
    }

    private @Getter String id;
    private @Getter Date dateOfBirth;
    private @Getter Name name;
    private @Getter Contact contact;
    private @Getter Document[] documents;
  }

  @ToString
  public class Name {
    protected Name() {
    }

    private @Getter String firstName;
    private @Getter String lastName;
  }

  @ToString
  public class Contact {
    protected Contact() {
    }

    private @Getter Phone[] phones;
  }

  @ToString
  public class Document {
    protected Document() {
    }

    private @Getter String documentType;
    private @Getter String number;
    private @Getter Date expiryDate;
    private @Getter String issuanceCountry;
    private @Getter String nationality;
    private @Getter boolean holder;
  }

  @ToString
  public class Phone {

    protected Phone() {
    }
    
    private @Getter String countryCallingCode;
    private @Getter String number;
  }

}
