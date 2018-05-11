package com.amadeus.resources;

import com.amadeus.Amadeus;
import com.amadeus.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;

/**
 * A generic resource as returned by all namespaced APIs.
 */
public class Resource {
  protected Resource() {}

  /**
   * The original response that this object is populated from.
   */
  private @Getter Response response;
  /**
   * The class used for deserialization.
   * @hide as only used internally
   */
  private @Getter Class deSerializationClass;

  /**
   * Turns a response into a Gson deserialized array of resources,
   * attaching the response to each resource.
   * @hide as only used internally
   */
  public static Resource[] fromArray(Response response, Class klass) {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
    Resource[] resources = (Resource[]) gson.fromJson(response.getData(), klass);
    for (Resource resource : resources) {
      resource.response = response;
      resource.deSerializationClass = klass;
    }
    return resources;
  }

  /**
   * Turns a response into a Gson deserialized resource,
   * attaching the response to the resource.
   * @hide as only used internally
   */
  public static Resource fromObject(Response response, Class klass) {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
    Resource resource = (Resource) gson.fromJson(response.getData(), klass);
    resource.response = response;
    resource.deSerializationClass = klass;
    return resource;
  }
}
