package com.amadeus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.amadeus.Amadeus;
import com.amadeus.Configuration;

import java.lang.NullPointerException;
import java.util.HashMap;
import java.util.Map;
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
    assertEquals("should set the client ID",
                 configuration.getClientId(),
                 "123");
    assertEquals("should set the client secret",
                configuration.getClientSecret(),
                "234");
  }

  @Test (expected = NullPointerException.class)
  public void testBuildWithoutClientId() {
    Configuration configuration = new Configuration();
    configuration.setClientSecret("234");
    configuration.build();
  }

  @Test (expected = NullPointerException.class)
  public void testBuildWithoutClientSecret() {
    Configuration configuration = new Configuration();
    configuration.setClientId("123");
    configuration.build();
  }

  @Test public void testBuildWithEnvironmentVariables() {
    Configuration configuration = new Configuration();
    Map<String, String> environment = new HashMap<String, String>();
    environment.put("AMADEUS_CLIENT_ID", "ENV_CLIENT_ID");
    environment.put("AMADEUS_CLIENT_SECRET", "ENV_CLIENT_SECRET");
    configuration.setEnvironment(environment);

    configuration.build();

    assertEquals("should set the client ID",
                 configuration.getClientId(),
                 "ENV_CLIENT_ID");
    assertEquals("should set the client secret",
                 configuration.getClientSecret(),
                 "ENV_CLIENT_SECRET");
  }
}
