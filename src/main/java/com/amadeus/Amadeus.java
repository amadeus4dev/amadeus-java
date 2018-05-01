package com.amadeus;

import com.amadeus.client.Configuration;
import com.amadeus.client.HTTP;
import lombok.ToString;

/**
 * The Amadeus API client.
 */
@ToString
public class Amadeus extends HTTP {
  // The version of the API.
  public static final String VERSION = "1.0.0";

  public Amadeus(Configuration configuration) {
    super(configuration);
  }
}
