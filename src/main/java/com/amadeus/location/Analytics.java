package com.amadeus.location;

import com.amadeus.Amadeus;
import com.amadeus.location.analytics.CategoryRatedAreas;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/location/analytics</code> endpoints.
 * </p>
 */
public class Analytics {
  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/location/analytics/category-rated-areas</code> endpoints.
   * </p>
   */
  public CategoryRatedAreas categoryRatedAreas;

  /**
   * Constructor.
   * @hide
   */
  public Analytics(Amadeus client) {
    this.categoryRatedAreas = new CategoryRatedAreas(client);
  }
}
