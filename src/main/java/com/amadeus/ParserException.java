package com.amadeus;

/**
 * This error occurs when the response type was JSON but could not be parsed.
 */
public class ParserException extends ResponseException {
  protected ParserException(Response response) {
    super(response);
  }
}
