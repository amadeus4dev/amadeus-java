package com.amadeus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.amadeus.client.AccessToken;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Resource;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.logging.Logger;
import org.eclipse.jetty.http.HttpMethod;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HTTPClientTest {
  Amadeus client;
  Configuration configuration;
  Params params;
  AccessToken accessToken;
  Request request;
  HttpURLConnection connection;
  Logger logger;
  String body;

  /**
   * HTTPClient Test.
   */
  @BeforeEach public void setup()  {
    client = mock(Amadeus.class);
    configuration = mock(Configuration.class);
    params = Params.with("foo", "bar");
    accessToken = mock(AccessToken.class);
    request = mock(Request.class);
    connection = mock(HttpURLConnection.class);
    logger = mock(Logger.class);
    body = "[{}]";

    when(client.getConfiguration()).thenReturn(configuration);
    when(configuration.getLogger()).thenReturn(logger);
    when(configuration.getLogLevel()).thenReturn("silent");
  }

  @Test public void testGetWithoutParams() throws ResponseException {
    when(client.get(anyString())).thenCallRealMethod();
    client.get("/foo");
    verify(client, times(1)).request(HttpVerbs.GET, "/foo", null, null);
  }

  @Test public void testGetWithParams() throws ResponseException {
    when(client.get(anyString(), any(Params.class))).thenCallRealMethod();
    client.get("/foo", params);
    verify(client, times(1)).request(HttpVerbs.GET, "/foo", params, null);
  }

  @Test public void testDeleteWithoutParams() throws ResponseException {
    when(client.delete(anyString())).thenCallRealMethod();
    client.delete("/foo");
    verify(client, times(1)).request(HttpVerbs.DELETE, "/foo", null, null);
  }

  @Test public void testDeleteWithParams() throws ResponseException {
    when(client.delete(anyString(), any(Params.class))).thenCallRealMethod();
    client.delete("/foo", params);
    verify(client, times(1)).request(HttpVerbs.DELETE, "/foo", params, null);
  }

  @Test public void testPostWithoutParamsWithoutBody() throws ResponseException {
    when(client.post(anyString())).thenCallRealMethod();
    client.post("/foo");
    verify(client, times(1)).request(HttpVerbs.POST, "/foo", null, null);
  }

  @Test public void testPostWithParamsWithoutBody() throws ResponseException {
    when(client.post(anyString(), any(Params.class))).thenCallRealMethod();
    client.post("/foo", params);
    verify(client, times(1)).request(HttpVerbs.POST, "/foo", params, null);
  }

  @Test public void testPostWithoutParamsWithBody() throws ResponseException {
    when(client.post(anyString(), anyString())).thenCallRealMethod();
    client.post("/foo", "[{}]");
    verify(client, times(1)).request(HttpVerbs.POST, "/foo", null, body);
  }

  @Test public void testRequest() throws ResponseException {
    client.accessToken = accessToken;
    when(accessToken.getBearerToken()).thenReturn("token");
    when(client.request(any(HttpVerbs.class), anyString(),
        any(Params.class), anyString())).thenCallRealMethod();
    client.request(HttpVerbs.GET,"/foo", params, body);
    verify(client, times(1)).unauthenticatedRequest(HttpVerbs.GET, "/foo", params, body, "token");
  }

  @Test public void testUnauthenticatedGetRequest() throws ResponseException, IOException {
    when(request.getVerb()).thenReturn(HttpVerbs.GET);
    when(request.getParams()).thenReturn(params);
    when(request.getConnection()).thenReturn(connection);

    when(connection.getResponseCode()).thenReturn(200);
    when(connection.getHeaderField("Content-Type")).thenReturn(
            "application/json");
    when(connection.getInputStream()).thenReturn(
            new ByteArrayInputStream("{ \"data\": [{}]}".getBytes()));

    when(client.buildRequest(HttpVerbs.GET, "/foo", params, null,null)).thenReturn(request);
    when(client.unauthenticatedRequest(HttpVerbs.GET, "/foo", params, null,null)).thenCallRealMethod();

    Response response = client.unauthenticatedRequest(HttpVerbs.GET, "/foo", params, null, null);

    assertTrue(response.isParsed());
    assertEquals(((JsonArray) response.getData()).size(), 1);
  }

  @Test public void testUnauthenticatedDeleteRequest() throws ResponseException, IOException {
    when(request.getVerb()).thenReturn(HttpVerbs.DELETE);
    when(request.getParams()).thenReturn(params);
    when(request.getConnection()).thenReturn(connection);

    when(connection.getResponseCode()).thenReturn(200);
    when(connection.getHeaderField("Content-Type")).thenReturn(
            "application/json");
    when(connection.getInputStream()).thenReturn(
            new ByteArrayInputStream("{ \"data\": [{}]}".getBytes()));

    when(client.buildRequest(HttpVerbs.DELETE, "/foo", params, null,null)).thenReturn(request);
    when(client.unauthenticatedRequest(HttpVerbs.DELETE, "/foo", params, null,null)).thenCallRealMethod();

    Response response = client.unauthenticatedRequest(HttpVerbs.DELETE, "/foo", params, null, null);

    assertTrue(response.isParsed());
    assertEquals(((JsonArray) response.getData()).size(), 1);
  }

  @Test public void testUnauthenticatedPostRequest() throws ResponseException, IOException {
    when(request.getVerb()).thenReturn(HttpVerbs.POST);
    when(request.getParams()).thenReturn(params);
    when(request.getConnection()).thenReturn(connection);

    when(connection.getOutputStream()).thenReturn(mock(OutputStream.class));
    when(connection.getResponseCode()).thenReturn(200);
    when(connection.getHeaderField("Content-Type")).thenReturn(
            "application/json");
    when(connection.getInputStream()).thenReturn(
            new ByteArrayInputStream("{ \"data\": [{}]}".getBytes()));

    when(client.buildRequest(HttpVerbs.POST, "/foo", params, null, null)).thenReturn(request);
    when(client.unauthenticatedRequest(HttpVerbs.POST, "/foo",
        params, null,null)).thenCallRealMethod();

    Response response = client.unauthenticatedRequest(HttpVerbs.POST, "/foo",
        params, null,null);

    assertTrue(response.isParsed());
    assertEquals(((JsonArray) response.getData()).size(), 1);
  }

  @Test public void testUnauthenticatedPostWithoutBody() throws ResponseException, IOException {
    when(request.getVerb()).thenReturn(HttpVerbs.POST);
    when(request.getBody()).thenReturn(null);
    when(request.getConnection()).thenReturn(connection);

    when(connection.getOutputStream()).thenReturn(mock(OutputStream.class));
    when(connection.getResponseCode()).thenReturn(200);
    when(connection.getHeaderField("Content-Type")).thenReturn(
            "application/json");
    when(connection.getInputStream()).thenReturn(
            new ByteArrayInputStream("{ \"data\": [{}]}".getBytes()));

    when(client.buildRequest(HttpVerbs.POST, "/foo", null, null,null)).thenReturn(request);
    when(client.unauthenticatedRequest(HttpVerbs.POST, "/foo", null, null,null)).thenCallRealMethod();

    Response response = client.unauthenticatedRequest(HttpVerbs.POST, "/foo", null, null,null);

    assertTrue(response.isParsed());
    assertEquals(((JsonArray) response.getData()).size(), 1);
  }


  //  @Test (expected = NetworkException.class)
  //  public void testFailedUnauthenticatedPostRequest() throws ResponseException, IOException {
  //    when(request.getVerb()).thenReturn("POST");
  //    when(request.getParams()).thenReturn(params);
  //    when(request.getConnection()).thenReturn(connection);
  //
  //    when(connection.getOutputStream()).thenReturn(new PipedOutputStream());
  //    when(connection.getResponseCode()).thenReturn(200);
  //    when(connection.getHeaderField("Content-Type")).thenReturn(
  //            "application/json");
  //    when(connection.getInputStream()).thenReturn(
  //            new ByteArrayInputStream("{ \"data\": [{}]}".getBytes()));
  //
  //    when(client.buildRequest("POST", "/foo", params, null,null)).thenReturn(request);
  //    when(client.unauthenticatedRequest("POST", "/foo", params, null,null)).thenCallRealMethod();
  //
  //    client.unauthenticatedRequest("POST", "/foo", params, null,null);
  //  }

  @Test public void testLogIfDebug() throws ResponseException, IOException {
    when(client.getConfiguration().getLogLevel()).thenReturn("debug");
    when(request.getVerb()).thenReturn(HttpVerbs.GET);
    when(request.getParams()).thenReturn(null);
    when(request.getConnection()).thenReturn(connection);

    when(connection.getResponseCode()).thenReturn(200);
    when(connection.getHeaderField("Content-Type")).thenReturn(
            "application/json");
    when(connection.getInputStream()).thenReturn(
            new ByteArrayInputStream("{ \"data\": [{}]}".getBytes()));

    when(client.buildRequest(HttpVerbs.GET, "/foo", null, null,null)).thenReturn(request);
    when(client.unauthenticatedRequest(HttpVerbs.GET, "/foo", null, null,null)).thenCallRealMethod();

    client.unauthenticatedRequest(HttpVerbs.GET, "/foo", null, null,null);

    verify(logger, times(2)).info(anyString());
  }

  @Test public void testLogIfSilent() throws ResponseException, IOException {
    when(request.getVerb()).thenReturn(HttpVerbs.GET);
    when(request.getParams()).thenReturn(null);
    when(request.getConnection()).thenReturn(connection);

    when(connection.getResponseCode()).thenReturn(200);
    when(connection.getHeaderField("Content-Type")).thenReturn(
            "application/json");
    when(connection.getInputStream()).thenReturn(
            new ByteArrayInputStream("{ \"data\": [{}]}".getBytes()));

    when(client.buildRequest(HttpVerbs.GET, "/foo", null, null,null)).thenReturn(request);
    when(client.unauthenticatedRequest(HttpVerbs.GET, "/foo", null, null,null)).thenCallRealMethod();

    client.unauthenticatedRequest(HttpVerbs.GET, "/foo", null, null,null);

    verify(logger, times(0)).info(anyString());
  }

  @Test public void testLogIfWarn() throws ResponseException, IOException {
    when(client.getConfiguration().getLogLevel()).thenReturn("warn");
    when(request.getVerb()).thenReturn(HttpVerbs.GET);
    when(request.getParams()).thenReturn(null);
    when(request.getConnection()).thenReturn(connection);

    when(connection.getResponseCode()).thenReturn(200);
    when(connection.getHeaderField("Content-Type")).thenReturn(
            "application/json");
    when(connection.getInputStream()).thenReturn(
            new ByteArrayInputStream("{ \"data\": [{}]}".getBytes()));

    when(client.buildRequest(HttpVerbs.GET, "/foo", null, null,null)).thenReturn(request);
    when(client.unauthenticatedRequest(HttpVerbs.GET, "/foo", null, null,null)).thenCallRealMethod();

    client.unauthenticatedRequest(HttpVerbs.GET, "/foo", null, null,null);

    verify(logger, times(0)).info(anyString());
  }

  @Test public void testBuildRequest() {
    when(client.buildRequest(HttpVerbs.GET, "/foo", null, null,null)).thenCallRealMethod();
    Request request = client.buildRequest(HttpVerbs.GET, "/foo", null, null,null);
    assertNotNull(request);
  }

  @Test public void testNextResponse() throws ResponseException {
    Response response = mock(Response.class);
    when(client.page("next", response)).thenReturn(response);
    when(client.next(response)).thenCallRealMethod();
    client.next(response);
    verify(client, times(1)).page("next", response);
  }

  @Test public void testPreviousResponse() throws ResponseException {
    Response response = mock(Response.class);
    when(client.page("previous", response)).thenReturn(response);
    when(client.previous(response)).thenCallRealMethod();
    client.previous(response);
    verify(client, times(1)).page("previous", response);
  }

  @Test public void testFirstResponse() throws ResponseException {
    Response response = mock(Response.class);
    when(client.page("first", response)).thenReturn(response);
    when(client.first(response)).thenCallRealMethod();
    client.first(response);
    verify(client, times(1)).page("first", response);
  }

  @Test public void testLastResponse() throws ResponseException {
    Response response = mock(Response.class);
    when(client.page("last", response)).thenReturn(response);
    when(client.last(response)).thenCallRealMethod();
    client.last(response);
    verify(client, times(1)).page("last", response);
  }

  @Test public void testNextResource() throws ResponseException {
    Resource resource = mock(Resource.class);
    when(client.page("next", resource)).thenReturn(null);
    when(client.next(resource)).thenCallRealMethod();
    client.next(resource);
    verify(client, times(1)).page("next", resource);
  }

  @Test public void testPreviousResource() throws ResponseException {
    Resource resource = mock(Resource.class);
    when(client.page("previous", resource)).thenReturn(null);
    when(client.previous(resource)).thenCallRealMethod();
    client.previous(resource);
    verify(client, times(1)).page("previous", resource);
  }

  @Test public void testFirstResource() throws ResponseException {
    Resource resource = mock(Resource.class);
    when(client.page("first", resource)).thenReturn(null);
    when(client.first(resource)).thenCallRealMethod();
    client.first(resource);
    verify(client, times(1)).page("first", resource);
  }

  @Test public void testLastResource() throws ResponseException {
    Resource resource = mock(Resource.class);
    when(client.page("last", resource)).thenReturn(null);
    when(client.last(resource)).thenCallRealMethod();
    client.last(resource);
    verify(client, times(1)).page("last", resource);
  }

  @Test public void testPage() throws ResponseException {
    Response response = mock(Response.class);
    Request request = mock(Request.class);

    JsonObject jsonObject = new JsonParser().parse("{ \"meta\": { "
            + "\"links\" : {\"next\": \"http://foobar.com?page=10\" } } }").getAsJsonObject();

    when(response.getResult()).thenReturn(jsonObject);
    when(response.getRequest()).thenReturn(request);
    when(request.getVerb()).thenReturn(HttpVerbs.GET);
    when(request.getPath()).thenReturn("/foo");
    when(request.getParams()).thenReturn(Params.with("foo", "bar"));

    when(client.request(any(HttpVerbs.class), anyString(),
        any(Params.class), anyString())).thenReturn(response);
    client.accessToken = accessToken;
    when(accessToken.getBearerToken()).thenReturn("token");
    when(client.page("next", response)).thenCallRealMethod();

    Response nextResponse = client.page("next", response);
    assertNotNull(nextResponse);
  }

  @Test public void testPageWithoutLinks() throws ResponseException {
    Response response = mock(Response.class);
    Request request = mock(Request.class);

    JsonObject jsonObject = new JsonParser().parse("{ \"meta\": { "
            + "\"links\" : {} } }").getAsJsonObject();

    when(response.getResult()).thenReturn(jsonObject);
    when(response.getRequest()).thenReturn(request);
    when(request.getVerb()).thenReturn(HttpVerbs.GET);
    when(request.getPath()).thenReturn("/foo");
    when(request.getParams()).thenReturn(Params.with("foo", "bar"));

    when(client.request(any(HttpVerbs.class), anyString(),
        any(Params.class), anyString())).thenReturn(response);
    when(client.page("next", response)).thenCallRealMethod();

    Response nextResponse = client.page("next", response);

    assertNull(nextResponse);
  }
}

