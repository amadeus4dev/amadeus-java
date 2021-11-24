package com.amadeus.resources;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * An Traveler object used in the body of Flight Create Orders.
 * @see com.amadeus.booking.flightOrder#get()
 */
@ToString
public class Traveler extends Resource {
  public Traveler(String id, String dateOfBirth, String gender, Name name, Contact contact, Document[] documents) {
    this.name = name;
    this.contact = contact;
  }

  public Traveler() {

  }

  private @Getter @Setter String id;
  private @Getter @Setter String dateOfBirth;
  private @Getter @Setter String gender;
  private @Getter @Setter Name name;
  private @Getter @Setter Contact contact;
  private @Getter @Setter Document[] documents;

  @ToString
  public class Name {
    public Name(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
    }

    private @Getter @Setter String firstName;
    private @Getter @Setter String lastName;

  }

  @ToString
  public class Contact {
    public Contact() {
    }

    public Contact(Phone phones, String emailAddress) {
    }

    private @Getter @Setter Phone[] phones;
    private @Getter @Setter String emailAddress;
  }

  @ToString
  public class Document {
    public Document() {
    }

    public Document(String documentType, String number, String expiryDate, 
        String issuanceCountry, String nationality, boolean holder) {

    }
    
    private @Getter @Setter String documentType;
    private @Getter @Setter String number;
    private @Getter @Setter String expiryDate;
    private @Getter @Setter String issuanceCountry;
    private @Getter @Setter String nationality;
    private @Getter @Setter boolean holder;
  }

  @ToString
  public class Phone {

    public Phone() {
    }
    
    public Phone(String countryCallingCode, String number) {
    }

    private @Getter @Setter String countryCallingCode;
    private @Getter @Setter String number;
    private @Getter @Setter String deviceType;
  }

}
