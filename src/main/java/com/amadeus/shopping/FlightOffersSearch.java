package com.amadeus.shopping;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.Resource;

public class FlightOffersSearch {
  private Amadeus client;

  public FlightOffersSearch(Amadeus client) {
    this.client = client;
  }

  public FlightOfferSearch[] get(Params params) throws ResponseException {
    Response response = client.get("/v2/shopping/flight-offers", params);
    return (FlightOfferSearch[]) Resource.fromArray(response, FlightOfferSearch[].class);
  }
}
