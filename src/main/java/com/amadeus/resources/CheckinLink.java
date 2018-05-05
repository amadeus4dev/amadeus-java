package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

@ToString
public class CheckinLink extends Resource {
  private @Getter String type;
  private @Getter String id;
  private @Getter String href;
  private @Getter String channel;
}
