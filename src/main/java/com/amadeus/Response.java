package com.amadeus;

import com.amadeus.Constants;
import com.amadeus.exceptions.AuthenticationException;
import com.amadeus.exceptions.ClientException;
import com.amadeus.exceptions.NotFoundException;
import com.amadeus.exceptions.ParserException;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.exceptions.ServerException;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
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
  private @Getter JsonElement data;
  /**
   * The warnings received from the API call.
   */
  private @Getter JsonElement warnings;
  /**
   * The raw body received from the API.
   */
  private @Getter String body;
  /**
   * The actual Request object used to make this API call.
   */
  private @Getter Request request;

  protected Response(Request request) {
    this.request = request;
  }

  // Tries to parse the raw response from the request.
  protected void parse(HTTPClient client) {
    parseStatusCode();
    parseData(client);
  }

  // Detects of any exceptions have occurred and throws the appropriate exceptions.
  protected void detectError(HTTPClient client) throws ResponseException {
    ResponseException exception = null;
    if (statusCode >= 500) {
      exception = new ServerException(this);
    } else if (statusCode == 404) {
      exception = new NotFoundException(this);
    } else if (statusCode == 401) {
      exception = new AuthenticationException(this);
    } else if (statusCode >= 400) {
      exception = new ClientException(this);
    } else if (!parsed) {
      exception = new ParserException(this);
    }

    if (exception != null) {
      exception.log(client.getConfiguration());
      throw exception;
    }
  }

  // Tries to parse the status code. Catches any exceptions and defaults to
  // status 0 if an error occurred.
  private void parseStatusCode() {
    try {
      this.statusCode = getRequest().getConnection().getResponseCode();
    } catch (IOException e) {
      this.statusCode = 0;
    }
  }

  // Tries to parse the data
  private void parseData(HTTPClient client) {
    this.parsed = false;
    this.body = readBody();
    this.result = parseJson(client);
    this.parsed = this.result != null;
    if (parsed && result.has("data")) {
      if (result.get("data").isJsonArray()) {
        this.data = result.get("data").getAsJsonArray();
      }
      if (result.get("data").isJsonObject()) {
        this.data = result.get("data").getAsJsonObject();
      }
    }
    if (parsed && result.has("warnings")) {
      if (result.get("warnings").isJsonArray()) {
        this.warnings = result.get("warnings").getAsJsonArray();
      }
      if (result.get("warnings").isJsonObject()) {
        this.warnings = result.get("warnings").getAsJsonObject();
      }
    }
  }

  // Tries to read the body.
  private String readBody() {
    // Workaround to avoid ParserException when status code is 204
    if (statusCode == 204) {
      body = "{ \"data\": { } } ";
      return body;
    }
    // Get the connection
    HttpURLConnection connection = getRequest().getConnection();

    // Try to get the input stream
    InputStream inputStream = null;
    try {
      inputStream = connection.getInputStream();
    } catch (IOException e) {
      inputStream = connection.getErrorStream();
    }

    // Try to parse the input stream
    try {
      InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
      BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
      StringBuffer body = new StringBuffer();
      String inputLine;
      while ((inputLine = bufferedReader.readLine()) != null) {
        body.append(inputLine);
      }
      bufferedReader.close();
      // Return the response body
      return body.toString();
    } catch (IOException e) {
      // return null if we could not parse the input stream
      return null;
    }
  }

  // Ties to parse the response body into a JSON Object
  private JsonObject parseJson(HTTPClient client) {
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
    String contentType = getRequest().getConnection().getHeaderField(Constants.CONTENT_TYPE);
    String[] expectedContentTypes = new String[] {
      "application/json", "application/vnd.amadeus+json"
    };
    return Arrays.asList(expectedContentTypes).contains(contentType);
  }

  // Checks if the response has a body
  private boolean hasBody() {
    return !(body == null || body.isEmpty());
  }
}
