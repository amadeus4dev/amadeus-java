package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;


@ToString
public class TripDetail extends Resource {
  protected TripDetail() {}

  private @Getter Trip trip;

  @ToString
  public class Trip {
    protected Trip() {
    }

    private @Getter String type;
    private @Getter String reference;
    private @Getter String creationDateTime;
    private @Getter String bookingDate;
    private @Getter String bookingNumber;
    private @Getter String provider;
    private @Getter String title;
    private @Getter String description;
    private @Getter Start start;
    private @Getter End end;
    private @Getter TravelAgency travelAgency;
    private @Getter Stakeholder[] stakeholders;
    private @Getter Price price;
    private @Getter Product[] products;
  }

  @ToString
  public class Start {
    protected Start() {}

    private @Getter String localDateTime;
    private @Getter String name;
    private @Getter String iataCode;
    private @Getter Address address;
  }

  @ToString
  public class End {
    protected End() {}

    private @Getter String localDateTime;
    private @Getter String name;
    private @Getter String iataCode;
    private @Getter Address address;
  }

  @ToString
  public class Address {
    protected Address() {}

    private @Getter String category;
    private @Getter String[] lines;
    private @Getter String postalCode;
    private @Getter String countryCode;
    private @Getter String cityName;
    private @Getter String stateCode;
    private @Getter String postalBox;
    private @Getter String text;
    private @Getter String state;
  }

  @ToString
  public class TravelAgency {
    protected TravelAgency() {}

    private @Getter String officeName;
    private @Getter Address address;
    private @Getter Phone phone;
    private @Getter Email email;
  }

  @ToString
  public class Phone {
    protected Phone() {}

    private @Getter String category;
    private @Getter String countryCode;
    private @Getter String number;
  }

  @ToString
  public class Email {
    protected Email() {}

    private @Getter String category;
    private @Getter String address;
  }

  @ToString
  public class Stakeholder {
    protected Stakeholder() {}

    private @Getter String id;
    private @Getter String nationality;
    private @Getter String passangerTypeCode;
    private @Getter String dateOfBirth;
    private @Getter Integer age;
    private @Getter Name name;
  }

  @ToString
  public class Name {
    protected Name() {}

    private @Getter String firstName;
    private @Getter String lastName;
    private @Getter String title;
    private @Getter String middleName;
    private @Getter String prefix;
    private @Getter String suffix;
  }

  @ToString
  public class Price {
    protected Price() {}

    private @Getter String currency;
    private @Getter String total;
    private @Getter String base;
    private @Getter String totalTaxes;
  }

  @ToString
  public class Product {
    protected Product() {}

    private @Getter Air air;
    private @Getter Hotel hotel;
    private @Getter Car car;
    private @Getter Train train;
  }

  @ToString
  public class Air {
    protected Air() {}

    private @Getter String confirmationNumber;
    private @Getter Baggage baggages;
    private @Getter Meal meal;
    private @Getter DepartureAirportLocation departureAirportLocation;
    private @Getter ArrivalAirportLocation arrivalAirportLocation;
    private @Getter DepartureAir departure;
    private @Getter ArrivalAir arrival;
    private @Getter Marketing marketing;
    private @Getter Operating operating;
    private @Getter Aircraft aircraft;
    private @Getter Seat[] seats;
  }

  @ToString
  public class Baggage {
    protected Baggage() {}

    private @Getter String quantity;
    private @Getter Weight weight;
  }

  @ToString
  public class Weight {
    protected Weight() {}

    private @Getter String amount;
  }

  @ToString
  public class Meal {
    protected Meal() {}

    private @Getter String code;
    private @Getter String description;
  }

  @ToString
  public class DepartureAirportLocation {
    protected DepartureAirportLocation() {}

    private @Getter String name;
    private @Getter Address address;
  }

  @ToString
  public class ArrivalAirportLocation {
    protected ArrivalAirportLocation() {}

    private @Getter String name;
    private @Getter Address address;
  }

  @ToString
  public class DepartureAir {
    protected DepartureAir() {}

    private @Getter String iataCode;
    private @Getter String terminal;
    private @Getter String checkInEndTime;
    private @Getter String localDateTime;
  }

  @ToString
  public class ArrivalAir {
    protected ArrivalAir() {}

    private @Getter String iataCode;
    private @Getter String terminal;
    private @Getter String localDateTime;
  }

  @ToString
  public class Marketing {
    protected Marketing() {}

    private @Getter Carrier carrier;
    private @Getter FlightDesignator flightDesignator;
  }

