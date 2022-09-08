package com.amadeus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.amadeus.client.AccessToken;
import com.amadeus.exceptions.ResponseException;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccessTokenTest {
  Amadeus client;
  Configuration configuration;
  Response response;
  JsonObject json;

  /**
   * Access Token Test.
   */
  @BeforeEach public void setupClientAndResponses() throws ResponseException {
    client = mock(Amadeus.class);
    configuration = new Configuration("client_id", "client_secret");
    when(client.getConfiguration()).thenReturn(configuration);

    response = mock(Response.class);
    json = new JsonObject();
    json.addProperty("access_token", "my_token");
    json.addProperty("expires_in", 600);
    when(response.getResult()).thenReturn(json);

    when(client.unauthenticatedRequest(HttpVerbs.POST,
            "/v1/security/oauth2/token", Params
                    .with("grant_type", "client_credentials")
                    .and("client_id", "client_id")
                    .and("client_secret", "client_secret"),
            null, null)).thenReturn(response);
  }

  @Test public void testNewToken() throws ResponseException {
    assertEquals(new AccessToken(client).getBearerToken(), "Bearer my_token");
  }

  @Test public void testCachedToken() throws ResponseException {
    AccessToken accessToken = new AccessToken(client);
    accessToken.getBearerToken();
    accessToken.getBearerToken();

    verify(client, times(1))
        .unauthenticatedRequest(any(HttpVerbs.class), anyString(),
            any(Params.class), isNull(), isNull());
  }

  @Test public void testExpiredToken() throws ResponseException {
    AccessToken accessToken = new AccessToken(client);
    json.addProperty("expires_in", 0);

    accessToken.getBearerToken();
    accessToken.getBearerToken();

    verify(client, times(2))
            .unauthenticatedRequest(any(HttpVerbs.class), anyString(),
                any(Params.class), isNull(), isNull());
  }
}
