package com.amadeus.client;

import com.amadeus.Configuration;
import com.amadeus.Constants;
import com.amadeus.HTTPClient;
import com.amadeus.Params;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
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
  private final HTTPClient client;
  // The access token value
  private String accessToken = null;
  // The (UNIX) expiry time of this token
  private long expiresAt;

  /**
   * Constructor.
   * @hides as only used internally
   */
  public AccessToken(HTTPClient client) {
    this.client = client;
  }

  /**
   * Creates a Bearer header using the cached Access Token.
   * @hides as only used internally
   */
  public String getBearerToken() throws ResponseException {
    lazyUpdateAccessToken();
    return String.format("Bearer %s", accessToken);
  }

  // Loads the access token if it's still null
  // or has expired.
  private void lazyUpdateAccessToken() throws ResponseException {
    if (needsRefresh()) {
      updateAccessToken();
    }
  }

  // Fetches the access token and then parses the resuling values.
  private void updateAccessToken() throws ResponseException {
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
  private Response fetchAccessToken() throws ResponseException {
    Configuration config = client.getConfiguration();
    return client.unauthenticatedRequest(
           Constants.POST,
           Constants.AUTH_URL,
            Params.with(Constants.GRANT_TYPE, Constants.CLIENT_CREDENTIALS)
                  .and(Constants.CLIENT_ID, config.getClientId())
                  .and(Constants.CLIENT_SECRET, config.getClientSecret()),
           null
    );
  }

  // Store the fetched access token and expiry date
  private void storeAccessToken(JsonObject result) {
    this.accessToken = result.get(Constants.ACCESS_TOKEN).getAsString();
    int expiresIn = result.get(Constants.EXPIRES_IN).getAsInt();
    this.expiresAt = System.currentTimeMillis() + expiresIn * 1000L;
  }
}
