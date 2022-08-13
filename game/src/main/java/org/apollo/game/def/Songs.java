package org.apollo.game.def;

public enum Songs {

  NEWBIE_MELODY(62, 1285);

  private final int id;
  private final int regionID;
  Songs(int id, int regionID) {
    this.id = id;
    this.regionID = regionID;
  }

  public int getID() {
    return id;
  }

  public static Songs get(int regionID) {
    for (Songs song : Songs.values()) {
      if (song.regionID == regionID)
        return song;
    }
    return null;
  }
}
