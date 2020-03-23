package examples.flight.offers;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.FlightPrice;

public class FlightOffersPrice {
  /**
   * <p>
   *   An example to call hotel Booking API
   *   <code>/v1/shopping/flight-offers/pricing</code> endpoints.
   * </p>
   *
   * <p>
   *   Access via the Amadeus client object.
   * </p>
   *
   * <pre>
   * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
   * amadeus.shopping.flightOffersSearch.pricing;</pre>
   */
  public static void main(String[] args) throws ResponseException {

    Amadeus amadeus = Amadeus
        .builder("REPLACE_BY_YOUR_API_KEY","REPLACE_BY_YOUR_API_SECRET")
        .build();

    FlightOfferSearch[] flightOffersSearches = amadeus.shopping.flightOffersSearch.get(
        Params.with("originLocationCode", "SYD")
                .and("destinationLocationCode", "BKK")
                .and("departureDate", "2020-11-01")
                .and("returnDate", "2020-11-08")
                .and("adults", 1)
                .and("max", 1));

    FlightPrice flightPricing = amadeus.shopping.flightOffersSearch.pricing.post(
            flightOffersSearches,
            Params.with("include", "detailed-fare-rules")
              .and("forceClass", "false")
          );  
    System.out.println(flightPricing.getResponse());
  }
}