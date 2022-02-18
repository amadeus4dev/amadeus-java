package com.amadeus.resources;

import com.amadeus.Response;
import lombok.Getter;
import lombok.ToString;

/**
 * A CollectionMeta Object Mapping.
 * @see Response#getMeta()
 */
@ToString
public class CollectionMeta extends Resource {
  protected CollectionMeta() {}

  private @Getter int count;
  private @Getter CollectionLinks links;

  @ToString
  public class CollectionLinks {
    protected CollectionLinks() {}

    private @Getter String self;
    private @Getter String next;
    private @Getter String previous;
    private @Getter String last;
    private @Getter String first;
    private @Getter String up;
  }
}
