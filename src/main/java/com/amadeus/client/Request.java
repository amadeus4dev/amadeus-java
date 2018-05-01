package com.amadeus.client;

import com.amadeus.Params;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;


@Accessors(chain = true)
@ToString
public class Request {
  /**
   * The HTTP verb to use for API calls.
   *
   * @param verb The HTTP verb to use for API calls.
   * @return The HTTP verb to use for API calls.
   */
  private @Getter @Setter String verb;
  /**
   * The scheme to use for API calls.
   *
   * @param scheme The scheme to use for API calls.
   * @return The scheme to use for API calls.
   */
  private @Getter String scheme;
  /**
   * The host domain to use for API calls.
   *
   * @param host The host domain to use for API calls.
   * @return The host domain to use for API calls.
   */
  private @Getter @Setter String host;
  /**
   * The path use for API calls.
   *
   * @param path The path to use for API calls.
   * @return The path to use for API calls.
   */
  private @Getter @Setter String path;
  /**
   * The params to send to the API endpoint.
   *
   * @param params The params to send to the API endpoint.
   * @return The params to send to the API endpoint.
   */
  private @Getter @Setter Params params;
  /**
   * The bearer token used to authenticate the API call.
   *
   * @param bearerToken The bearer token used to authenticate the API call.
   * @return The bearer token used to authenticate the API call.
   */
  private @Getter @Setter String bearerToken;
  /**
   * The version of the SDK used.
   *
   * @param clientVersion The version of the SDK used
   * @return The version of the SDK used
   */
  private @Getter @Setter String clientVersion;
  /**
   * The version of Java used.
   *
   * @param languageVersion The version of Java used
   * @return The version of Java used
   */
  private @Getter @Setter String languageVersion;
  /**
   * The custom Application ID passed in the user agent.
   *
   * @param appId The custom Application ID passed in the user agent
   * @return The custom Application ID passed in the user agent
   */
  private @Getter @Setter String appId;
  /**
   * The custom Application Version passed in the user agent.
   *
   * @param appVersion The custom Application Version passed in the user agent
   * @return The custom Application Version passed in the user agent
   */
  private @Getter @Setter String appVersion;
  /**
   * Whether this connection uses SSL.
   *
   * @param ssl Whether this connection uses SSL
   * @return Whether this connection uses SSL
   */
  private @Getter @Setter boolean ssl;
  /**
   * The port to use for this request.
   *
   * @param port The port to use for this request
   * @return The port to use for this request
   */
  private @Getter @Setter int port;
  /**
   * The headers for this request.
   *
   * @param headers The headers for this request
   * @return The headers for this request
   */
  private @Getter HashMap<String, String> headers;
  /**
   * The full URI for this request, based on the
   * verb, port, path, host, etc.
   *
   * @param uri The full URI for this request
   * @return The full URI for this request
   */
  private @Getter String uri;
  /**
   * The connection used for this request.
   *
   * @param connection The connection used for this request
   * @return The connection used for this request
   */
  private @Getter HttpURLConnection connection;

  protected Request build() {
    initializeScheme();
    initializeUrl();
    initializeHeaders();
    return this;
  }

  private void initializeScheme() {
    this.scheme = this.isSsl() ? "https" : "http";
  }

  private void initializeUrl() {
    this.uri = String.format("%s://%s:%s/%s",
            getScheme(), getHost(),
            getPort(), getPath());
  }

  private void initializeHeaders() {
    this.headers = new HashMap<String, String>();
    headers.put("User-Agent", buildUserAgent());
    headers.put("Accept", "application/json, application/vnd.amadeus+json");
  }

  private String buildUserAgent() {
    String userAgent = String.format("amadeus-java/%s", clientVersion);
    userAgent = userAgent.concat(String.format(" java/%s", languageVersion));
    if (appId != null) {
      userAgent = userAgent.concat(String.format(" %s/%s", appId, appVersion));
    }
    return userAgent;
  }

  protected HttpURLConnection buildConnection() throws IOException {
    if (this.connection == null) {
      this.connection = (HttpURLConnection) new URL(uri).openConnection();
      connection.setRequestMethod(getVerb());
      connection.setDoInput(true);
      connection.setDoOutput(true);

      for (Map.Entry<String, String> entry : headers.entrySet()) {
        connection.setRequestProperty(entry.getKey(), entry.getValue());
      }
    }
    return connection;
  }
}
