
import org.apollo.game.model.entity.setting.PrivilegeLevel

on_command("welcome", PrivilegeLevel.ADMINISTRATOR)
    .then { player ->
        player.interfaceSet.openOverlay(651)
    }