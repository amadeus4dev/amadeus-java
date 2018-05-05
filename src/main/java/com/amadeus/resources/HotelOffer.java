package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

@ToString
public class HotelOffer extends Resource {
  private @Getter String type;
  private @Getter Hotel hotel;
  private @Getter boolean available;
  private @Getter Offer[] offers;

  @ToString
  private class Hotel {
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
    private @Getter AddressType address;
    private @Getter HotelContact contact;
  }

  @ToString
  public class Offer extends Resource {
    private @Getter String type;
    private @Getter String id;
    private @Getter Integer roomQuantity;
    private @Getter String bookingCode;
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
  }

  @ToString
  private class RateFamily {
    private @Getter String code;
    private @Getter String type;
  }

  @ToString
  private class Commission {
    private @Getter String percentage;
    private @Getter String amount;
    private @Getter TextWithLanguageType description;
  }

  @ToString
  private class RoomDetails {
    private @Getter String type;
    private @Getter EstimatedRoomType typeEstimated;
    private @Getter TextWithLanguageType description;
  }

  @ToString
  private class EstimatedRoomType {
    private @Getter String category;
    private @Getter Integer beds;
    private @Getter String bedType;
  }

  @ToString
  private class HotelPrice {
    private @Getter String currency;
    private @Getter String total;
    private @Getter String base;
    private @Getter HotelTax[] taxes;
    private @Getter PriceVariations variations;
  }

  @ToString
  private class HotelTax {
    private @Getter String currency;
    private @Getter String amount;
    private @Getter String code;
    private @Getter String percentage;
    private @Getter boolean included;
    private @Getter String description;
    private @Getter String pricingFrequency;
    private @Getter String pricingMode;
  }

  @ToString
  private class PriceVariations {
    private @Getter BaseTotalAmount average;
    private @Getter PriceVariation[] changes;
  }

  @ToString
  private class PriceVariation {
    private @Getter String startDate;
    private @Getter String endDate;
    private @Getter String base;
    private @Getter String total;
  }

  @ToString
  private class BaseTotalAmount {
    private @Getter String base;
    private @Getter String total;
  }

  @ToString
  private class Guests {
    private @Getter Integer adults;
    private @Getter Integer[] childAges;
  }

  @ToString
  private class TextWithLanguageType {
    private @Getter String lang;
    private @Getter String text;
  }

  @ToString
  private class MediaURI {
    private @Getter String uri;
  }

  @ToString
  private class AddressType {
    private @Getter String[] lines;
    private @Getter String postalCode;
    private @Getter String cityName;
    private @Getter String countryCode;
    private @Getter String stateCode;
  }

  @ToString
  private class HotelContact {
    private @Getter String phone;
    private @Getter String fax;
  }

  @ToString
  private class PolicyDetails {
    private @Getter GuaranteePolicy guarantee;
    private @Getter GuaranteePolicy deposit;
    private @Getter GuaranteePolicy prepay;
    private @Getter GuaranteePolicy holdTime;
    private @Getter CancellationPolicy cancellation;
  }

  @ToString
  private class GuaranteePolicy {
    private @Getter String amount;
    private @Getter String deadline;
    private @Getter TextWithLanguageType description;
    private @Getter PaymentPolicy acceptedPayments;
  }

  @ToString
  private class CancellationPolicy {
    private @Getter String type;
    private @Getter String amount;
    private @Getter Integer numberOfNights;
    private @Getter String percentage;
    private @Getter String deadline;
    private @Getter TextWithLanguageType description;
  }

  @ToString
  private class PaymentPolicy {
    private @Getter String[] creditCards;
    private @Getter String method;
  }
}
