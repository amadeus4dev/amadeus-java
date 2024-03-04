package com.amadeus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import java.util.List;

public class ParamsTest {
  /**
   * Params Test.
   */
  @Test public void testNullKeyValueWith() {
    assertThrows(NullPointerException.class, () -> Params.with(null, "123"));
  }

  @Test public void testNullKeyValueAnd() {
    assertThrows(NullPointerException.class, () -> Params.with("foo", "123").and(null, "234"));
  }

  @Test public void testToQueryString() {
    Params params = Params.with("foo", "123").and("bar", "234");
    assertEquals(params.toQueryString(), "bar=234&foo=123");
  }

  @Test public void testToQueryStringWithList(){
    Params params = Params.with("foo", List.of("id1", "id2"));
    assertEquals(params.toQueryString(), "foo=id1%2Cid2");
  }

  @Test public void testToQueryStringWithEncodingError() {
    Params params = Params.with("foo", "123");
    params.encoding = "foobar";
    assertEquals(params.toQueryString(), "");
  }

  @Test public void testToString() {
    Params params = Params.with("foo", "123").and("bar", "234");
    assertEquals(params.toString(), "bar=234&foo=123");
  }
}
