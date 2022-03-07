package com.amadeus;

import com.amadeus.dutyOfCare.Diseases;
import com.amadeus.shopping.FlightDates;

/**
 * <p>
 *   A namespaced client for the
 *   <code>/v1/duty-of-care</code> endpoints.
 * </p>
 *
 * <p>
 *   Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
 * amadeus.dutyOfCare;</pre>
 *
 * @hide
 */
public class DutyOfCare {
  private Amadeus client;

  /**
   * <p>
   *   A namespaced client for the
   *   <code>/v1/duty-of-care/diseases/covid19-area-report</code> endpoints.
   * </p>
   */
  public Diseases diseases;

  /**
   * Constructor.
   * @hide
   */
  public DutyOfCare(Amadeus client) {
    this.client = client;
    this.diseases = new Diseases(client);
  }
}
