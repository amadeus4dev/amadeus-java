package com.amadeus;

/**
 * This error occurs when there is an error on the server.
 */
public class ServerException extends ResponseException {
  protected ServerException(Response response) {
    super(response);
  }
}
