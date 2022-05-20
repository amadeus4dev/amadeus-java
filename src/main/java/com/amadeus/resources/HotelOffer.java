package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * An HotelOffer object as returned by the HotelOffers API.
 * @see com.amadeus.shopping.HotelOffers#get()
 */
@ToString
public class HotelOffer extends Resource {
  protected HotelOffer() {}

  private @Getter String type;
  private @Getter Hotel hotel;
  private @Getter boolean available;
  private @Getter Offer[] offers;
  private @Getter String self;

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class Hotel {
    protected Hotel() {}

    private @Getter String hotelId;
    private @Getter String chainCode;
    private @Getter String brandCode;
    private @Getter String dupeId;
    private @Getter String name;
    private @Getter String cityCode;
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class Offer extends Resource {
    protected Offer() {}

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
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class RateFamily {
    protected RateFamily() {}

    private @Getter String code;
    private @Getter String type;
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class Commission {
    protected Commission() {}

    private @Getter String percentage;
    private @Getter String amount;
    private @Getter QualifiedFreeText description;
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class RoomDetails {
    protected RoomDetails() {}

    private @Getter String type;
    private @Getter EstimatedRoomType typeEstimated;
    private @Getter QualifiedFreeText description;
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class EstimatedRoomType {
    protected EstimatedRoomType() {}

    private @Getter String category;
    private @Getter Integer beds;
    private @Getter String bedType;
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class HotelPrice {
    protected HotelPrice() {}

    private @Getter String currency;
    private @Getter String sellingTotal;
    private @Getter String total;
    private @Getter String base;
    private @Getter HotelTax[] taxes;
    private @Getter Markup[] markups;
    private @Getter PriceVariations variations;
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class HotelTax {
    protected HotelTax() {}

    private @Getter String currency;
    private @Getter String amount;
    private @Getter String code;
    private @Getter String percentage;
    private @Getter boolean included;
    private @Getter String description;
    private @Getter String pricingFrequency;
    private @Getter String pricingMode;
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class PriceVariations {
    protected PriceVariations() {}

    private @Getter Price average;
    private @Getter PriceVariation[] changes;
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class PriceVariation {
    protected PriceVariation() {}

    private @Getter String startDate;
    private @Getter String endDate;
    private @Getter String currency;
    private @Getter String sellingTotal;
    private @Getter String base;
    private @Getter String total;
    private @Getter Markup[] markups;
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class Price {
    protected Price() {}

    private @Getter String currency;
    private @Getter String sellingTotal;
    private @Getter String base;
    private @Getter String total;
    private @Getter Markup[] markups;
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class Guests {
    protected Guests() {}

    private @Getter Integer adults;
    private @Getter Integer[] childAges;
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class QualifiedFreeText {
    protected QualifiedFreeText() {}

    private @Getter String lang;
    private @Getter String text;
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class PolicyDetails {
    protected PolicyDetails() {}

    private @Getter String paymentType;
    private @Getter GuaranteePolicy guarantee;
    private @Getter DepositPolicy deposit;
    private @Getter DepositPolicy prepay;
    private @Getter HoldPolicy holdTime;
    private @Getter CancellationPolicy cancellation;
    private @Getter CheckInOutPolicy checkInOut;
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class DepositPolicy {
    protected DepositPolicy() {}

    private @Getter String amount;
    private @Getter String deadline;
    private @Getter QualifiedFreeText description;
    private @Getter PaymentPolicy acceptedPayments;
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class HoldPolicy {
    protected HoldPolicy() {}

    private @Getter String deadline;
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class CheckInOutPolicy {

    protected CheckInOutPolicy() {}

    private @Getter String checkIn;
    private @Getter QualifiedFreeText checkInDescription;
    private @Getter String checkOut;
    private @Getter QualifiedFreeText checkOutDescription;
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class GuaranteePolicy {
    protected GuaranteePolicy() {}

    private @Getter QualifiedFreeText description;
    private @Getter PaymentPolicy acceptedPayments;
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class CancellationPolicy {
    protected CancellationPolicy() {}

    private @Getter String type;
    private @Getter String amount;
    private @Getter Integer numberOfNights;
    private @Getter String percentage;
    private @Getter String deadline;
    private @Getter QualifiedFreeText description;
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class PaymentPolicy {
    protected PaymentPolicy() {}

    private @Getter String[] creditCards;
    private @Getter String[] method;
  }

  /**
   * An HotelOffer-related object as returned by the HotelOffers API.
   * @see com.amadeus.shopping.HotelOffers#get()
   */
  @ToString
  public class Markup {
    protected Markup() {}

    private @Getter String amount;
  }
}
