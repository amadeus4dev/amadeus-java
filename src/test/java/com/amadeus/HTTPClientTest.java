package com.amadeus;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.amadeus.client.AccessToken;
import com.amadeus.exceptions.NetworkException;
import com.amadeus.exceptions.ResponseException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedOutputStream;
import java.net.HttpURLConnection;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;

public class HTTPClientTest {
  Amadeus client;
  Configuration configuration;
  Params params;
  AccessToken accessToken;
  Request request;
  HttpURLConnection connection;
  Logger logger;

  @Before public void setup()  {
    client = mock(Amadeus.class);
    configuration = mock(Configuration.class);
    params = Params.with("foo", "bar");
    accessToken = mock(AccessToken.class);
    request = mock(Request.class);
    connection = mock(HttpURLConnection.class);
    logger = mock(Logger.class);

    when(client.getConfiguration()).thenReturn(configuration);
    when(configuration.getLogger()).thenReturn(logger);
    when(configuration.getLogLevel()).thenReturn("silent");
  }

  @Test public void testGetWithoutParams() throws ResponseException {
    when(client.get(anyString())).thenCallRealMethod();
    client.get("/foo");
    verify(client, times(1)).request("GET", "/foo", null);
  }

  @Test public void testGetWithParams() throws ResponseException {
    when(client.get(anyString(), any(Params.class))).thenCallRealMethod();
    client.get("/foo", params);
    verify(client, times(1)).request("GET", "/foo", params);
  }

  @Test public void testPostWithoutParams() throws ResponseException {
    when(client.post(anyString())).thenCallRealMethod();
    client.post("/foo");
    verify(client, times(1)).request("POST", "/foo", null);
  }

  @Test public void testPostWitParams() throws ResponseException {
    when(client.post(anyString(), any(Params.class))).thenCallRealMethod();
    client.post("/foo", params);
    verify(client, times(1)).request("POST", "/foo", params);
  }

  @Test public void testRequest() throws ResponseException {
    client.accessToken = accessToken;
    when(accessToken.getBearerToken()).thenReturn("token");
    when(client.request(anyString(), anyString(), any(Params.class))).thenCallRealMethod();
    client.request("GET","/foo", params);
    verify(client, times(1)).unauthenticatedRequest("GET", "/foo", params, "token");
  }

  @Test public void testUnauthenticatedGetRequest() throws ResponseException, IOException {
    when(request.getVerb()).thenReturn("GET");
    when(request.getParams()).thenReturn(params);
    when(request.getConnection()).thenReturn(connection);

    when(connection.getResponseCode()).thenReturn(200);
    when(connection.getHeaderField("Content-Type")).thenReturn(
            "application/json");
    when(connection.getInputStream()).thenReturn(
            new ByteArrayInputStream("{ \"data\": [{}]}".getBytes()));

    when(client.buildRequest("GET", "/foo", params, null)).thenReturn(request);
    when(client.unauthenticatedRequest("GET", "/foo", params, null)).thenCallRealMethod();

    Response response = client.unauthenticatedRequest("GET", "/foo", params, null);

    assertTrue(response.isParsed());
    assertEquals(response.getData().size(), 1);
  }

  @Test public void testUnauthenticatedPostRequest() throws ResponseException, IOException {
    when(request.getVerb()).thenReturn("POST");
    when(request.getParams()).thenReturn(params);
    when(request.getConnection()).thenReturn(connection);

    when(connection.getOutputStream()).thenReturn(mock(OutputStream.class));
    when(connection.getResponseCode()).thenReturn(200);
    when(connection.getHeaderField("Content-Type")).thenReturn(
            "application/json");
    when(connection.getInputStream()).thenReturn(
            new ByteArrayInputStream("{ \"data\": [{}]}".getBytes()));

    when(client.buildRequest("POST", "/foo", params, null)).thenReturn(request);
    when(client.unauthenticatedRequest("POST", "/foo", params, null)).thenCallRealMethod();

    Response response = client.unauthenticatedRequest("POST", "/foo", params, null);

    assertTrue(response.isParsed());
    assertEquals(response.getData().size(), 1);
  }

