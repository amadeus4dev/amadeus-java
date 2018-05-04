package com.amadeus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.amadeus.Amadeus;
import com.amadeus.Configuration;

import java.util.logging.Logger;
import org.junit.Test;


public class ConfigurationTest {
  @Test public void testInitialize() {
    Configuration configuration = new Configuration("id", "secret");
    assertTrue("should return a Configuration object",
               configuration instanceof Configuration);
  }

  @Test public void testBuild() {
    Configuration configuration = new Configuration("123", "234");

    assertTrue("should return a Amadeus object",
               configuration.build() instanceof Amadeus);
    assertEquals("should set the com.amadeus.client ID",
                 configuration.getClientId(),
                 "123");
    assertEquals("should set the com.amadeus.client secret",
                configuration.getClientSecret(),
                "234");
  }

  @Test public void testBuildDefaults() {
    Configuration configuration = new Configuration("id", "secret");
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
    Configuration configuration = new Configuration("id", "secret")
            .setLogger(logger)
            .setLogLevel("debug");

    assertEquals(configuration.getLogger(), logger);
    assertEquals(configuration.getLogLevel(), "debug");
  }

  @Test public void testBuildCustomHostname() {
    Configuration configuration = new Configuration("id", "secret").setHostname("production");
    assertEquals(configuration.getHostname(), "production");
    assertEquals(configuration.getHost(), "api.amadeus.com");
  }

  @Test (expected = IllegalArgumentException.class)
  public void testBuildInvalidHostname() {
    new Configuration("id", "secret").setHostname("foo");
  }

  @Test public void testBuildCustomHost() {
    Configuration configuration = new Configuration("id", "secret").setHost("foo.bar.com");
    assertEquals(configuration.getHost(), "foo.bar.com");
  }

  @Test public void testBuildCustomSsl() {
    Configuration configuration = new Configuration("id", "secret").setSsl(true);
    assertTrue(configuration.isSsl());
    assertEquals(configuration.getPort(),443);
  }


  @Test public void testBuildCustomSslWithCustomPort() {
    Configuration configuration = new Configuration("id", "secret").setPort(8080).setSsl(true);
    assertTrue(configuration.isSsl());
    assertEquals(configuration.getPort(),8080);
  }

  @Test public void testBuildCustomNonSsl() {
    Configuration configuration = new Configuration("id", "secret").setSsl(false);
    assertFalse(configuration.isSsl());
    assertEquals(configuration.getPort(),80);
  }

  @Test public void testBuildCustomNonSslWithCustomPort() {
    Configuration configuration = new Configuration("id", "secret").setPort(8080).setSsl(false);
    assertFalse(configuration.isSsl());
    assertEquals(configuration.getPort(),8080);
  }

  @Test public void testToString() {
    Configuration configuration = new Configuration("id", "secret").setPort(8080).setSsl(false);
    assertTrue(configuration.toString()
            .startsWith("Configuration(clientId=id, clientSecret=secret,"));
  }
}
