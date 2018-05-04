package com.amadeus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import org.junit.Before;
import org.junit.Test;

public class ResponseTest {
  Amadeus client;
  Request request;
  Response response;
  HttpURLConnection connection;

  @Before public void setup() {
    request = mock(Request.class);
    response = new Response(request);
    connection = mock(HttpURLConnection.class);

    client = Amadeus.builder("id", "secret")
            .setLogLevel("silent").build();

    when(request.getConnection()).thenReturn(connection);
  }

  @Test public void testInitialize() {
    assertEquals(response.getRequest(), request);
  }

  @Test public void testParse() throws IOException {
    when(connection.getResponseCode()).thenReturn(200);
    when(connection.getHeaderField("Content-Type")).thenReturn(
            "application/json");
    when(connection.getInputStream()).thenReturn(
            new ByteArrayInputStream("{ \"data\": []}".getBytes()));

    response.parse(client);

    assertEquals(response.getStatusCode(), 200);
    assertEquals(response.getBody(), "{ \"data\": []}");
    assertTrue(response.isParsed());
    assertNotNull(response.getResult());
    assertNotNull(response.getData());
  }


  @Test public void testNoData() throws IOException {
    when(connection.getResponseCode()).thenReturn(200);
    when(connection.getHeaderField("Content-Type")).thenReturn(
            "application/json");
    when(connection.getInputStream()).thenReturn(
            new ByteArrayInputStream("{}".getBytes()));

    response.parse(client);

    assertEquals(response.getStatusCode(), 200);
    assertEquals(response.getBody(), "{}");
    assertTrue(response.isParsed());
    assertNotNull(response.getResult());
    assertNull(response.getData());
  }

  @Test public void testEmptyBody() throws IOException {
    when(connection.getResponseCode()).thenReturn(200);
    when(connection.getHeaderField("Content-Type")).thenReturn(
            "application/json");
    when(connection.getInputStream()).thenReturn(
            new ByteArrayInputStream("".getBytes()));

    response.parse(client);

    assertEquals(response.getStatusCode(), 200);
    assertEquals(response.getBody(), "");
    assertFalse(response.isParsed());
    assertNull(response.getResult());
    assertNull(response.getData());
  }

  @Test public void testEmptyConnection() throws IOException {
    InputStream stream = mock(ByteArrayInputStream.class);
    when(connection.getResponseCode()).thenThrow(new IOException());
    when(connection.getInputStream()).thenReturn(stream);
    when(stream.read()).thenReturn(-1);

    response.parse(client);

    assertEquals(response.getStatusCode(), 0);
    assertEquals(response.getBody(), null);
    assertFalse(response.isParsed());
    assertNull(response.getResult());
    assertNull(response.getData());
  }

  @Test public void testEmptyConnectionWithStatusCode() throws IOException {
    InputStream stream = mock(ByteArrayInputStream.class);
    when(connection.getResponseCode()).thenReturn(200);
    when(connection.getHeaderField("Content-Type")).thenReturn(
            "application/json");
    when(connection.getInputStream()).thenReturn(stream);
    when(stream.read()).thenReturn(-1);

    response.parse(client);

    assertEquals(response.getStatusCode(), 200);
    assertEquals(response.getBody(), null);

    assertFalse(response.isParsed());
    assertNull(response.getResult());
    assertNull(response.getData());
  }

  @Test public void testErrorResponse() throws IOException {
    when(connection.getResponseCode()).thenReturn(400);
    when(connection.getHeaderField("Content-Type")).thenReturn(
            "application/json");
    when(connection.getInputStream()).thenThrow(new IOException());
    when(connection.getErrorStream()).thenReturn(
            new ByteArrayInputStream("{ \"data\": []}".getBytes()));

    response.parse(client);

    assertEquals(response.getStatusCode(), 400);
    assertEquals(response.getBody(), "{ \"data\": []}");
    assertTrue(response.isParsed());
    assertNotNull(response.getResult());
    assertNotNull(response.getData());
  }

  @Test (expected = ServerException.class)
  public void detectServerException() throws ResponseException, IOException {
    when(connection.getResponseCode()).thenReturn(500);
    when(connection.getInputStream()).thenReturn(
            new ByteArrayInputStream("".getBytes()));
    response.parse(client);
    response.detectError(client);
  }

  @Test (expected = NotFoundException.class)
  public void detectNotFoundException() throws ResponseException, IOException {
    when(connection.getResponseCode()).thenReturn(404);
    when(connection.getInputStream()).thenReturn(
            new ByteArrayInputStream("".getBytes()));
    response.parse(client);
    response.detectError(client);
  }

  @Test (expected = AuthenticationException.class)
  public void detectAuthenticationException() throws ResponseException, IOException {
    when(connection.getResponseCode()).thenReturn(401);
    when(connection.getInputStream()).thenReturn(
            new ByteArrayInputStream("".getBytes()));
    response.parse(client);
    response.detectError(client);
  }

  @Test (expected = ClientException.class)
  public void detectClientException() throws ResponseException, IOException {
    when(connection.getResponseCode()).thenReturn(400);
    when(connection.getInputStream()).thenReturn(
            new ByteArrayInputStream("".getBytes()));
    response.parse(client);
    response.detectError(client);
  }

  @Test (expected = ParserException.class)
  public void detectParserException() throws ResponseException, IOException {
    when(connection.getResponseCode()).thenReturn(200);
    when(connection.getInputStream()).thenReturn(
            new ByteArrayInputStream("{".getBytes()));
    response.parse(client);
    response.detectError(client);
  }

  @Test public void detectNoException() throws ResponseException, IOException {
    when(connection.getResponseCode()).thenReturn(200);
    when(connection.getHeaderField("Content-Type")).thenReturn(
            "application/json");
    when(connection.getInputStream()).thenReturn(
            new ByteArrayInputStream("{}".getBytes()));
    response.parse(client);
    response.detectError(client);
  }

  @Test public void testToString() {
    assertTrue(response.toString().startsWith("Response("));
  }
}
