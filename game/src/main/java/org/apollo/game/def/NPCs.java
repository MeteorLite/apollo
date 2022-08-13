package org.apollo.game.def;

public enum NPCs {

  RUNESCAPE_GUIDE("Runescape Guide", 945),
  SURVIVAL_GUIDE("Survival Guide", 943);

  public final String name;
  private final int id;
  NPCs(String name, int id) {
    this.name = name;
    this.id = id;
  }

  public int getID() {
    return id;
  }

  public String getName() {
    return name;
  }

  public static NPCs get(int id) {
    for (NPCs npc : values()) {
      if (npc.getID() == id)
        return npc;
    }
    return null;
  }
}
