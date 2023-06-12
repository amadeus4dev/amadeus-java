package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * A TripDetail object as returned by the Transfer Offers API.
 * @see com.amadeus.shopping.TransferOffers#post()
 */
@ToString
public class TransferOffers extends Resource {
  private @Getter String startDateTime;
  private @Getter Integer passengers;
  private @Getter String startLocationCode;
  private @Getter String startUicCode;
  private @Getter String startLfiCode;
  private @Getter String startAddressLine;
  private @Getter String startZipCode;
  private @Getter String startCountryCode;
  private @Getter String startCityName;
  private @Getter String startStateCode;
  private @Getter String startGeoCode;
  private @Getter String startName;
  private @Getter String startGooglePlaceId;
  private @Getter String endLocationCode;
  private @Getter String endUicCode;
  private @Getter String endLfiCode;
  private @Getter String endAddressLine;
  private @Getter String endZipCode;
  private @Getter String endCountryCode;
  private @Getter String endCityName;
  private @Getter String endStateCode;
  private @Getter String endGeoCode;
  private @Getter String endName;
  private @Getter String endGooglePlaceId;
  private @Getter String transferType; 
  private @Getter String duration;
  private @Getter String language; 
  private @Getter String currency; 
  private @Getter String vehicleCategory; 
  private @Getter String vehicleCode; 
  private @Getter String providerCodes; 
  private @Getter Integer baggages; 
  private @Getter String discountNumbers; 
  private @Getter String extraServiceCodes; 
  private @Getter String equipmentCodes; 
  private @Getter String reference; 
  private @Getter StopOverRequest[] stopOvers;
  private @Getter TravelSegment[] startConnectedSegment;
  private @Getter TravelSegment[] endConnectedSegment;
  private @Getter PassenegerCharacteristics[] passenegerCharacteristics;

  protected TransferOffers() {}

  @ToString
  public class StopOverRequest {
    private @Getter String duration;
    private @Getter String locationCode;
    private @Getter String addressLine;
    private @Getter String countryCode;
    private @Getter String cityName;
    private @Getter String zipCode;
    private @Getter String googlePlaceId;
    private @Getter String name;
    private @Getter String lfiCode;
    private @Getter String stateCode;
    private @Getter String geoCode;
    private @Getter Integer sequenceNumber;
    private @Getter String uicCode;

    protected StopOverRequest() {}

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
}
