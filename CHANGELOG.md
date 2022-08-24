# Changelog

6.3.0 - 2022-08-23
--------------------
Add support for the [Travel Restrictions v2](https://developers.amadeus.com/self-service/category/covid-19-and-travel-safety/api-doc/travel-restrictions/api-reference)

Add support for JDK 8 and 11, Big thanks to [Steve Donovan](https://github.com/steve-donovan) for his contribution! :clap:

Update Traveler resource model, Big thanks to [Steve Donovan](https://github.com/steve-donovan) for his contribution! :clap:

Add [SonarCloud](https://sonarcloud.io/summary/overall?id=amadeus4dev_amadeus-java) in GitHub Action

6.2.1 - 2022-07-22
--------------------
Removed unnecessary toString() on a String. Big thanks to [Steve Donovan](https://github.com/steve-donovan) for his contribution! :clap:

Fixed property type name in the FlightOffersSearch resource

6.2.0 - 2022-07-18
--------------------
Add support for the [Airline Routes API](https://developers.amadeus.com/self-service/category/air/api-doc/airline-routes/api-reference). Big thanks to [Siddhartha Dutta](https://github.com/siddydutta) for his contribution! :clap:

Add support for the [Hotel Name Autocomplete API](https://developers.amadeus.com/self-service/category/hotel/api-doc/hotel-name-autocomplete/api-reference)

Add support for the [City Search API](https://developers.amadeus.com/self-service/category/trip/api-doc/city-search/api-reference)

Bug fix in the DatedFlight.Timing resource. Big thanks to [Frank Koornstra](https://github.com/frankkoornstra) for his contribution! :clap:

Add email to the HotelOffer.HotelContact resource

Update GSON dependency

6.1.0 - 2022-05-23
--------------------
Add support for the [Hotel Search API v3](https://developers.amadeus.com/self-service/category/hotel/api-doc/hotel-search/api-reference)

6.0.0 - 2022-05-19
--------------------
Add support for the [Hotel List API](https://developers.amadeus.com/self-service/category/hotel/api-doc/hotel-list/api-reference)

Add support for the [Branded Fares Upsell API](https://developers.amadeus.com/self-service/category/air/api-doc/branded-fares-upsell/api-reference)


Add usbType to the SeatMap resource

Improve Test Coverage until 75%

Remove the AI-Generated Photos API

Bug fix in the generating Javadocs

Add support for APIs that need X-HTTP-Method-Override Header

5.9.0 - 2022-03-17
--------------------
Add support for the [Flight Availablities Search API](https://developers.amadeus.com/self-service/category/air/api-doc/flight-availabilities-search/api-reference)

Add support for the [Travel Restrictions API](https://developers.amadeus.com/self-service/category/covid-19-and-travel-safety/api-doc/travel-restrictions/api-reference)

Add support for the [Location Score API](https://developers.amadeus.com/self-service/category/destination-content/api-doc/location-score/api-reference)

Add support for the [Airport Routes API](https://developers.amadeus.com/self-service/category/air/api-doc/airport-routes/api-reference)

5.8.2 - 2021-12-01
--------------------
Bug fix in the Traveler resource

5.8.1 - 2021-11-18
--------------------
Bug fix in the FlightOffersSearch resource

5.8.0 - 2021-10-20
--------------------
Add support for the [Trip Parser API](https://developers.amadeus.com/self-service/category/trip/api-doc/trip-parser/api-reference). Big thanks to [Siddhartha Dutta](https://github.com/siddydutta) for his contribution! :clap:

Bug fix in the DatedFlight resource

5.7.3 - 2021-10-08
--------------------
Update gradle version and creation of automated releasing with Gradle plugin.

5.7.2 - 2021-04-27
--------------------
Fix unwanted exception in description of an error. Big thanks to [João Cana Verde](https://github.com/JPCanaverde) for his contribution! :clap:

5.7.1 - 2021-03-09
--------------------
Add media and available seats counter to the SeatMap resource

5.6.1 - 2021-02-08
--------------------
Fix unwanted exception on `DELETE` method of Flight Order Management API

5.6.0 - 2020-11-10
--------------------
Add support for the [Flight Price Analysis API](https://developers.amadeus.com/self-service/category/air/api-doc/flight-price-analysis/api-reference)

5.5.0 - 2020-10-13
--------------------
Add support for the [Tours and Activities API](https://developers.amadeus.com/self-service/category/destination-content/api-doc/tours-and-activities/api-reference)

5.4.1 - 2020-09-11
--------------------
Add support for the [On-Demand Flight Status API](https://developers.amadeus.com/self-service/category/air/api-doc/on-demand-flight-status/api-reference)

## 5.3.1-2020-08-20
[Bug](https://github.com/amadeus4dev/amadeus-java/issues/85) fix in SafePlace resource which didn't return the safetyScores - reported by [jvence](https://github.com/jvence), thank you very much!

## 5.3.0-2020-08-06
Add support for the [Travel Recommendations API](https://developers.amadeus.com/self-service/category/trip/api-doc/travel-recommendations)

Moved the code examples directory to a dedicated [code examples repository](https://github.com/amadeus4dev/amadeus-code-examples)

## 5.2.0-2020-06-11
Add AircraftCabinAmenities to the SeatMap resource

## 5.1.0-2020-06-11
Add support for the [Safe Place API](https://developers.amadeus.com/self-service/category/destination-content/api-doc/safe-place-api)

## 5.0.0-2020-04-27
Add support for the [Flight Choice Prediction v2](https://developers.amadeus.com/self-service/category/air/api-doc/flight-choice-prediction)

The input of Flight Choice Prediction v2 is the result of Flight Offers Search API - in v1 the input was the result of Flight Low-Fare Search

Add choiceProbability to FlightOfferSearch resource

Remove support for Flight Low-Fare Search: decommission on May 28, 2020 and mandatory migration to Flight Offers Search

Remove support for Flight Choice Prediction v1

## 4.1.0-2020-04-15
Bug fix - Fix helpers for Flight Create Orders
Add new helper methods to ease the use of Flight Booking APIs

## 4.0.1-2020-04-06
Bug fix - Updated AssociatedRecords to Array in HotelBooking.java

## 4.0.0-2020-03-24

Big thanks to [Spiros Batziopoulos](https://github.com/SealSoft) for his contribution to the Flight Offers Price! :clap:

Add support for the [Flight Offers Price API](https://developers.amadeus.com/self-service/category/air/api-doc/flight-offers-price)

> The Flight Offers Price API confirms the flight price (including taxes and fees) and availability for a given flight returned by the Flight Offers Search API. The API also returns pricing for ancillary products (additional bags, extra legroom, etc.) and the payment information details needed for booking.

Add support for the [Flight Create Orders API](https://developers.amadeus.com/self-service/category/air/api-doc/flight-create-orders)

> The Flight Create Orders API is a flight booking API that lets you perform the final booking for a desired flight and ancillary products (additional bags, extra legroom, etc.). The API returns a unique ID for the flight order and reservation details. This API is used to perform the final booking on confirmed fares returned by the Flight Offers Price API.

Add support for the [Flight Order Management API](https://developers.amadeus.com/self-service/category/air/api-doc/flight-order-management)

> The Flight Order Management API lets you consult bookings created through the Flight Create Orders API. Using the booking ID generated by Flight Create Orders, Flight Order Management returns the last-updated version of the booking record with any post-booking modifications including but not limited to ticket information, form of payment or other remarks.

Add support for the [Trip Purpose Prediction API](https://developers.amadeus.com/self-service/category/trip/api-doc/trip-purpose-prediction)

> The Trip Purpose Prediction API returns the probability of whether a round-trip flight itinerary is for business or leisure travel. The API takes flight dates, departure city and arrival city and then applies a machine-learning model trained with Amadeus historical data to determine the probability that the itinerary is for business or leisure travel. This API is useful for gaining insight and optimizing the search and shopping experience.

Add support for the [Hotel Booking API](https://developers.amadeus.com/self-service/category/hotel/api-doc/hotel-booking)

> The Amadeus Hotel Booking API lets you complete bookings at over 150,000 hotels and accommodations around the world. To complete bookings, you must first use the Amadeus Hotel Search API to search for hotel deals, select the desired offer and confirm the final price and availability. You can then use the Hotel Booking API to complete the reservation by providing an offer id, guest information and payment information.

Add support for the AI-Generated Photos API
> The AI-Generated Photos API returns a link to download a rendered image of a landscape. The image size is 512x512 pixels and the currently available image categories are BEACH and MOUNTAIN. The link to download the AI-generated picture is valid for 24 hours. This API is an experimental project created by the Amadeus AI Lab using the Nvidia StyleGAN framework. This API is free to use and we welcome any feedback you may have about improvements.

Add support for the [SeatMap Display API](https://developers.amadeus.com/self-service/category/air/api-doc/seatmap-display)

> SeatMap Display API allows you to get information to display airplane cabin plan from a Flight Offer in order for the traveler to be able to choose his seat during the flight booking flow thanks to POST method. In addition GET method allows you to display airplane cabin plan from an existing Flight Order.

Remove support for Most Searched Destinations

Add support for Points of Interest Retrieve endpoint

Add support for the [Airport on Time API](https://developers.amadeus.com/self-service/category/air/api-doc/airport-on-time-performance)

> The Airport On-Time Performance API returns the estimated percentage of on-time flight departures for a given airport and date. The API receives the 3-letter IATA airport code and departure date and applies a machine-learning model trained with Amadeus historical data to estimate the overall airport on-time performance. This API is in currently in beta and only returns accurate data for airports located in the U.S.

Add support for the [Flight Delay Prediction API](https://developers.amadeus.com/self-service/category/air/api-doc/flight-delay-prediction)

> The Flight Delay Prediction API returns the probability that a given flight will be delayed by four possible delay lengths: less than 30 minutes, 30-60 minutes, 60-120 minutes and over 120 minutes/cancellation. The API receives flight information and applies a machine-learning model trained with Amadeus historical data to determine the probability of flight delay.

##3.3.0-2019-10-18
Big thanks to [Spiros Batziopoulos](https://github.com/SealSoft) for his contributions! The 2 APIs below were added to the SDK by him! :clap:


Add support for the [Hotel Ratings API](https://developers.amadeus.com/self-service/category/hotel/api-doc/hotel-ratings)

> The Hotel Ratings API provides hotel ratings based on automated sentiment analysis algorithm applied on the online reviews. Apart from an overall rating for a hotel also provides ratings for different categories of each (e.g.: staff, pool, internet, location). This provides a key content information for decision making during a shopping experience being able to compare how good a hotel is compared to others, sort hotels by ratings, filter by categories or recommend a hotel based on the trip context.

Add support for the [Flight Offers Search API](https://developers.amadeus.com/self-service/category/air/api-doc/flight-offers-search)

> The Flight Offers Search API allows to get cheapest flight recommendations and prices on a given journey. It provides a list of flight recommendations and fares from a given origin (city or airport), for a given date (or date range) and for a given list of passengers. Additional information such as bag allowance, first ancillary bag prices or fare details are also provided.
## 3.2.0 - 2019-06-04
Release of the [Flight Choice Prediction API](https://developers.amadeus.com/self-service/category/air/api-doc/flight-choice-prediction)

> The Flight Choice Prediction API allows developers to forecast traveler choices in the context of search & shopping. Exposing machine learning & AI services for travel, this API consumes the output of the Flight Low-fare Search API and returns augmented content with probabilities of choices for each flight offers.

## 3.1.0 - 2019-04-02

# Points of interest API

New version of the Java SDK to support a new endpoint:

* [Points of Interest](https://developers.amadeus.com/self-service/category/210/api-doc/55/api-docs-and-example/10014)

## 3.0.1 - 2019-01-28
[Bug #21](https://github.com/amadeus4dev/amadeus-java/issues/21) reported by [vht210](https://github.com/vht210), thank you very much!

Fix a bug in the Request.java with HTTPURLConnection, making the SDK doing only POST calls in Android.

## 3.0.0 - 2019-01-22

## Hotel Search v2 has been deployed (Hotel Search v1 is now deprecated)

### General
* Remove the support for Hotel Search v1
* URLs for all three endpoints have been simplified for ease-of-use and consistency
Find Hotels
### Find Hotels - 1st endpoint
* The parameter `hotels` has been renamed to `hotelIds`
### View Hotel Rooms - 2nd endpoint
* Update from `amadeus.shopping.hotel("BGLONBGB").hotelOffers.get();` to `amadeus.shopping.hotelOffersByHotel.get(Params.with("hotelId", "BGLONBGB"));`
* Now get all images in ‘View Hotels Rooms’ endpoint using the view parameter as               `FULL_ALL_IMAGES`
### View Room Details - 3rd endpoint
* Updated from `amadeus.shopping.hotel("BGLONBGB").offer("XXX").get();` to `amadeus.shopping..hotelOffer("XXX").get();`
* Image category added under Media in the response
* Hotel distance added in the response
* Response now refers to the common HotelOffer object model

## 2.0.0 - 2018-10-16

[Flight Most Searched Destinations](https://developers.amadeus.com/self-service/category/203/api-doc/6): Redesign of the API - Split the previous endpoint in 2 endpoints:
* 1st endpoint to find the most searched destinations
* 2nd endpoint to have more data about a dedicated origin & destination

[Flight Most Booked Destinations](https://developers.amadeus.com/self-service/category/203/api-doc/27):
* Rename origin to originCityCode

[Flight Most Traveled Destinations](https://developers.amadeus.com/self-service/category/203/api-doc/7):
* Rename origin in originCityCode

[Flight Check-in Links](https://developers.amadeus.com/self-service/category/203/api-doc/8):
* Rename airline to airlineCode

[Airport & City Search](https://developers.amadeus.com/self-service/category/203/api-doc/10):
* Remove parameter onlyMajor

[Airport Nearest Relevant](https://developers.amadeus.com/self-service/category/203/api-doc/9):
* Add radius as parameter

[Airline Code Lookup](https://developers.amadeus.com/self-service/category/203/api-doc/26):
* Regroup parameters _IATACode_ and _ICAOCode_ under the same name _airlineCodes_

## 1.1.2 - 2018-10-28
Contribution by [nirmalvp](https://github.com/nirmalvp)

Bug fix - The AMADEUS_HOST environment variable wasn't working

## 1.1.1 - 2018-09-09

Bug fix - Some sub-attributes accessors were private and not accessible

## 1.1.0 - 2018-08-01

New version of the Java library to support our 3 new endpoints:

* [Flight Most Booked Destinations](https://developers.amadeus.com/self-service/category/203/api-doc/27)

* [Flight Busiest Traveling Period](https://developers.amadeus.com/self-service/category/203/api-doc/28)

* [Airline Code Lookup](https://developers.amadeus.com/self-service/category/203/api-doc/26)

## 1.0.1 - 2018-06-08

Fix documentation typos and publish a new version with signed jar

## 1.0.0 - 2018-06-01

The first stable version of the Amadeus for Developers Java SDK
