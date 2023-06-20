package com.amadeus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class AmadeusTest {
  /**
   * Amadeus Test.
   */
  @Test public void testBuilder() {
    Configuration config = Amadeus.builder("id", "secret");
    assertNotNull(config,
        "should return a Configuration");
  }

  @Test public void testBuilderWithNullClientId() {
    assertThrows(NullPointerException.class, () -> Amadeus.builder(null, "secret").build());
  }

  @Test public void testBuilderWithNullClientSecret() {
    assertThrows(NullPointerException.class, () -> Amadeus.builder("client", null).build());
  }

  @Test public void testBuilderWithEnvironment() {
    Map<String,String> environment = new HashMap<String,String>() {
      {
        put("AMADEUS_CLIENT_ID", "123");
        put("AMADEUS_CLIENT_SECRET", "234");
        put("AMADEUS_LOG_LEVEL", "debug");
        put("AMADEUS_PORT", "123");
        put("AMADEUS_HOST", "my.custom.host.com");
      }
    };
    Configuration config = Amadeus.builder(environment);
    assertNotNull(config, "should return a Configuration");

    Amadeus amadeus = Amadeus.builder(environment).build();
    assertEquals(amadeus.getConfiguration().getLogLevel(), "debug");
    assertEquals(amadeus.getConfiguration().getPort(), 123);
    assertEquals(amadeus.getConfiguration().getHost(), "my.custom.host.com");
  }

  @Test
  public void testBuilderWithInvalidEnvironment() {

    // Given
    Map<String,String> environment = new HashMap<>(); //System.getenv();
    environment.put("AMADEUS_CLIENT_ID", "MY_CLIENT_ID");
    environment.put("AMADEUS_CLIENT_SECRET", "MY_CLIENT_SECRET");

    // When
    boolean result = Amadeus.builder(environment).build() instanceof Amadeus;

    // Then
    assertTrue(result, "should return a Configuration");
  }

  @Test public void testVersion() {
    assertEquals(Amadeus.VERSION, "7.1.0", "should have a version number");
  }

}
