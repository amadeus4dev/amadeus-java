package com.amadeus.exceptions;

import com.amadeus.Response;

/**
 * This error occurs when the client did not provide the right parameters.
 */
public class ClientException extends ResponseException {
  /**
   * Constructor.
   * @hides as only used internally
   */
  public ClientException(Response response) {
    super(response);
  }
}
