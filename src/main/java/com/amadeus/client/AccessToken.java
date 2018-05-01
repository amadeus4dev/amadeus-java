package com.amadeus.client;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.google.gson.JsonObject;

import java.util.Map;

public class AccessToken {
  private static final int TOKEN_BUFFER = 10000;
  private final Amadeus client;
  private String accessToken;
  private long expiresAt;

  public AccessToken(HTTP client) {
    this.client = (Amadeus) client;
  }

  public String getBearerToken() {
    return String.format("Bearer %s", getToken());
  }

  private String getToken() {
    if (accessToken == null || needsRefresh()) {
      updateAccessToken();
    }
    return accessToken;
  }

  private void updateAccessToken() {
    Response response = fetchAccessToken();
    storeAccessToken(response.getResult());
  }

  private boolean needsRefresh() {
    return (accessToken == null) || (System.currentTimeMillis() + TOKEN_BUFFER > expiresAt);
  }

  private Response fetchAccessToken() {
    return client.unauthenticatedRequest(
           "POST",
           "/v1/security/oauth2/token",
            new Params().put("grant_type", "client_credentials")
                  .put("client_id", client.getConfiguration().getClientId())
                  .put("client_secret", client.getConfiguration().getClientSecret()),
           null
    );
  }

  private void storeAccessToken(JsonObject result) {
    this.accessToken = result.get("access_token").getAsString();
    int expiresIn = result.get("expires_in").getAsInt();
    this.expiresAt = System.currentTimeMillis() + expiresIn * 1000L;
  }
}
