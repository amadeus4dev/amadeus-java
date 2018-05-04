package com.amadeus.exceptions;

import com.amadeus.Response;

/**
 * This error occurs when there is an error on the server.
 */
public class ServerException extends ResponseException {
  /**
   * Constructor.
   * @hides as only used internally
   */
  public ServerException(Response response) {
    super(response);
  }
}
