package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * An SeatMap object as returned by the SeatMap API.
 * @see com.amadeus.booking.SeatMaps#get()
 * @see com.amadeus.booking.SeatMaps#post() */
@ToString
public class SeatMap extends Resource {
  protected SeatMap() {}

  private @Getter String type;
  private @Getter String flightOfferid;
  private @Getter String segmentid;
  private @Getter String carrierCode;
  private @Getter String number;
  private @Getter Aircraft aircraft;
  private @Getter Departure departure;
  private @Getter Deck[] decks;
  private @Getter AircraftCabinAmenities aircraftCabinAmenities;
  private @Getter AvailableSeatsCounter[] availableSeatsCounters;

  @ToString
  public class Aircraft {
    protected Aircraft() {
    }

    private @Getter String code;
  }

  @ToString
  public class Departure {
    protected Departure() {
    }

    private @Getter String iataCode;
    private @Getter String at;
  }

  @ToString
  public class Arrival {
    protected Arrival() {
    }

    private @Getter String iataCode;
  }

  @ToString
  public class Deck {
    protected Deck() {
    }

    private @Getter String deckType;
    private @Getter DeckConfiguration deckConfiguration;

  }

  @ToString
  public class AircraftCabinAmenities {
    protected AircraftCabinAmenities() {
    }

    private @Getter AmenityPower power;
    private @Getter AmenityWifi wifi;
    private @Getter AmenityBeverage beverage;
    private @Getter AmenityFood food;
    private @Getter AmenityEntertainment[] entertainment;
    private @Getter AmenitySeat seat;

  }

  @ToString
  public class AmenitySeat {
    protected AmenitySeat() {
    }

    private @Getter int legSpace;
    private @Getter String spaceUnit;
    private @Getter String tilt;
    private @Getter String amenityType;
    private @Getter Media[] medias;

  }

  @ToString
  public class AmenityPower {
    protected AmenityPower() {
    }

    private @Getter boolean isChargeable;
    private @Getter String powerType;

  }

  @ToString
  public class AmenityWifi {
    protected AmenityWifi() {
    }

    private @Getter boolean isChargeable;
    private @Getter String wifiCoverage;

  }

  @ToString
  public class AmenityBeverage {
    protected AmenityBeverage() {
    }

    private @Getter boolean isChargeable;
    private @Getter String beverageType;

  }

  @ToString
  public class AmenityFood {
    protected AmenityFood() {
    }

    private @Getter boolean isChargeable;
    private @Getter String foodType;

  }

  @ToString
  public class AmenityEntertainment {
    protected AmenityEntertainment() {
    }

    private @Getter boolean isChargeable;
    private @Getter String entertainmentType;

  }

  @ToString
  public class DeckConfiguration {
    protected DeckConfiguration() {
    }

    private @Getter int width;
    private @Getter int length;
    private @Getter int startseatRow;
    private @Getter int endSeatRow;
    private @Getter int startWingsRow;
    private @Getter int endWingsRow;
    private @Getter int startWingsX;
    private @Getter int endWingsX;

  }

  @ToString
  public class AvailableSeatsCounter {
    protected AvailableSeatsCounter() {
    }

    private @Getter int value;
    private @Getter String travelerId;
  }

  @ToString
  public class Media {
    protected Media() {
    }

    private @Getter String title;
    private @Getter String href;
    private @Getter String mediaType;
    private @Getter QualifiedFreeText description;
  }

  @ToString
  public class QualifiedFreeText {
    protected QualifiedFreeText() {
    }

    private @Getter String text;
    private @Getter String lang;
  }
}
