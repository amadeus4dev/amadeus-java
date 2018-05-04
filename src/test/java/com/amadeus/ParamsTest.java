package com.amadeus;

import java.io.UnsupportedEncodingException;
import org.junit.Assert;
import org.junit.Test;

public class ParamsTest {
  @Test(expected = NullPointerException.class)
  public void testNullKeyValueWith() {
    Params.with(null, "123");
  }

  @Test(expected = NullPointerException.class)
  public void testNullKeyValueAnd() {
    Params.with("foo", "123").and(null, "234");
  }

  @Test public void testToQueryString() {
    Params params = Params.with("foo", "123").and("bar", "234");
    Assert.assertEquals(params.toQueryString(), "bar=234&foo=123");
  }

  @Test public void testToQueryStringWithEncodingError() {
    Params params = Params.with("foo", "123");
    params.encoding = "foobar";
    Assert.assertEquals(params.toQueryString(), "");
  }

  @Test public void testToString() {
    Params params = Params.with("foo", "123").and("bar", "234");
    Assert.assertEquals(params.toString(), "bar=234&foo=123");
  }
}
