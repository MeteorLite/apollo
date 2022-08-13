package org.apollo.game.def;

public enum Configs {

  TUTORIAL_PROGRESS_BAR_PROGRESS(406);

  private final int id;
  Configs(int id) {
    this.id = id;
  }

  public int getID() {
    return id;
  }
}
