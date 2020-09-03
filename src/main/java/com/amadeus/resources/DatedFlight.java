package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * An DatedFlight object as returned by the On Flight Status Demand API.
 * @see com.amadeus.schedule.Flights#get()
 */
@ToString
public class DatedFlight extends Resource {
  protected DatedFlight() {}

  private @Getter String type;
  private @Getter String scheduledDepartureDate;
  private @Getter FlightDesignator flightDesignator;
  private @Getter FlightPoints[] flightPoints;
  private @Getter Segments[] segments;
  private @Getter Legs[] legs;

  @ToString
  public class FlightDesignator {
    protected FlightDesignator() {
    }

    private @Getter String carrierCode;
    private @Getter int flightNumber;
  }

  @ToString
  public class FlightPoints {
    protected FlightPoints() {
    }

    private @Getter String iataCode;
    private @Getter Departure departure;
    private @Getter Arrival arrival;
  }

  @ToString
  public class Departure {
    protected Departure() {
    }

    private @Getter Timings[] timings;
  }

  @ToString
  public class Arrival {
    protected Arrival() {
    }

    private @Getter Timings[] timings;
  }

  @ToString
  public class Timings {
    protected Timings() {
    }

    private @Getter String qualifier;
    private @Getter String value;
  }

  @ToString
  public class Segments {
    protected Segments() {
    }

    private @Getter String boardPointIataCode;
    private @Getter String offPointIataCode;
    private @Getter String scheduledSegmentDuration;
  }

  @ToString
  public class Legs {
    protected Legs() {
    }

    private @Getter String boardPointIataCode;
    private @Getter String offPointIataCode;
    private @Getter AircraftEquipment aircraftEquipment;
    private @Getter String scheduledLegDuration;
  }

  @ToString
  public class AircraftEquipment {
    protected AircraftEquipment() {
    }

    private @Getter String aircraftType;
  }

}
