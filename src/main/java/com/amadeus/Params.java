package com.amadeus;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import lombok.NonNull;

/**
 * A convenient helper class for building data to pass into a request.
 *
 * <pre>
 *   amadeus.get("/foo/bar", Params.with("first_name", "John").and("last_name", "Smith"));
 * </pre>
 */
public class Params extends HashMap<String, String> {
  protected String encoding = "UTF-8";

  protected Params() {}

  /**
   * Initializes a new Param map with an initial key/value pair.
   *
   * <pre>
   *   amadeus.get("/foo/bar", Params.with("first_name", "John"));
   * </pre>
   *
   * @param key the key for the parameter to send to the API
   * @param value the value for the given key
   * @return the Param object, allowing for convenient chaining
   */
  public static Params with(@NonNull String key, Object value) {
    return new Params().and(key, value);
  }

  /**
   * Adds another key/value pair to the Params map. Automatically
   * converts all values to strings.
   *
   * <pre>
   *   amadeus.get("/foo/bar", Params.with("first_name", "John").and("last_name", "Smith"));
   * </pre>
   *
   * @param key the key for the parameter to send to the API
   * @param value the value for the given key
   * @return the Param object, allowing for convenient chaining
   */
  public Params and(@NonNull String key, Object value) {
    put(key, String.valueOf(value));
    return this;
  }

  // Converts params into a HTTP query string.
  protected String toQueryString() {
    StringBuilder query = new StringBuilder();
    boolean first = true;
    for (Map.Entry<String, String> entry : entrySet()) {
      if (!first) {
        query.append("&");
      }
      first = false;
      try {
        query.append(URLEncoder.encode(entry.getKey(), encoding));
        query.append("=");
        query.append(URLEncoder.encode(entry.getValue(), encoding));
      } catch (UnsupportedEncodingException e) {
        // no need to anything
      }
    }

    return query.toString();
  }

  /**
   * Converts params into a HTTP query string.
   */
  public String toString() {
    return toQueryString();
  }
}
