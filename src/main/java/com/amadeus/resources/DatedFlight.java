package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * An DatedFlight object as returned by the On-Demand Flight Status API.
 * @see com.amadeus.schedule.Flights#get()
 */
@ToString
public class DatedFlight extends Resource {
  private @Getter String type;
  private @Getter String scheduledDepartureDate;
  private @Getter FlightDesignator flightDesignator;
  private @Getter FlightPoint[] flightPoints;
  private @Getter Segment[] segments;
  private @Getter Leg[] legs;

  protected DatedFlight() {}

  @ToString
  public class FlightDesignator {
    private @Getter String carrierCode;
    private @Getter int flightNumber;
    private @Getter String operationalSuffix;

    protected FlightDesignator() {}
  }

  @ToString
  public class FlightPoint {
    private @Getter String iataCode;
    private @Getter Departure departure;
    private @Getter Arrival arrival;

    protected FlightPoint() {}
  }

  @ToString
  public class Departure {
    private @Getter Timing[] timings;
    private @Getter Terminal terminal;
    private @Getter Gate gate;

    protected Departure() {}
  }

  @ToString
  public class Arrival {
    private @Getter Timing[] timings;
    private @Getter Terminal terminal;
    private @Getter Gate gate;

    protected Arrival() {}
  }

  @ToString
  public class Timing {
    private @Getter String qualifier;
    private @Getter String value;
    private @Getter Delay[] delays;

    protected Timing() {}
  }

  @ToString
  public class Delay {
    private @Getter String duration;

    protected Delay() {}
  }

  @ToString
  public class Gate {
    private @Getter String mainGate;

    protected Gate() {}
  }

  @ToString
  public class Terminal {
    private @Getter String code;

    protected Terminal() {}
  }

  @ToString
  public class Segment {
    private @Getter String boardPointIataCode;
    private @Getter String offPointIataCode;
    private @Getter String scheduledSegmentDuration;
    private @Getter Partnership partnership;

    protected Segment() {}
  }

  @ToString
  public class Partnership {
    private @Getter FlightDesignator operatingFlight;

    protected Partnership() {}
  }

  @ToString
  public class Leg {
    private @Getter String boardPointIataCode;
    private @Getter String offPointIataCode;
    private @Getter AircraftEquipment aircraftEquipment;
    private @Getter String scheduledLegDuration;

    protected Leg() {}
  }

  @ToString
  public class AircraftEquipment {
    private @Getter String aircraftType;

    protected AircraftEquipment() {}
  }

}
