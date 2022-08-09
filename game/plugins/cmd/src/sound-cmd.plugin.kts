import org.apollo.game.message.impl.SoundEffectMessage
import org.apollo.game.model.entity.setting.PrivilegeLevel

on_command("sound", PrivilegeLevel.MODERATOR)
        .then { player ->
            if (arguments.size != 3) {
                player.sendMessage("Invalid syntax - ::sound [id] [type] [delay]")
                return@then
            }

            var id = -1
            var type = -1
            var delay = -1
            try {
                id = arguments[0].toInt()
                type = arguments[1].toInt()
                delay = arguments[2].toInt()


            } catch (_: Exception) {
                player.sendMessage("Invalid syntax - ::sound [id] [type] [delay]")
                return@then
            }
            if (!(0..65535).contains(id)
                    || !(0..65535).contains(type)
                    || !(0..65535).contains(id)) {
                player.sendMessage("Invalid syntax - ::sound [id] [type] [delay] (0..65536)")
                return@then
            }

            if (delay == 0)
                delay = 65535

            player.send(
                SoundEffectMessage(
                    id,
                    type,
                    delay
                )
            )
            player.sendMessage("Played sound: ID:$id type:$type delay:$delay")
        }