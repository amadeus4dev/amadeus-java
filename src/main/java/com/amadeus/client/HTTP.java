package com.amadeus.client;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.logging.Logger;

public class HTTP extends ConfigurableClient {
  private AccessToken accessToken;

  public HTTP(Configuration configuration) {
    super(configuration);
  }

  public Response get(String path, Params params) {
    return request("GET", path, params);
  }

  public Response post(String path, Params params) {
    return request("POST", path, params);
  }

  private Response request(String verb, String path, Params params) {
    return unauthenticatedRequest(verb, path, params, getAccessToken().getBearerToken());
  }

  /**
   * Test.
   *
   * @param verb The verb
   * @param path The path
   * @param params The params
   * @param bearerToken The token
   * @return
   */
  public Response unauthenticatedRequest(String verb, String path,
                                               Params params, String bearerToken) {
    Request request = buildRequest(verb, path, params, bearerToken);
    log(request);
    return execute(request);
  }

  private AccessToken getAccessToken() {
    if (accessToken == null) {
      this.accessToken = new AccessToken(this);
    }
    return accessToken;
  }

  private Request buildRequest(String verb, String path,
                               Params params, String bearerToken) {
    return new Request()
            .setVerb(verb)
            .setHost(getConfiguration().getHost())
            .setPath(path)
            .setParams(params)
            .setBearerToken(bearerToken)
            .setLanguageVersion(System.getProperty("java.version"))
            .setClientVersion(Amadeus.VERSION)
            .setAppId(getConfiguration().getCustomAppId())
            .setAppVersion(getConfiguration().getCustomAppVersion())
            .setPort(getConfiguration().getPort())
            .setSsl(getConfiguration().isSsl())
            .build();
  }

  private void log(Object object) {
    if (getConfiguration().getLogLevel() == "debug") {
      Logger logger = getConfiguration().getLogger();
      logger.info(object.toString());
    }
  }

  private Response execute(Request request) {
    fetch(request);
    Response response = new Response(request);
    response.parse((Amadeus) this);
    log(response);
    //    response.detectError(this);
    return response;
  }

  private void fetch(Request request) {
    HttpURLConnection connection;

    try {
      connection = request.buildConnection();
      write(request.getParams(), connection);
    } catch (IOException e) {
      // Connection Could not be established
      e.printStackTrace();
    }
  }

  private void write(Params params, HttpURLConnection connection) throws IOException {
    OutputStream os = connection.getOutputStream();
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
    writer.write(params.toQueryString());
    writer.flush();
    writer.close();
    os.close();
  }
}