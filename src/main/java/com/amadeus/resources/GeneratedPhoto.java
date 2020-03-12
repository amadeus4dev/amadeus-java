package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * An GeneratedPhoto object as returned by the AI-Generated Photos API.
 * @see Traveled#get()
 */
@ToString
public class GeneratedPhoto extends Resource {
  protected GeneratedPhoto() {}

  private @Getter String type;
  private @Getter String owner;
  private @Getter String attachmentUri;
  private @Getter String description;
  private @Getter String fileKbSize;
  private @Getter String expirationDateTime;
  private @Getter MediaMetadata mediaMetadata;

  /**
   * A MediaMetadata-related object as returned by the AI-Generated Photos API.
   * @see GeneratedPhotos#get()
   */
  @ToString
  public class MediaMetadata {
    protected MediaMetadata() {}

    private @Getter Dimension dimensions;

    /**
     * A MediaMetadata-related object as returned by the AI-Generated Photos API.
     * @see GeneratedPhotos#get()
     */
    @ToString
    public class Dimension {
      protected Dimension() {}

      private @Getter String height;
      private @Getter String width;

    }
  }
}
