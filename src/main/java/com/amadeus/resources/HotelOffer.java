package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * An HotelOffer object as returned by the HotelOffers API.
 * @see com.amadeus.shopping.HotelOffers#get()
 */
@ToString
public class HotelOffer extends Resource {
  private @Getter String type;
  private @Getter Hotel hotel;
  private @Getter boolean available;
  private @Getter Offer[] offers;

  protected HotelOffer() {}

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class Hotel {
    private @Getter String type;
    private @Getter String hotelId;
    private @Getter String chainCode;
    private @Getter String brandCode;
    private @Getter String dupeId;
    private @Getter String name;
    private @Getter Integer rating;
    private @Getter TextWithLanguageType description;
    private @Getter String[] amenities;
    private @Getter MediaURI[] media;
    private @Getter String cityCode;
    private @Getter double latitude;
    private @Getter double longitude;
    private @Getter HotelDistance hotelDistance;
    private @Getter AddressType address;
    private @Getter HotelContact contact;

    protected Hotel() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class Offer extends Resource {
    private @Getter String type;
    private @Getter String id;
    private @Getter Integer roomQuantity;
    private @Getter String rateCode;
    private @Getter RateFamily rateFamilyEstimated;
    private @Getter String category;
    private @Getter TextWithLanguageType description;
    private @Getter Commission commission;
    private @Getter String boardType;
    private @Getter RoomDetails room;
    private @Getter Guests guests;
    private @Getter HotelPrice price;
    private @Getter PolicyDetails policies;

    protected Offer() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class HotelDistance {
    private @Getter String description;
    private @Getter double distance;
    private @Getter String distanceUnit;

    protected HotelDistance() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class RateFamily {
    private @Getter String code;
    private @Getter String type;

    protected RateFamily() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class Commission {
    private @Getter String percentage;
    private @Getter String amount;
    private @Getter TextWithLanguageType description;

    protected Commission() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class RoomDetails {
    private @Getter String type;
    private @Getter EstimatedRoomType typeEstimated;
    private @Getter TextWithLanguageType description;

    protected RoomDetails() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class EstimatedRoomType {
    private @Getter String category;
    private @Getter Integer beds;
    private @Getter String bedType;

    protected EstimatedRoomType() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class HotelPrice {
    private @Getter String currency;
    private @Getter String total;
    private @Getter String base;
    private @Getter HotelTax[] taxes;
    private @Getter PriceVariations variations;

    protected HotelPrice() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class HotelTax {
    private @Getter String currency;
    private @Getter String amount;
    private @Getter String code;
    private @Getter String percentage;
    private @Getter boolean included;
    private @Getter String description;
    private @Getter String pricingFrequency;
    private @Getter String pricingMode;

    protected HotelTax() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class PriceVariations {
    private @Getter BaseTotalAmount average;
    private @Getter PriceVariation[] changes;

    protected PriceVariations() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class PriceVariation {
    private @Getter String startDate;
    private @Getter String endDate;
    private @Getter String base;
    private @Getter String total;

    protected PriceVariation() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class BaseTotalAmount {
    private @Getter String base;
    private @Getter String total;

    protected BaseTotalAmount() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class Guests {
    private @Getter Integer adults;
    private @Getter Integer[] childAges;

    protected Guests() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class TextWithLanguageType {
    private @Getter String lang;
    private @Getter String text;
    
    protected TextWithLanguageType() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class MediaURI {
    private @Getter String uri;
    private @Getter String category;

    protected MediaURI() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class AddressType {
    private @Getter String[] lines;
    private @Getter String postalCode;
    private @Getter String cityName;
    private @Getter String countryCode;
    private @Getter String stateCode;

    protected AddressType() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class HotelContact {
    private @Getter String phone;
    private @Getter String fax;
    private @Getter String email;

    protected HotelContact() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class PolicyDetails {
    private @Getter GuaranteePolicy guarantee;
    private @Getter GuaranteePolicy deposit;
    private @Getter GuaranteePolicy prepay;
    private @Getter GuaranteePolicy holdTime;
    private @Getter CancellationPolicy cancellation;
    private @Getter CheckInOutPolicy checkInOut;

    protected PolicyDetails() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class CheckInOutPolicy {
    private @Getter String checkIn;
    private @Getter TextWithLanguageType checkInDescription;
    private @Getter String checkOut;
    private @Getter TextWithLanguageType checkOutDescription;

    protected CheckInOutPolicy() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class GuaranteePolicy {
    private @Getter String amount;
    private @Getter String deadline;
    private @Getter TextWithLanguageType description;
    private @Getter PaymentPolicy acceptedPayments;

    protected GuaranteePolicy() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class CancellationPolicy {
    private @Getter String type;
    private @Getter String amount;
    private @Getter Integer numberOfNights;
    private @Getter String percentage;
    private @Getter String deadline;
    private @Getter TextWithLanguageType description;

    protected CancellationPolicy() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class PaymentPolicy {
    private @Getter String[] creditCards;
    private @Getter String method;

    protected PaymentPolicy() {}
  }
}
