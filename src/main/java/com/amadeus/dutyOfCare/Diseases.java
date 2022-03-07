package com.amadeus.dutyOfCare;

import com.amadeus.Amadeus;
import com.amadeus.dutyOfCare.diseases.Covid19AreaReport;

public class Diseases {
  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/duty-of-care/diseases/covid19-area-report</code> endpoints.
   * </p>
   */
  public Covid19AreaReport covid19AreaReport;

  /**
   * Constructor.
   * @hide
   */
  public Diseases(Amadeus client) {
    this.covid19AreaReport = new Covid19AreaReport(client);
  }
}
