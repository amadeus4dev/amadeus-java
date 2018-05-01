package com.amadeus;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import lombok.ToString;


@ToString(includeFieldNames = false)
public class Params {
  private HashMap<String, String> map;

  public Params() {
    this.map = new HashMap<String, String>();
  }

  public static Params build(String key, Object value) {
    return new Params().put(key, value);
  }

  public boolean containsKey(String key) {
    return map.containsKey(key);
  }

  public Set keySet() {
    return map.keySet();
  }

  public String get(String key) {
    return map.get(key);
  }

  public Set<Map.Entry<String, String>> entrySet() {
    return map.entrySet();
  }

  /**
   * Test.
   *
   * @param key The key
   * @param value The value
   * @return a params
   */
  public Params put(String key, Object value) {
    map.put(key, value.toString());
    return this;
  }

  /**
   * Converts params into a HTTP query string.
   *
   * @return a HTTP query String.
   * @throws UnsupportedEncodingException When any of the params were not UTF-8
   */
  public String toQueryString() throws UnsupportedEncodingException {
    StringBuilder result = new StringBuilder();
    boolean first = true;
    for (Map.Entry<String, String> entry : map.entrySet()) {
      if (first) {
        first = false;
      } else {
        result.append("&");
      }

      result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
      result.append("=");
      result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
    }

    return result.toString();
  }
}
