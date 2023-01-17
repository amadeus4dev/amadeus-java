package com.amadeus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.amadeus.airline.Destinations;
import com.amadeus.airport.DirectDestinations;
import com.amadeus.airport.predictions.AirportOnTime;
import com.amadeus.analytics.ItineraryPriceMetrics;
import com.amadeus.booking.FlightOrder;
import com.amadeus.booking.FlightOrders;
import com.amadeus.booking.HotelBookings;
import com.amadeus.dutyofcare.diseases.Covid19AreaReport;
import com.amadeus.dutyofcare.diseases.Covid19Report;
import com.amadeus.ereputation.HotelSentiments;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.location.analytics.CategoryRatedAreas;
import com.amadeus.referenceData.Airlines;
import com.amadeus.referenceData.Location;
import com.amadeus.referenceData.Locations;
import com.amadeus.referenceData.RecommendedLocations;
import com.amadeus.referenceData.locations.Airports;
import com.amadeus.referenceData.locations.Cities;
import com.amadeus.referenceData.locations.Hotel;
import com.amadeus.referenceData.locations.PointsOfInterest;
import com.amadeus.referenceData.locations.hotels.ByCity;
import com.amadeus.referenceData.locations.hotels.ByGeocode;
import com.amadeus.referenceData.locations.hotels.ByHotels;
import com.amadeus.referenceData.urls.CheckinLinks;
import com.amadeus.safety.SafetyRatedLocations;
import com.amadeus.schedule.Flights;
import com.amadeus.shopping.Activities;
import com.amadeus.shopping.Activity;
import com.amadeus.shopping.Availability;
import com.amadeus.shopping.FlightDates;
import com.amadeus.shopping.FlightDestinations;
import com.amadeus.shopping.FlightOffers;
import com.amadeus.shopping.FlightOffersSearch;
import com.amadeus.shopping.HotelOffer;
import com.amadeus.shopping.HotelOfferSearch;
import com.amadeus.shopping.HotelOffers;
import com.amadeus.shopping.HotelOffersByHotel;
import com.amadeus.shopping.HotelOffersSearch;
import com.amadeus.shopping.SeatMaps;
import com.amadeus.shopping.availability.FlightAvailabilities;
import com.amadeus.shopping.flightOffers.Prediction;
import com.amadeus.shopping.flightOffers.Pricing;
import com.amadeus.shopping.flightOffers.Upselling;
import com.amadeus.travel.TripParser;
import com.amadeus.travel.analytics.airTraffic.Booked;
import com.amadeus.travel.analytics.airTraffic.BusiestPeriod;
import com.amadeus.travel.analytics.airTraffic.Traveled;
import com.amadeus.travel.predictions.FlightDelay;
import com.amadeus.travel.predictions.TripPurpose;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class NamespaceTest {

  private Amadeus client;
  private Params params;
  private Response singleResponse;
  private Response multiResponse;
  private String body;
  private JsonObject jsonObject;

  /**
   * Namespace Test - All namespaces exist.
   */
  @Test public void testAllNamespacesExist() {
    Amadeus client = Amadeus.builder("id", "secret").build();
    assertNotNull(client.referenceData.urls.checkinLinks);
    assertNotNull(client.referenceData.locations.airports);
    assertNotNull(client.referenceData.locations.pointsOfInterest);
    assertNotNull(client.referenceData.locations.pointsOfInterest.bySquare);
    assertNotNull(client.referenceData.locations.pointOfInterest("XXX"));
    assertNotNull(client.referenceData.location("123"));
    assertNotNull(client.referenceData.recommendedLocations);
    assertNotNull(client.referenceData.airlines);
    assertNotNull(client.travel.analytics.airTraffic.traveled);
    assertNotNull(client.travel.analytics.airTraffic.booked);
    assertNotNull(client.travel.predictions.tripPurpose);
    assertNotNull(client.travel.predictions.flightDelay);
    assertNotNull(client.shopping.activities);
    assertNotNull(client.shopping.activities.bySquare);
    assertNotNull(client.shopping.activity("XXX"));
    assertNotNull(client.shopping.flightDates);
    assertNotNull(client.shopping.flightDestinations);
    assertNotNull(client.shopping.flightOffers);
    assertNotNull(client.shopping.flightOffersSearch);
    assertNotNull(client.shopping.flightOffersSearch.pricing);
    assertNotNull(client.shopping.flightOffers.prediction);
    assertNotNull(client.shopping.flightOffers.upselling);
    assertNotNull(client.shopping.hotelOffers);
    assertNotNull(client.shopping.hotelOffersSearch);
    assertNotNull(client.shopping.hotelOffersByHotel);
    assertNotNull(client.shopping.seatMaps);
    assertNotNull(client.ereputation.hotelSentiments);
    assertNotNull(client.shopping.hotelOffer("XXX"));
    assertNotNull(client.airport.predictions.onTime);
    assertNotNull(client.booking.flightOrder("XXX"));
    assertNotNull(client.booking.hotelBookings);
    assertNotNull(client.safety.safetyRatedLocations);
    assertNotNull(client.safety.safetyRatedLocations.bySquare);
    assertNotNull(client.safety.safetyRatedLocation("XXX"));
    assertNotNull(client.schedule.flights);
    assertNotNull(client.travel.tripParser);
    assertNotNull(client.airport.directDestinations);
    assertNotNull(client.shopping.availability.flightAvailabilities);
    assertNotNull(client.dutyOfCare.diseases);
    assertNotNull(client.dutyOfCare.diseases.covid19AreaReport);
    assertNotNull(client.dutyOfCare.diseases.covid19Report);
    assertNotNull(client.location.analytics);
    assertNotNull(client.location.analytics.categoryRatedAreas);
    assertNotNull(client.referenceData.locations.hotels);
    assertNotNull(client.referenceData.locations.hotels.byHotels);
    assertNotNull(client.referenceData.locations.hotels.byCity);
    assertNotNull(client.referenceData.locations.hotels.byGeocode);
    assertNotNull(client.referenceData.locations.cities);
    assertNotNull(client.airline.destinations);
  }

  /**
   * Namespace Test - For each API.
   */
  @BeforeEach
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
  public void testCheckinLinks() throws ResponseException {
    // Testing Checkin Links
    Mockito.when(client.get("/v2/reference-data/urls/checkin-links", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v2/reference-data/urls/checkin-links", params))
        .thenReturn(multiResponse);
    CheckinLinks checkinLinks = new CheckinLinks(client);
  
    assertNotNull(checkinLinks.get());
    assertNotNull(checkinLinks.get(params));
    assertEquals(checkinLinks.get().length, 2);
  }

  @Test
  public void testLocations() throws ResponseException {
    // Testing Airport City Search
    Mockito.when(client.get("/v1/reference-data/locations", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/reference-data/locations", params))
        .thenReturn(multiResponse);
    Locations locations = new Locations(client);
    assertNotNull(locations.get());
    assertNotNull(locations.get(params));
    assertEquals(locations.get().length, 2);
  }

  @Test
  public void testAirports() throws ResponseException {
    // Testing Airport Nearest Relevant 
    Mockito.when(client.get("/v1/reference-data/locations/airports", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/reference-data/locations/airports", params))
        .thenReturn(multiResponse);
    Airports airports = new Airports(client);
    assertNotNull(airports.get());
    assertNotNull(airports.get(params));
    assertEquals(airports.get().length, 2);
  }

  @Test
  public void testPOIs() throws ResponseException {
    // Testing Points of Interest
    Mockito.when(client.get("/v1/reference-data/locations/pois", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/reference-data/locations/pois", params))
        .thenReturn(multiResponse);
    PointsOfInterest pois = new PointsOfInterest(client);
    assertNotNull(pois.get());
    assertNotNull(pois.get(params));
    assertEquals(pois.get().length, 2);
  }

  @Test
  public void testPOIsBySquare() throws ResponseException {
    // Testing Points of Interest by square
    Mockito.when(client.get("/v1/reference-data/locations/pois", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/reference-data/locations/pois", params))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/reference-data/locations/pois/by-square", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/reference-data/locations/pois/by-square", params))
        .thenReturn(multiResponse);
    PointsOfInterest poisSquare = new PointsOfInterest(client);
    assertNotNull(poisSquare.get());
    assertNotNull(poisSquare.get(params));
    assertEquals(poisSquare.get().length, 2);
  }

  @Test
  public void testPOIsById() throws ResponseException {
    // Testing Points of Interest by Id
    Mockito.when(client.get("/v1/reference-data/locations/pois", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/reference-data/locations/pois", params))
        .thenReturn(multiResponse);   
    Mockito.when(client.get("/v1/reference-data/locations/pois/XXX", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/reference-data/locations/pois/XXX", params))
        .thenReturn(multiResponse);
    PointsOfInterest poi = new PointsOfInterest(client);
    assertNotNull(poi.get());
    assertNotNull(poi.get(params));
    assertEquals(poi.get().length, 2);
  }

  @Test
  public void testRecommendedLocations() throws ResponseException {
    // Testing Travel Recommendations
    Mockito.when(client.get("/v1/reference-data/recommended-locations", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/reference-data/recommended-locations", params))
        .thenReturn(multiResponse);
    RecommendedLocations destinations = new RecommendedLocations(client);
    assertNotNull(destinations.get());
    assertNotNull(destinations.get(params));
    assertEquals(destinations.get().length, 2);
  }

  @Test
  public void testSafetyRatedLocations() throws ResponseException {
    // Testing Safe Place
    Mockito.when(client.get("/v1/safety/safety-rated-locations", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/safety/safety-rated-locations", params))
        .thenReturn(multiResponse);
    SafetyRatedLocations safetyCoords = new SafetyRatedLocations(client);
    assertNotNull(safetyCoords.get());
    assertNotNull(safetyCoords.get(params));
    assertEquals(safetyCoords.get().length, 2);
  }

  @Test
  public void testSafetyRatedLocationsBySquare() throws ResponseException {
    // Testing Safe Place by square
    Mockito.when(client.get("/v1/safety/safety-rated-locations", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/safety/safety-rated-locations", params))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/safety/safety-rated-locations/by-square", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/safety/safety-rated-locations/by-square", params))
        .thenReturn(multiResponse);
    SafetyRatedLocations safetySquare = new SafetyRatedLocations(client);
    assertNotNull(safetySquare.get());
    assertNotNull(safetySquare.get(params));
    assertEquals(safetySquare.get().length, 2);
  }
  
  @Test
  public void testSafetyRatedLocationsById() throws ResponseException {
    // Testing Safe Place by Id  
    Mockito.when(client.get("/v1/safety/safety-rated-locations", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/safety/safety-rated-locations", params))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/safety/safety-rated-locations/XXX", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/safety/safety-rated-locations/XXX", params))
        .thenReturn(multiResponse);
    SafetyRatedLocations safetyById = new SafetyRatedLocations(client);
    assertNotNull(safetyById.get());
    assertNotNull(safetyById.get(params));
    assertEquals(safetyById.get().length, 2);
  }

  @Test
  public void testActivities() throws ResponseException {
    // Testing Tours and Activities
    Mockito.when(client.get("/v1/shopping/activities", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/shopping/activities", params))
        .thenReturn(multiResponse);
    Activities activities = new Activities(client);
    assertNotNull(activities.get());
    assertNotNull(activities.get(params));
    assertEquals(activities.get().length, 2);
  }
  
  @Test
  public void testActivitiesBySquare() throws ResponseException {
    // Testing Tours and Activities by square
    Mockito.when(client.get("/v1/shopping/activities", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/shopping/activities", params))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/shopping/activities/by-square", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/shopping/activities/by-square", params))
        .thenReturn(multiResponse);
    Activities activitiesBySquare = new Activities(client);
    assertNotNull(activitiesBySquare.get());
    assertNotNull(activitiesBySquare.get(params));
    assertEquals(activitiesBySquare.get().length, 2);
  }

  @Test
  public void testActivitiesById() throws ResponseException {
    // Testing Tours and Activities by Id
    Mockito.when(client.get("/v1/shopping/activities", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/shopping/activities", params))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/shopping/activities/XXX", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/shopping/activities/XXX", params))
        .thenReturn(multiResponse);
    Activities activityById = new Activities(client);
    assertNotNull(activityById.get());
    assertNotNull(activityById.get(params));
    assertEquals(activityById.get().length, 2);
  }

  @Test
  public void testLocationsById() throws ResponseException {
    // Testing Airport City Search by Id
    Mockito.when(client.get("/v1/reference-data/locations/ALHR", null))
        .thenReturn(singleResponse);
    Mockito.when(client.get("/v1/reference-data/locations/ALHR", params))
        .thenReturn(singleResponse);
    Location location = new Location(client, "ALHR");
    assertNotNull(location.get());
    assertNotNull(location.get(params));
  }

  @Test
  public void testAirlines() throws ResponseException {
    // Testing Airline Code Lookup
    Mockito.when(client.get("/v1/reference-data/airlines", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/reference-data/airlines", params))
        .thenReturn(multiResponse);
    Airlines airlines = new Airlines(client);
    assertNotNull(airlines.get());
    assertNotNull(airlines.get(params));
    assertEquals(airlines.get().length, 2);
  }

  @Test
  public void testTraveled() throws ResponseException {
    // Testing Flight Most Traveled Destinations
    Mockito.when(client.get("/v1/travel/analytics/air-traffic/traveled", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/travel/analytics/air-traffic/traveled", params))
        .thenReturn(multiResponse);
    Traveled traveled = new Traveled(client);
    assertNotNull(traveled.get());
    assertNotNull(traveled.get(params));
    assertEquals(traveled.get().length, 2);
  }

  @Test
  public void testBooked() throws ResponseException {
    // Testing Flight Most Booked Destinations
    Mockito.when(client.get("/v1/travel/analytics/air-traffic/booked", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/travel/analytics/air-traffic/booked", params))
        .thenReturn(multiResponse);
    Booked booked = new Booked(client);
    assertNotNull(booked.get());
    assertNotNull(booked.get(params));
    assertEquals(booked.get().length, 2);
  }

  @Test
  public void testBusiestPeriod() throws ResponseException {
    // Testing Flight Busiest Period
    Mockito.when(client.get("/v1/travel/analytics/air-traffic/busiest-period", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/travel/analytics/air-traffic/busiest-period", params))
        .thenReturn(multiResponse);
    BusiestPeriod busiestPeriod = new BusiestPeriod(client);
    assertNotNull(busiestPeriod.get());
    assertNotNull(busiestPeriod.get(params));
    assertEquals(busiestPeriod.get().length, 2);
  }

  @Test
  public void testFlightDates() throws ResponseException {
    // Testing Flight Cheapest Date Search
    Mockito.when(client.get("/v1/shopping/flight-dates", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/shopping/flight-dates", params))
        .thenReturn(multiResponse);
    FlightDates flightDates = new FlightDates(client);
    assertNotNull(flightDates.get());
    assertNotNull(flightDates.get(params));
    assertEquals(flightDates.get().length, 2);
  }

  @Test
  public void testFlightDestinations() throws ResponseException {
    // Testing Flight Inspiration Search
    Mockito.when(client.get("/v1/shopping/flight-destinations", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/shopping/flight-destinations", params))
        .thenReturn(multiResponse);
    FlightDestinations flightDestinations = new FlightDestinations(client);
    assertNotNull(flightDestinations.get());
    assertNotNull(flightDestinations.get(params));
    assertEquals(flightDestinations.get().length, 2);
  }

  @Test
  public void testHotelOffers() throws ResponseException {
    // Testing hotel offers v2
    Mockito.when(client.get("/v2/shopping/hotel-offers", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v2/shopping/hotel-offers", params))
        .thenReturn(multiResponse);
    HotelOffers hotelOffers = new HotelOffers(client);
    assertNotNull(hotelOffers.get());
    assertNotNull(hotelOffers.get(params));
    assertEquals(hotelOffers.get().length, 2);
  }

  @Test
  public void testHotelOffersByHotel() throws ResponseException {
    // Testing hotel offer search for a hotel
    Mockito.when(client.get("/v2/shopping/hotel-offers/by-hotel", null))
        .thenReturn(singleResponse);
    Mockito.when(client.get("/v2/shopping/hotel-offers/by-hotel", params))
        .thenReturn(singleResponse);
    HotelOffersByHotel hotelOffersByHotel = new HotelOffersByHotel(client);
    assertNotNull(hotelOffersByHotel.get());
    assertNotNull(hotelOffersByHotel.get(params));
  }

  @Test
  public void testHotelOffersByIdl() throws ResponseException {
    // Test fetching a specific offer
    Mockito.when(client.get("/v2/shopping/hotel-offers/XXX", null))
        .thenReturn(singleResponse);
    Mockito.when(client.get("/v2/shopping/hotel-offers/XXX", params))
        .thenReturn(singleResponse);
    HotelOffer hotelOffer = new HotelOffer(client, "XXX");
    assertNotNull(hotelOffer.get());
    assertNotNull(hotelOffer.get(params));
  }

  @Test
  public void testHotelOffersSearch() throws ResponseException {
    // Testing Hotel Offers Search v3
    Mockito.when(client.get("/v3/shopping/hotel-offers", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v3/shopping/hotel-offers", params))
        .thenReturn(multiResponse);
    HotelOffersSearch hotelOffersSearch = new HotelOffersSearch(client);
    assertNotNull(hotelOffersSearch.get());
    assertNotNull(hotelOffersSearch.get(params));
    assertEquals(hotelOffersSearch.get().length, 2);
  }

  @Test
  public void testFlightOffersSearch() throws ResponseException {
    // Test Flight Offers Search GET
    Mockito.when(client.get("/v2/shopping/flight-offers", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v2/shopping/flight-offers", params))
        .thenReturn(multiResponse);
    FlightOffersSearch flightOfferSearch = new FlightOffersSearch(client);
    assertNotNull(flightOfferSearch.get(params));
  }

  @Test
  public void testHotelSentiments() throws ResponseException {
    // Testing hotel ratings
    Mockito.when(client.get("/v2/e-reputation/hotel-sentiments", null))
            .thenReturn(multiResponse);
    Mockito.when(client.get("/v2/e-reputation/hotel-sentiments", params))
            .thenReturn(multiResponse);
    HotelSentiments hotelSentiments = new HotelSentiments(client);
    assertNotNull(hotelSentiments.get(params));
  }

  @Test
  public void testTripPurpose() throws ResponseException {
    // Testing Trip Purpose Prediction
    Mockito.when(client.get("/v1/travel/predictions/trip-purpose", null))
            .thenReturn(singleResponse);
    Mockito.when(client.get("/v1/travel/predictions/trip-purpose", params))
            .thenReturn(singleResponse);
    TripPurpose tripPurpose = new TripPurpose(client);
    assertNotNull(tripPurpose.get(params));
  }

  @Test
  public void testOnTime() throws ResponseException {
    // Testing Airport On-Time
    Mockito.when(client.get("/v1/airport/predictions/on-time", null))
            .thenReturn(singleResponse);
    Mockito.when(client.get("/v1/airport/predictions/on-time", params))
            .thenReturn(singleResponse);
    AirportOnTime airportOnTime = new AirportOnTime(client);
    assertNotNull(airportOnTime.get());
    assertNotNull(airportOnTime.get(params));
  }

  @Test
  public void testFlightDelay() throws ResponseException {
    // Test Flight Delay Predictions
    Mockito.when(client.get("/v1/travel/predictions/flight-delay", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/travel/predictions/flight-delay", params))
        .thenReturn(multiResponse);
    FlightDelay flightDelay = new FlightDelay(client);
    assertNotNull(flightDelay.get());
    assertNotNull(flightDelay.get(params));
  }

  @Test
  public void testSeatmaps() throws ResponseException {
    // Testing SeatMap Display GET 
    Mockito.when(client.get("/v1/shopping/seatmaps", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/shopping/seatmaps", params))
        .thenReturn(multiResponse);
    SeatMaps seatmap = new SeatMaps(client);
    assertNotNull(seatmap.get(params));
  }

  @Test
  public void testFlightOrdersGet() throws ResponseException {
    // Testing Flight Create Orders
    Mockito.when(client.get("/v1/booking/flight-orders/XXX", null))
        .thenReturn(singleResponse);
    Mockito.when(client.get("/v1/booking/flight-orders/XXX", params))
        .thenReturn(singleResponse);
    FlightOrder flightOrder = new FlightOrder(client, "XXX");
    assertNotNull(flightOrder.get());
    assertNotNull(flightOrder.get(params));
  }

  @Test
  public void testFlights() throws ResponseException {
    // Testingn On Demand Flight Status
    Mockito.when(client.get("/v2/schedule/flights", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v2/schedule/flights", params))
        .thenReturn(multiResponse);
    Flights flightStatus = new Flights(client);
    assertNotNull(flightStatus.get());
    assertNotNull(flightStatus.get(params));
    assertEquals(flightStatus.get().length, 2);
  }

  @Test
  public void testPriceMetrics() throws ResponseException {
    // Testing Flight Price Analysis
    Mockito.when(client.get("/v1/analytics/itinerary-price-metrics", null))
        .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/analytics/itinerary-price-metrics", params))
        .thenReturn(multiResponse);
    ItineraryPriceMetrics metrics = new ItineraryPriceMetrics(client);
    assertNotNull(metrics.get());
    assertNotNull(metrics.get(params));
    assertEquals(metrics.get().length, 2);
  }

  @Test
  public void testDirectDestinations() throws ResponseException {
    // Testing Airport Routes
    Mockito.when(client.get("/v1/airport/direct-destinations", null))
      .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/airport/direct-destinations", params))
      .thenReturn(multiResponse);
    DirectDestinations directDestinations = new DirectDestinations(client);
    assertNotNull(directDestinations.get());
    assertNotNull(directDestinations.get(params));
    assertEquals(directDestinations.get().length, 2);
  }

  @Test
  public void testCovid19AreaReportv1() throws ResponseException {
    // Testing travel restrictions v1
    Mockito.when(client.get("/v1/duty-of-care/diseases/covid19-area-report", null))
      .thenReturn(singleResponse);
    Mockito.when(client.get("/v1/duty-of-care/diseases/covid19-area-report", params))
      .thenReturn(singleResponse);
    Covid19AreaReport covid19AreaReport = new Covid19AreaReport(client);
    assertNotNull(covid19AreaReport.get());
    assertNotNull(covid19AreaReport.get(params));
  }

  @Test
  public void testCovid19AreaReport() throws ResponseException {
    // Testing Travel Restrictions
    Mockito.when(client.get("/v2/duty-of-care/diseases/covid19-area-report", null))
      .thenReturn(singleResponse);
    Mockito.when(client.get("/v2/duty-of-care/diseases/covid19-area-report", params))
      .thenReturn(singleResponse);
    Covid19Report covid19Report = new Covid19Report(client);
    assertNotNull(covid19Report.get());
    assertNotNull(covid19Report.get(params));
  }

  @Test
  public void testCategoryRatedAreas() throws ResponseException {
    // Testing Location Score
    Mockito.when(client.get("/v1/location/analytics/category-rated-areas", null))
      .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/location/analytics/category-rated-areas", params))
      .thenReturn(multiResponse);
    CategoryRatedAreas categoryRatedAreas = new CategoryRatedAreas(client);
    assertNotNull(categoryRatedAreas.get());
    assertNotNull(categoryRatedAreas.get(params));
    assertEquals(categoryRatedAreas.get().length, 2);
  }

  @Test
  public void testByHotels() throws ResponseException {
    // Testing Hotel List by Id
    Mockito.when(client.get("/v1/reference-data/locations/hotels/by-hotels", null))
      .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/reference-data/locations/hotels/by-hotels", params))
      .thenReturn(multiResponse);
    ByHotels hotelsByHotelIds = new ByHotels(client);
    assertNotNull(hotelsByHotelIds.get());
    assertNotNull(hotelsByHotelIds.get(params));
    assertEquals(hotelsByHotelIds.get().length, 2);
  }

  @Test
  public void testByCity() throws ResponseException {
    // Testing Hotel list by city
    Mockito.when(client.get("/v1/reference-data/locations/hotels/by-city", null))
      .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/reference-data/locations/hotels/by-city", params))
      .thenReturn(multiResponse);
    ByCity hotelsByCity = new ByCity(client);
    assertNotNull(hotelsByCity.get());
    assertNotNull(hotelsByCity.get(params));
    assertEquals(hotelsByCity.get().length, 2);
  }

  @Test
  public void testByGeocode() throws ResponseException {
    // Testing Hotel List by geocode
    Mockito.when(client.get("/v1/reference-data/locations/hotels/by-geocode", null))
      .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/reference-data/locations/hotels/by-geocode", params))
      .thenReturn(multiResponse);
    ByGeocode hotelsByGeocode = new ByGeocode(client);
    assertNotNull(hotelsByGeocode.get());
    assertNotNull(hotelsByGeocode.get(params));
    assertEquals(hotelsByGeocode.get().length, 2);
  }

  @Test
  public void testHotel() throws ResponseException {
    // Testing Hotel Autocomplete
    Hotel hotel = new Hotel(client);
    Mockito.when(client.get("/v1/reference-data/locations/hotel", params))
      .thenReturn(multiResponse);
    assertNotNull(hotel.get(params));
  }

  @Test
  public void testCities() throws ResponseException {
    // Testing City Search
    Mockito.when(client.get("/v1/reference-data/locations/cities", null))
      .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/reference-data/locations/cities", params))
      .thenReturn(multiResponse);
    Cities cities = new Cities(client);
    assertNotNull(cities.get());
    assertNotNull(cities.get(params));
    assertEquals(cities.get().length, 2);
  }

  @Test
  public void testDestinations() throws ResponseException {
    // Testing Airline Routes
    Mockito.when(client.get("/v1/airline/destinations", null))
      .thenReturn(multiResponse);
    Mockito.when(client.get("/v1/airline/destinations", params))
      .thenReturn(multiResponse);
    Destinations airlineDestinations = new Destinations(client);
    assertNotNull(airlineDestinations.get());
    assertNotNull(airlineDestinations.get(params));
    assertEquals(airlineDestinations.get().length, 2);
  }

  @Test
  public void testPrediction() throws ResponseException {
    // Testing Flight Choice Prediction
    Mockito.when(client.post("/v2/shopping/flight-offers/prediction", (String) null))
        .thenReturn(multiResponse);
    Mockito.when(client.post("/v2/shopping/flight-offers/prediction", body))
        .thenReturn(multiResponse);
    Prediction flightOffersPrediction = new Prediction(client);
    assertNotNull(flightOffersPrediction.post());
    assertNotNull(flightOffersPrediction.post(body));
    assertEquals(flightOffersPrediction.post().length, 2);
  }

  @Test
  public void testFlightOffers() throws ResponseException {
    // Testing Flight Offers Search POST
    Mockito.when(client.post("/v2/shopping/flight-offers", (String) null))
            .thenReturn(multiResponse);
    Mockito.when(client.post("/v2/shopping/flight-offers", body))
            .thenReturn(multiResponse);
    Mockito.when(client.post("/v2/shopping/flight-offers", jsonObject))
            .thenReturn(multiResponse);
    FlightOffersSearch flightOfferSearch = new FlightOffersSearch(client);
    assertNotNull(flightOfferSearch.post());
    assertNotNull(flightOfferSearch.post(body));
    assertEquals(flightOfferSearch.post().length, 2);
  }

  @Test
  public void testPricing() throws ResponseException {
    // Testing Flight Offers Price
    Mockito.when(client.post("/v1/shopping/flight-offers/pricing", (String) null))
            .thenReturn(singleResponse);
    Mockito.when(client.post("/v1/shopping/flight-offers/pricing", body))
            .thenReturn(singleResponse);
    Mockito.when(client.post("/v1/shopping/flight-offers/pricing", params, jsonObject))
            .thenReturn(singleResponse);
    Pricing pricing = new Pricing(client);
    assertNotNull(pricing.post());
    assertNotNull(pricing.post(body));
  }

  @Test
  public void testFlightOrders() throws ResponseException {
    // Testing Flight Create Orders
    Mockito.when(client.post("/v1/booking/flight-orders", (String) null))
            .thenReturn(singleResponse);
    Mockito.when(client.post("/v1/booking/flight-orders", body))
            .thenReturn(singleResponse);
    FlightOrders order = new FlightOrders(client);
    assertNotNull(order.post());
    assertNotNull(order.post(body));
  }

  @Test
  public void testSeatmapsPost() throws ResponseException {
    // Testing SeatMap Display POST
    Mockito.when(client.post("/v1/shopping/seatmaps", (String) null))
            .thenReturn(multiResponse);
    Mockito.when(client.post("/v1/shopping/seatmaps", body))
            .thenReturn(multiResponse);
    Mockito.when(client.post("/v1/shopping/seatmaps", jsonObject))
            .thenReturn(multiResponse);
    SeatMaps seatmap = new SeatMaps(client);
    assertNotNull(seatmap.post());
    assertNotNull(seatmap.post(body));
  }

  @Test
  public void testHotelBookings() throws ResponseException {
    // Test Hotel Booking POST
    Mockito.when(client.post("/v1/booking/hotel-bookings", (String) null))
            .thenReturn(multiResponse);
    Mockito.when(client.post("/v1/booking/hotel-bookings", body))
            .thenReturn(multiResponse);
    Mockito.when(client.post("/v1/booking/hotel-bookings", jsonObject))
            .thenReturn(multiResponse);
    HotelBookings hotel = new HotelBookings(client);
    assertNotNull(hotel.post());
    assertNotNull(hotel.post(body));
  }

  @Test
  public void testTripParser() throws ResponseException {
    // Test Trip Parser
    Mockito.when(client.post("/v3/travel/trip-parser", (String) null))
            .thenReturn(singleResponse);
    Mockito.when(client.post("/v3/travel/trip-parser", body))
            .thenReturn(singleResponse);
    Mockito.when(client.post("/v3/travel/trip-parser", jsonObject))
            .thenReturn(singleResponse);
    TripParser tripParser = new TripParser(client);
    assertNotNull(tripParser.post());
    assertNotNull(tripParser.post(body));
  }

  @Test
  public void testFlightAvailabilities() throws ResponseException {
    // Testing Flight Availabilities Search
    Mockito.when(client.post("/v1/shopping/availability/flight-availabilities", (String) null))
      .thenReturn(multiResponse);
    Mockito.when(client.post("/v1/shopping/availability/flight-availabilities", body))
      .thenReturn(multiResponse);
    Mockito.when(client.post("/v1/shopping/availability/flight-availabilities", jsonObject))
      .thenReturn(multiResponse);
    FlightAvailabilities flightAvailabilities = new FlightAvailabilities(client);
    assertNotNull(flightAvailabilities.post());
    assertNotNull(flightAvailabilities.post(body));
    assertEquals(flightAvailabilities.post().length, 2);
  }

  @Test
  public void testUpselling() throws ResponseException {
    // Testing Branded Fares Upsell
    Mockito.when(client.post("/v1/shopping/flight-offers/upselling", (String) null))
      .thenReturn(multiResponse);
    Mockito.when(client.post("/v1/shopping/flight-offers/upselling", body))
      .thenReturn(multiResponse);
    Upselling upsellFlightOffers = new Upselling(client);
    assertNotNull(upsellFlightOffers.post());
    assertNotNull(upsellFlightOffers.post(body));
    assertEquals(upsellFlightOffers.post().length, 2);
  }

  @Test
  public void testFlightOrdersbyId() throws ResponseException {
    // Testing Flight Order Management DELETE
    Mockito.when(client.delete("/v1/booking/flight-orders/XXX", null))
        .thenReturn(singleResponse);
    Mockito.when(client.delete("/v1/booking/flight-orders/XXX", params))
        .thenReturn(singleResponse);
    FlightOrder flightOrder = new FlightOrder(client, "XXX");
    assertNotNull(flightOrder.delete());
    assertNotNull(flightOrder.delete(params));

  }

}
