package com.amadeus.exceptions;

import com.amadeus.Response;

/**
 * This error occurs when the path could not be found.
 */
public class NotFoundException extends ResponseException {
  public NotFoundException(Response response) {
    super(response);
  }
}
