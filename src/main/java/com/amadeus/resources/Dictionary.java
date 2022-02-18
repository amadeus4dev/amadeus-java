package com.amadeus.resources;

import com.amadeus.Response;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * A Dictionary Object which is mapped from the
 * @see Response#getDictionaries()
 */
@ToString
public class Dictionary extends Resource {
  protected Dictionary() {}

  private @Getter Map<String, LocationValue> locations;
  private @Getter Map<String, String> aircraft;
  private @Getter Map<String, String> currencies;
  private @Getter Map<String, String> carriers;

  @ToString
  public class LocationValue {
    protected LocationValue() {}

    private @Getter String cityCode;
    private @Getter String countryCode;
  }
}
