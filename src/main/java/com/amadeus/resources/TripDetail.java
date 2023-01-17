package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * A TripDetail object as returned by the Trip Parser API.
 * @see com.amadeus.travel.TripParser#post()
 */
@ToString
public class TripDetail extends Resource {
  private @Getter Trip trip;

    protected TripDetail() {}

  @ToString
  public class Trip {
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

    protected Trip() {}

  }

  @ToString
  public class Start {
    private @Getter String localDateTime;
    private @Getter String name;
    private @Getter String iataCode;
    private @Getter Address address;

    protected Start() {}
  }

  @ToString
  public class End {
    private @Getter String localDateTime;
    private @Getter String name;
    private @Getter String iataCode;
    private @Getter Address address;

    protected End() {}
  }

  @ToString
  public class Address {
    private @Getter String category;
    private @Getter String[] lines;
    private @Getter String postalCode;
    private @Getter String countryCode;
    private @Getter String cityName;
    private @Getter String stateCode;
    private @Getter String postalBox;
    private @Getter String text;
    private @Getter String state;

    protected Address() {}
  }

  @ToString
  public class TravelAgency {
    private @Getter String officeName;
    private @Getter Address address;
    private @Getter Phone phone;
    private @Getter Email email;

    protected TravelAgency() {}
  }

  @ToString
  public class Phone {
    private @Getter String category;
    private @Getter String countryCode;
    private @Getter String number;

    protected Phone() {}
  }

  @ToString
  public class Email {
    private @Getter String category;
    private @Getter String address;

    protected Email() {}
  }

  @ToString
  public class Stakeholder {
    private @Getter String id;
    private @Getter String nationality;
    private @Getter String passangerTypeCode;
    private @Getter String dateOfBirth;
    private @Getter Integer age;
    private @Getter Name name;

    protected Stakeholder() {}
  }

  @ToString
  public class Name {
    private @Getter String firstName;
    private @Getter String lastName;
    private @Getter String title;
    private @Getter String middleName;
    private @Getter String prefix;
    private @Getter String suffix;

    protected Name() {}
  }

  @ToString
  public class Price {
    private @Getter String currency;
    private @Getter String total;
    private @Getter String base;
    private @Getter String totalTaxes;

    protected Price() {}
  }

  @ToString
  public class Product {
    private @Getter Air air;
    private @Getter Hotel hotel;
    private @Getter Car car;
    private @Getter Train train;

    protected Product() {}
  }

  @ToString
  public class Air {
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

    protected Air() {}
  }

  @ToString
  public class Baggage {
    private @Getter String quantity;
    private @Getter Weight weight;

    protected Baggage() {}
  }

  @ToString
  public class Weight {
    private @Getter String amount;

    protected Weight() {}
  }

  @ToString
  public class Meal {
    private @Getter String code;
    private @Getter String description;

    protected Meal() {}
  }

  @ToString
  public class DepartureAirportLocation {
    private @Getter String name;
    private @Getter Address address;

    protected DepartureAirportLocation() {}
  }

  @ToString
  public class ArrivalAirportLocation {
    private @Getter String name;
    private @Getter Address address;

    protected ArrivalAirportLocation() {}
  }

  @ToString
  public class DepartureAir {
    private @Getter String iataCode;
    private @Getter String terminal;
    private @Getter String checkInEndTime;
    private @Getter String localDateTime;

    protected DepartureAir() {}
  }

  @ToString
  public class ArrivalAir {
    private @Getter String iataCode;
    private @Getter String terminal;
    private @Getter String localDateTime;

    protected ArrivalAir() {}
  }

  @ToString
  public class Marketing {
    private @Getter Carrier carrier;
    private @Getter FlightDesignator flightDesignator;

    protected Marketing() {}
  }

  @ToString
  public class Operating {
    private @Getter Carrier carrier;
    private @Getter FlightDesignator flightDesignator;

    protected Operating() {}
  }

  @ToString
  public class Carrier {
    private @Getter String name;

    protected Carrier() {}
  }

  @ToString
  public class FlightDesignator {
    private @Getter String carrierCode;
    private @Getter String flightNumber;
    private @Getter String operationalSuffix;

    protected FlightDesignator() {}
  }

  @ToString
  public class Aircraft {
    private @Getter String aircraftType;
    private @Getter String aircraftDescription;

    protected Aircraft() {}
  }

  @ToString
  public class Seat {
    private @Getter String number;
    private @Getter String cabin;
    private @Getter AssociationRef[] associationRefs;

    protected Seat() {}
  }

  @ToString
  public class AssociationRef {
    private @Getter String id;
    private @Getter String type;

    protected AssociationRef() {}
  }

  @ToString
  public class Hotel {
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

    protected Hotel() {}
  }

  @ToString
  public class ContactHotel {
    private @Getter String phone;

    protected ContactHotel() {}
  }

  @ToString
  public class Description {
    private @Getter String text;

    protected Description() {}
  }

  @ToString
  public class Policies {
    private @Getter Cancellation cancellation;

    protected Policies() {}
  }

  @ToString
  public class Cancellation {
    private @Getter Description description;

    protected Cancellation() {}
  }

  @ToString
  public class Guests {
    private @Getter Integer adults;
    private @Getter Integer[] childAge;

    protected Guests() {}
  }

  @ToString
  public class Room {
    private @Getter String type;
    private @Getter TypeEstimated typeEstimated;

    protected Room() {}
  }

  @ToString
  public class TypeEstimated {
    private @Getter String category;
    private @Getter String beds;
    private @Getter String bedType;

    protected TypeEstimated() {}
  }

  @ToString
  public class Car {
    private @Getter String confirmationNumber;
    private @Getter String serviceProviderName;
    private @Getter AssociatedEquipment[] associatedEquipments;
    private @Getter Pickup pickup;
    private @Getter Dropoff dropoff;
    private @Getter Driver driver;
    private @Getter CarVehicle vehicle;

    protected Car() {}
  }

  @ToString
  public class AssociatedEquipment {
    private @Getter String name;

    protected AssociatedEquipment() {}
  }

  @ToString
  public class Pickup {
    private @Getter String localDateTime;
    private @Getter Location location;

    protected Pickup() {}
  }

  @ToString
  public class Dropoff {
    private @Getter String localDateTime;
    private @Getter Location location;

    protected Dropoff() {}
  }

  @ToString
  public class Location {
    private @Getter String iataCode;
    private @Getter Address address;

    protected Location() {}
  }

  @ToString
  public class Driver {
    private @Getter Contact[] contacts;

    protected Driver() {}
  }

  @ToString
  public class Contact {
    private @Getter Phone phone;

    protected Contact() {}
  }

  @ToString
  public class CarVehicle {
    private @Getter String acrissCode;
    private @Getter String carModel;
    private @Getter Integer doors;

    protected CarVehicle() {}
  }

  @ToString
  public class Train {
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

    protected Train() {}
  }

  @ToString
  public class Departure {
    private @Getter String subType;
    private @Getter String name;
    private @Getter String iataCode;

    protected Departure() {}
  }

  @ToString
  public class Arrival {
    private @Getter String subType;
    private @Getter String name;
    private @Getter String iataCode;

    protected Arrival() {}
  }

  @ToString
  public class Vehicle {
    private @Getter String vehicleType;
    private @Getter String code;
    private @Getter String number;
    private @Getter String displayName;

    protected Vehicle() {}
  }
}
