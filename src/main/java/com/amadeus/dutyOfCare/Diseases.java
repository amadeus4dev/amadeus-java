package com.amadeus.dutyofcare;

import com.amadeus.Amadeus;
import com.amadeus.dutyofcare.diseases.Covid19Report;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/duty-of-care/diseases</code> endpoints.
 * </p>
 */
public class Diseases {
  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v2/duty-of-care/diseases/covid19-area-report</code> endpoints.
   * </p>
   */
  public Covid19Report covid19Report;

  /**
   * Constructor.
   * @hide
   */
  public Diseases(Amadeus client) {
    this.covid19Report = new Covid19Report(client);
  }
}
