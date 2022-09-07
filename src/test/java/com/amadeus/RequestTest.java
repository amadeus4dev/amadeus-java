package com.amadeus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import org.junit.jupiter.api.Test;

public class RequestTest {
  /**
   * Request Test.
   */
  @Test public void testInitializer() {
    Amadeus amadeus = Amadeus.builder("123", "234").build();
    Params params = Params.with("foo", "bar");
    Request request = new Request(HttpVerbs.GET, "/foo/bar", params, null,"token", amadeus);

    assertEquals(request.getVerb(), HttpVerbs.GET);
    assertEquals(request.getHost(), "test.api.amadeus.com");
    assertEquals(request.getPath(), "/foo/bar");
    assertEquals(request.getParams(), params);
    assertEquals(request.getBearerToken(), "token");
    assertEquals(request.getLanguageVersion(), System.getProperty("java.version"));
    assertEquals(request.getClientVersion(), Amadeus.VERSION);
    assertNull(request.getAppId());
    assertNull(request.getAppVersion());
    assertEquals(request.getPort(), 443);
    assertTrue(request.isSsl());
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
    Request request = new Request(HttpVerbs.GET, "/foo/bar", params, null, null, amadeus);

    assertEquals(request.getHeaders().size(), 2);
    assertNull(request.getHeaders().get("Authorization"));
  }

  @Test public void testInitializerWithCustomAppInfo() {
    Amadeus amadeus = Amadeus.builder("123", "234")
            .setCustomAppVersion("123")
            .setCustomAppId("amadeus-cli")
            .build();
    Params params = Params.with("foo", "bar");
    Request request = new Request(HttpVerbs.GET, "/foo/bar", params, null,"token", amadeus);

    assertTrue(request.getHeaders()
            .get("User-Agent").matches("amadeus-java/.* java/.* amadeus-cli/.*"));
  }

  @Test public void testInitializerWithHTTP() {
    Amadeus amadeus = Amadeus.builder("123", "234")
            .setSsl(false)
            .build();
    Request request = new Request(HttpVerbs.GET, "/foo/bar", null, null, "token", amadeus);

    assertEquals(request.getScheme(), "http");
  }

  @Test public void testBuildUriForGetRequest() {
    Amadeus amadeus = Amadeus.builder("123", "234").build();
    Params params = Params.with("foo", "bar");
    Request request = new Request(HttpVerbs.GET, "/foo/bar", params, null,null, amadeus);
    assertEquals(request.getUri(), "https://test.api.amadeus.com:443/foo/bar?foo=bar");
  }

  @Test public void testBuildUriForGetRequestWithoutParams() {
    Amadeus amadeus = Amadeus.builder("123", "234").build();
    Request request = new Request(HttpVerbs.GET, "/foo/bar", null, null,null, amadeus);
    assertEquals(request.getUri(), "https://test.api.amadeus.com:443/foo/bar?");
  }

  @Test public void testBuildUriForPostRequest() {
    Amadeus amadeus = Amadeus.builder("123", "234").build();
    Params params = Params.with("foo", "bar");
    Request request = new Request(HttpVerbs.POST, "/foo/bar", params, null,null, amadeus);

    assertEquals(request.getUri(), "https://test.api.amadeus.com:443/foo/bar?foo=bar");
  }

  @Test public void testToString() {
    Amadeus amadeus = Amadeus.builder("123", "234").build();
    Request request = new Request(HttpVerbs.GET, "/foo/bar", null, null,null, amadeus);

    assertTrue(request.toString()
            .startsWith("Request(verb=GET, scheme=https, host=test.api.amadeus.com"));
  }

  @Test public void testEstablishConnection() throws IOException {
    Amadeus amadeus = Amadeus.builder("123", "234").build();
    Request request = new Request(HttpVerbs.POST, "/v1/security/oauth2/token", null, null,null, amadeus);
    request.establishConnection();
    assertNotNull(request.getConnection());
  }

  @Test public void testRequestWithoutHttpOverrideHeader() {
    Amadeus amadeus = Amadeus.builder("123", "234").build();
    Request request = new Request(HttpVerbs.GET, "/foo/bar", null, null,"token", amadeus);
    assertNull(request.getHeaders().get(Constants.X_HTTP_METHOD_OVERRIDE));
  }

  @Test public void testRequestWithHttpOverrideHeader() {
    Amadeus amadeus = Amadeus.builder("123", "234").build();
    for (String path : Constants.APIS_WITH_EXTRA_HEADER) {
      Request request = new Request(HttpVerbs.POST, path, null, null,"token", amadeus);
      assertEquals(request.getHeaders().get(Constants.X_HTTP_METHOD_OVERRIDE), "GET");
    }
  }
}
