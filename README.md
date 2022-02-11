# Amadeus Java SDK

[![Build](https://github.com/amadeus4dev/amadeus-java/actions/workflows/build_gradle.yml/badge.svg?branch=master)](https://github.com/amadeus4dev/amadeus-java/actions/workflows/build_gradle.yml)
[![Discord](https://img.shields.io/discord/696822960023011329?label=&logo=discord&logoColor=ffffff&color=7389D8&labelColor=6A7EC2)](https://discord.gg/cVrFBqx)

Amadeus provides a rich set of APIs for the travel industry. For more details, check out the [Amadeus for Developers Portal](https://developers.amadeus.com) or the [SDK class reference](https://amadeus4dev.github.io/amadeus-java/).

## Installation

This library requires Java 1.7+ and the [Gson library](https://github.com/google/gson). You can install the SDK via Maven or Gradle:

#### Maven
```xml
<dependency>
  <groupId>com.amadeus</groupId>
  <artifactId>amadeus-java</artifactId>
  <version>5.8.2</version>
</dependency>
```
#### Gradle
```js
compile "com.amadeus:amadeus-java:5.8.2"
```

## Getting Started

To make your first API call, you will need to [register](https://developers.amadeus.com/register) for an Amadeus Developer Account and [set up your first application](https://developers.amadeus.com/my-apps).

```java
import com.amadeus.Amadeus;
import com.amadeus.Params;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.referenceData.Locations;
import com.amadeus.resources.Location;

public class AmadeusExample {
  public static void main(String[] args) throws ResponseException {
    Amadeus amadeus = Amadeus
            .builder("REPLACE_BY_YOUR_API_KEY", "REPLACE_BY_YOUR_API_SECRET")
            .build();

    Location[] locations = amadeus.referenceData.locations.get(Params
      .with("keyword", "LON")
      .and("subType", Locations.ANY));

    System.out.println(locations);
  }
}
```

Examples
--------------------------
You can find all the endpoints in self-contained [code examples](https://github.com/amadeus4dev/amadeus-code-examples).
## Initialization

The client can be initialized directly:

```java
//Initialize using parameters
Amadeus amadeus = Amadeus
        .builder("REPLACE_BY_YOUR_API_KEY", "REPLACE_BY_YOUR_API_SECRET")
        .build();
```

Alternatively, it can be initialized without any parameters if the environment variables `AMADEUS_CLIENT_ID` and `AMADEUS_CLIENT_SECRET` are present.

```java
Amadeus amadeus = Amadeus
        .builder(System.getenv())
        .build();
```

Your credentials can be found on the [Amadeus dashboard](https://developers.amadeus.com/my-apps).

By default the SDK is set to `test` environment. To switch to a `production` (pay-as-you-go) environment, please switch the hostname as follows:

```java
Amadeus amadeus = Amadeus
        .builder(System.getenv())
        .setHostname("production")
        .build();
```

## Documentation

Amadeus has a large set of APIs, and our documentation is here to get you started. Head over to our [reference documentation](https://amadeus4dev.github.io/amadeus-java/) for in-depth information about every SDK method, its arguments and return types.

## Making API calls

This library conveniently maps every API path to a similar path. For example, `GET /v2/reference-data/urls/checkin-links?airlineCode=BA` would be:

```java
amadeus.referenceData.urls.checkinLinks.get(Params.with("airlineCode", "BA"));
```

Similarly, to select a resource by ID, you can pass in the ID to the **singular** path. For example,  `GET /v2/shopping/hotel-offers/XXX` would be:

```java
amadeus.shopping.hotelOffer("XXX").get(...);
```

You can make any arbitrary API call as well directly with the `.get` method.
Keep in mind, this returns a raw `Resource`.

```java
Response response = amadeus.get("/v2/reference-data/urls/checkin-links", Params.with("airlineCode", "BA"));

response.getResult();
```

Or, with POST method:

```java
Response response = amadeus.post("/v1/shopping/availability/flight-availabilities", body);
```

## Response

Every successful API call returns a `Resource` object. The `Resource` object has the raw response body (in string format) available:

```java
Location[] locations = amadeus.referenceData.locations.get(Params
  .with("keyword", "LON")
  .and("subType", Locations.ANY));

 // The raw response, as a string
locations[0].getResponse().getBody();
```

## Pagination

If an API endpoint supports pagination, the other pages are available under the
`.next`, `.previous`, `.last` and `.first` methods.

```java
Location[] locations = amadeus.referenceData.locations.get(Params
  .with("keyword", "LON")
  .and("subType", Locations.ANY));

// Fetches the next page
Location[] locations = (Location[]) amadeus.next(locations[0]);
```

If a page is not available, the method will return `null`.

## Logging & Debugging

The SDK makes it easy to add your own logger.

```java
import java.util.logging.Logger;

// Assumes the current class is called MyLogger
private final static Logger LOGGER = Logger.getLogger(MyLogger.class.getName());

...

Amadeus amadeus = Amadeus
        .builder("REPLACE_BY_YOUR_API_KEY", "REPLACE_BY_YOUR_API_SECRET")
        .setLogger(LOGGER)
        .build();
)
```

Additionally, to enable more verbose logging, you can set the appropriate level on your own logger. The easiest way would be to enable debugging via a parameter during initialization, or using the `AMADEUS_LOG_LEVEL` environment variable.

```java
Amadeus amadeus = Amadeus
        .builder("REPLACE_BY_YOUR_API_KEY", "REPLACE_BY_YOUR_API_SECRET")
        .setLogLevel("debug") // or warn
        .build();
```

## List of supported endpoints
```java
// Flight Inspiration Search
FlightDestination[] flightDestinations = amadeus.shopping.flightDestinations.get(Params
  .with("origin", "MAD"));

// Flight Cheapest Date Search
FlightDate[] flightDates = amadeus.shopping.flightDates.get(Params
  .with("origin", "MAD")
  .and("destination", "MUC"));

// Flight Offers Search v2 GET
FlightOfferSearch[] flightOffersSearches = amadeus.shopping.flightOffersSearch.get(
              Params.with("originLocationCode", "SYD")
                      .and("destinationLocationCode", "BKK")
                      .and("departureDate", "2022-09-01")
                      .and("returnDate", "2022-09-08")
                      .and("adults", 2)
                      .and("max", 3));

// Flight Offers Search v2 POST
// body can be a String version of your JSON or a JsonObject
FlightOfferSearch[] flightOffersSearches = amadeus.shopping.flightOffersSearch.post(body);

// Flight Order Management
// The flightOrderID comes from the Flight Create Orders (in test environment it's temporary)
// Retrieve a flight order
FlightOrder order = amadeus.booking.flightOrder("eJzTd9f3NjIJdzUGAAp%2fAiY=").get();
// Cancel a flight order
Response order = amadeus.booking.flightOrder("eJzTd9f3NjIJdzUGAAp%2fAiY=").delete();

// Flight Offers price
FlightPrice[] flightPricing = amadeus.shopping.flightOffersSearch.pricing.post(
                    body,
                    Params.with("include", "other-services")
                          .and("forceClass", "false"));

// Flight Choice Prediction
// Note that the example calls 2 APIs: Flight Offers Search & Flight Choice Prediction
FlightOfferSearch[] flightOffers = amadeus.shopping.flightOffersSearch.get(
              Params.with("originLocationCode", "NYC")
                      .and("destinationLocationCode", "MAD")
                      .and("departureDate", "2021-04-01")
                      .and("returnDate", "2021-04-08")
                      .and("adults", 1));

// Using a JSonObject
JsonObject result = flightOffers[0].getResponse().getResult();
FlightOfferSearch[] flightOffersPrediction = amadeus.shopping.flightOffers.prediction.post(result);

// Using a String
String body = flightOffers[0].getResponse().getBody();
FlightOfferSearch[] flightOffersPrediction = amadeus.shopping.flightOffers.prediction.post(body);

// Flight Check-in Links
CheckinLink[] checkinLinks = amadeus.referenceData.urls.checkinLinks.get(Params
  .with("airlineCode", "BA"));

// Airline Code LookUp
Airline[] airlines = amadeus.referenceData.airlines.get(Params
  .with("airlineCodes", "BA"));

// Airport & City Search (autocomplete)
// Find all the cities and airports starting by the keyword 'LON'
Location[] locations = amadeus.referenceData.locations.get(Params
  .with("keyword", "LON")
  .and("subType", Locations.ANY));
// Get a specific city or airport based on its id
Location location = amadeus.referenceData
  .location("ALHR").get();

// Airport Nearest Relevant (for London)
Location[] locations = amadeus.referenceData.locations.airports.get(Params
  .with("latitude", 0.1278)
  .and("longitude", 51.5074));

// Flight Most Booked Destinations
AirTraffic[] airTraffics = amadeus.travel.analytics.airTraffic.booked.get(Params
  .with("originCityCode", "MAD")
  .and("period", "2017-08"));

// Flight Most Traveled Destinations
AirTraffic[] airTraffics = amadeus.travel.analytics.airTraffic.traveled.get(Params
  .with("originCityCode", "MAD")
  .and("period", "2017-01"));

// Flight Busiest Traveling Period
Period[] busiestPeriods = amadeus.travel.analytics.airTraffic.busiestPeriod.get(Params
  .with("cityCode", "MAD")
  .and("period", "2017")
  .and("direction", BusiestPeriod.ARRIVING));

// Hotel Search API
// Get list of hotels by city code
HotelOffer[] offers = amadeus.shopping.hotelOffers.get(Params
  .with("cityCode", "MAD"));
// Get list of offers for a specific hotel
HotelOffer hotelOffer = amadeus.shopping.hotelOffersByHotel.get(Params.with("hotelId", "BGLONBGB"));
// Confirm the availability of a specific offer
HotelOffer offer = amadeus.shopping.hotelOffer("4BA070CE929E135B3268A9F2D0C51E9D4A6CF318BA10485322FA2C7E78C7852E").get();

// Hotel Booking
// The body can be a String version of your JSON or a JsonObject
HotelBooking[] hotel = amadeus.booking.hotelBookings.post(body);

// Hotel Ratings / Sentiments
HotelSentiment[] hotelSentiments = amadeus.ereputation.hotelSentiments.get(Params.with("hotelIds", "ELONMFS,ADNYCCTB"));

// Points of Interest
// What are the popular places in Barcelona (based a geo location and a radius)
PointOfInterest[] pointsOfInterest = amadeus.referenceData.locations.pointsOfInterest.get(Params
   .with("latitude", "41.39715")
   .and("longitude", "2.160873"));

// What are the popular places in Barcelona? (based on a square)
PointOfInterest[] pointsOfInterest = amadeus.referenceData.locations.pointsOfInterest.bySquare.get(Params
    .with("north", "41.397158")
    .and("west", "2.160873")
    .and("south", "41.394582")
    .and("east", "2.177181"));

// Returns a single Point of Interest from a given id
PointOfInterest pointOfInterest = amadeus.referenceData.locations.pointOfInterest("9CB40CB5D0").get();

// Safe Place
// How safe is Barcelona? (based a geo location and a radius)
SafePlace[] safetyScore = amadeus.safety.safetyRatedLocations.get(Params
      .with("latitude", "41.39715")
      .and("longitude", "2.160873"));

// How safe is Barcelona? (based on a square)
SafePlace[] safetyScore = amadeus.safety.safetyRatedLocations.bySquare.get(Params
    .with("north", "41.397158")
    .and("west", "2.160873")
    .and("south", "41.394582")
    .and("east", "2.177181"));

// What is the safety information of a location based on it's Id?
SafePlace safetyScore = amadeus.safety.safetyRatedLocation("Q930400801").get();

// Tours and Activities
// What are the popular activities in Barcelona (based a geo location and a radius)
Activity[] activities = amadeus.shopping.activities.get(Params
   .with("latitude", "41.39715")
   .and("longitude", "2.160873"));

// What are the popular activities in Barcelona? (based on a square)
Activity[] activities = amadeus.shopping.activities.bySquare.get(Params
    .with("north", "41.397158")
    .and("west", "2.160873")
    .and("south", "41.394582")
    .and("east", "2.177181"));

// Returns a single activity from a given id
Activity activity = amadeus.shopping.activity("4615").get();

// What's the likelihood flights from this airport will leave on time?
Prediction AirportOnTime = amadeus.airport.predictions.onTime.get(Params
    .with("airportCode", "NCE")
    .and("date", "2021-04-01"));

// What's the likelihood of a given flight to be delayed?
Prediction[] flightDelay = amadeus.travel.predictions.flightDelay.get(Params
    .with("originLocationCode", "NCE")
    .and("destinationLocationCode", "IST")
    .and("departureDate", "2020-08-01")
    .and("departureTime", "18:20:00")
    .and("arrivalDate", "2020-08-01")
    .and("arrivalTime", "22:15:00")
    .and("aircraftCode", "321")
    .and("carrierCode", "TK")
    .and("flightNumber", "1816")
    .and("duration", "PT31H10M"));

// Flight Create Orders to book a flight
// Using a JSonObject or String
FlightOrder createdOrder = amadeus.booking.flightOrders.post(body);

// Using a JsonObject for flight offer and Traveler[] as traveler information
// see example at src/main/java/examples/flight/createorders/FlightCreateOrders.java
FlightOrder createdOrder = amadeus.booking.flightOrders.post(flightOffersSearches, travelerArray);

// What is the the seat map of a given flight?
SeatMap[] seatmap = amadeus.shopping.seatMaps.get(Params
    .with("flight-orderId", "eJzTd9f3NjIJdzUGAAp%2fAiY="));

// What is the the seat map of a given flight?
// The body can be a String version of your JSON or a JsonObject
SeatMap[] seatmap = amadeus.shopping.seatMaps.post(body);

// AI-Generated Photos
GeneratedPhoto photo = amadeus.media.files.generatedPhotos.get(Params
    .with("category", "BEACH"));

// Trip Purpose Prediction
Prediction tripPurpose = amadeus.travel.predictions.tripPurpose.get(Params
    .with("originLocationCode", "NYC")
    .and("destinationLocationCode", "MAD")
    .and("departureDate", "2021-04-01")
    .and("returnDate", "2021-04-08"));

// Travel Recommendations
Location destinations = amadeus.referenceData.recommendedLocations.get(Params
    .with("cityCodes", "PAR")
    .and("travelerCountryCode", "FR"));

// On Demand Flight Status
DatedFlight[] flightStatus = amadeus.schedule.flights.get(Params
    .with("carrierCode", "AZ")
    .and("flightNumber", "319")
    .and("scheduledDepartureDate", "2021-03-13"));

// Flight Price Analysis
ItineraryPriceMetric[] metrics = amadeus.analytics.itineraryPriceMetrics.get(Params
    .with("originIataCode", "MAD")
    .and("destinationIataCode", "CDG")
    .and("departureDate", "2021-03-21"));

// Trip Parser v3 POST
// body can be a String version of your JSON or a JsonObject or a compatible File object
TripDetail tripDetail = amadeus.travel.tripParser.post(body);

// Airport Routes
Destination[] directDestinations = amadeus.airport.directDestinations.get(Params
    .with("departureAirportCode","MAD")
    .and("max","2"));
```

## Development & Contributing

Want to contribute? Read our [Contributors Guide](.github/CONTRIBUTING.md) for
guidance on installing and running this code in a development environment.


## License

This library is released under the [MIT License](LICENSE).

## Help

You can find us on [StackOverflow](https://stackoverflow.com/questions/tagged/amadeus) or join our developer community on
[Discord](https://discord.gg/cVrFBqx).
