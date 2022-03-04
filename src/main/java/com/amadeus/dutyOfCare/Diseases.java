package com.amadeus.dutyOfCare;

import com.amadeus.Amadeus;
import com.amadeus.dutyOfCare.diseases.TravelRestrictions;

public class Diseases {
  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/duty-of-care/diseases/covid19-area-report</code> endpoints.
   * </p>
   */
  public TravelRestrictions travelRestrictions;

  /**
   * Constructor.
   * @hide
   */
  public Diseases(Amadeus client) {
    this.travelRestrictions = new TravelRestrictions(client);
  }
}
