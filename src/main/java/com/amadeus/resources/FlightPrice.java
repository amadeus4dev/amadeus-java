package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

@ToString
public class FlightPrice extends Resource {
  protected FlightPrice() {}

  private @Getter String type;
  private @Getter FlightOfferSearch[] flightOffers;
  private @Getter BookingRequirements bookingRequirements;

  @ToString
  public class BookingRequirements {
    protected BookingRequirements() {}

    private @Getter Boolean invoiceAddressRequired;
    private @Getter Boolean mailingAddressRequired;
    private @Getter Boolean emailAddressRequired;
    private @Getter Boolean phoneCountryCodeRequired;
    private @Getter Boolean mobilePhoneNumberRequired;
    private @Getter Boolean phoneNumberRequired;
    private @Getter Boolean postalCodeRequired;
    private @Getter PassengerConditions[] travelerRequirements;
  }

  @ToString
  public class PassengerConditions {
    protected PassengerConditions(){}

    private @Getter String travelerId;
    private @Getter Boolean genderRequired;
    private @Getter Boolean documentRequired;
    private @Getter Boolean documentIssuanceCityRequired;
    private @Getter Boolean dateOfBirthRequired;
    private @Getter Boolean redressRequiredIfAny;
    private @Getter Boolean airFranceDiscountRequired;
    private @Getter Boolean spanishResidentDiscountRequired;
    private @Getter Boolean residenceRequired;
  }

}
