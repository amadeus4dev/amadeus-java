package com.amadeus.resources;

import java.util.Date;
import lombok.Getter;
import lombok.ToString;

@ToString
public class FlightOffer extends Resource {
  private @Getter String type;
  private @Getter String id;
  private @Getter OfferItem[] offerItems;

  @ToString
  private class OfferItem {
    private @Getter Service[] services;
    private @Getter Price price;
    private @Getter Price pricePerAdult;
    private @Getter Price pricePerInfant;
    private @Getter Price pricePerChild;
    private @Getter Price pricePerSenior;
  }

  @ToString
  private class Service {
    private @Getter Segment[] segments;
  }

  @ToString
  private class Segment {
    private @Getter FlightSegment flightSegment;
    private @Getter PricingDetail pricingDetailPerAdult;
    private @Getter PricingDetail pricingDetailPerInfant;
    private @Getter PricingDetail pricingDetailPerChild;
    private @Getter PricingDetail pricingDetailPerSenior;
  }

  @ToString
  private class FlightSegment {
    private @Getter FlightEndPoint departure;
    private @Getter FlightEndPoint arrival;
    private @Getter String carrierCode;
    private @Getter String number;
    private @Getter OperatingFlight operating;
    private @Getter String duration;
    private @Getter FlightStop[] stops;
  }

  @ToString
  private class FlightEndPoint {
    private @Getter String iataCode;
    private @Getter String terminal;
    private @Getter String at;
  }

  @ToString
  private class OperatingFlight {
    private @Getter String carrierCode;
    private @Getter String number;
  }

  @ToString
  private class FlightStop {
    private @Getter String iataCode;
    private @Getter AircraftEquipment newAircraft;
    private @Getter String duration;
    private @Getter Date arrivalAt;
    private @Getter Date departureAt;
  }

  @ToString
  private class AircraftEquipment {
    private @Getter String code;
  }

  @ToString
  private class Price {
    private @Getter double total;
    private @Getter double totalTaxes;
  }

  @ToString
  private class PricingDetail {
    private @Getter String travelClass;
    private @Getter String fareClass;
    private @Getter int availability;
    private @Getter String fareBasis;
  }
}
