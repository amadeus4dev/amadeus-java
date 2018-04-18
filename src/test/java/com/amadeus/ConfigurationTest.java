package com.amadeus;

import com.amadeus.Amadeus;
import com.amadeus.Configuration;

import java.lang.NullPointerException;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

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

  @Test public void testBuildDefaults() {
    Configuration configuration = new Configuration();
    assertTrue(configuration.getLogger() instanceof Logger);
    assertEquals(configuration.getLogLevel(), "silent");
    assertEquals(configuration.getHostname(), "test");
    assertEquals(configuration.getHost(), "test.api.amadeus.com");
    assertTrue(configuration.isSsl());
    assertEquals(configuration.getPort(), 443);
    assertNull(configuration.getCustomAppId());
    assertNull(configuration.getCustomAppVersion());
  }

  @Test public void testBuildCustomLogger() {
    Logger logger = Logger.getLogger("Test");
    Configuration configuration = new Configuration()
            .setLogger(logger)
            .setLogLevel("debug");

    assertEquals(configuration.getLogger(), logger);
    assertEquals(configuration.getLogLevel(), "debug");
  }

  @Test public void testBuildCustomHostname() {
    Configuration configuration = new Configuration().setHostname("production");
    assertEquals(configuration.getHostname(), "production");
    assertEquals(configuration.getHost(), "api.amadeus.com");
  }

  @Test (expected = IllegalArgumentException.class)
  public void testBuildInvalidHostname() {
    Configuration configuration = new Configuration().setHostname("foo");
  }

  @Test public void testBuildCustomHost() {
    Configuration configuration = new Configuration().setHost("foo.bar.com");
    assertEquals(configuration.getHost(), "foo.bar.com");
  }

  @Test public void testBuildCustomSsl() {
    Configuration configuration = new Configuration().setSsl(true);
    assertTrue(configuration.isSsl());
    assertEquals(configuration.getPort(),443);
  }


  @Test public void testBuildCustomSslWithCustomPort() {
    Configuration configuration = new Configuration().setPort(8080).setSsl(true);
    assertTrue(configuration.isSsl());
    assertEquals(configuration.getPort(),8080);
  }

  @Test public void testBuildCustomNonSsl() {
    Configuration configuration = new Configuration().setSsl(false);
    assertFalse(configuration.isSsl());
    assertEquals(configuration.getPort(),80);
  }

  @Test public void testBuildCustomNonSslWithCustomPort() {
    Configuration configuration = new Configuration().setPort(8080).setSsl(false);
    assertFalse(configuration.isSsl());
    assertEquals(configuration.getPort(),8080);
  }
}
