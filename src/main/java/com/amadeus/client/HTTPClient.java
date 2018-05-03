package com.amadeus.client;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Request;
import com.amadeus.Response;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.util.logging.Logger;

public class HTTPClient extends ConfigurableClient {
  private AccessToken accessToken;

  public HTTPClient(Configuration configuration) {
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
   * @hide
   *
   * @param verb test
   * @param path test
   * @param params test
   * @param bearerToken test
   * @return test
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
    Configuration config = getConfiguration();
    return new Request(verb, config.getHost(), path, params, bearerToken,
            System.getProperty("java.version"), Amadeus.VERSION, config.getCustomAppId(),
            config.getCustomAppVersion(), config.getPort(), config.isSsl());
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
      request.establishConnection();
      write(request);
    } catch (IOException e) {
      // Connection Could not be established
      e.printStackTrace();
    }
  }

  private void write(Request request) throws IOException {
    OutputStream os = request.getConnection().getOutputStream();
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
    writer.write(request.getParams().toQueryString());
    writer.flush();
    writer.close();
    os.close();
  }
}