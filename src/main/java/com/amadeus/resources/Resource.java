package com.amadeus.resources;

import com.amadeus.Response;
import com.google.gson.Gson;
import lombok.Getter;

public class Resource {
  /**
   * The original response that this object is populated from.
   */
  private @Getter Response response;

  /**
   * Turns a response into a Gson deserialized array of resources,
   * attaching the response to each resource.
   * @hide as only used internally
   */
  public static Resource[] fromArray(Response response, Class klass) {
    Resource[] resources = (Resource[]) new Gson().fromJson(response.getData(), klass);
    for (Resource resource : resources) {
      resource.response = response;
    }
    return resources;
  }

  /**
   * Turns a response into a Gson deserialized resource,
   * attaching the response to the resource.
   * @hide as only used internally
   */
  public static Resource fromObject(Response response, Class klass) {
    Resource resource = (Resource) new Gson().fromJson(response.getData(), klass);
    resource.response = response;
    return resource;
  }
}
