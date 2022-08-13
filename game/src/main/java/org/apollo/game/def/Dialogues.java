package org.apollo.game.def;

public enum Dialogues {

  RUNESCAPE_GUIDE_0(0),
  RUNESCAPE_GUIDE_1(1),
  RUNESCAPE_GUIDE_2(2),
  RUNESCAPE_GUIDE_3(3),
  RUNESCAPE_GUIDE_4(4),
  RUNESCAPE_GUIDE_5(5),

  RUNESCAPE_GUIDE_6(6),

  SURVIVAL_EXPERT_0(7),
  SURVIVAL_EXPERT_1(8),
  SURVIVAL_EXPERT_2(9),
  SURVIVAL_EXPERT_3(10),
  SURVIVAL_EXPERT_4(11);
  private final int id;
  Dialogues(int id) {
    this.id = id;
  }

  public int getID() {
    return id;
  }
}
