package com.amadeus;

import lombok.experimental.Accessors;
import lombok.Getter;
import lombok.Setter;

@Accessors(chain = true)
public class Configuration {
  private @Getter @Setter String clientId;
  private @Getter @Setter String clientSecret;

  public Amadeus build() {
      return new Amadeus(this);
  }
}
