package org.apollo.game.dialogue;

import org.apollo.game.def.Dialogues;
import org.apollo.game.def.Expressions;
import org.apollo.game.def.Interfaces;
import org.apollo.game.def.NPCs;
import org.apollo.game.message.impl.SetWidgetItemModelMessage;
import org.apollo.game.message.impl.SetWidgetModelAnimationMessage;
import org.apollo.game.message.impl.SetWidgetNpcModelMessage;
import org.apollo.game.message.impl.SetWidgetTextMessage;
import org.apollo.game.model.entity.Npc;
import org.apollo.game.model.entity.Player;

public class Dialogue {

  public static void npcOneLine(Player player, Npc n,
      Dialogues dialogue, Expressions expression, String line1) {

    NPCs npc = NPCs.get(n.getId());

    if (npc == null || player == null)
      return;

    player.setLastDialogue(dialogue);

    int expressionID = expression == null ? Expressions.DEFAULT.getAnimation() : expression.getAnimation();

    player.send(new SetWidgetModelAnimationMessage(Interfaces.NPC_ONE_LINE_MODEL.getID(), expressionID));
    player.send(new SetWidgetNpcModelMessage(Interfaces.NPC_ONE_LINE_MODEL.getID(), npc.getID()));
    player.send(new SetWidgetTextMessage(Interfaces.NPC_ONE_LINE_HEADER.getID(), npc.getName()));
    player.send(new SetWidgetTextMessage(Interfaces.NPC_ONE_LINE_LINE_1.getID(), line1));
    player.getInterfaceSet().openDialogue(Interfaces.NPC_ONE_LINE.getID());
  }

  public static void updateNpcOneLine(Player player,
      Dialogues dialogue, Expressions expression, String line1) {

    if (player == null)
      return;

    player.setLastDialogue(dialogue);

    int expressionID = expression == null ? Expressions.DEFAULT.getAnimation() : expression.getAnimation();

    player.send(new SetWidgetModelAnimationMessage(Interfaces.NPC_ONE_LINE_MODEL.getID(), expressionID));
    player.send(new SetWidgetTextMessage(Interfaces.NPC_ONE_LINE_LINE_1.getID(), line1));
    player.getInterfaceSet().openDialogue(Interfaces.NPC_ONE_LINE.getID());
  }

  public static void npcTwoLine(Player player, Npc n,
      Dialogues dialogue, Expressions expression, String line1, String line2) {

    NPCs npc = NPCs.get(n.getId());

    if (npc == null || player == null)
      return;

    player.setLastDialogue(dialogue);

    int expressionID = expression == null ? Expressions.DEFAULT.getAnimation() : expression.getAnimation();

    player.send(new SetWidgetModelAnimationMessage(Interfaces.NPC_TWO_LINE_MODEL.getID(), expressionID));
    player.send(new SetWidgetNpcModelMessage(Interfaces.NPC_TWO_LINE_MODEL.getID(), npc.getID()));
    player.send(new SetWidgetTextMessage(Interfaces.NPC_TWO_LINE_HEADER.getID(), npc.getName()));
    player.send(new SetWidgetTextMessage(Interfaces.NPC_TWO_LINE_LINE_1.getID(), line1));
    player.send(new SetWidgetTextMessage(Interfaces.NPC_TWO_LINE_LINE_2.getID(), line2));
    player.getInterfaceSet().openDialogue(Interfaces.NPC_TWO_LINE.getID());
  }

  public static void updateNpcTwoLine(Player player,
      Dialogues dialogue, Expressions expression, String line1, String line2) {

    if (player == null)
      return;

    player.setLastDialogue(dialogue);

    int expressionID = expression == null ? Expressions.DEFAULT.getAnimation() : expression.getAnimation();

    player.send(new SetWidgetModelAnimationMessage(Interfaces.NPC_TWO_LINE_MODEL.getID(), expressionID));
    player.send(new SetWidgetTextMessage(Interfaces.NPC_TWO_LINE_LINE_1.getID(), line1));
    player.send(new SetWidgetTextMessage(Interfaces.NPC_TWO_LINE_LINE_2.getID(), line2));
    player.getInterfaceSet().openDialogue(Interfaces.NPC_TWO_LINE.getID());
  }

  public static void npcThreeLine(Player player, Npc n,
      Dialogues dialogue, Expressions expression, String line1, String line2, String line3) {

    NPCs npc = NPCs.get(n.getId());

    if (npc == null || player == null)
      return;

    player.setLastDialogue(dialogue);

    int expressionID = expression == null ? Expressions.DEFAULT.getAnimation() : expression.getAnimation();

    player.send(new SetWidgetModelAnimationMessage(Interfaces.NPC_THREE_LINE_MODEL.getID(), expressionID));
    player.send(new SetWidgetNpcModelMessage(Interfaces.NPC_THREE_LINE_MODEL.getID(), npc.getID()));
    player.send(new SetWidgetTextMessage(Interfaces.NPC_THREE_LINE_HEADER.getID(), npc.getName()));
    player.send(new SetWidgetTextMessage(Interfaces.NPC_THREE_LINE_LINE_1.getID(), line1));
    player.send(new SetWidgetTextMessage(Interfaces.NPC_THREE_LINE_LINE_2.getID(), line2));
    player.send(new SetWidgetTextMessage(Interfaces.NPC_THREE_LINE_LINE_3.getID(), line3));
    player.getInterfaceSet().openDialogue(Interfaces.NPC_THREE_LINE.getID());
  }

