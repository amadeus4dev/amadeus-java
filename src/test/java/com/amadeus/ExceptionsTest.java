package com.amadeus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.amadeus.exceptions.AuthenticationException;
import com.amadeus.exceptions.ClientException;
import com.amadeus.exceptions.NetworkException;
import com.amadeus.exceptions.NotFoundException;
import com.amadeus.exceptions.ParserException;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.exceptions.ServerException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.logging.Logger;
import org.junit.Test;


public class ExceptionsTest {
  @Test public void testNilResponse() {
    ResponseException error = new ResponseException(null);
    assertEquals(error.toString(), "com.amadeus.exceptions.ResponseException: [---]");
  }

  @Test public void testNoStatusCode() {
    Response response = mock(Response.class);
    ResponseException error = new ResponseException(response);
    assertEquals(error.toString(), "com.amadeus.exceptions.ResponseException: [---]");
  }

  @Test public void testNoJson() {
    Response response = mock(Response.class);
    when(response.getStatusCode()).thenReturn(400);

    ResponseException error = new ResponseException(response);
    assertEquals(error.toString(), "com.amadeus.exceptions.ResponseException: [400]");
  }

  @Test public void testForSingleError() {
    Response response = mock(Response.class);
    when(response.getStatusCode()).thenReturn(401);
    JsonObject json = new JsonObject();
    json.addProperty("error_description", "error message");
    when(response.getResult()).thenReturn(json);
    when(response.isParsed()).thenReturn(true);

    ResponseException error = new ResponseException(response);
    assertEquals(error.toString(), "com.amadeus.exceptions.ResponseException: [401]"
            + "\nerror message");
  }

  @Test public void testForSingleErrorWithName() {
    Response response = mock(Response.class);
    when(response.getStatusCode()).thenReturn(401);
    JsonObject json = new JsonObject();
    json.addProperty("error_description", "error message");
    json.addProperty("error", "error description");
    when(response.getResult()).thenReturn(json);
    when(response.isParsed()).thenReturn(true);

    ResponseException error = new ResponseException(response);
    assertEquals(error.toString(), "com.amadeus.exceptions.ResponseException: [401]"
            + "\nerror description"
            + "\nerror message");
  }

  @Test public void testForMultipleErrors() {
    Response response = mock(Response.class);
    when(response.getStatusCode()).thenReturn(401);
    String body = "{\"errors\":[{\"status\":400,\"code\":32171,\"title\":\"MANDATORY DATA"
        + "MISSING\",\"detail\":\"This field must be filled.\",\"source\":{\"parameter\":\"d"
        + "epartureDate\"}},{\"status\":400,\"code\":32171,\"title\":\"MANDATORY DATA MISSIN"
        + "G\",\"detail\":\"This field must be filled.\",\"source\":{\"parameter\":\"origin\""
        + "}},{\"status\":400,\"code\":32171,\"title\":\"MANDATORY DATA MISSING\",\"detail\""
        + ":\"This field must be filled.\",\"source\":{\"parameter\":\"destination\"}}]}";
    JsonObject json = new JsonParser().parse(body).getAsJsonObject();
    when(response.getResult()).thenReturn(json);
    when(response.isParsed()).thenReturn(true);

    ResponseException error = new ResponseException(response);
    assertEquals(error.toString(), "com.amadeus.exceptions.ResponseException: [401]"
            + "\n[departureDate] This field must be filled."
            + "\n[origin] This field must be filled."
            + "\n[destination] This field must be filled.");
  }

  @Test public void testForEmptyErrors() {
    Response response = mock(Response.class);
    when(response.getStatusCode()).thenReturn(401);
    String body = "{\"errors\":[{\"detail\":\"error\"}]}";
    JsonObject json = new JsonParser().parse(body).getAsJsonObject();
    when(response.getResult()).thenReturn(json);
    when(response.isParsed()).thenReturn(true);

    ResponseException error = new ResponseException(response);
    assertEquals(error.toString(), "com.amadeus.exceptions.ResponseException: [401]"
            + "\nerror");
  }

  @Test public void testForErrorsWithoutParameter() {
    Response response = mock(Response.class);
    when(response.getStatusCode()).thenReturn(401);
    String body = "{\"errors\":[{\"detail\":\"error\", \"source\":{}}]}";
    JsonObject json = new JsonParser().parse(body).getAsJsonObject();
    when(response.getResult()).thenReturn(json);
    when(response.isParsed()).thenReturn(true);

    ResponseException error = new ResponseException(response);
    assertEquals(error.toString(), "com.amadeus.exceptions.ResponseException: [401]"
            + "\nerror");
  }

  @Test public void testLogIfWarn() {
    Response response = mock(Response.class);
    when(response.getStatusCode()).thenReturn(400);
    ResponseException error = new ResponseException(response);

    Configuration configuration = mock(Configuration.class);
    Logger logger = mock(Logger.class);
    when(configuration.getLogLevel()).thenReturn("warn");
    when(configuration.getLogger()).thenReturn(logger);

    error.log(configuration);

    verify(logger).warning("Amadeus ResponseException [400]");
  }

  @Test public void testLogIfSilent() {
    Response response = mock(Response.class);
    when(response.getStatusCode()).thenReturn(400);
    ResponseException error = new ResponseException(response);

    Configuration configuration = mock(Configuration.class);
    Logger logger = mock(Logger.class);
    when(configuration.getLogLevel()).thenReturn("silent");
    when(configuration.getLogger()).thenReturn(logger);

    error.log(configuration);

    verify(logger, times(0)).warning("Amadeus ResponseException [400]");
  }

  @Test public void testOtherExceptions() {
    assertTrue(new AuthenticationException(null) instanceof ResponseException);
    assertTrue(new ClientException(null) instanceof ResponseException);
    assertTrue(new NetworkException(null) instanceof ResponseException);
    assertTrue(new NotFoundException(null) instanceof ResponseException);
    assertTrue(new ParserException(null) instanceof ResponseException);
    assertTrue(new ServerException(null) instanceof ResponseException);
  }
}
