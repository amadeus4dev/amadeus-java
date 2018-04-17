package com.amadeus;

// import com.google.gson.Gson;
// import java.net.HttpURLConnection;
// import java.net.URL;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.io.OutputStreamWriter;
// import java.io.OutputStream;
// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.util.HashMap;
// import java.util.Map;
// import java.io.UnsupportedEncodingException;
// import java.net.URLEncoder;
import lombok.Getter;

/**
 * The Amadeus API client.
 */
public class Amadeus {
  /**
   * All the config for the API client.
   * @return The config for this API client
   */
  private final @Getter Configuration configuration;

  protected Amadeus(Configuration configuration) {
    this.configuration = configuration;
  }

  /**
   * Creates a builder object that can be used to build
   * an Amadeus client.
   *
   * <pre>
   * Amadeus amadeus = Amadeus.builder()
   *                          .setClientId('YOUR_CLIENT_ID')
   *                          .setClientSecret('YOUR_CLIENT_SECRET')
   *                          .build();
   * </pre>
   *
   * @return a Configuration object
   */
  public static Configuration builder() {
    return new Configuration();
  }
}
