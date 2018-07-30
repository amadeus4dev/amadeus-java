package com.amadeus;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.referenceData.Airlines;
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
import com.amadeus.travel.analytics.airTraffic.Booked;
import com.amadeus.travel.analytics.airTraffic.Traveled;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.junit.Before;
import org.junit.Test;

public class NamespaceTest {
  private Amadeus client;
  private Params params;
  private Response singleResponse;
  private Response multiResponse;

  @Test public void testAllNamespacesExist() {
    Amadeus client = Amadeus.builder("id", "secret").build();
    assertNotNull(client.referenceData.urls.checkinLinks);
    assertNotNull(client.referenceData.locations.airports);
    assertNotNull(client.referenceData.location("123"));
    assertNotNull(client.referenceData.airlines);
    assertNotNull(client.travel.analytics.airTraffic.traveled);
    assertNotNull(client.travel.analytics.airTraffic.booked);
    assertNotNull(client.travel.analytics.fareSearches);
    assertNotNull(client.shopping.flightDates);
    assertNotNull(client.shopping.flightDestinations);
    assertNotNull(client.shopping.flightOffers);
    assertNotNull(client.shopping.hotelOffers);
    assertNotNull(client.shopping.hotel("123").hotelOffers);
    assertNotNull(client.shopping.hotel("123").offer("234"));
  }

  @Before public void setup() {
    client = mock(Amadeus.class);
    params = Params.with("airline", "1X");

    // Prepare a plural response
    JsonArray jsonArray = new JsonArray();
    jsonArray.add(new JsonObject());
    jsonArray.add(new JsonObject());
    multiResponse = mock(Response.class);
    when(multiResponse.isParsed()).thenReturn(true);
    when(multiResponse.getData()).thenReturn(jsonArray);

    // Prepare a single response
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("foo", "bar");
    singleResponse = mock(Response.class);
    when(singleResponse.isParsed()).thenReturn(true);
    when(singleResponse.getData()).thenReturn(jsonObject);
  }

