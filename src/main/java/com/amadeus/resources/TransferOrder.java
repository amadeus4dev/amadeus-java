package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * A TransferOrder object as returned by the Transfer Booking API.
 * @see com.amadeus.ordering.transferOrders#post()
 */
@ToString
public class TransferOrder extends Resource {
  private @Getter String type;
  private @Getter String id;    
  private @Getter String reference;
  private @Getter TransferReservation[] transfers;
  private @Getter Passengers[] passengers;
  private @Getter Agency agency;

  protected TransferOrder() {}

  @ToString
  public class TransferReservation {
    private @Getter String confirmNbr;
    private @Getter String status;
    private @Getter String note;
    private @Getter String methodOfPayment;
    private @Getter String paymentServiceProvider;
    private @Getter String offerId;
    private @Getter String transferType;
    private @Getter String duration;
    private @Getter String[] methodsOfPaymentAccepted;
    private @Getter TransferOffersPost.Location start;
    private @Getter TransferOffersPost.Location end;
    private @Getter TransferOffersPost.StopOver[] stopOvers;
    private @Getter TransferOffersPost.PassenegerCharacteristics[] passenegerCharacteristics;
    private @Getter TransferOffersPost.Vehicle vehicle;
    private @Getter TransferOffersPost.ServiceProvider serviceProvider;
    private @Getter TransferOffersPost.PartnerInfo partnerInfo;
    private @Getter TransferOffersPost.Quotation quotation;
    private @Getter TransferOffersPost.Quotation converted;
    private @Getter TransferOffersPost.ExtraService[] extraServices;
    private @Getter TransferOffersPost.Equipment[] equipment;
    private @Getter TransferOffersPost.CancellationRules[] cancellationRules;
    private @Getter TransferOffersPost.DiscountCode[] discountCodes;
    private @Getter TransferOffersPost.Distance distance;

    protected TransferReservation() {}

  }

  @ToString
  public class Passengers {
    private @Getter String type;
    private @Getter String firstName;
    private @Getter String lastName;
    private @Getter String title;
    private @Getter String paymentServiceProvider;
    private @Getter String offerId;
    private @Getter String transferType;
    private @Getter String duration;
    private @Getter String[] methodsOfPaymentAccepted;
    private @Getter Contact contacts;
    private @Getter TransferOffersPost.AddressCommon address;

    protected Passengers() {}

  }
 
  @ToString
  public class Contact {
    private @Getter String phoneNumber;
    private @Getter String email;

    protected Contact() {}

  }

  @ToString
  public class Agency {
    private @Getter Email contacts;

    protected Agency() {}

  }

  @ToString
  public class Email {
    private @Getter String address;

    protected Email() {}

  }

}
