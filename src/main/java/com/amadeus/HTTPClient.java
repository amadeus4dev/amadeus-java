package com.amadeus;

import com.amadeus.Constants;
import com.amadeus.client.AccessToken;
import com.amadeus.exceptions.NetworkException;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Resource;
import com.google.gson.JsonObject;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.logging.Logger;
import lombok.Getter;

/**
 * The HTTP part of the Amadeus API client. See the Amadeus class for
 * more details on initialization.
 */
public class HTTPClient {
  // A cached copy of the Access Token. It will auto refresh for every bearerToken (if needed)
  protected AccessToken accessToken = new AccessToken(this);

  /**
   * The configuration for this API client.
   */
  private @Getter Configuration configuration;

  protected HTTPClient(Configuration configuration) {
    this.configuration = configuration;
  }

  /**
   * A helper module for making generic GET requests calls. It is used by
   * every namespaced API GET method.
   *
   * @see Amadeus#get(String, Params)
   */
  public Response get(String path) throws ResponseException {
    return request(Constants.GET, path, null,null);
  }

  /**
   * <p>
   *   A helper module for making generic GET requests calls. It is used by
   *   every namespaced API GET method.
   * </p>
   *
   * <pre>
   *   amadeus.referenceData.urls.checkinLinks.get(Params.with("airline", "1X"));
   * </pre>
   *
   * <p>
   *   It can be used to make any generic API call that is automatically
   *   authenticated using your API credentials:
   * </p>
   *
   * <pre>
   *    amadeus.get("/v2/reference-data/urls/checkin-links", Params.with("airline", "1X"));
   * </pre>
   *
   * @param path The full path for the API call
   * @param params The optional GET params to pass to the API
   * @return a Response object containing the status code, body, and parsed data.
   */
  public Response get(String path, Params params) throws ResponseException {
    return request(Constants.GET, path, params, null);
  }

  /**
   * <p>
   *   A helper module for making generic DELETE requests calls. It is used by
   *   every namespaced API DELETE method.
   * </p>
   *
   * <pre>
   *   amadeus.booking.flightOrder("eJzTd9f3NjIJdzUGAAp%2fAiY=").delete();
   * </pre>
   *
   * <p>
   *   It can be used to make any generic API call that is automatically
   *   authenticated using your API credentials:
   * </p>
   *
   * <pre>
   *    amadeus.delete("/v1/foo/bar", Params.with("airline", "1X"));
   * </pre>
   *
   * @param path The full path for the API call
   * @param params The optional DELETE params to pass to the API
   * @return a Response object containing the status code, body, and parsed data.
   */
  public Response delete(String path, Params params) throws ResponseException {
    return request(Constants.DELETE, path, params, null);
  }

  /**
   * A helper module for making generic DELETE requests calls. It is used by
   * every namespaced API DELETE method.
   *
   * @see Amadeus#delete(String, Params)
   */
  public Response delete(String path) throws ResponseException {
    return request(Constants.DELETE, path, null,null);
  }

  /**
   * A helper module for making generic POST requests calls. It is used by
   * every namespaced API POST method.
   *
   * @see Amadeus#post(String, Params)
   */
  public Response post(String path) throws ResponseException {
    return request(Constants.POST, path, null, null);
  }

  /**
   * <p>
   *   A helper module for making generic POST requests calls. It is used by
   *   every namespaced API POST method.
   * </p>
   *
   * <pre>
   *   amadeus.foo.bar.post(Params.with("airline", "1X"));
   * </pre>
   *
   * <p>
   *   It can be used to make any generic API call that is automatically
   *   authenticated using your API credentials:
   * </p>
   *
   * <pre>
   *    amadeus.post("/v1/foo/bar", Params.with("airline", "1X"));
   * </pre>
   *
   * @param path The full path for the API call
   * @param params The optional POST params to pass to the API
   * @return a Response object containing the status code, body, and parsed data.
   */
  public Response post(String path, Params params) throws ResponseException {
    return request(Constants.POST, path, params, null);
  }

