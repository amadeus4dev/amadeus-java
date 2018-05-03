package com.amadeus;

/**
 * This error occurs when the client did not provide the right credentials.
 */
public class AuthenticationException extends ResponseException {
  protected AuthenticationException(Response response) {
    super(response);
  }
}
