package org.apollo.game.def;

public enum Animations {

  STOP(-1),
  FIREMAKING(733);

  private final int id;
  Animations(int id) {
    this.id = id;
  }

  public int getID() {
    return id;
  }
}
