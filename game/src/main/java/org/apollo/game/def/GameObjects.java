package org.apollo.game.def;

public enum GameObjects {

  DOOR(3014),
  FIRE_NORMAL(2732);

  private final int id;
  GameObjects(int id) {
    this.id = id;
  }

  public int getID() {
    return id;
  }
}
