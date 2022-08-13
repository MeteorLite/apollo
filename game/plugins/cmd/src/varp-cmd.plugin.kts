import org.apollo.game.message.impl.OpenInterfaceMessage
import org.apollo.game.message.impl.SoundEffectMessage
import org.apollo.game.model.entity.setting.PrivilegeLevel

on_command("varbit", PrivilegeLevel.MODERATOR)
        .then { player ->
            if (arguments.size != 2) {
                player.sendMessage("Invalid syntax - ::varbit [id] [value]")
                return@then
            }
            //50
            var id = -1
            var value = -1
            try {
                id = arguments[0].toInt()
                value = arguments[1].toInt()

            } catch (_: Exception) {
                player.sendMessage("Invalid syntax - ::varbit [id] [value]")
                return@then
            }
            if (!(0..65535).contains(id)) {
                player.sendMessage("Invalid syntax - ::varbit [id] [value] (0..65536)")
                return@then
            }

            world.varsManager.forceSendVarBit(id, value, player)

            player.sendMessage("sent varbit: ID:$id Value:$value")
        }