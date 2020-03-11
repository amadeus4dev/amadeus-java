package com.amadeus.resources;

import lombok.Getter;
import lombok.ToString;

/**
 * An SeatMap object as returned by the SeatMap API.
 * @see com.amadeus.booking.SeatMaps#get()
 * @see com.amadeus.booking.SeatMaps#post() */
@ToString
public class SeatMap extends Resource {
  protected SeatMap() {}

  private @Getter String type;
  private @Getter String flightOfferid;
  private @Getter String segmentid;
  private @Getter String carrierCode;
  private @Getter String number;
  private @Getter Aircraft aircraft;
  private @Getter Departure departure;
  private @Getter Deck[] decks;

  @ToString
  public class Aircraft {
    protected Aircraft() {
    }

    private @Getter String code;
  }

  @ToString
  public class Departure {
    protected Departure() {
    }

    private @Getter String iataCode;
    private @Getter String at;
  }

  @ToString
  public class Arrival {
    protected Arrival() {
    }

    private @Getter String iataCode;
  }

  @ToString
  public class Deck {
    protected Deck() {
    }

    private @Getter String deckType;
    private @Getter DeckConfiguration deckConfiguration;

  }

  @ToString
  public class DeckConfiguration {
    protected DeckConfiguration() {
    }

    private @Getter int width;
    private @Getter int length;
    private @Getter int startseatRow;
    private @Getter int endSeatRow;
    private @Getter int startWingsRow;
    private @Getter int endWingsRow;
    private @Getter int startWingsX;
    private @Getter int endWingsX;

  }

}
