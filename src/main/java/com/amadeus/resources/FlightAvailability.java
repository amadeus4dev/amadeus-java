/*NOSONAR*/

package com.amadeus.resources;

import com.amadeus.shopping.availability.FlightAvailabilities;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

/**
 * A FlightAvailability object as returned by the Flight Availabilities Search API.
 * @see FlightAvailabilities#post()
 */
@ToString
public class FlightAvailability extends Resource {
  private @Getter String type;
  private @Getter String id;
  private @Getter String originDestinationId;
  private @Getter String source;
  private @Getter Boolean instantTicketingRequired;
  private @Getter Boolean paymentCardRequired;
  private @Getter String duration;
  private @Getter ExtendedSegment[] segments;

  protected FlightAvailability() {}

  @ToString
  public class ExtendedSegment {
    private @Getter String closedStatus;
    private @Getter AvailabilityClass[] availabilityClasses;
    private @Getter String id;
    private @Getter String numberOfStops;
    private @Getter Boolean blacklistedInEU;
    private @Getter Co2Emission[] co2Emissions;
    private @Getter FlightEndpoint departure;
    private @Getter FlightEndpoint arrival;
    private @Getter String carrierCode;
    private @Getter String number;
    private @Getter AircraftEquipment aircraft;
    private @Getter OperatingFlight operating;
    private @Getter String duration;
    private @Getter FlightStop[] stops;

    protected ExtendedSegment() {}
  }

  @ToString
  public class FlightEndpoint {
    private @Getter String iataCode;
    private @Getter String terminal;
    private @Getter String at;

    protected FlightEndpoint() {}
  }

  @ToString
  public class AircraftEquipment {
    private @Getter String code;

    protected AircraftEquipment() {}
  }

  @ToString
  public class AvailabilityClass {
    private @Getter int numberOfBookableSeats;
    @SerializedName("class")
    private @Getter String segmentClass;
    private @Getter String closedStatus;
    private @Getter TourAllotment tourAllotment;

    protected AvailabilityClass() {}
  }

  @ToString
  public class FlightStop {
    private @Getter String iataCode;
    private @Getter String duration;
    private @Getter String arrivalAt;
    private @Getter String departureAt;

    protected FlightStop() {}
  }

  @ToString
  public class OperatingFlight {
    private @Getter String carrierCode;

    protected OperatingFlight() {}
  }

  @ToString
  public class TourAllotment {
    private @Getter String tourName;
    private @Getter String tourReference;
    private @Getter String mode;
    private @Getter String remainingSeats;

    protected TourAllotment() {}
  }

  @ToString
  public class Co2Emission {
    private @Getter int weight;
    private @Getter String weightUnit;
    private @Getter String cabin;

    protected Co2Emission() {}
  }
}
