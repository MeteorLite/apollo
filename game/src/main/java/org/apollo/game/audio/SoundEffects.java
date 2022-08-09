package org.apollo.game.audio;

public enum SoundEffects {

  DOOR_OPEN(326);

  private final int id;
  SoundEffects(int id) {
    this.id = id;
  }

  public int getID() {
    return id;
  }

  public static SoundEffects get(int id) {
    for (SoundEffects song : SoundEffects.values()) {
      if (song.id == id)
        return song;
    }
    return null;
  }
}
