package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * A TransferOffersPost object as returned by the Transfer Offers API.
 * @see com.amadeus.shopping.TransferOffersPost#post()
 */
@ToString
public class TransferOffersPost extends Resource {
  private @Getter String transferType;
  private @Getter String duration;
  private @Getter String language;
  private @Getter String type;
  private @Getter String id;
  private @Getter String[] settings;
  private @Getter Location start;
  private @Getter Location end;
  private @Getter StopOver[] stopOvers;
  private @Getter PassenegerCharacteristics[] passenegerCharacteristics;
  private @Getter TravelSegment startConnectedSegment;
  private @Getter TravelSegment endConnectedSegment;
  private @Getter Vehicle vehicle;
  private @Getter ServiceProvider serviceProvider;
  private @Getter BusinessIdentification businessIdentification;
  private @Getter PartnerInfo partnerInfo;
  private @Getter Quotation quotation;
  private @Getter Quotation converted;
  private @Getter ExtraService[] extraServices;
  private @Getter Equipment[] equipment;
  private @Getter CancellationRules[] cancellationRules;
  private @Getter String[] methodsOfPaymentAccepted;
  private @Getter DiscountCode[] discountCodes;
  private @Getter Distance distance;

  protected TransferOffersPost() {}

  @ToString
  public class Distance {
    private @Getter Integer value;
    private @Getter String unit;

    protected Distance() {}

  }

  @ToString
  public class Discount {
    private @Getter String monetaryAmount;

    protected Discount() {}

  }

  @ToString
  public class DiscountCode {
    private @Getter String type;
    private @Getter String value;

    protected DiscountCode() {}

  }

  @ToString
  public class Base {
    private @Getter String monetaryAmount;

    protected Base() {}

  }

  @ToString
  public class Tax {
    private @Getter String monetaryAmount;
    private @Getter String indicator;
    private @Getter String natureCode;
    private @Getter String countryCode;
    private @Getter String rate;
    private @Getter ContactWithAddress contacts;

    protected Tax() {}

  }

  @ToString
  public class CancellationRules {
    private @Getter String ruleDescription;
    private @Getter String feeType;
    private @Getter String feeValue;
    private @Getter String currencyCode;
    private @Getter String metricType;
    private @Getter String metricMin;
    private @Getter String metricMax;

    protected CancellationRules() {}

  }

  @ToString
  public class Fee {
    private @Getter String monetaryAmount;
    private @Getter String indicator;
    private @Getter String currencyCode;

    protected Fee() {}

  }

  @ToString
  public class PointsAndCash {
    private @Getter String monetaryAmount;

    protected PointsAndCash() {}

  }

  @ToString
  public class Quotation {
    private @Getter String monetaryAmount;
    private @Getter String currencyCode;
    private @Getter Boolean isEstimated;
    private @Getter Base base;
    private @Getter Discount discount;
    private @Getter Tax[] taxes;
    private @Getter Fee[] fees;
    private @Getter PointsAndCash totalTaxes;
    private @Getter PointsAndCash totalFees;

    protected Quotation() {}

  }

  @ToString
  public class PartnerInfo {
    private @Getter String serviceProvider;

    protected PartnerInfo() {}

  }


  @ToString
  public class ServiceProvider {
    private @Getter String code;
    private @Getter String name;
    private @Getter String logoUrl;
    private @Getter String termsUrl;
    private @Getter Boolean isPreferred;
    private @Getter ContactWithAddress contacts;

    protected ServiceProvider() {}

  }

  @ToString
  public class BusinessIdentification {
    private @Getter String vatRegistrationNumber;

    protected BusinessIdentification() {}

  }

  @ToString
  public class ContactWithAddress {
    private @Getter String phoneNumber;
    private @Getter String email;
    private @Getter AddressCommon address;

    protected ContactWithAddress() {}

  }

  @ToString
  public class AddressCommon {
    private @Getter String line;
    private @Getter String zip;
    private @Getter String countryCode;
    private @Getter String cityName;
    private @Getter String stateCode;

    protected AddressCommon() {}

  }

  @ToString
  public class Vehicle {
    private @Getter String code;
    private @Getter String category;
    private @Getter String description;
    private @Getter String imageURL;
    private @Getter Seat[] seats;
    private @Getter Baggage[] baggages;

    protected Vehicle() {}

  }

  @ToString
  public class Baggage {
    private @Getter Integer count;
    private @Getter String size;

    protected Baggage() {}

  }

  @ToString
  public class Seat {
    private @Getter String row;
    private @Getter Integer count;
    private @Getter String size;

    protected Seat() {}

  }

  @ToString
  public class StopOver {
    private @Getter String duration;
    private @Getter Integer sequenceNumber;
    private @Getter Location location;

    protected StopOver() {}

  }

  @ToString
  public class TravelSegment {
    private @Getter String transportationType;
    private @Getter String transportationNumber;
    private @Getter TravelSegmentLocation departure;
    private @Getter TravelSegmentLocation arrival;

    protected TravelSegment() {}

  }
  
  @ToString
  public class TravelSegmentLocation {
    private @Getter String uicCode;
    private @Getter String iataCode;
    private @Getter String localDateTime;

    protected TravelSegmentLocation() {}

  }

  @ToString
  public class PassenegerCharacteristics {
    private @Getter String passengerTypeCode;
    private @Getter Integer age;

    protected PassenegerCharacteristics() {}

  }

  @ToString
  public class Location {
    private @Getter String dateTime;
    private @Getter String locationCode;
    private @Getter String lfiCode;
    private @Getter String name;
    private @Getter String googlePlaceId;
    private @Getter String uicCode;
    private @Getter Address address;

    protected Location() {}

  }

  @ToString
  public class Address {
    private @Getter String line;
    private @Getter String zip;
    private @Getter String countryCode;
    private @Getter String cityName;
    private @Getter String stateCode;
    private @Getter double latitude;
    private @Getter double longitude;

    protected Address() {}

  }

  @ToString
  public class ExtraService {
    private @Getter String code;
    private @Getter String itemId;
    private @Getter String description;
    private @Getter String metricType;
    private @Getter String metricValue;
    private @Getter Quotation quotation;
    private @Getter Quotation converted;
    private @Getter Boolean isBookable;
    private @Getter Boolean taxIncluded;
    private @Getter Boolean includedInTotal;

    protected ExtraService() {}

  }

  @ToString
  public class Equipment {
    private @Getter String code;
    private @Getter String itemId;
    private @Getter String description;
    private @Getter String metricType;
    private @Getter String metricValue;
    private @Getter Quotation quotation;
    private @Getter Quotation converted;
    private @Getter Boolean isBookable;
    private @Getter Boolean taxIncluded;
    private @Getter Boolean includedInTotal;

    protected Equipment() {}

  }
}
