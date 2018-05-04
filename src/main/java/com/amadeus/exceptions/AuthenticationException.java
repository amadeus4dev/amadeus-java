package com.amadeus.exceptions;

import com.amadeus.Response;

/**
 * This error occurs when the client did not provide the right credentials.
 */
public class AuthenticationException extends ResponseException {
  /**
   * Constructor.
   * @hides as only used internally
   */
  public AuthenticationException(Response response) {
    super(response);
  }
}
