package com.amadeus.dutyofcare.diseases;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.DiseaseReport;
import com.amadeus.resources.Resource;

/**
 * <p>
 * A namespaced client for the
 * <code>/v2/duty-of-care/diseases/covid19-area-report</code> endpoints.
 * </p>
 *
 * <p>
 * Access via the Amadeus client object.
 * </p>
 *
 * <pre>
 * Amadeus amadeus = Amadeus.builder(API_KEY, API_SECRET).build();
 * amadeus.dutyOfCare.diseases.covid19Report;</pre>
 */
public class Covid19Report {
  private Amadeus client;

  /**
   * Constructor.
   * @hide
   */
  public Covid19Report(Amadeus client) {
    this.client = client;
  }

  /**
   * <p>
   *    Get up-to-date data on COVID-19 caseloads and travel restrictions
   *    for a given country, city or region.
   * </p>
   *
   * <pre>
   * amadeus.dutyOfCare.diseases.covid19Report.get(Params
   *     .with("countryCode", "US"));
   * </pre>
   *
   * @param params the parameters to send to the API
   * @return an API response object
   * @throws ResponseException when an exception occurs
   */
  public DiseaseReport get(Params params) throws ResponseException {
    Response response = client.get("/v2/duty-of-care/diseases/covid19-area-report", params);
    return (DiseaseReport) Resource.fromObject(response, DiseaseReport.class);
  }

  /**
   * Convenience method for calling <code>get</code> without any parameters.
   * @see Covid19Report#get()
   */
  public DiseaseReport get() throws ResponseException {
    return get(null);
  }
}
