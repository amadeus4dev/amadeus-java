package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * An Period object as returned by the Prediction APIs.
 *
 * @see com.amadeus.travel.predictions.TripPurpose#get()
 */
@ToString
public class Prediction extends Resource {
  private @Getter String type;
  private @Getter String subType;
  private @Getter String id;
  private @Getter String result;
  private @Getter String probability;

  protected Prediction() {}
}
