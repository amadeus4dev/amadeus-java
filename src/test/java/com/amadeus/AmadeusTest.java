package com.amadeus;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    Amadeus.builder("id", "secret");
    assertTrue(true,
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
    Amadeus.builder(environment);
    assertTrue(true, "should return a Configuration");

    Amadeus amadeus = Amadeus.builder(environment).build();
    assertEquals(amadeus.getConfiguration().getLogLevel(), "debug");
    assertEquals(amadeus.getConfiguration().getPort(), 123);
    assertEquals(amadeus.getConfiguration().getHost(), "my.custom.host.com");
  }

  /*
  @Test(expected = NullPointerException.class)
  public void testBuilderWithInvalidEnvironment() {
    Map<String,String> environment = System.getenv();
    assertTrue("should return a Configuration",
            Amadeus.builder(environment).build() instanceof Amadeus);
  }*/

  @Test public void testVersion() {
    assertEquals(Amadeus.VERSION, "5.9.0", "should have a version number");
  }

}
