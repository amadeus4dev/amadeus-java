package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * A ScoreLocation object as returned by the Transfer Management API.
 * @see com.amadeus.ordering.transfer-orders.transfers.cancellation.TransferCancellation#post()
 */
@ToString
public class TransferCancellation extends Resource {
      private @Getter String confirmNbr;
      private @Getter String reservationStatus;

  protected TransferCancellation() {}
    
}
