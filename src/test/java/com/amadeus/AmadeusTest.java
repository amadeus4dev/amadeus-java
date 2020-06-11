package com.amadeus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;


public class AmadeusTest {
  @Test public void testBuilder() {
    assertTrue("should return a Configuration",
               Amadeus.builder("id", "secret") instanceof Configuration);
  }

  @Test(expected = NullPointerException.class)
  public void testBuilderWithNullClientId() {
    Amadeus.builder(null, "secret").build();
  }

  @Test(expected = NullPointerException.class)
  public void testBuilderWithNullClientSecret() {
    Amadeus.builder("client", null).build();
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
    assertTrue("should return a Configuration",
            Amadeus.builder(environment) instanceof Configuration);

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
    assertEquals("should have a version number", Amadeus.VERSION, "5.2.0");
  }

}
