import org.apollo.game.def.*
import org.apollo.game.dialogue.Dialogue
import org.apollo.game.message.impl.*
import org.apollo.game.model.Direction
import org.apollo.game.model.Position
import org.apollo.game.model.inter.InterfaceConstants
import org.apollo.game.plugin.kotlin.message.ButtonClick

 on(ButtonClick) {
     if (player.tutorialProgress < 27) {
         when (button) {
             Interfaces.ACCEPT_PLAYER_APPEARANCE_BUTTON.id -> {
                 player.setHasAppearance(true)
                 player.tutorialStepTwo()
             }
         }
     }

         player.sendMessage("Button clicked: $button")
 }

 on { ObjectActionMessage::class }
     .where { id == GameObjects.DOOR.id }
     .then { player ->
        if (player.tutorialProgress == 1) {
            if (position.x == 3098 && position.y == 3107) {
                val lockedDoor = LockedDoor.find(player, player.world, position, id) ?: return@then
                lockedDoor.directionToMove = Direction.EAST
                if ( player.tutorialProgress == 1 && player.position.x < position.x) {
                    OpenLockedDoorAction.start(this, player, lockedDoor, position)
                    player.tutorialProgress = 2
                }
            }
            terminate()
        }
     }

 on { NpcActionMessage::class }
     .then { player ->
         val entity = player.world.npcRepository[index]
         if (entity.id == NPCs.RUNESCAPE_GUIDE.id) {
             player.lastChattingNPC = entity
             Dialogue.npcTwoLine(player, entity, Dialogues.RUNESCAPE_GUIDE_0,
                 null,
                 "Greetings! I see you are a new arrival to this land. My",
                 "job is to welcome all new visitors. So welcome!")
             terminate()
         } else if (entity.id == NPCs.SURVIVAL_GUIDE.id) {
             Dialogue.npcFourLine(player, entity, Dialogues.SURVIVAL_EXPERT_0,
                 null,
                 "Hello there, newcomer. My name is Brynna. My job is",
                 "to teach you a few survival tips and tricks. First off",
                 "we're going to start with the most basic survival skill of",
                 "all, making a fire.")
             terminate()
         }
     }

 on { DialogueContinueMessage::class }
     .then { player ->
         when (player.lastDialogue) {
             Dialogues.RUNESCAPE_GUIDE_0 -> {
                 Dialogue.updateNpcTwoLine(player, Dialogues.RUNESCAPE_GUIDE_1,
                     null,
                     "You have already learnt the first thing needed to",
                     "succeed in this world... talking to other people!")
                 terminate()
             }
             Dialogues.RUNESCAPE_GUIDE_1 -> {
                 Dialogue.npcThreeLine(player, player.lastChattingNPC, Dialogues.RUNESCAPE_GUIDE_2,
                     null,
                     "You will find many inhabitants of this world have useful",
                     "things to say to you. By clicking on them with your",
                     "mouse you can talk to them.")
                 terminate()
             }
             Dialogues.RUNESCAPE_GUIDE_2 -> {
                 Dialogue.updateNpcThreeLine(player, Dialogues.RUNESCAPE_GUIDE_3,
                     null,
                     "I would also suggest reading through some of the",
                     "supporting information on the website. There you can",
                     "find maps, a bestiary and much more.")
                 terminate()
             }
             Dialogues.RUNESCAPE_GUIDE_3 -> {
                 Dialogue.npcTwoLine(player, player.lastChattingNPC, Dialogues.RUNESCAPE_GUIDE_4,
                     null,
                     "You will notice a flashing icon of a wrench, please click",
                     "on this to continue the tutorial.")
                 val tabs = InterfaceConstants.TUTORIAL_STEP_1_TABS
                 for (tab in tabs.indices) {
                     player.send(SwitchTabInterfaceMessage(tab, tabs[tab]))
                 }
                 player.send(FlashTabInterfaceMessage(11))
                 terminate()
             }
             Dialogues.RUNESCAPE_GUIDE_4 -> {
                 Dialogue.informationFourLine(player, "@blu@Player controls",
                     "Please click on the flashing wrench icon found at the bottom",
                     "right of your screen. This will display your player controls.",
                     "",
                     "")
                 terminate()
             }
             Dialogues.RUNESCAPE_GUIDE_5 -> {
                 player.tutorialStepThree()
                 terminate()
             }
             Dialogues.SURVIVAL_EXPERT_0 -> {
                 player.inventory.add(Items.BRONZE_AXE.id, 1)
                 player.inventory.add(Items.TINDERBOX.id, 1)
                 player.lastDialogue = Dialogues.SURVIVAL_EXPERT_1
                 Dialogue.itemTwo(player,
                     "",
                     "The Survival Guide gives you a @blu@tinderbox@bla@ and a",
                     "@blu@bronze axe!", Items.TINDERBOX.id, 150)
                 player.send(ConfigMessage(Configs.TUTORIAL_PROGRESS_BAR_PROGRESS.id, 2));
                 terminate()
             }
             Dialogues.SURVIVAL_EXPERT_1 -> {
                 val tabs = InterfaceConstants.TUTORIAL_STEP_2_TABS
                 for (tab in tabs.indices) {
                     player.send(SwitchTabInterfaceMessage(tab, tabs[tab]))
                 }
                 player.send(FlashTabInterfaceMessage(3))
                 player.lastDialogue = Dialogues.SURVIVAL_EXPERT_2
                 Dialogue.informationFourLine(player,
                     "@blu@Viewing the items you were given.",
                     "Click on the flashing backpack icon to the right hand side of",
                     "the main window to view your inventory. Your inventory is a list",
                     "of everything you have on your backpack.",
                     "")
                 terminate()
             }
             Dialogues.SURVIVAL_EXPERT_3 -> {
                 player.send(PositionHintIconMessage.reset())
                 player.lastDialogue = Dialogues.SURVIVAL_EXPERT_4
                 Dialogue.informationFourLine(player,
                     "@blu@Making a fire",
                     "Well done! You managed to cut some logs from the tree! Next,",
                     "use the tinderbox in your inventory to light the logs.",
                     "First click on the tinderbox to use it.",
                     "Then click on the logs in your inventory to light them.")
                 terminate()
             }
             else -> {}
         }
     }

 on { FlashingTabClickedMessage::class}
     .then {player ->
         when (tab) {
             11 -> {
                 Dialogue.npcTwoLine(player, player.lastChattingNPC, Dialogues.RUNESCAPE_GUIDE_5,
                     null,
                     "To continue the tutorial go through the door over",
                     "there and speak to your first instructor")
                 terminate()
             }
             3 -> {
                 //send(new ConfigMessage(TUTORIAL_PROGRESS_BAR_PROGRESS.getID(), 2));
                 player.send(PositionHintIconMessage(HintIconMessage.Type.EAST, Position(3099, 3096), 115))
                 Dialogue.informationFourLine(player,
                     "@blu@Cut down a tree",
                     "You can click on the backpack icon at any time to view the",
                     "items that you currently have in your inventory. You will see",
                     "that you now have an axe in your inventory. Use this to get",
                     "some logs by clicking on the indicated tree.")
                 terminate()
             }
         }

     }

