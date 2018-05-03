package com.amadeus.client;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.Response;
import com.google.gson.JsonObject;

/**
 * A memoized Access Token, with the ability to auto-refresh when needed.
 * @hide as only used internally
 */
public class AccessToken {
  // Renew the token 10 seconds earlier than required,
  // just to account for system lag
  private static final long TOKEN_BUFFER = 10000L;
  // An instance of the API client
  private final Amadeus client;
  // The access token value
  private String accessToken;
  // The (UNIX) expiry time of this token
  private long expiresAt;

  public AccessToken(HTTPClient client) {
    this.client = (Amadeus) client;
  }

  // Creates a Bearer header using the cached Access Token.
  public String getBearerToken() {
    lazyUpdateAccessToken();
    return String.format("Bearer %s", accessToken);
  }

  // Loads the access token if it's still null
  // or has expired.
  private void lazyUpdateAccessToken() {
    if (accessToken == null || needsRefresh()) {
      updateAccessToken();
    }
  }

  // Fetches the access token and then parses the resuling values.
  private void updateAccessToken() {
    Response response = fetchAccessToken();
    storeAccessToken(response.getResult());
  }

  // Checks if this access token needs a refresh.
  private boolean needsRefresh() {
    boolean isNull = accessToken == null;
    boolean expired = (System.currentTimeMillis() + TOKEN_BUFFER) > expiresAt;
    return isNull || expired;
  }

  // Fetches a new Access Token using the credentials from the client
  private Response fetchAccessToken() {
    Configuration config = client.getConfiguration();
    return client.unauthenticatedRequest(
           "POST",
           "/v1/security/oauth2/token",
            Params.with("grant_type", "client_credentials")
                  .and("client_id", config.getClientId())
                  .and("client_secret", config.getClientSecret()),
           null
    );
  }

  // Store the fetched access token and expiry date
  private void storeAccessToken(JsonObject result) {
    this.accessToken = result.get("access_token").getAsString();
    int expiresIn = result.get("expires_in").getAsInt();
    this.expiresAt = System.currentTimeMillis() + expiresIn * 1000L;
  }
}
