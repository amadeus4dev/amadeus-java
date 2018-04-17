package com.amadeus;

import static org.junit.Assert.assertTrue;

import com.amadeus.Amadeus;
import com.amadeus.Configuration;

import java.lang.IllegalArgumentException;
import org.junit.Test;

public class ConfigurationTest {
  @Test public void testInitialize() {
    Configuration configuration = new Configuration();
    assertTrue("should return a Configuration object",
               configuration instanceof Configuration);
  }

  @Test public void testBuild() {
    Configuration configuration = new Configuration();
    configuration.setClientId("123");
    configuration.setClientSecret("234");

    assertTrue("should return a Amadeus object",
               configuration.build() instanceof Amadeus);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testBuildWithoutClientId() {
    Configuration configuration = new Configuration();
    configuration.setClientSecret("234");
    configuration.build();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testBuildWithoutClientSecret() {
    Configuration configuration = new Configuration();
    configuration.setClientId("123");
    configuration.build();
  }

  @Test public void testBuildWithEnvironmentVariables() {
    Configuration configuration = new Configuration();
    configuration.setClientId("123");
    configuration.setClientSecret("234");
    configuration.build();
  }
}
