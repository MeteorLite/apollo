import org.apollo.game.message.impl.SongMessage
import org.apollo.game.model.entity.setting.PrivilegeLevel

on_command("song", PrivilegeLevel.MODERATOR)
        .then { player ->
            if (arguments.size != 1) {
                player.sendMessage("Invalid syntax - ::sound [id]")
                return@then
            }

            val id: Int
            try {
                id = arguments[0].toInt()
            } catch (_: Exception) {
                player.sendMessage("Invalid syntax - ::song [id]")
                return@then
            }
            if (!(0..65535).contains(id)) {
                player.sendMessage("Invalid syntax - ::song [id] (0..65536)")
                return@then
            }

            player.send(SongMessage(id))
            player.sendMessage("Played song: ID:$id")
        }