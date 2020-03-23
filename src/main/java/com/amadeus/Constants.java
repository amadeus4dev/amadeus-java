package com.amadeus;

/**
 * A class for constant variables.
 *
 * <pre>
 *  To use: Constants.VARIABLE
 * </pre>
 */
public final class Constants {
  // HTTP verbs
  public static final String GET = "GET";
  public static final String POST = "POST";
  public static final String PUT = "PUT";
  public static final String DELETE = "DELETE";


  public static final String HTTPS = "https";
  public static final String HTTP = "http";

  public static final String USER_AGENT = "User-Agent";
  public static final String ACCEPT = "Accept";
  public static final String AUTHORIZATION = "Authorization";
  public static final String CONTENT_TYPE = "Content-Type";

  // Pagination
  public static final String FIRST = "first";
  public static final String LAST = "last";
  public static final String NEXT = "next";
  public static final String PREVIOUS = "previous";

  // Authorization
  public static final String GRANT_TYPE = "grant_type";
  public static final String CLIENT_CREDENTIALS = "client_credentials";
  public static final String CLIENT_ID = "client_id";
  public static final String CLIENT_SECRET = "client_secret";
  public static final String AUTH_URL = "/v1/security/oauth2/token";
  public static final String ACCESS_TOKEN = "access_token";
  public static final String EXPIRES_IN = "expires_in";


  /**
   * The caller references the constants using <tt>Consts.EMPTY_STRING</tt>,
   * and so on. Thus, the caller should be prevented from constructing objects of
   * this class, by declaring this private constructor.
   */
  private Constants() {
    throw new AssertionError();
  }
}