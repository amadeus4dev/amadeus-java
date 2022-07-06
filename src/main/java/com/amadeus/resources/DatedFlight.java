package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * An DatedFlight object as returned by the On-Demand Flight Status API.
 * @see com.amadeus.schedule.Flights#get()
 */
@ToString
public class DatedFlight extends Resource {
  protected DatedFlight() {}

  private @Getter String type;
  private @Getter String scheduledDepartureDate;
  private @Getter FlightDesignator flightDesignator;
  private @Getter FlightPoint[] flightPoints;
  private @Getter Segment[] segments;
  private @Getter Leg[] legs;

  @ToString
  public class FlightDesignator {
    protected FlightDesignator() {
    }

    private @Getter String carrierCode;
    private @Getter int flightNumber;
    private @Getter String operationalSuffix;

  }

  @ToString
  public class FlightPoint {
    protected FlightPoint() {
    }

    private @Getter String iataCode;
    private @Getter Departure departure;
    private @Getter Arrival arrival;
  }

  @ToString
  public class Departure {
    protected Departure() {
    }

    private @Getter Timing[] timings;
    private @Getter Terminal terminal;
    private @Getter Gate gate;
  }

  @ToString
  public class Arrival {
    protected Arrival() {
    }

    private @Getter Timing[] timings;
    private @Getter Terminal terminal;
    private @Getter Gate gate;
  }

  @ToString
  public class Timing {
    protected Timing() {
    }

    private @Getter String qualifier;
    private @Getter String value;
    private @Getter Delay[] delays;
  }

  @ToString
  public class Delay {
    protected Delay() {
    }

    private @Getter String duration;
  }

  @ToString
  public class Gate {
    protected Gate() {
    }

    private @Getter String mainGate;
  }

  @ToString
  public class Terminal {
    protected Terminal() {
    }

    private @Getter String code;
  }

  @ToString
  public class Segment {
    protected Segment() {
    }

    private @Getter String boardPointIataCode;
    private @Getter String offPointIataCode;
    private @Getter String scheduledSegmentDuration;
    private @Getter Partnership partnership;
  }

  @ToString
  public class Partnership {
    protected Partnership() {
    }

    private @Getter FlightDesignator operatingFlight;
  }

  @ToString
  public class Leg {
    protected Leg() {
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
