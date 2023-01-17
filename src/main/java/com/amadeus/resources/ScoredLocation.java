package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * A ScoreLocation object as returned by the Location Score API.
 * @see com.amadeus.location.analytics.CategoryRatedAreas#get()
 */
@ToString
public class ScoredLocation extends Resource {
  private @Getter GeoCode geoCode;
  private @Getter int radius;
  private @Getter CategoryScores categoryScores;
  private @Getter String type;

  protected ScoredLocation() {}

  @ToString
  public class GeoCode {
    private @Getter float latitude;
    private @Getter float longitude;

    protected GeoCode() {}
  }

  @ToString
  public class CategoryScores {
    private @Getter Sight sight;
    private @Getter Restaurant restaurant;
    private @Getter Shopping shopping;
    private @Getter NightLife nightLife;

    protected CategoryScores() {}

    @ToString
    public class Sight {
      private @Getter int overall;
      private @Getter int historical;
      private @Getter int beachAndPark;

      protected Sight() {}
    }

    @ToString
    public class Restaurant {
      private @Getter int overall;
      private @Getter int vegetarian;

      protected Restaurant() {}
    }

    @ToString
    public class Shopping {
      private @Getter int overall;
      private @Getter int luxury;

      protected Shopping() {}
    }

    @ToString
    public class NightLife {
      private @Getter int overall;

      protected NightLife() {}
    }
  }

}
