package com.amadeus;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.amadeus.AccessToken;
import com.amadeus.Amadeus;
import com.amadeus.Configuration;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.ResponseException;

import com.google.gson.JsonObject;
import org.junit.Before;
import org.junit.Test;

public class AccessTokenTest {
  Amadeus client;
  Configuration configuration;
  Response response;
  JsonObject json;

  @Before public void setupClientAndResponses() throws ResponseException {
    client = mock(Amadeus.class);
    configuration = new Configuration("client_id", "client_secret");
    when(client.getConfiguration()).thenReturn(configuration);

    response = mock(Response.class);
    json = new JsonObject();
    json.addProperty("access_token", "my_token");
    json.addProperty("expires_in", 600);
    when(response.getResult()).thenReturn(json);

    when(client.unauthenticatedRequest("POST",
            "/v1/security/oauth2/token", Params
                    .with("grant_type", "client_credentials")
                    .and("client_id", "client_id")
                    .and("client_secret", "client_secret"),
            null)).thenReturn(response);
  }

  @Test public void testNewToken() throws ResponseException {
    assertEquals(new AccessToken(client).getBearerToken(), "Bearer my_token");
  }

  @Test public void testCachedToken() throws ResponseException {
    AccessToken accessToken = new AccessToken(client);
    accessToken.getBearerToken();
    accessToken.getBearerToken();

    verify(client, times(1))
      .unauthenticatedRequest(anyString(), anyString(), any(Params.class), (String) isNull());
  }

  @Test public void testExpiredToken() throws ResponseException {
    AccessToken accessToken = new AccessToken(client);
    json.addProperty("expires_in", 0);

    accessToken.getBearerToken();
    accessToken.getBearerToken();

    verify(client, times(2))
            .unauthenticatedRequest(anyString(), anyString(), any(Params.class), (String) isNull());
  }
}