  @Test public void testGetMethods() throws ResponseException {
    // Testing CheckinLinks
    when(client.get("/v2/reference-data/urls/checkin-links", null))
            .thenReturn(multiResponse);
    when(client.get("/v2/reference-data/urls/checkin-links", params))
            .thenReturn(multiResponse);
    CheckinLinks checkinLinks = new CheckinLinks(client);

    assertNotNull(checkinLinks.get());
    assertNotNull(checkinLinks.get(params));
    assertEquals(checkinLinks.get().length, 2);

    // Testing location search
    when(client.get("/v1/reference-data/locations", null))
            .thenReturn(multiResponse);
    when(client.get("/v1/reference-data/locations", params))
            .thenReturn(multiResponse);
    Locations locations = new Locations(client);
    assertNotNull(locations.get());
    assertNotNull(locations.get(params));
    assertEquals(locations.get().length, 2);

    // Testing airport search
    when(client.get("/v1/reference-data/locations/airports", null))
            .thenReturn(multiResponse);
    when(client.get("/v1/reference-data/locations/airports", params))
            .thenReturn(multiResponse);
    Airports airports = new Airports(client);
    assertNotNull(airports.get());
    assertNotNull(airports.get(params));
    assertEquals(airports.get().length, 2);

    // Testing fetching a single location
    when(client.get("/v1/reference-data/locations/ALHR", null))
            .thenReturn(singleResponse);
    when(client.get("/v1/reference-data/locations/ALHR", params))
            .thenReturn(singleResponse);
    Location location = new Location(client, "ALHR");
    assertNotNull(location.get());
    assertNotNull(location.get(params));

    // Testing airlines search
    when(client.get("/v1/reference-data/airlines", null))
            .thenReturn(multiResponse);
    when(client.get("/v1/reference-data/airlines", params))
            .thenReturn(multiResponse);
    Airlines airlines = new Airlines(client);
    assertNotNull(airlines.get());
    assertNotNull(airlines.get(params));
    assertEquals(airlines.get().length, 2);


    // Testing traveled stats
    when(client.get("/v1/travel/analytics/air-traffic/traveled", null))
            .thenReturn(multiResponse);
    when(client.get("/v1/travel/analytics/air-traffic/traveled", params))
            .thenReturn(multiResponse);
    Traveled traveled = new Traveled(client);
    assertNotNull(traveled.get());
    assertNotNull(traveled.get(params));
    assertEquals(traveled.get().length, 2);

    // Testing booked stats
    when(client.get("/v1/travel/analytics/air-traffic/booked", null))
            .thenReturn(multiResponse);
    when(client.get("/v1/travel/analytics/air-traffic/booked", params))
            .thenReturn(multiResponse);
    Booked booked = new Booked(client);
    assertNotNull(booked.get());
    assertNotNull(booked.get(params));
    assertEquals(booked.get().length, 2);

    // Testing fare search stats
    when(client.get("/v1/travel/analytics/fare-searches", null))
            .thenReturn(multiResponse);
    when(client.get("/v1/travel/analytics/fare-searches", params))
            .thenReturn(multiResponse);
    FareSearches fareSearches = new FareSearches(client);
    assertNotNull(fareSearches.get());
    assertNotNull(fareSearches.get(params));
    assertEquals(fareSearches.get().length, 2);

    // Testing flight date search
    when(client.get("/v1/shopping/flight-dates", null))
            .thenReturn(multiResponse);
    when(client.get("/v1/shopping/flight-dates", params))
            .thenReturn(multiResponse);
    FlightDates flightDates = new FlightDates(client);
    assertNotNull(flightDates.get());
    assertNotNull(flightDates.get(params));
    assertEquals(flightDates.get().length, 2);

    // Testing flight destination search
    when(client.get("/v1/shopping/flight-destinations", null))
            .thenReturn(multiResponse);
    when(client.get("/v1/shopping/flight-destinations", params))
            .thenReturn(multiResponse);
    FlightDestinations flightDestinations = new FlightDestinations(client);
    assertNotNull(flightDestinations.get());
    assertNotNull(flightDestinations.get(params));
    assertEquals(flightDestinations.get().length, 2);

    // Testing flight offer search
    when(client.get("/v1/shopping/flight-offers", null))
            .thenReturn(multiResponse);
    when(client.get("/v1/shopping/flight-offers", params))
            .thenReturn(multiResponse);
    FlightOffers flightOffers = new FlightOffers(client);
    assertNotNull(flightOffers.get());
    assertNotNull(flightOffers.get(params));
    assertEquals(flightOffers.get().length, 2);

    // Testing hotel offer search
    when(client.get("/v1/shopping/hotel-offers", null))
            .thenReturn(multiResponse);
    when(client.get("/v1/shopping/hotel-offers", params))
            .thenReturn(multiResponse);
    HotelOffers hotelOffers = new HotelOffers(client);
    assertNotNull(hotelOffers.get());
    assertNotNull(hotelOffers.get(params));
    assertEquals(hotelOffers.get().length, 2);

    // Testing hotel offer search for a hotel
    when(client.get("/v1/shopping/hotels/123/hotel-offers", null))
            .thenReturn(singleResponse);
    when(client.get("/v1/shopping/hotels/123/hotel-offers", params))
            .thenReturn(singleResponse);
    com.amadeus.shopping.hotel.HotelOffers hotelOffers2
            = new com.amadeus.shopping.hotel.HotelOffers(client, "123");
    assertNotNull(hotelOffers2.get());
    assertNotNull(hotelOffers2.get(params));

    // Test fetching a specific offer
    when(client.get("/v1/shopping/hotels/123/offers/234", null))
            .thenReturn(singleResponse);
    when(client.get("/v1/shopping/hotels/123/offers/234", params))
            .thenReturn(singleResponse);
    Offer offer = new Offer(client, "123", "234");
    assertNotNull(offer.get());
    assertNotNull(offer.get(params));
  }
}
