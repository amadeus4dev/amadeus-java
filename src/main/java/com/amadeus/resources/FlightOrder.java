package com.amadeus.resources;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
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

  @AllArgsConstructor
  @ToString
  public class Traveler {
    protected Traveler() {
    }

    private @Getter @Setter String id;
    private @Getter @Setter Date dateOfBirth;
    private @Getter @Setter Name name;
    private @Getter @Setter Contact contact;
    private @Getter @Setter Document[] documents;
  }
  
  @AllArgsConstructor
  @ToString
  public class Name {
    protected Name() {
    }

    private @Getter @Setter String firstName;
    private @Getter @Setter String lastName;
  }

  @AllArgsConstructor
  @ToString
  public class Contact {
    protected Contact() {
    }

    private @Getter Phone[] phones;
  }

  @AllArgsConstructor
  @ToString
  public class Document {
    protected Document() {
    }

    private @Getter @Setter String documentType;
    private @Getter @Setter String number;
    private @Getter @Setter Date expiryDate;
    private @Getter @Setter String issuanceCountry;
    private @Getter @Setter String nationality;
    private @Getter @Setter boolean holder;
  }

  @AllArgsConstructor 
  @ToString
  public class Phone {

    protected Phone() {
    }
    
    private @Getter @Setter String countryCallingCode;
    private @Getter @Setter String number;
  }

}
