package com.amadeus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.amadeus.Amadeus;
import com.amadeus.Configuration;

import org.junit.Test;

public class AmadeusTest {
  @Test public void testInitialize() {
    Amadeus amadeus = new Amadeus(new Configuration());
    assertTrue("should require a Configuration object",
               amadeus instanceof Amadeus);
  }

  @Test public void testBuilder() {
    assertTrue("should return a Configuration",
               Amadeus.builder() instanceof Configuration);
  }

  @Test public void testVersion() {
    assertEquals("should have a version number", Amadeus.VERSION, "1.0.0");
  }
}
