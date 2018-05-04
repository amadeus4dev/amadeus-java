package com.amadeus;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.referenceData.urls.CheckinLinks;
import org.junit.Test;

public class NamespaceTest {
  @Test public void testAllNamespacesExist() {
    Amadeus client = Amadeus.builder("id", "secret").build();
    assertNotNull(client.referenceData.urls.checkinLinks);
  }

  @Test public void testGetMethods() throws ResponseException {
    Amadeus client = mock(Amadeus.class);

    when(client.get("/v2/reference-data/urls/checkin-links", null))
            .thenReturn(mock(Response.class));
    CheckinLinks checkinLinks = new CheckinLinks(client);
    assertTrue(checkinLinks.get() instanceof Response);

    Params params = Params.with("airline", "1X");
    when(client.get("/v2/reference-data/urls/checkin-links", params))
            .thenReturn(mock(Response.class));
    checkinLinks = new CheckinLinks(client);
    assertTrue(checkinLinks.get(params) instanceof Response);
  }
}
