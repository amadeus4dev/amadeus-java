package com.amadeus.resources;

import com.amadeus.shopping.availability.FlightAvailabilities;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

/**
 * A FlightAvailabilitySearch object as returned by the FlightAvailabilitiesSearch API.
 * @see FlightAvailabilities#post()
 */
@ToString
public class FlightAvailability extends Resource {
  protected FlightAvailability() {}

  private @Getter String type;
  private @Getter String id;
  private @Getter String originDestinationId;
  private @Getter String source;
  private @Getter Boolean instantTicketingRequired;
  private @Getter Boolean paymentCardRequired;
  private @Getter String duration;
  private @Getter ExtendedSegment[] segments;

  @ToString
  public class ExtendedSegment {
    protected ExtendedSegment() {}

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
  }

  @ToString
  public class FlightEndpoint {
    protected FlightEndpoint() { }

    private @Getter String iataCode;
    private @Getter String terminal;
    private @Getter String at;
  }

  @ToString
  public class AircraftEquipment {
    protected AircraftEquipment() {}

    private @Getter String code;
  }

  @ToString
  public class AvailabilityClass {
    protected AvailabilityClass() {}

    private @Getter int numberOfBookableSeats;
    @SerializedName("class")
    private @Getter String segmentClass;
    private @Getter String closedStatus;
    private @Getter TourAllotment tourAllotment;
  }

  @ToString
  public class FlightStop {
    protected FlightStop() {}

    private @Getter String iataCode;
    private @Getter String duration;
    private @Getter String arrivalAt;
    private @Getter String departureAt;
  }

  @ToString
  public class OperatingFlight {
    protected OperatingFlight() {}

    private @Getter String carrierCode;
  }

  @ToString
  public class TourAllotment {
    protected TourAllotment() {}

    private @Getter String tourName;
    private @Getter String tourReference;
    private @Getter String mode;
    private @Getter String remainingSeats;
  }

  @ToString
  public class Co2Emission {
    protected Co2Emission() {
    }

    private @Getter int weight;
    private @Getter String weightUnit;
    private @Getter String cabin;
  }
}
