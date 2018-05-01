package com.amadeus.client;

import com.amadeus.Amadeus;
import com.amadeus.Response;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Arrays;

import lombok.Getter;

public class Parser {
  private @Getter Response response;

  public Parser(Response response) {
    this.response = response;
  }

  public void parse(Amadeus client) {
    parseStatusCode();
    parseData(client);
  }

  private void parseStatusCode() {
    try {
      response.setStatusCode(response.getRequest().getConnection().getResponseCode());
    } catch (IOException e) {
      response.setStatusCode(0);
    }
  }

  private void parseData(Amadeus client) {
    response.setParsed(false);
    response.setBody(readBody());
    response.setResult(parseJson(client));
    response.setData(response.getResult().getAsJsonObject("data"));
  }

  private String readBody() {
    try {
      HttpURLConnection connection = response.getRequest().getConnection();
      InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
      BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
      StringBuffer body = new StringBuffer();
      String inputLine;
      while ((inputLine = bufferedReader.readLine()) != null) {
        body.append(inputLine);
      }
      bufferedReader.close();
      return body.toString();
    } catch (IOException e) {
      return null;
    }
  }

  private JsonObject parseJson(Amadeus client) {
    if (isJson()) {
      JsonParser parser = new JsonParser();
      return parser.parse(response.getBody()).getAsJsonObject();
    }
    return null;
  }

  private boolean isJson() {
    return hasJsonHeader() && hasBody();
  }

  private boolean hasJsonHeader() {
    String contentType = response.getRequest().getConnection().getHeaderField("Content-Type");
    String[] expectedContentTypes = new String[]{
      "application/json", "application/vnd.amadeus+json"
    };
    return Arrays.asList(expectedContentTypes).contains(contentType);
  }

  private boolean hasBody() {
    return response.getBody() != null;
  }
}
