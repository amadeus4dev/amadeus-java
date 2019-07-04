package com.amadeus;

import com.amadeus.Constants;

import com.google.gson.JsonElement;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * An object containing all the details of the request made, including the host,
 * path, port, params, and headers. Generally this object can be accessed as part of
 * an API response, and can be used to debug the API call made.
 */
@Accessors(chain = true)
@ToString
public class Request {
  /**
   * The HTTPClient verb to use for API calls.
   */
  private @Getter String verb;
  /**
   * The scheme to use for API calls.
   */
  private @Getter String scheme;
  /**
   * The host domain to use for API calls.
   */
  private @Getter String host;
  /**
   * The path use for API calls.
   */
  private @Getter String path;
  /**
   * The params to send to the API endpoint.
   */
  private @Getter Params params;
  /**
   * The body to send to the API endpoint.
   */
  private @Getter String body;
  /**
   * The bearer token used to authenticate the API call.
   */
  private @Getter String bearerToken;
  /**
   * The version of the SDK used.
   */
  private @Getter String clientVersion;
  /**
   * The version of Java used.
   */
  private @Getter String languageVersion;
  /**
   * The custom Application ID passed in the user agent.
   */
  private @Getter String appId;
  /**
   * The custom Application Version passed in the user agent.
   */
  private @Getter String appVersion;
  /**
   * Whether this connection uses SSL.
   */
  private @Getter boolean ssl;
  /**
   * The port to use for this request.
   */
  private @Getter int port;
  /**
   * The headers for this request.
   */
  private @Getter HashMap<String, String> headers;
  /**
   * The full URI for this request, based on the
   * verb, port, path, host, etc.
   */
  private @Getter String uri;
  // The connection used to make the API call.
  private @Getter HttpURLConnection connection;

  protected Request(String verb, String path, Params params, String body, String bearerToken,
                 HTTPClient client) {
    Configuration config = client.getConfiguration();

    this.verb = verb;
    this.host = config.getHost();
    this.path = path;
    this.params = params;
    this.body = body;
    this.bearerToken = bearerToken;
    this.languageVersion = System.getProperty("java.version");
    this.clientVersion = Amadeus.VERSION;
    this.appId = config.getCustomAppId();
    this.appVersion = config.getCustomAppVersion();
    this.port = config.getPort();
    this.ssl = config.isSsl();

    determineScheme();
    prepareUrl();
    prepareHeaders();
  }

  // Builds a HttpURLConnection using all the data for this request.
  protected void establishConnection() throws IOException {
    this.connection = (HttpURLConnection) new URL(uri).openConnection();
    connection.setRequestMethod(verb);
    connection.setDoInput(true);
    if (verb == Constants.POST || verb == Constants.PUT) {
      connection.setDoOutput(true);
    }
    for (Map.Entry<String, String> entry : headers.entrySet()) {
      connection.setRequestProperty(entry.getKey(), entry.getValue());
    }
  }

  // Determines the scheme based on the SSL value
  private void determineScheme() {
    this.scheme = isSsl() ? Constants.HTTPS : Constants.HTTP;
  }

  // Prepares the full URL based on the scheme, host, port and path.
  private void prepareUrl() {
    this.uri = String.format("%s://%s:%s%s?%s",
            scheme, host, port, path, getQueryParams());
  }

  // Prepares the headers to be sent in the request
  private void prepareHeaders() {
    this.headers = new HashMap<String, String>();
    headers.put(Constants.USER_AGENT, buildUserAgent());
    headers.put(Constants.ACCEPT, "application/json, application/vnd.amadeus+json");

    if (bearerToken != null) {
      headers.put(Constants.AUTHORIZATION, bearerToken);
    }
  }

  // Determines the User-Agent header, based on the client version, language version, and custom
  // app information.
  private String buildUserAgent() {
    String userAgent = String.format("amadeus-java/%s", clientVersion);
    userAgent = userAgent.concat(String.format(" java/%s", languageVersion));
    if (appId != null) {
      userAgent = userAgent.concat(String.format(" %s/%s", appId, appVersion));
    }
    return userAgent;
  }

  // Gets the serialized params, only if this is a Get call
  private String getQueryParams() {
    if (verb == Constants.GET && params != null) {
      return params.toQueryString();
    } else {
      return "";
    }
  }
}
