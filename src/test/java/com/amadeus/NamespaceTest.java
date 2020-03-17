package com.amadeus;

import com.amadeus.airport.predictions.AirportOnTime;
import com.amadeus.booking.FlightOrder;
import com.amadeus.booking.FlightOrders;
import com.amadeus.ereputation.HotelSentiments;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.media.files.GeneratedPhotos;
import com.amadeus.referenceData.Airlines;
import com.amadeus.referenceData.Location;
import com.amadeus.referenceData.Locations;
import com.amadeus.referenceData.locations.Airports;
import com.amadeus.referenceData.locations.PointsOfInterest;
import com.amadeus.referenceData.urls.CheckinLinks;
import com.amadeus.shopping.FlightDates;
import com.amadeus.shopping.FlightDestinations;
import com.amadeus.shopping.FlightOffers;
import com.amadeus.shopping.FlightOffersSearch;
import com.amadeus.shopping.HotelOffer;
import com.amadeus.shopping.HotelOffers;
import com.amadeus.shopping.HotelOffersByHotel;
import com.amadeus.shopping.SeatMaps;
import com.amadeus.shopping.flightOffers.Prediction;
import com.amadeus.travel.analytics.airTraffic.Booked;
import com.amadeus.travel.analytics.airTraffic.BusiestPeriod;
import com.amadeus.travel.analytics.airTraffic.Traveled;
import com.amadeus.travel.predictions.FlightDelay;
import com.amadeus.travel.predictions.TripPurpose;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class NamespaceTest {

  private Amadeus client;
  private Params params;
  private Response singleResponse;
  private Response multiResponse;
  private String body;
  private JsonObject jsonObject;

  @Test
  public void testAllNamespacesExist() {
    Amadeus client = Amadeus.builder("id", "secret").build();
    TestCase.assertNotNull(client.referenceData.urls.checkinLinks);
    TestCase.assertNotNull(client.referenceData.locations.airports);
    TestCase.assertNotNull(client.referenceData.locations.pointsOfInterest);
    TestCase.assertNotNull(client.referenceData.locations.pointsOfInterest.bySquare);
    TestCase.assertNotNull(client.referenceData.location("123"));
    TestCase.assertNotNull(client.referenceData.airlines);
    TestCase.assertNotNull(client.travel.analytics.airTraffic.traveled);
    TestCase.assertNotNull(client.travel.analytics.airTraffic.booked);
    TestCase.assertNotNull(client.travel.predictions.tripPurpose);
    TestCase.assertNotNull(client.travel.predictions.flightDelay);
    TestCase.assertNotNull(client.shopping.flightDates);
    TestCase.assertNotNull(client.shopping.flightDestinations);
    TestCase.assertNotNull(client.shopping.flightOffers);
    TestCase.assertNotNull(client.shopping.flightOffersSearch);
    TestCase.assertNotNull(client.shopping.flightOffers.prediction);
    TestCase.assertNotNull(client.shopping.hotelOffers);
    TestCase.assertNotNull(client.shopping.hotelOffersByHotel);
    TestCase.assertNotNull(client.shopping.seatMaps);
    TestCase.assertNotNull(client.ereputation.hotelSentiments);
    TestCase.assertNotNull(client.shopping.hotelOffer("XXX"));
    TestCase.assertNotNull(client.airport.predictions.onTime);
    TestCase.assertNotNull(client.booking.flightOrder("XXX"));
    TestCase.assertNotNull(client.media.files.generatedPhotos);
  }

  @Before
  public void setup() {
    client = Mockito.mock(Amadeus.class);
    params = Params.with("airline", "1X");
    body = "{ \"data\": [{}]}";

    // Prepare a plural response
    JsonArray jsonArray = new JsonArray();
    jsonArray.add(new JsonObject());
    jsonArray.add(new JsonObject());
    multiResponse = Mockito.mock(Response.class);
    Mockito.when(multiResponse.isParsed()).thenReturn(true);
    Mockito.when(multiResponse.getData()).thenReturn(jsonArray);

    // Prepare a single response
    jsonObject = new JsonObject();
    jsonObject.addProperty("foo", "bar");
    singleResponse = Mockito.mock(Response.class);
    Mockito.when(singleResponse.isParsed()).thenReturn(true);
    Mockito.when(singleResponse.getData()).thenReturn(jsonObject);
  }

  @Test
  public void testGetMethods() throws ResponseException {
    // Testing CheckinLinks
    Mockito.when(client.get("/v2/reference-data/urls/checkin-links", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v2/reference-data/urls/checkin-links", params))
        .thenReturn(multiResponse);
    CheckinLinks checkinLinks = new CheckinLinks(client);

    TestCase.assertNotNull(checkinLinks.get());
    TestCase.assertNotNull(checkinLinks.get(params));
    TestCase.assertEquals(checkinLinks.get().length, 2);

    // Testing location search
    Mockito.when(client.get("/v1/reference-data/locations", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/reference-data/locations", params))
        .thenReturn(multiResponse);
    Locations locations = new Locations(client);
    TestCase.assertNotNull(locations.get());
    TestCase.assertNotNull(locations.get(params));
    TestCase.assertEquals(locations.get().length, 2);

    // Testing airport search
    Mockito.when(client.get("/v1/reference-data/locations/airports", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/reference-data/locations/airports", params))
        .thenReturn(multiResponse);
    Airports airports = new Airports(client);
    TestCase.assertNotNull(airports.get());
    TestCase.assertNotNull(airports.get(params));
    TestCase.assertEquals(airports.get().length, 2);

    // Testing points of interest
    Mockito.when(client.get("/v1/reference-data/locations/pois", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/reference-data/locations/pois", params))
        .thenReturn(multiResponse);
    PointsOfInterest pois = new PointsOfInterest(client);
    TestCase.assertNotNull(pois.get());
    TestCase.assertNotNull(pois.get(params));
    TestCase.assertEquals(pois.get().length, 2);

    // Testing points of interest by square
    Mockito.when(client.get("/v1/reference-data/locations/pois/by-square", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/reference-data/locations/pois/by-square", params))
        .thenReturn(multiResponse);
    PointsOfInterest poisSquare = new PointsOfInterest(client);
    TestCase.assertNotNull(poisSquare.get());
    TestCase.assertNotNull(poisSquare.get(params));
    TestCase.assertEquals(poisSquare.get().length, 2);

    // Testing fetching a single location
    Mockito.when(client.get("/v1/reference-data/locations/ALHR", null))
        .thenReturn(singleResponse);
    Mockito.when(client.get("/v1/reference-data/locations/ALHR", params))
        .thenReturn(singleResponse);
    Location location = new Location(client, "ALHR");
    TestCase.assertNotNull(location.get());
    TestCase.assertNotNull(location.get(params));

    // Testing airlines search
    Mockito.when(client.get("/v1/reference-data/airlines", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/reference-data/airlines", params))
        .thenReturn(multiResponse);
    Airlines airlines = new Airlines(client);
    TestCase.assertNotNull(airlines.get());
    TestCase.assertNotNull(airlines.get(params));
    TestCase.assertEquals(airlines.get().length, 2);

    // Testing traveled stats
    Mockito.when(client.get("/v1/travel/analytics/air-traffic/traveled", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/travel/analytics/air-traffic/traveled", params))
        .thenReturn(multiResponse);
    Traveled traveled = new Traveled(client);
    TestCase.assertNotNull(traveled.get());
    TestCase.assertNotNull(traveled.get(params));
    TestCase.assertEquals(traveled.get().length, 2);

    // Testing booked stats
    Mockito.when(client.get("/v1/travel/analytics/air-traffic/booked", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/travel/analytics/air-traffic/booked", params))
        .thenReturn(multiResponse);
    Booked booked = new Booked(client);
    TestCase.assertNotNull(booked.get());
    TestCase.assertNotNull(booked.get(params));
    TestCase.assertEquals(booked.get().length, 2);

    // Testing busiest traveling period
    Mockito.when(client.get("/v1/travel/analytics/air-traffic/busiest-period", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/travel/analytics/air-traffic/busiest-period", params))
        .thenReturn(multiResponse);
    BusiestPeriod busiestPeriod = new BusiestPeriod(client);
    TestCase.assertNotNull(busiestPeriod.get());
    TestCase.assertNotNull(busiestPeriod.get(params));
    TestCase.assertEquals(busiestPeriod.get().length, 2);

    // Testing flight date search
    Mockito.when(client.get("/v1/shopping/flight-dates", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/shopping/flight-dates", params))
        .thenReturn(multiResponse);
    FlightDates flightDates = new FlightDates(client);
    TestCase.assertNotNull(flightDates.get());
    TestCase.assertNotNull(flightDates.get(params));
    TestCase.assertEquals(flightDates.get().length, 2);

    // Testing flight destination search
    Mockito.when(client.get("/v1/shopping/flight-destinations", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/shopping/flight-destinations", params))
        .thenReturn(multiResponse);
    FlightDestinations flightDestinations = new FlightDestinations(client);
    TestCase.assertNotNull(flightDestinations.get());
    TestCase.assertNotNull(flightDestinations.get(params));
    TestCase.assertEquals(flightDestinations.get().length, 2);

    // Testing flight offer search
    Mockito.when(client.get("/v1/shopping/flight-offers", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/shopping/flight-offers", params))
        .thenReturn(multiResponse);
    FlightOffers flightOffers = new FlightOffers(client);
    TestCase.assertNotNull(flightOffers.get());
    TestCase.assertNotNull(flightOffers.get(params));
    TestCase.assertEquals(flightOffers.get().length, 2);

    // Testing hotel offer search
    Mockito.when(client.get("/v2/shopping/hotel-offers", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v2/shopping/hotel-offers", params))
        .thenReturn(multiResponse);
    HotelOffers hotelOffers = new HotelOffers(client);
    TestCase.assertNotNull(hotelOffers.get());
    TestCase.assertNotNull(hotelOffers.get(params));
    TestCase.assertEquals(hotelOffers.get().length, 2);

    // Testing hotel offer search for a hotel
    Mockito.when(client.get("/v2/shopping/hotel-offers/by-hotel", null))
        .thenReturn(singleResponse);
    Mockito.when(client.get("/v2/shopping/hotel-offers/by-hotel", params))
        .thenReturn(singleResponse);
    HotelOffersByHotel hotelOffersByHotel = new HotelOffersByHotel(client);
    TestCase.assertNotNull(hotelOffersByHotel.get());
    TestCase.assertNotNull(hotelOffersByHotel.get(params));

    // Test fetching a specific offer
    Mockito.when(client.get("/v2/shopping/hotel-offers/XXX", null))
        .thenReturn(singleResponse);
    Mockito.when(client.get("/v2/shopping/hotel-offers/XXX", params))
        .thenReturn(singleResponse);
    HotelOffer hotelOffer = new HotelOffer(client, "XXX");
    TestCase.assertNotNull(hotelOffer.get());
    TestCase.assertNotNull(hotelOffer.get(params));

    // Test flight offers search get
    Mockito.when(client.get("/v2/shopping/flight-offers", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v2/shopping/flight-offers", params))
        .thenReturn(multiResponse);
    FlightOffersSearch flightOfferSearch = new FlightOffersSearch(client);
    TestCase.assertNotNull(flightOfferSearch.get(params));

    // Test hotel ratings
    Mockito.when(client.get("/v2/e-reputation/hotel-sentiments", null))
            .thenReturn(multiResponse);
    Mockito.when(client.get("/v2/e-reputation/hotel-sentiments", params))
            .thenReturn(multiResponse);
    HotelSentiments hotelSentiments = new HotelSentiments(client);
    TestCase.assertNotNull(hotelSentiments.get(params));

    // Test trip purpose prediction
    Mockito.when(client.get("/v1/travel/predictions/trip-purpose", null))
            .thenReturn(singleResponse);
    Mockito.when(client.get("/v1/travel/predictions/trip-purpose", params))
            .thenReturn(singleResponse);
    TripPurpose tripPurpose = new TripPurpose(client);
    TestCase.assertNotNull(tripPurpose.get(params));
    // Test airport-on-time
    Mockito.when(client.get("/v1/airport/predictions/on-time", null))
            .thenReturn(singleResponse);
    Mockito.when(client.get("/v1/airport/predictions/on-time", params))
            .thenReturn(singleResponse);
    AirportOnTime airportOnTime = new AirportOnTime(client);
    TestCase.assertNotNull(airportOnTime.get());
    TestCase.assertNotNull(airportOnTime.get(params));

    // Test flight delay predictions
    Mockito.when(client.get("/v1/travel/predictions/flight-delay", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/travel/predictions/flight-delay", params))
        .thenReturn(multiResponse);
    FlightDelay flightDelay = new FlightDelay(client);
    TestCase.assertNotNull(flightDelay.get());
    TestCase.assertNotNull(flightDelay.get(params));

    // Test SeatMaps get
    Mockito.when(client.get("/v1/shopping/seatmaps", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/shopping/seatmaps", params))
        .thenReturn(multiResponse);
    SeatMaps seatmap = new SeatMaps(client);
    TestCase.assertNotNull(seatmap.get(params));

    // Test fetching a specific offer
    Mockito.when(client.get("/v1/booking/flight-orders/XXX", null))
        .thenReturn(singleResponse);
    Mockito.when(client.get("/v1/booking/flight-orders/XXX", params))
        .thenReturn(singleResponse);
    FlightOrder flightOrder = new FlightOrder(client, "XXX");
    TestCase.assertNotNull(flightOrder.get());
    TestCase.assertNotNull(flightOrder.get(params));

    // Testing AI-generated photos
    Mockito.when(client.get("/v2/media/files/generated-photos", null))
        .thenReturn(singleResponse);
    Mockito.when(client.get("/v2/media/files/generated-photos", params))
        .thenReturn(singleResponse);
    GeneratedPhotos photo = new GeneratedPhotos(client);
    TestCase.assertNotNull(photo.get());
    TestCase.assertNotNull(photo.get(params));
  }

  @Test
  public void testPostMethods() throws ResponseException {
    // Testing flight choice prediction
    Mockito.when(client.post("/v1/shopping/flight-offers/prediction", (String) null))
        .thenReturn(multiResponse);
    Mockito.when(client.post("/v1/shopping/flight-offers/prediction", body))
        .thenReturn(multiResponse);
    Prediction flightOffersPrediction = new Prediction(client);
    TestCase.assertNotNull(flightOffersPrediction.post());
    TestCase.assertNotNull(flightOffersPrediction.post(body));
    TestCase.assertEquals(flightOffersPrediction.post().length, 2);

    // Test flight offers search post
    Mockito.when(client.post("/v2/shopping/flight-offers", (String) null))
            .thenReturn(multiResponse);
    Mockito.when(client.post("/v2/shopping/flight-offers", body))
            .thenReturn(multiResponse);
    Mockito.when(client.post("/v2/shopping/flight-offers", jsonObject))
            .thenReturn(multiResponse);
    FlightOffersSearch flightOfferSearch = new FlightOffersSearch(client);
    TestCase.assertNotNull(flightOfferSearch.post());
    TestCase.assertNotNull(flightOfferSearch.post(body));
    TestCase.assertEquals(flightOfferSearch.post().length, 2);

    // Test flight create orders
    Mockito.when(client.post("/v1/booking/flight-orders", (String) null))
            .thenReturn(singleResponse);
    Mockito.when(client.post("/v1/booking/flight-orders", body))
            .thenReturn(singleResponse);
    FlightOrders order = new FlightOrders(client);
    TestCase.assertNotNull(order.post());
    TestCase.assertNotNull(order.post(body));

    // Test SeatMaps post
    Mockito.when(client.post("/v1/shopping/seatmaps", (String) null))
            .thenReturn(multiResponse);
    Mockito.when(client.post("/v1/shopping/seatmaps", body))
            .thenReturn(multiResponse);
    Mockito.when(client.post("/v1/shopping/seatmaps", jsonObject))
            .thenReturn(multiResponse);
    SeatMaps seatmap = new SeatMaps(client);
    TestCase.assertNotNull(seatmap.post());
    TestCase.assertNotNull(seatmap.post(body));
  }
}
