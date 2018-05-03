package com.amadeus;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Arrays;
import lombok.Getter;
import lombok.ToString;

/**
 * A generic response as received from an API call. Contains the status code, body,
 * and parsed JSON (if any).
 */
@ToString
public class Response {
  /**
   * The HTTP status code for the response, if any.
   */
  private @Getter int statusCode;
  /**
   * Wether the raw body has been parsed into JSON.
   */
  private @Getter boolean parsed;
  /**
   * The parsed JSON received from the API, if the result was JSON.
   */
  private @Getter JsonObject result;
  /**
   * The data extracted from the JSON data - if the body contained JSON.
   */
  private @Getter JsonObject data;
  /**
   * The raw body received from the API.
   */
  private @Getter String body;
  /**
   * The actual Request object used to make this API call.
   */
  private @Getter Request request;

  /**
   * The constructor.
   * @hide as only used internally by HTTPClient
   */
  public Response(Request request) {
    this.request = request;
  }

  /**
   * Tries to parse the raw response from the request.
   * @hide as only used internally by HTTPClient
   */
  public void parse(Amadeus client) {
    parseStatusCode();
    parseData(client);
  }

  // Tries to parse the status code. Catches any errors and defaults to
  // status 0 if an error occurred.
  private void parseStatusCode() {
    try {
      this.statusCode = getRequest().getConnection().getResponseCode();
    } catch (IOException e) {
      this.statusCode = 0;
    }
  }

  // Tries to parse the data
  private void parseData(Amadeus client) {
    this.parsed = false;
    this.body = readBody();
    this.result = parseJson(client);
    this.data = getResult().getAsJsonObject("data");
  }

  // Tries to read the body.
  private String readBody() {
    try {
      HttpURLConnection connection = getRequest().getConnection();
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
      //TODO: Catch any errors
      return null;
    }
  }

  // Ties to parse the response body into a JSON Object
  private JsonObject parseJson(Amadeus client) {
    if (isJson()) {
      return new JsonParser().parse(getBody()).getAsJsonObject();
    }
    return null;
  }

  // Checks if the response is likely to be JSON.
  private boolean isJson() {
    return hasJsonHeader() && hasBody();
  }

  // Checks if the response headers include a JSON mime-type.
  private boolean hasJsonHeader() {
    String contentType = getRequest().getConnection().getHeaderField("Content-Type");
    String[] expectedContentTypes = new String[] {
      "application/json", "application/vnd.amadeus+json"
    };
    return Arrays.asList(expectedContentTypes).contains(contentType);
  }

  // Checks if the response has a body
  private boolean hasBody() {
    return getBody() != null;
  }
}
