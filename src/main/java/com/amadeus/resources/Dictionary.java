package com.amadeus.resources;

import com.amadeus.Response;
import java.util.Map;
import lombok.Getter;
import lombok.ToString;

/**
 * A Dictionary Object which is mapping.
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