  /**
   * <p>
   *   A helper module for making generic POST requests calls. It is used by
   *   every namespaced API POST method.
   * </p>
   *
   * <pre>
   *   amadeus.foo.bar.post(Params.with("airline", "1X"));
   * </pre>
   *
   * <p>
   *   It can be used to make any generic API call that is automatically
   *   authenticated using your API credentials:
   * </p>
   *
   * <pre>
   *    amadeus.post("/v1/foo/bar", Params.with("airline", "1X"));
   * </pre>
   *
   * @param path The full path for the API call
   * @param body The optional POST params to pass to the API
   * @return a Response object containing the status code, body, and parsed data.
   */
  public Response post(String path, String body) throws ResponseException {
    return request(Constants.POST, path, null, body);
  }

  /**
   * <p>
   *   A helper module for making generic POST requests calls. It is used by
   *   every namespaced API POST method.
   * </p>
   *
   * <p>
   *   It can be used to make any generic API call that is automatically
   *   authenticated using your API credentials:
   * </p>
   *
   * <pre>
   *    amadeus.post("/v1/foo/bar", { "foo" : "bar" })
   * </pre>
   *
   * @param path The full path for the API call
   * @param body The POST JsonObject body to pass to the API
   * @return a Response object containing the status code, body, and parsed data.
   */
  public Response post(String path, JsonObject body) throws ResponseException {
    return request(Constants.POST, path, null, body.toString());
  }

  /**
   * <p>
   *   A helper module for making generic POST requests calls. It is used by
   *   every namespaced API POST method.
   * </p>
   *
   * <p>
   *   It can be used to make any generic API call that is automatically
   *   authenticated using your API credentials:
   * </p>
   *
   * <pre>
   *    amadeus.post("/v1/foo/bar", Params.with("airline", "1X"), { "foo" : "bar" })
   * </pre>
   *
   * @param path The full path for the API call
   * @param params The optional POST params to pass to the API
   * @param body The POST JsonObject body to pass to the API
   * @return a Response object containing the status code, body, and parsed data.
   */
  public Response post(String path, Params params, JsonObject body) throws ResponseException {
    return request(Constants.POST, path, params, body.toString());
  }

  /**
   * <p>
   *   A helper module for making generic POST requests calls. It is used by
   *   every namespaced API POST method.
   * </p>
   *
   * <p>
   *   It can be used to make any generic API call that is automatically
   *   authenticated using your API credentials:
   * </p>
   *
   * <pre>
   *    amadeus.post("/v1/foo/bar", Params.with("airline", "1X"), { "foo" : "bar" })
   * </pre>
   *
   * @param path The full path for the API call
   * @param params The optional POST params to pass to the API
   * @param body The POST String object body to pass to the API
   * @return a Response object containing the status code, body, and parsed data.
   */
  public Response post(String path, Params params, String body) throws ResponseException {
    return request(Constants.POST, path, params, body.toString());
  }

  /**
   * A generic method for making any authenticated or unauthenticated request,
   * passing in the bearer token explicitly. Used primarily by the
   * AccessToken to get the first AccessToken.
   *
   * @hides as only used internally
   */
  public Response unauthenticatedRequest(String verb, String path, Params params, String body,
      String bearerToken) throws ResponseException {
    Request request = buildRequest(verb, path, params, body, bearerToken);
    log(request);
    return execute(request);
  }

  /**
   * Fetches the previous page for a given response.
   * @param response a response object previously received for which includes an array of data
   * @return a new response of data
   * @throws ResponseException if the page could not be found
   */
  public Response previous(Response response) throws ResponseException {
    return page(Constants.PREVIOUS, response);
  }

  /**
   * Fetches the previous page for a given response.
   * @param resource one of the responses previously received from an API call
   * @return a new array of resources of the same type
   * @throws ResponseException if the page could not be found
   */
  public Resource[] previous(Resource resource) throws ResponseException {
    return page(Constants.PREVIOUS, resource);
  }

  /**
   * Fetches the next page for a given response.
   * @param response a response object previously received for which includes an array of data
   * @return a new response of data
   * @throws ResponseException if the page could not be found
   */
  public Response next(Response response) throws ResponseException {
    return page(Constants.NEXT, response);
  }

  /**
   * Fetches the next page for a given response.
   * @param resource one of the responses previously received from an API call
   * @return a new array of resources of the same type
   * @throws ResponseException if the page could not be found
   */
  public Resource[] next(Resource resource) throws ResponseException {
    return page(Constants.NEXT, resource);
  }

