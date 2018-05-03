package com.amadeus;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.Getter;

/**
 *  A custom generic Amadeus error.
 */
public class ResponseException extends Exception {
  private @Getter String code;
  private @Getter Response response;
  private @Getter String description;

  protected ResponseException(Response response) {
    super(determineDescription(response));
    this.response = response;
    this.description = determineDescription(response);
    determineCode();
  }

  private void determineCode() {
    this.code = getClass().getSimpleName();
  }

  private static String determineDescription(Response response) {
    StringBuffer description = determineShortDescription(response);
    description.append(determineLongDescription(response));
    return description.toString();
  }

  private static StringBuffer determineShortDescription(Response response) {
    StringBuffer message = new StringBuffer();
    if (response.getStatusCode() == 0) {
      message.append("[---]");
    } else {
      message.append(String.format("[%s]", response.getStatusCode()));
    }
    return message;
  }

  private static StringBuffer determineLongDescription(Response response) {
    StringBuffer description = new StringBuffer();
    if (response != null && response.isParsed()) {
      if (response.getResult().has("error_description")) {
        description.append(getErrorDescription(response));
      }
      if (response.getResult().has("errors")) {
        description.append(getErrorsDescription(response));
      }
    }
    return description;
  }

  private static StringBuffer getErrorDescription(Response response) {
    JsonObject result = response.getResult();
    StringBuffer message = new StringBuffer();
    if (response.getResult().has("error")) {
      message.append(String.format("\n%s", result.get("error").getAsString()));
    }
    if (response.getResult().has("error_description")) {
      message.append(String.format("\n%s", result.get("error_description").getAsString()));
    }
    return message;
  }

  private static StringBuffer getErrorsDescription(Response response) {
    StringBuffer message = new StringBuffer();
    for (JsonElement error : response.getResult().get("errors").getAsJsonArray()) {
      JsonObject json = error.getAsJsonObject();
      message.append("\n");
      if (json.has("source")) {
        JsonObject source = json.get("source").getAsJsonObject();
        if (source.has("parameter")) {
          message.append(String.format("[%s] ", source.get("parameter").getAsString()));
        }
      }
      message.append(String.format("%s", json.get("detail").getAsString()));
    }
    return message;
  }

  // Logs the response.
  protected void log(HTTPClient client) {
    if (client.getConfiguration().getLogLevel() == "warn") {
      String warning = String.format("Amadeus %s %s", code, description);
      client.getConfiguration().getLogger().warning(warning);
    }
  }
}