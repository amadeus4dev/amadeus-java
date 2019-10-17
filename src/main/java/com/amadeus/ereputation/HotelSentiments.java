package com.amadeus.ereputation;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.HotelRating;
import com.amadeus.resources.Resource;

public class HotelSentiments {
  private Amadeus client;

  public HotelSentiments(Amadeus client) {
    this.client = client;
  }

  public HotelRating[] get(Params params) throws ResponseException {
    Response response = client.get("/v2/e-reputation/hotel-sentiments", params);
    return (HotelRating[]) Resource.fromArray(response, HotelRating[].class);
  }
}
