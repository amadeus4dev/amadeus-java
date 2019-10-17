package com.amadeus.ereputation;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.HotelSentiment;
import com.amadeus.resources.Resource;

public class HotelSentiments {
  private Amadeus client;

  public HotelSentiments(Amadeus client) {
    this.client = client;
  }

  public HotelSentiment[] get(Params params) throws ResponseException {
    Response response = client.get("/v2/e-reputation/hotel-sentiments", params);
    return (HotelSentiment[]) Resource.fromArray(response, HotelSentiment[].class);
  }
}
