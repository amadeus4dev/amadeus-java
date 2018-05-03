package com.amadeus;

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
  /**
   * The connection used to make the API call.
   * @hide as only used internally
   */
  private @Getter HttpURLConnection connection;

  /**
   * The constructor.
   * @hide as only used internally
   */
  public Request(String verb, String host, String path, Params params, String bearerToken,
                 String languageVersion, String clientVersion, String appId, String appVersion,
                 int port, boolean ssl) {
    this.verb = verb;
    this.host = host;
    this.path = path;
    this.params = params;
    this.bearerToken = bearerToken;
    this.languageVersion = languageVersion;
    this.clientVersion = clientVersion;
    this.appId = appId;
    this.appVersion = appVersion;
    this.port = port;
    this.ssl = ssl;

    determineScheme();
    prepareUrl();
    prepareHeaders();
  }

  /**
   * Builds a HttpURLConnection using all the data for this request.
   * @hide as only used internally
   */
  public void establishConnection() throws IOException {
    this.connection = (HttpURLConnection) new URL(uri).openConnection();
    connection.setRequestMethod(verb);
    connection.setDoInput(true);
    connection.setDoOutput(true);
    for (Map.Entry<String, String> entry : headers.entrySet()) {
      connection.setRequestProperty(entry.getKey(), entry.getValue());
    }
  }

  // Determines the scheme based on the SSL value
  private void determineScheme() {
    this.scheme = this.isSsl() ? "https" : "http";
  }

  // Prepares the full URL based on the scheme, host, port and path.
  private void prepareUrl() {
    this.uri = String.format("%s://%s:%s/%s",
            getScheme(), getHost(),
            getPort(), getPath());
  }

  // Prepares the headers to be sent in the request
  private void prepareHeaders() {
    this.headers = new HashMap<String, String>();
    headers.put("User-Agent", buildUserAgent());
    headers.put("Accept", "application/json, application/vnd.amadeus+json");
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
}
