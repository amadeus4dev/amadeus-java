package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * A ScoreLocation object as returned by the Location Score API.
 * @see com.amadeus.location.analytics.CategoryRatedAreas#get()
 */
@ToString
public class ScoredLocation extends Resource {
  protected ScoredLocation() {}

  private @Getter GeoCode geoCode;
  private @Getter int radius;
  private @Getter CategoryScores categoryScores;
  private @Getter String type;

  @ToString
  public class GeoCode {
    protected GeoCode() {}

    private @Getter float latitude;
    private @Getter float longitude;
  }

  @ToString
  public class CategoryScores {
    protected CategoryScores() {}

    private @Getter Sight sight;
    private @Getter Restaurant restaurant;
    private @Getter Shopping shopping;
    private @Getter NightLife nightLife;

    @ToString
    public class Sight {
      protected Sight() {}

      private @Getter int overall;
      private @Getter int historical;
      private @Getter int beachAndPark;
    }

    @ToString
    public class Restaurant {
      protected Restaurant() {}

      private @Getter int overall;
      private @Getter int vegetarian;
    }

    @ToString
    public class Shopping {
      protected Shopping() {}

      private @Getter int overall;
      private @Getter int luxury;
    }

    @ToString
    public class NightLife {
      protected NightLife() {}

      private @Getter int overall;
    }
  }

}