  /**
   * Fetches the first page for a given response.
   * @param response a response object previously received for which includes an array of data
   * @return a new response of data
   * @throws ResponseException if the page could not be found
   */
  public Response first(Response response) throws ResponseException {
    return page(Constants.FIRST, response);
  }

  /**
   * Fetches the first page for a given response.
   * @param resource one of the responses previously received from an API call
   * @return a new array of resources of the same type
   * @throws ResponseException if the page could not be found
   */
  public Resource[] first(Resource resource) throws ResponseException {
    return page(Constants.FIRST, resource);
  }

  /**
   * Fetches the last page for a given response.
   * @param response a response object previously received for which includes an array of data
   * @return a new response of data
   * @throws ResponseException if the page could not be found
   */
  public Response last(Response response) throws ResponseException {
    return page(Constants.LAST, response);
  }

  /**
   * Fetches the last page for a given response.
   * @param resource one of the responses previously received from an API call
   * @return a new array of resources of the same type
   * @throws ResponseException if the page could not be found
   */
  public Resource[] last(Resource resource) throws ResponseException {
    return page(Constants.LAST, resource);
  }

  // A generic method for making requests of any verb.
  protected Response request(String verb, String path, Params params, String body)
      throws ResponseException {
    return unauthenticatedRequest(verb, path, params, body, accessToken.getBearerToken());
  }

  // Builds a request
  protected Request buildRequest(String verb, String path, Params params, String body,
      String bearerToken) {
    return new Request(verb, path, params, body, bearerToken, this);
  }

  // A simple log that only triggers if we are in debug mode
  private void log(Object object) {
    if (getConfiguration().getLogLevel() == "debug") {
      Logger logger = getConfiguration().getLogger();
      logger.info(object.toString());
    }
  }

  // Executes a request and return a Response
  private Response execute(Request request) throws ResponseException {
    Response response = new Response(fetch(request));
    response.parse(this);
    log(response);
    response.detectError(this);
    return response;
  }


  // Tries to make an API call. Raises an error if it can't complete the call.
  private Request fetch(Request request) throws NetworkException {
    try {
      request.establishConnection();
      write(request);
    } catch (IOException e) {
      throw new NetworkException(new Response(request));
    }
    return request;
  }

  // Writes the parameters to the request.
  private void write(Request request) throws IOException {

    // POST with access token + body + URL parameters
    if (request.getVerb() == Constants.POST && request.getParams() != null
            && request.getBearerToken() != null) {
      OutputStream os = request.getConnection().getOutputStream();
      BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
      // writer.write(request.getParams().toQueryString());
      if (request.getBody() != null) {
        writer.write(request.getBody());
      }
      writer.flush();
      writer.close();
      os.close();
    }

    // POST with access without token (authentication call)
    if (request.getVerb() == Constants.POST && request.getParams() != null
            && request.getBearerToken() == null) {
      OutputStream os = request.getConnection().getOutputStream();
      BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
      writer.write(request.getParams().toQueryString());
      writer.flush();
      writer.close();
      os.close();
    }

    // POST with access token + body
    if (request.getVerb() == Constants.POST && request.getParams() == null) {
      OutputStream os = request.getConnection().getOutputStream();
      BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
      if (request.getBody() != null) {
        writer.write(request.getBody());
      }
      writer.flush();
      writer.close();
      os.close();
    }
  }

  /**
   * Fetches the response for another page.
   * @hide as ony used internally
   */
  protected Response page(String pageName, Response response) throws ResponseException {
    try {
      String[] parts = response.getResult().get("meta").getAsJsonObject()
              .get("links").getAsJsonObject().get(pageName).getAsString().split("=");

      String pageNumber = parts[parts.length - 1];

      Request request = response.getRequest();
      Params params = (Params) request.getParams().clone();
      params.put("page[offset]", pageNumber);

      return request(request.getVerb(), request.getPath(), params, "emptyBody");
    } catch (NullPointerException e) {
      return null;
    }
  }

  /**
   * Fetches the response for another page.
   * @hide as ony used internally
   */
  protected Resource[] page(String pageName, Resource resource) throws ResponseException {
    Response response = page(pageName, resource.getResponse());
    return Resource.fromArray(response, resource.getDeSerializationClass());
  }
}
