package com.amadeus.resources;

import java.util.ArrayList;

import lombok.Getter;
import lombok.ToString;

/**
 * An Trip Parser object as returned by the Trip Parser API.
 * @see Traveled#get()
 */
@ToString
public class TripParser extends Resource {
  protected TripParser() {}

  private @Getter String type;
  private @Getter String id;
  private @Getter String status;
  private @Getter Self self;

  /**
   * An Self-related object as returned by the Trip Parser API.
   * @see Traveled#get()
   */
  @ToString
  public class Self {
    protected Self() {}

    private @Getter String href;
    private @Getter ArrayList<String> methods;
  }
}
