package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;


/**
 * A TransferCancellation object as returned by the Transfer Management API.
 * @see com.amadeus.ordering.transferOrders.transfer.Cancellation#post()
 */
@ToString
public class TransferCancellation extends Resource {
  private @Getter String confirmNbr;
  private @Getter String reservationStatus;

  protected TransferCancellation() {}
    
}