  @Test public void testUnauthenticatedPostWithoutParams() throws ResponseException, IOException {
    when(request.getVerb()).thenReturn("POST");
    when(request.getParams()).thenReturn(null);
    when(request.getConnection()).thenReturn(connection);

    when(connection.getOutputStream()).thenReturn(mock(OutputStream.class));
    when(connection.getResponseCode()).thenReturn(200);
    when(connection.getHeaderField("Content-Type")).thenReturn(
            "application/json");
    when(connection.getInputStream()).thenReturn(
            new ByteArrayInputStream("{ \"data\": [{}]}".getBytes()));

    when(client.buildRequest("POST", "/foo", null, null)).thenReturn(request);
    when(client.unauthenticatedRequest("POST", "/foo", null, null)).thenCallRealMethod();

    Response response = client.unauthenticatedRequest("POST", "/foo", null, null);

    assertTrue(response.isParsed());
    assertEquals(response.getData().size(), 1);
  }


  @Test (expected = NetworkException.class)
  public void tesFailedUnauthenticatedPostRequest() throws ResponseException, IOException {
    when(request.getVerb()).thenReturn("POST");
    when(request.getParams()).thenReturn(params);
    when(request.getConnection()).thenReturn(connection);

    when(connection.getOutputStream()).thenReturn(new PipedOutputStream());
    when(connection.getResponseCode()).thenReturn(200);
    when(connection.getHeaderField("Content-Type")).thenReturn(
            "application/json");
    when(connection.getInputStream()).thenReturn(
            new ByteArrayInputStream("{ \"data\": [{}]}".getBytes()));

    when(client.buildRequest("POST", "/foo", params, null)).thenReturn(request);
    when(client.unauthenticatedRequest("POST", "/foo", params, null)).thenCallRealMethod();

    client.unauthenticatedRequest("POST", "/foo", params, null);
  }

  @Test public void testLogIfDebug() throws ResponseException, IOException {
    when(client.getConfiguration().getLogLevel()).thenReturn("debug");
    when(request.getVerb()).thenReturn("GET");
    when(request.getParams()).thenReturn(null);
    when(request.getConnection()).thenReturn(connection);

    when(connection.getResponseCode()).thenReturn(200);
    when(connection.getHeaderField("Content-Type")).thenReturn(
            "application/json");
    when(connection.getInputStream()).thenReturn(
            new ByteArrayInputStream("{ \"data\": [{}]}".getBytes()));

    when(client.buildRequest("GET", "/foo", null, null)).thenReturn(request);
    when(client.unauthenticatedRequest("GET", "/foo", null, null)).thenCallRealMethod();

    client.unauthenticatedRequest("GET", "/foo", null, null);

    verify(logger, times(2)).info(anyString());
  }

  @Test public void testLogIfSilent() throws ResponseException, IOException {
    when(request.getVerb()).thenReturn("GET");
    when(request.getParams()).thenReturn(null);
    when(request.getConnection()).thenReturn(connection);

    when(connection.getResponseCode()).thenReturn(200);
    when(connection.getHeaderField("Content-Type")).thenReturn(
            "application/json");
    when(connection.getInputStream()).thenReturn(
            new ByteArrayInputStream("{ \"data\": [{}]}".getBytes()));

    when(client.buildRequest("GET", "/foo", null, null)).thenReturn(request);
    when(client.unauthenticatedRequest("GET", "/foo", null, null)).thenCallRealMethod();

    client.unauthenticatedRequest("GET", "/foo", null, null);

    verify(logger, times(0)).info(anyString());
  }

  @Test public void testLogIfWarn() throws ResponseException, IOException {
    when(client.getConfiguration().getLogLevel()).thenReturn("warn");
    when(request.getVerb()).thenReturn("GET");
    when(request.getParams()).thenReturn(null);
    when(request.getConnection()).thenReturn(connection);

    when(connection.getResponseCode()).thenReturn(200);
    when(connection.getHeaderField("Content-Type")).thenReturn(
            "application/json");
    when(connection.getInputStream()).thenReturn(
            new ByteArrayInputStream("{ \"data\": [{}]}".getBytes()));

    when(client.buildRequest("GET", "/foo", null, null)).thenReturn(request);
    when(client.unauthenticatedRequest("GET", "/foo", null, null)).thenCallRealMethod();

    client.unauthenticatedRequest("GET", "/foo", null, null);

    verify(logger, times(0)).info(anyString());
  }

  @Test public void testBuildRequest() {
    when(client.buildRequest("GET", "/foo", null, null)).thenCallRealMethod();
    Request request = client.buildRequest("GET", "/foo", null, null);
    assertNotNull(request);
  }
}
