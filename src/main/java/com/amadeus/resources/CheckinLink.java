package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * An CheckinLink object as returned by the CheckinLink API.
 * @see com.amadeus.referenceData.urls.CheckinLinks#get()
 */
@ToString
public class CheckinLink extends Resource {
  protected CheckinLink() {}

  private @Getter String type;
  private @Getter String id;
  private @Getter String href;
  private @Getter String channel;
}
