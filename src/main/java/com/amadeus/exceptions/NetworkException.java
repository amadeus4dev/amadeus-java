package com.amadeus.exceptions;

import com.amadeus.Response;

/**
 * This error occurs when there is some kind of error in the network.
 */
public class NetworkException extends ResponseException {
  /**
   * Constructor.
   * @hides as only used internally
   */
  public NetworkException(Response response) {
    super(response);
  }
}
