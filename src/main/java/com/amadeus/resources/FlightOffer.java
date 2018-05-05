package com.amadeus.resources;

import java.util.Date;
import lombok.Getter;
import lombok.ToString;

/**
 * An FlightOffer object as returned by the FlightOffers API.
 * @see com.amadeus.shopping.FlightOffers#get()
 */
@ToString
public class FlightOffer extends Resource {
  protected FlightOffer() {}

  private @Getter String type;
  private @Getter String id;
  private @Getter OfferItem[] offerItems;

  /**
   * An FlightOffer-related object as returned by the FlightOffers API.
   * @see com.amadeus.shopping.FlightOffers#get()
   */
  @ToString
  public class OfferItem {
    protected OfferItem() {}

    private @Getter Service[] services;
    private @Getter Price price;
    private @Getter Price pricePerAdult;
    private @Getter Price pricePerInfant;
    private @Getter Price pricePerChild;
    private @Getter Price pricePerSenior;
  }

  /**
   * An FlightOffer-related object as returned by the FlightOffers API.
   * @see com.amadeus.shopping.FlightOffers#get()
   */
  @ToString
  public class Service {
    protected Service() {}

    private @Getter Segment[] segments;
  }

  /**
   * An FlightOffer-related object as returned by the FlightOffers API.
   * @see com.amadeus.shopping.FlightOffers#get()
   */
  @ToString
  public class Segment {
    protected Segment() {}

    private @Getter FlightSegment flightSegment;
    private @Getter PricingDetail pricingDetailPerAdult;
    private @Getter PricingDetail pricingDetailPerInfant;
    private @Getter PricingDetail pricingDetailPerChild;
    private @Getter PricingDetail pricingDetailPerSenior;
  }

  /**
   * An FlightOffer-related object as returned by the FlightOffers API.
   * @see com.amadeus.shopping.FlightOffers#get()
   */
  @ToString
  public class FlightSegment {
    protected FlightSegment() {}

    private @Getter FlightEndPoint departure;
    private @Getter FlightEndPoint arrival;
    private @Getter String carrierCode;
    private @Getter String number;
    private @Getter OperatingFlight operating;
    private @Getter String duration;
    private @Getter FlightStop[] stops;
  }

  /**
   * An FlightOffer-related object as returned by the FlightOffers API.
   * @see com.amadeus.shopping.FlightOffers#get()
   */
  @ToString
  public class FlightEndPoint {
    protected FlightEndPoint() {}

    private @Getter String iataCode;
    private @Getter String terminal;
    private @Getter String at;
  }

  /**
   * An FlightOffer-related object as returned by the FlightOffers API.
   * @see com.amadeus.shopping.FlightOffers#get()
   */
  @ToString
  public class OperatingFlight {
    protected OperatingFlight() {}

    private @Getter String carrierCode;
    private @Getter String number;
  }

  /**
   * An FlightOffer-related object as returned by the FlightOffers API.
   * @see com.amadeus.shopping.FlightOffers#get()
   */
  @ToString
  public class FlightStop {
    protected FlightStop() {}

    private @Getter String iataCode;
    private @Getter AircraftEquipment newAircraft;
    private @Getter String duration;
    private @Getter Date arrivalAt;
    private @Getter Date departureAt;
  }

  /**
   * An FlightOffer-related object as returned by the FlightOffers API.
   * @see com.amadeus.shopping.FlightOffers#get()
   */
  @ToString
  public class AircraftEquipment {
    protected AircraftEquipment() {}

    private @Getter String code;
  }

  /**
   * An FlightOffer-related object as returned by the FlightOffers API.
   * @see com.amadeus.shopping.FlightOffers#get()
   */
  @ToString
  public class Price {
    protected Price() {}

    private @Getter double total;
    private @Getter double totalTaxes;
  }

  /**
   * An FlightOffer-related object as returned by the FlightOffers API.
   * @see com.amadeus.shopping.FlightOffers#get()
   */
  @ToString
  public class PricingDetail {
    protected PricingDetail() {}

    private @Getter String travelClass;
    private @Getter String fareClass;
    private @Getter int availability;
    private @Getter String fareBasis;
  }
}
