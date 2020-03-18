package examples.flight.createorders;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.FlightOrder;
import com.amadeus.resources.Traveler;
import com.amadeus.resources.Traveler.Document;
import com.amadeus.resources.Traveler.Phone;

public class FlightCreateOrders {
  /**
   * <p>
   *   An example to call the Flight Create Orders API
   *   <code>/v1/booking/flight-orders</code> endpoints.
   * </p>
   *
   * <p>
   *   Access via the Amadeus client object.
   * </p>
   *
   * <pre>
   * Amadeus amadeus = Amadeus.builder("clientId", "secret").build();
   * amadeus.booking.flightOrders;</pre>
   */
  public static void main(String[] args) throws ResponseException {

    Traveler traveler = new Traveler();

    traveler.setId("1");
    traveler.setDateOfBirth("2000-04-14");
    traveler.setName(traveler.new Name("JORGE", "GONZALES"));

    Traveler.Phone[] phone = new Phone[1];
    phone[0] = traveler.new Phone();
    phone[0].setCountryCallingCode("33");
    phone[0].setNumber("675426222");
    phone[0].setDeviceType("MOBILE");

    Traveler.Contact contact = traveler.new Contact();
    contact.setPhones(phone);
    traveler.setContact(contact);

    Traveler.Document[] document = new Document[1];
    document[0] = traveler.new Document();
    document[0].setDocumentType("PASSPORT");
    document[0].setNumber("480080076");
    document[0].setExpiryDate("2022-10-11");
    document[0].setIssuanceCountry("ES");
    document[0].setNationality("ES");
    document[0].setHolder(true);
    traveler.setDocuments(document);

    Traveler[] travelerArray = new Traveler[1];
    travelerArray[0] = traveler;
    System.out.println(travelerArray[0]);

    Amadeus amadeus = Amadeus
        .builder("YOUR_CLIENT_ID","YOUR_CLIENT_SECRET")
        .build();

    FlightOfferSearch[] flightOffersSearches = amadeus.shopping.flightOffersSearch.get(
        Params.with("originLocationCode", "SYD")
                .and("destinationLocationCode", "BKK")
                .and("departureDate", "2020-11-01")
                .and("returnDate", "2020-11-08")
                .and("adults", 1)
                .and("max", 1));

    FlightOrder order = amadeus.booking.flightOrders.post(flightOffersSearches, travelerArray);
    System.out.println(order);
  }
}