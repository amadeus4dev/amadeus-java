package com.amadeus;

import com.amadeus.client.Parser;
import com.amadeus.client.Request;
import com.google.gson.JsonObject;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
public class Response {
  private @Getter @Setter int statusCode;
  private @Getter @Setter boolean parsed;
  private @Getter @Setter JsonObject result;
  private @Getter @Setter JsonObject data;
  private @Getter @Setter String body;
  private @Getter Request request;

  public Response(Request request) {
    this.request = request;
  }

  public void parse(Amadeus client) {
    new Parser(this).parse(client);
  }
}
