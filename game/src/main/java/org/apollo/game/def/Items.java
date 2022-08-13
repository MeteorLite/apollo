package org.apollo.game.def;

public enum Items {

  TINDERBOX(590),
  LOGS(1511),
  BRONZE_AXE(1351);



  private final int id;
  Items(int id) {
    this.id = id;
  }

  public int getID() {
    return id;
  }
}
