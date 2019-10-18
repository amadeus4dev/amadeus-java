# Changelog
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
