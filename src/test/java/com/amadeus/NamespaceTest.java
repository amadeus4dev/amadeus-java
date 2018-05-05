package com.amadeus;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.referenceData.Location;
import com.amadeus.referenceData.Locations;
import com.amadeus.referenceData.locations.Airports;
import com.amadeus.referenceData.urls.CheckinLinks;
import com.amadeus.shopping.FlightDates;
import com.amadeus.shopping.FlightDestinations;
import com.amadeus.shopping.FlightOffers;
import com.amadeus.shopping.HotelOffers;
import com.amadeus.shopping.hotel.Offer;
import com.amadeus.travel.analytics.FareSearches;
import com.amadeus.travel.analytics.airTraffic.Traveled;
import org.junit.Test;

public class NamespaceTest {
  @Test public void testAllNamespacesExist() {
    Amadeus client = Amadeus.builder("id", "secret").build();
    assertNotNull(client.referenceData.urls.checkinLinks);
    assertNotNull(client.referenceData.locations.airports);
    assertNotNull(client.referenceData.location("123"));
    assertNotNull(client.travel.analytics.airTraffic.traveled);
    assertNotNull(client.travel.analytics.fareSearches);
    assertNotNull(client.shopping.flightDates);
    assertNotNull(client.shopping.flightDestinations);
    assertNotNull(client.shopping.flightOffers);
    assertNotNull(client.shopping.hotelOffers);
    assertNotNull(client.shopping.hotel("123").hotelOffers);
    assertNotNull(client.shopping.hotel("123").offer("234"));
  }

  @Test public void testGetMethods() throws ResponseException {
    Amadeus client = mock(Amadeus.class);
    Params params = Params.with("airline", "1X");

    when(client.get("/v2/reference-data/urls/checkin-links", null))
            .thenReturn(mock(Response.class));
    when(client.get("/v2/reference-data/urls/checkin-links", params))
            .thenReturn(mock(Response.class));
    CheckinLinks checkinLinks = new CheckinLinks(client);
    assertTrue(checkinLinks.get() instanceof Response);
    assertTrue(checkinLinks.get(params) instanceof Response);

    when(client.get("/v1/reference-data/locations", null))
            .thenReturn(mock(Response.class));
    when(client.get("/v1/reference-data/locations", params))
            .thenReturn(mock(Response.class));
    Locations locations = new Locations(client);
    assertTrue(locations.get() instanceof Response);
    assertTrue(locations.get(params) instanceof Response);

    when(client.get("/v1/reference-data/locations/airports", null))
            .thenReturn(mock(Response.class));
    when(client.get("/v1/reference-data/locations/airports", params))
            .thenReturn(mock(Response.class));
    Airports airports = new Airports(client);
    assertTrue(airports.get() instanceof Response);
    assertTrue(airports.get(params) instanceof Response);

    when(client.get("/v1/reference-data/locations/ALHR", null))
            .thenReturn(mock(Response.class));
    when(client.get("/v1/reference-data/locations/ALHR", params))
            .thenReturn(mock(Response.class));
    Location location = new Location(client, "ALHR");
    assertTrue(location.get() instanceof Response);
    assertTrue(location.get(params) instanceof Response);

    when(client.get("/v1/travel/analytics/air-traffic/traveled", null))
            .thenReturn(mock(Response.class));
    when(client.get("/v1/travel/analytics/air-traffic/traveled", params))
            .thenReturn(mock(Response.class));
    Traveled traveled = new Traveled(client);
    assertTrue(traveled.get() instanceof Response);
    assertTrue(traveled.get(params) instanceof Response);

    when(client.get("/v1/travel/analytics/fare-searches", null))
            .thenReturn(mock(Response.class));
    when(client.get("/v1/travel/analytics/fare-searches", params))
            .thenReturn(mock(Response.class));
    FareSearches fareSearches = new FareSearches(client);
    assertTrue(fareSearches.get() instanceof Response);
    assertTrue(fareSearches.get(params) instanceof Response);

    when(client.get("/v1/shopping/flight-dates", null))
            .thenReturn(mock(Response.class));
    when(client.get("/v1/shopping/flight-dates", params))
            .thenReturn(mock(Response.class));
    FlightDates flightDates = new FlightDates(client);
    assertTrue(flightDates.get() instanceof Response);
    assertTrue(flightDates.get(params) instanceof Response);

    when(client.get("/v1/shopping/flight-destinations", null))
            .thenReturn(mock(Response.class));
    when(client.get("/v1/shopping/flight-destinations", params))
            .thenReturn(mock(Response.class));
    FlightDestinations flightDestinations = new FlightDestinations(client);
    assertTrue(flightDestinations.get() instanceof Response);
    assertTrue(flightDestinations.get(params) instanceof Response);

    when(client.get("/v1/shopping/flight-offers", null))
            .thenReturn(mock(Response.class));
    when(client.get("/v1/shopping/flight-offers", params))
            .thenReturn(mock(Response.class));
    FlightOffers flightOffers = new FlightOffers(client);
    assertTrue(flightOffers.get() instanceof Response);
    assertTrue(flightOffers.get(params) instanceof Response);

    when(client.get("/v1/shopping/hotel-offers", null))
            .thenReturn(mock(Response.class));
    when(client.get("/v1/shopping/hotel-offers", params))
            .thenReturn(mock(Response.class));
    HotelOffers hotelOffers = new HotelOffers(client);
    assertTrue(hotelOffers.get() instanceof Response);
    assertTrue(hotelOffers.get(params) instanceof Response);

    when(client.get("/v1/shopping/hotels/123/hotel-offers", null))
            .thenReturn(mock(Response.class));
    when(client.get("/v1/shopping/hotels/123/hotel-offers", params))
            .thenReturn(mock(Response.class));
    com.amadeus.shopping.hotel.HotelOffers hotelOffers2
            = new com.amadeus.shopping.hotel.HotelOffers(client, "123");
    assertTrue(hotelOffers2.get() instanceof Response);
    assertTrue(hotelOffers2.get(params) instanceof Response);

    when(client.get("/v1/shopping/hotels/123/offers/234", null))
            .thenReturn(mock(Response.class));
    when(client.get("/v1/shopping/hotels/123/offers/234", params))
            .thenReturn(mock(Response.class));
    Offer offer = new Offer(client, "123", "234");
    assertTrue(offer.get() instanceof Response);
    assertTrue(offer.get(params) instanceof Response);
  }
}
