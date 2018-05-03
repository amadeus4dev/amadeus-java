package com.amadeus;

/**
 * This error occurs when the path could not be found.
 */
public class NotFoundException extends ResponseException {
  protected NotFoundException(Response response) {
    super(response);
  }
}
