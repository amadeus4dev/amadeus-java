package com.amadeus.resources;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

/**
 * An Airline object as returned by the Airline Code LookUp API.
 * @see com.amadeus.shopping.FlightOffersSearch#get()
 */
@ToString
public class FlightOfferSearch extends Resource {
  protected FlightOfferSearch() {}

  private @Getter String type;
  private @Getter String id;
  private @Getter String source;
  private @Getter boolean instantTicketingRequired;
  private @Getter boolean disablePricing;
  private @Getter boolean nonHomogeneous;
  private @Getter boolean oneWay;
  private @Getter boolean paymentCardRequired;
  private @Getter String lastTicketingDate;
  private @Getter int numberOfBookableSeats;
  private @Getter Itinerary[] itineraries;
  private @Getter SearchPrice price;
  private @Getter PricingOptions pricingOptions;
  private @Getter String[] validatingAirlineCodes;
  private @Getter TravelerPricing[] travelerPricings;
  private @Getter String choiceProbability;
  private @Getter FareRules fareRules;

  @ToString
  public class Itinerary {
    protected Itinerary() {
    }

    private @Getter String duration;
    private @Getter SearchSegment[] segments;

  }

  @ToString
  public class SearchSegment {
    protected SearchSegment() {
    }

    private @Getter AirportInfo departure;
    private @Getter AirportInfo arrival;
    private @Getter String carrierCode;
    private @Getter String number;
    private @Getter Aircraft aircraft;
    private @Getter OperatingFlight operating;
    private @Getter String duration;
    private @Getter FlightStop[] stops;
    private @Getter String id;
    private @Getter int numberOfStops;
    private @Getter boolean blacklistedInEU;
    private @Getter Co2Emissions[] co2Emissions;
  }

  @ToString
  public class OperatingFlight {
    protected OperatingFlight() {
    }

    private @Getter String carrierCode;
  }

  @ToString
  public class FlightStop {
    protected FlightStop() {
    }

    private @Getter String iataCode;
    private @Getter String duration;
    private @Getter String arrivalAt;
    private @Getter String departureAt;
  }

  @ToString
  public class Co2Emissions {
    protected Co2Emissions() {
    }

    private @Getter int weight;
    private @Getter String weightUnit;
    private @Getter String cabin;
  }

  @ToString
  public class AirportInfo {
    protected AirportInfo() {
    }

    private @Getter String iataCode;
    private @Getter String terminal;
    private @Getter String at;
  }

  @ToString
  public class Aircraft {
    protected Aircraft() {
    }

    private @Getter String code;
  }

  @ToString
  public class SearchPrice {
    protected SearchPrice() {
    }

    private @Getter String currency;
    private @Getter String total;
    private @Getter String base;
    private @Getter Fee[] fees;
    private @Getter String grandTotal;
    private @Getter Tax[] taxes;
    private @Getter String refundableTaxes;
    private @Getter String margin;
    private @Getter String billingCurrency;
    private @Getter AdditionalService[] additionalServices;
  }

  @ToString
  public class Fee {
    protected Fee() {
    }

    private @Getter String amount;
    private @Getter String type;
  }

  @ToString
  public class Tax {
    protected Tax() {
    }

    private @Getter String amount;
    private @Getter String code;
  }

  @ToString
  public class AdditionalService {
    protected AdditionalService() {
    }

    private @Getter String amount;
    private @Getter String type;
  }

  @ToString
  public class PricingOptions {
    private @Getter boolean includedCheckedBagsOnly;
    private @Getter String[] fareType;
    private @Getter String[] corporateCodes;
    private @Getter boolean refundableFare;
    private @Getter boolean noRestrictionFare;
    private @Getter boolean noPenaltyFare;
  }

  @ToString
  public class TravelerPricing {
    protected TravelerPricing() {
    }

    private @Getter String travelerId;
    private @Getter String fareOption;
    private @Getter String travelerType;
    private @Getter String associatedAdultId;
    private @Getter SearchPrice price;
    private @Getter FareDetailsBySegment[] fareDetailsBySegment;
  }

  @ToString
  public class FareDetailsBySegment {
    protected FareDetailsBySegment() {
    }

    private @Getter String segmentId;
    private @Getter String cabin;
    private @Getter String fareBasis;
    private @Getter String brandedFare;
    @SerializedName("class")
    private @Getter String segmentClass;
    private @Getter boolean isAllotment;
    private @Getter AllotmentDetails allotmentDetails;
    private @Getter String sliceDiceIndicator;
    private @Getter BaggageAllowance includedCheckedBags;
    private @Getter AdditionalServiceRequest additionalServices;
    private @Getter Amenity[] amenities;
  }

  @ToString
  public class AllotmentDetails {
    protected AllotmentDetails() {
    }

    private @Getter String tourName;
    private @Getter String tourReference;
  }

  @ToString
  public class BaggageAllowance {
    protected BaggageAllowance() {
    }

    private @Getter int quantity;
    private @Getter int weight;
    private @Getter String weightUnit;
  }

  @ToString
  public class AdditionalServiceRequest {
    protected AdditionalServiceRequest() {
    }

    private @Getter BaggageAllowance chargeableCheckedBags;
    private @Getter String chargeableSeatNumber;
    private @Getter String[] otherServices;
  }

  @ToString
  public class Amenity {
    protected Amenity() {
    }

    private @Getter String code;
    private @Getter String description;
    private @Getter Boolean isChargeable;
    private @Getter String amenityType;
  }

  @ToString
  public class FareRules {
    protected FareRules() {
    }

    private @Getter String currency;
    private @Getter TermAndCondition[] rules;
  }

  @ToString
  public class TermAndCondition {
    protected TermAndCondition() {
    }

    private @Getter String category;
    private @Getter String circumstances;
    private @Getter boolean notApplicable;
    private @Getter String maxPenaltyAmount;
    private @Getter Description[] descriptions;
  }

  @ToString
  public class Description {
    protected Description() {
    }

    private @Getter String descriptionType;
    private @Getter String text;
  }
}
