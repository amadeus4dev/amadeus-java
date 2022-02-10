package com.amadeus.resources;

import com.amadeus.shopping.FlightAvailabilitiesSearch;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

/**
 * A FlightAvailabilitySearch object as returned by the FlightAvailabilitiesSearch API.
 * @see FlightAvailabilitiesSearch#get()
 */
@ToString
public class FlightAvailabilitySearch extends Resource {
  protected FlightAvailabilitySearch() {}

  private @Getter String type;
  private @Getter String id;
  private @Getter String originalDestinationId;
  private @Getter String source;
  private @Getter Boolean instantTicketingRequired;
  private @Getter Boolean paymentCardRequired;
  private @Getter String duration;
  private @Getter SearchSegment[] segments;

  @ToString
  public class SearchSegment {
	protected SearchSegment() {}

	private @Getter String id;
	private @Getter int numberOfStops;
	private @Getter boolean blacklistedInEU;
	private @Getter AirportInfo departure;
	private @Getter AirportInfo arrival;
	private @Getter String carrierCode;
	private @Getter String number;
	private @Getter Aircraft aircraft;
	private @Getter AvailabilityClass[] availabilityClasses;
  }

  @ToString
  public class AirportInfo {
	protected AirportInfo() { }

	private @Getter String iataCode;
	private @Getter String terminal;
	private @Getter String at;
  }

  @ToString
  public class Aircraft {
	protected Aircraft() {}

	private @Getter String code;
  }

  @ToString
  public class AvailabilityClass {
	protected AvailabilityClass() {}

	private @Getter int numberOfBookableSeats;
	@SerializedName("class")
	private @Getter String segmentClass;
  }
}
