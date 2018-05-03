package com.amadeus;

/**
 * This error occurs when there is some kind of error in the network.
 */
public class NetworkException extends ResponseException {
  protected NetworkException(Response response) {
    super(response);
  }
}
