package com.amadeus;

/**
 * This error occurs when the client did not provide the right parameters.
 */
public class ClientException extends ResponseException {
  protected ClientException(Response response) {
    super(response);
  }
}
