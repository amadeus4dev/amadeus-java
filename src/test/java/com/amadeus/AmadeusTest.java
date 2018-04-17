package com.amadeus;

import static org.junit.Assert.assertNotNull;

import com.amadeus.Amadeus;
import java.io.IOException;
import org.junit.Test;

public class AmadeusTest {
  @Test public void testGetConfiguration() throws IOException {
    Amadeus amadeus = Amadeus.builder()
                             .setClientId("ABC")
                             .setClientSecret("DEF")
                             .build();

    assertNotNull("should return a configuration object", amadeus.getConfiguration());
  }
}
