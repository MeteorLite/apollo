import org.apollo.game.message.impl.ObjectActionMessage

/**
 * Hook into the [ObjectActionMessage] and listens for a supported door [GameObject]
 */
on { ObjectActionMessage::class }
        .where { option == 1 }
        .then {player ->
            val door = Door.find(player.world, position, id) ?: return@then
            if (player.tutorialProgress == 26) {
                if (door.supported()) {
                    OpenDoorAction.start(this, player, door, position)
                }
            }
        }