  @ToString
  public class Operating {
    protected Operating() {}

    private @Getter Carrier carrier;
    private @Getter FlightDesignator flightDesignator;
  }

  @ToString
  public class Carrier {
    protected Carrier() {}

    private @Getter String name;
  }

  @ToString
  public class FlightDesignator {
    protected FlightDesignator() {}

    private @Getter String carrierCode;
    private @Getter String flightNumber;
    private @Getter String operationalSuffix;
  }

  @ToString
  public class Aircraft {
    protected Aircraft() {}

    private @Getter String aircraftType;
    private @Getter String aircraftDescription;
  }

  @ToString
  public class Seat {
    protected Seat() {}

    private @Getter String number;
    private @Getter String cabin;
    private @Getter AssociationRef[] associationRefs;
  }

  @ToString
  public class AssociationRef {
    protected AssociationRef() {}

    private @Getter String id;
    private @Getter String type;
  }

  @ToString
  public class Hotel {
    protected Hotel() {}

    private @Getter String confirmationNumber;
    private @Getter String checkInDate;
    private @Getter String checkOutDate;
    private @Getter Integer roomQuantity;
    private @Getter ContactHotel contact;
    private @Getter Address address;
    private @Getter String[] amenities;
    private @Getter Description description;
    private @Getter Policies policies;
    private @Getter Guests guests;
    private @Getter Room room;
  }

  @ToString
  public class ContactHotel {
    protected ContactHotel() {}

    private @Getter String phone;
  }

  @ToString
  public class Description {
    protected Description() {}

    private @Getter String text;
  }

  @ToString
  public class Policies {
    protected Policies() {}

    private @Getter Cancellation cancellation;
  }

  @ToString
  public class Cancellation {
    protected Cancellation() {}

    private @Getter Description description;
  }

  @ToString
  public class Guests {
    protected Guests() {}

    private @Getter Integer adults;
    private @Getter Integer[] childAge;
  }

  @ToString
  public class Room {
    protected Room() {}

    private @Getter String type;
    private @Getter TypeEstimated typeEstimated;
  }

  @ToString
  public class TypeEstimated {
    protected TypeEstimated() {}

    private @Getter String category;
    private @Getter String beds;
    private @Getter String bedType;
  }

  @ToString
  public class Car {
    protected Car() {}

    private @Getter String confirmationNumber;
    private @Getter String serviceProviderName;
    private @Getter AssociatedEquipment[] associatedEquipments;
    private @Getter Pickup pickup;
    private @Getter Dropoff dropoff;
    private @Getter Driver driver;
    private @Getter CarVehicle vehicle;
  }

  @ToString
  public class AssociatedEquipment {
    protected AssociatedEquipment() {}

    private @Getter String name;
  }

  @ToString
  public class Pickup {
    protected Pickup() {}

    private @Getter String localDateTime;
    private @Getter Location location;
  }

  @ToString
  public class Dropoff {
    protected Dropoff() {}

    private @Getter String localDateTime;
    private @Getter Location location;
  }

  @ToString
  public class Location {
    protected Location() {}

    private @Getter String iataCode;
    private @Getter Address address;
  }

  @ToString
  public class Driver {
    protected Driver() {}

    private @Getter Contact[] contacts;
  }

  @ToString
  public class Contact {
    protected Contact() {}

    private @Getter Phone phone;
  }

  @ToString
  public class CarVehicle {
    protected CarVehicle() {}

    private @Getter String acrissCode;
    private @Getter String carModel;
    private @Getter Integer doors;
  }

  @ToString
  public class Train {
    protected Train() {}

    private @Getter String confirmNbr;
    private @Getter String serviceProviderName;
    private @Getter String bookingClass;
    private @Getter Departure departure;
    private @Getter String departureDateTime;
    private @Getter String arrivalDateTime;
    private @Getter Arrival arrival;
    private @Getter String duration;
    private @Getter String arrivalTrack;
    private @Getter Seat[] seats;
    private @Getter Vehicle vehicle;
  }

  @ToString
  public class Departure {
    protected Departure() {}

    private @Getter String subType;
    private @Getter String name;
    private @Getter String iataCode;
  }

  @ToString
  public class Arrival {
    protected Arrival() {}

    private @Getter String subType;
    private @Getter String name;
    private @Getter String iataCode;
  }

  @ToString
  public class Vehicle {
    protected Vehicle() {}

    private @Getter String vehicleType;
    private @Getter String code;
    private @Getter String number;
    private @Getter String displayName;
  }
}
