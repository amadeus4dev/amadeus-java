package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;


/**
 * A TransferOrder object as returned by the Transfer Booking API.
 * @see com.amadeus.ordering.transferOrders#post()
 */
@ToString
public class TransferOrder extends Resource {
  private @Getter Integer status;
  private @Getter Integer code;    
  private @Getter String title;
  private @Getter String detail;
  private @Getter IssueSource source;


  protected TransferOrder() {}

  @ToString
  public class IssueSource {
    private @Getter String pointer;
    private @Getter String parameter;
    private @Getter String example;

    protected IssueSource() {}

  }
    
}
