import org.apollo.game.message.impl.OpenInterfaceMessage
import org.apollo.game.message.impl.SoundEffectMessage
import org.apollo.game.model.entity.setting.PrivilegeLevel

on_command("interface", PrivilegeLevel.MODERATOR)
        .then { player ->
            if (arguments.size != 1) {
                player.sendMessage("Invalid syntax - ::interface [id]")
                return@then
            }

            var id = -1
            try {
                id = arguments[0].toInt()


            } catch (_: Exception) {
                player.sendMessage("Invalid syntax - ::interface [id]")
                return@then
            }
            if (!(0..65535).contains(id)) {
                player.sendMessage("Invalid syntax - ::interface [id] (0..65536)")
                return@then
            }

            player.send(
                OpenInterfaceMessage(
                    id
                )
            )

            player.sendMessage("Opened interface: ID:$id")
        }