package com.amadeus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

public class RequestTest {
  @Test public void testInitializer() {
    Amadeus amadeus = Amadeus.builder("123", "234").build();
    Params params = Params.with("foo", "bar");
    Request request = new Request("GET", "/foo/bar", params, null,"token", amadeus);

    assertEquals(request.getVerb(), "GET");
    assertEquals(request.getHost(), "test.api.amadeus.com");
    assertEquals(request.getPath(), "/foo/bar");
    assertEquals(request.getParams(), params);
    assertEquals(request.getBearerToken(), "token");
    assertEquals(request.getLanguageVersion(), System.getProperty("java.version"));
    assertEquals(request.getClientVersion(), Amadeus.VERSION);
    assertEquals(request.getAppId(), null);
    assertEquals(request.getAppVersion(), null);
    assertEquals(request.getPort(), 443);
    assertEquals(request.isSsl(), true);
    assertEquals(request.getScheme(), "https");
    assertEquals(request.getHeaders().size(), 4);
    assertEquals(request.getHeaders()
            .get(Constants.ACCEPT), "application/json, application/vnd.amadeus+json");
    assertEquals(request.getHeaders()
            .get(Constants.CONTENT_TYPE), "application/vnd.amadeus+json");
    assertEquals(request.getHeaders().get(Constants.AUTHORIZATION), "token");
    assertTrue(request.getHeaders().get(Constants.USER_AGENT).matches("amadeus-java/.* java/.*"));
  }

  @Test public void testInitializerWithoutBearerToken() {
    Amadeus amadeus = Amadeus.builder("123", "234").build();
    Params params = Params.with("foo", "bar");
    Request request = new Request("GET", "/foo/bar", params, null, null, amadeus);

    assertEquals(request.getHeaders().size(), 2);
    assertEquals(request.getHeaders().get("Authorization"), null);
  }

  @Test public void testInitializerWithCustomAppInfo() {
    Amadeus amadeus = Amadeus.builder("123", "234")
            .setCustomAppVersion("123")
            .setCustomAppId("amadeus-cli")
            .build();
    Params params = Params.with("foo", "bar");
    Request request = new Request("GET", "/foo/bar", params, null,"token", amadeus);

    assertTrue(request.getHeaders()
            .get("User-Agent").matches("amadeus-java/.* java/.* amadeus-cli/.*"));
  }

  @Test public void testInitializerWithHTTP() {
    Amadeus amadeus = Amadeus.builder("123", "234")
            .setSsl(false)
            .build();
    Request request = new Request("GET", "/foo/bar", null, null, "token", amadeus);

    assertEquals(request.getScheme(), "http");
  }

  @Test public void testBuildUriForGetRequest() {
    Amadeus amadeus = Amadeus.builder("123", "234").build();
    Params params = Params.with("foo", "bar");
    Request request = new Request("GET", "/foo/bar", params, null,null, amadeus);
    assertEquals(request.getUri(), "https://test.api.amadeus.com:443/foo/bar?foo=bar");
  }

  @Test public void testBuildUriForGetRequestWithoutParams() {
    Amadeus amadeus = Amadeus.builder("123", "234").build();
    Request request = new Request("GET", "/foo/bar", null, null,null, amadeus);
    assertEquals(request.getUri(), "https://test.api.amadeus.com:443/foo/bar?");
  }

  @Test public void testBuildUriForPostRequest() {
    Amadeus amadeus = Amadeus.builder("123", "234").build();
    Params params = Params.with("foo", "bar");
    Request request = new Request("POST", "/foo/bar", params, null,null, amadeus);

    assertEquals(request.getUri(), "https://test.api.amadeus.com:443/foo/bar?foo=bar");
  }

  @Test public void testToString() {
    Amadeus amadeus = Amadeus.builder("123", "234").build();
    Request request = new Request("GET", "/foo/bar", null, null,null, amadeus);

    assertTrue(request.toString()
            .startsWith("Request(verb=GET, scheme=https, host=test.api.amadeus.com"));
  }

  @Test public void testEstablishConnection() throws IOException {
    Amadeus amadeus = Amadeus.builder("123", "234").build();
    Request request = new Request("POST", "/v1/security/oauth2/token", null, null,null, amadeus);
    request.establishConnection();
    assertNotNull(request.getConnection());
  }
}
