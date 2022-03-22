package com.amadeus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.amadeus.exceptions.AuthenticationException;
import com.amadeus.exceptions.ClientException;
import com.amadeus.exceptions.NotFoundException;
import com.amadeus.exceptions.ParserException;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.exceptions.ServerException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ResponseTest {
  Amadeus client;
  Request request;
  Response response;
  HttpURLConnection connection;

  /**
   * Response Test.
   */
  @BeforeEach public void setup() {
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

  @Test public void testParseObjectData() throws IOException {
    when(connection.getResponseCode()).thenReturn(200);
    when(connection.getHeaderField("Content-Type")).thenReturn(
            "application/json");
    when(connection.getInputStream()).thenReturn(
            new ByteArrayInputStream("{ \"data\": { \"foo\": \"bar\"}}".getBytes()));

    response.parse(client);

    assertEquals(response.getStatusCode(), 200);
    assertEquals(response.getBody(), "{ \"data\": { \"foo\": \"bar\"}}");
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

  @Test public void testNoContent() throws IOException {
    when(connection.getResponseCode()).thenReturn(204);
    when(connection.getHeaderField("Content-Type")).thenReturn(
            "application/json");
    when(connection.getInputStream()).thenReturn(
            new ByteArrayInputStream("".getBytes()));

    response.parse(client);

    assertEquals(response.getStatusCode(), 204);
    assertNull(response.getBody());
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
    assertNull(response.getBody());
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
    assertNull(response.getBody());

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

  @Test public void detectServerException() throws IOException {
    when(connection.getResponseCode()).thenReturn(500);
    when(connection.getInputStream()).thenReturn(
        new ByteArrayInputStream("".getBytes()));
    response.parse(client);
    assertThrows(ServerException.class, () -> response.detectError(client));
  }

  @Test public void detectNotFoundException() throws IOException {
    when(connection.getResponseCode()).thenReturn(404);
    when(connection.getInputStream()).thenReturn(
            new ByteArrayInputStream("".getBytes()));
    response.parse(client);
    assertThrows(NotFoundException.class, () -> response.detectError(client));
  }

  @Test public void detectAuthenticationException() throws IOException {
    when(connection.getResponseCode()).thenReturn(401);
    when(connection.getInputStream()).thenReturn(
        new ByteArrayInputStream("".getBytes()));
    response.parse(client);
    assertThrows(AuthenticationException.class, () -> response.detectError(client));
  }

  @Test public void detectClientException() throws IOException {
    when(connection.getResponseCode()).thenReturn(400);
    when(connection.getInputStream()).thenReturn(
            new ByteArrayInputStream("".getBytes()));
    response.parse(client);
    assertThrows(ClientException.class, () -> response.detectError(client));
  }

  @Test public void detectParserException() throws IOException {
    when(connection.getResponseCode()).thenReturn(200);
    when(connection.getInputStream()).thenReturn(
            new ByteArrayInputStream("{".getBytes()));
    response.parse(client);
    assertThrows(ParserException.class, () -> response.detectError(client));
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

  @Test public void detectNoExceptionNoContent() throws ResponseException, IOException {
    when(connection.getResponseCode()).thenReturn(204);
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
