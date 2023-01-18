package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * An HotelOfferSearch object as returned by the HotelOffers API v3.
 * @see com.amadeus.shopping.HotelOffers#get()
 */
@ToString
public class HotelOfferSearch extends Resource {
  private @Getter String type;
  private @Getter Hotel hotel;
  private @Getter boolean available;
  private @Getter Offer[] offers;
  private @Getter String self;

  protected HotelOfferSearch() {}

  /**
   * An HotelOffer-related object as returned by the HotelOffers API v3.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class Hotel {
    private @Getter String hotelId;
    private @Getter String chainCode;
    private @Getter String brandCode;
    private @Getter String dupeId;
    private @Getter String name;
    private @Getter String cityCode;

    protected Hotel() {}

  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API v3.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class Offer extends Resource {
    private @Getter String type;
    private @Getter String id;
    private @Getter String checkInDate;
    private @Getter String checkOutDate;
    private @Getter Integer roomQuantity;
    private @Getter String rateCode;
    private @Getter RateFamily rateFamilyEstimated;
    private @Getter String category;
    private @Getter QualifiedFreeText description;
    private @Getter Commission commission;
    private @Getter String boardType;
    private @Getter RoomDetails room;
    private @Getter Guests guests;
    private @Getter HotelPrice price;
    private @Getter PolicyDetails policies;
    private @Getter String self;

    protected Offer() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API v3.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class RateFamily {
    private @Getter String code;
    private @Getter String type;

    protected RateFamily() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API v3.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class Commission {
    private @Getter String percentage;
    private @Getter String amount;
    private @Getter QualifiedFreeText description;

    protected Commission() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API v3.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class RoomDetails {
    private @Getter String type;
    private @Getter EstimatedRoomType typeEstimated;
    private @Getter QualifiedFreeText description;

    protected RoomDetails() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API v3.
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
   * An HotelOffer-related object as returned by the HotelOffers API v3.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class HotelPrice {
    private @Getter String currency;
    private @Getter String sellingTotal;
    private @Getter String total;
    private @Getter String base;
    private @Getter HotelTax[] taxes;
    private @Getter Markup[] markups;
    private @Getter PriceVariations variations;

    protected HotelPrice() {}
    
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API v3.
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
   * An HotelOffer-related object as returned by the HotelOffers API v3.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class PriceVariations {
    private @Getter Price average;
    private @Getter PriceVariation[] changes;

    protected PriceVariations() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API v3.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class PriceVariation {
    private @Getter String startDate;
    private @Getter String endDate;
    private @Getter String currency;
    private @Getter String sellingTotal;
    private @Getter String base;
    private @Getter String total;
    private @Getter Markup[] markups;

    protected PriceVariation() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API v3.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class Price {
    private @Getter String currency;
    private @Getter String sellingTotal;
    private @Getter String base;
    private @Getter String total;
    private @Getter Markup[] markups;

    protected Price() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API v3.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class Guests {
    private @Getter Integer adults;
    private @Getter Integer[] childAges;

    protected Guests() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API v3.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class QualifiedFreeText {
    private @Getter String lang;
    private @Getter String text;

    protected QualifiedFreeText() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API v3.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class PolicyDetails {
    private @Getter String paymentType;
    private @Getter GuaranteePolicy guarantee;
    private @Getter DepositPolicy deposit;
    private @Getter DepositPolicy prepay;
    private @Getter HoldPolicy holdTime;
    private @Getter CancellationPolicy cancellation;
    private @Getter CheckInOutPolicy checkInOut;

    protected PolicyDetails() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API v3.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class DepositPolicy {
    private @Getter String amount;
    private @Getter String deadline;
    private @Getter QualifiedFreeText description;
    private @Getter PaymentPolicy acceptedPayments;

    protected DepositPolicy() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API v3.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class HoldPolicy {
    private @Getter String deadline;

    protected HoldPolicy() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API v3.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class CheckInOutPolicy {
    private @Getter String checkIn;
    private @Getter QualifiedFreeText checkInDescription;
    private @Getter String checkOut;
    private @Getter QualifiedFreeText checkOutDescription;

    protected CheckInOutPolicy() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API v3.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class GuaranteePolicy {
    private @Getter QualifiedFreeText description;
    private @Getter PaymentPolicy acceptedPayments;

    protected GuaranteePolicy() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API v3.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class CancellationPolicy {
    private @Getter String type;
    private @Getter String amount;
    private @Getter Integer numberOfNights;
    private @Getter String percentage;
    private @Getter String deadline;
    private @Getter QualifiedFreeText description;

    protected CancellationPolicy() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API v3.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class PaymentPolicy {
    private @Getter String[] creditCards;
    private @Getter String[] method;

    protected PaymentPolicy() {}
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API v3.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class Markup {
    private @Getter String amount;

    protected Markup() {}
  }
}