  public static void updateNpcThreeLine(Player player,
      Dialogues dialogue, Expressions expression, String line1, String line2, String line3) {

    if (player == null)
      return;

    player.setLastDialogue(dialogue);

    int expressionID = expression == null ? Expressions.DEFAULT.getAnimation() : expression.getAnimation();

    player.send(new SetWidgetModelAnimationMessage(Interfaces.NPC_THREE_LINE_MODEL.getID(), expressionID));
    player.send(new SetWidgetTextMessage(Interfaces.NPC_THREE_LINE_LINE_1.getID(), line1));
    player.send(new SetWidgetTextMessage(Interfaces.NPC_THREE_LINE_LINE_2.getID(), line2));
    player.send(new SetWidgetTextMessage(Interfaces.NPC_THREE_LINE_LINE_3.getID(), line3));
    player.getInterfaceSet().openDialogue(Interfaces.NPC_THREE_LINE.getID());
  }

  public static void npcFourLine(Player player, Npc n,
      Dialogues dialogue, Expressions expression, String line1, String line2, String line3, String line4) {

    NPCs npc = NPCs.get(n.getId());

    if (npc == null || player == null)
      return;

    player.setLastDialogue(dialogue);

    int expressionID = expression == null ? Expressions.DEFAULT.getAnimation() : expression.getAnimation();

    player.send(new SetWidgetModelAnimationMessage(Interfaces.NPC_FOUR_LINE_MODEL.getID(), expressionID));
    player.send(new SetWidgetNpcModelMessage(Interfaces.NPC_FOUR_LINE_MODEL.getID(), npc.getID()));
    player.send(new SetWidgetTextMessage(Interfaces.NPC_FOUR_LINE_HEADER.getID(), npc.getName()));
    player.send(new SetWidgetTextMessage(Interfaces.NPC_FOUR_LINE_LINE_1.getID(), line1));
    player.send(new SetWidgetTextMessage(Interfaces.NPC_FOUR_LINE_LINE_2.getID(), line2));
    player.send(new SetWidgetTextMessage(Interfaces.NPC_FOUR_LINE_LINE_3.getID(), line3));
    player.send(new SetWidgetTextMessage(Interfaces.NPC_FOUR_LINE_LINE_4.getID(), line4));
    player.getInterfaceSet().openDialogue(Interfaces.NPC_FOUR_LINE.getID());
  }

  public static void updateNpcFourLine(Player player,
      Dialogues dialogue, Expressions expression, String line1, String line2, String line3, String line4) {

    if (player == null)
      return;

    player.setLastDialogue(dialogue);

    int expressionID = expression == null ? Expressions.DEFAULT.getAnimation() : expression.getAnimation();

    player.send(new SetWidgetModelAnimationMessage(Interfaces.NPC_FOUR_LINE_MODEL.getID(), expressionID));
    player.send(new SetWidgetTextMessage(Interfaces.NPC_FOUR_LINE_LINE_1.getID(), line1));
    player.send(new SetWidgetTextMessage(Interfaces.NPC_FOUR_LINE_LINE_2.getID(), line2));
    player.send(new SetWidgetTextMessage(Interfaces.NPC_FOUR_LINE_LINE_3.getID(), line3));
    player.send(new SetWidgetTextMessage(Interfaces.NPC_FOUR_LINE_LINE_4.getID(), line4));
    player.getInterfaceSet().openDialogue(Interfaces.NPC_FOUR_LINE.getID());
  }

  public static void informationFourLine(Player player,String header, String line1, String line2, String line3, String line4) {

    if (player == null)
      return;

    player.send(new SetWidgetTextMessage(Interfaces.INFORMATION_LARGE_FORCED_HEADER.getID(), header));
    player.send(new SetWidgetTextMessage(Interfaces.INFORMATION_LARGE_FORCED_LINE_1.getID(), line1));
    player.send(new SetWidgetTextMessage(Interfaces.INFORMATION_LARGE_FORCED_LINE_2.getID(), line2));
    player.send(new SetWidgetTextMessage(Interfaces.INFORMATION_LARGE_FORCED_LINE_3.getID(), line3));
    player.send(new SetWidgetTextMessage(Interfaces.INFORMATION_LARGE_FORCED_LINE_4.getID(), line4));
    player.getInterfaceSet().openDialogue(Interfaces.INFORMATION_LARGE_FORCED.getID());
  }

  public static void itemOne(Player player, String header, String item1,
      int itemID, int zoom) {
    player.send(new SetWidgetItemModelMessage(Interfaces.ITEM_ONE_MODEL.getID(), itemID, zoom));
    player.send(new SetWidgetTextMessage(Interfaces.ITEM_ONE_HEADER.getID(), header));
    player.send(new SetWidgetTextMessage(Interfaces.ITEM_ONE_LINE_1.getID(), item1));
    player.getInterfaceSet().openDialogue(Interfaces.ITEM_ONE.getID());
  }

  public static void itemTwo(Player player, String header, String item1, String item2,
      int itemID, int zoom) {
    player.send(new SetWidgetItemModelMessage(Interfaces.ITEM_TWO_MODEL.getID(), itemID, zoom));
    player.send(new SetWidgetTextMessage(Interfaces.ITEM_TWO_HEADER.getID(), header));
    player.send(new SetWidgetTextMessage(Interfaces.ITEM_TWO_LINE_1.getID(), item1));
    player.send(new SetWidgetTextMessage(Interfaces.ITEM_TWO_LINE_2.getID(), item2));
    player.getInterfaceSet().openDialogue(Interfaces.ITEM_TWO.getID());
  }

}
