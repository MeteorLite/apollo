import org.apollo.game.message.impl.SendTileItemMessage
import org.apollo.game.model.Item
import org.apollo.game.model.Position
import org.apollo.game.model.event.impl.Pulse

on_event { Pulse::class }
    .then {
        var burnPulses = 0;
        for (map in Fires.fireMap) {
            when (map.value.logInfo) {
                Logs.LOG -> {
                    burnPulses = 75
                }
                else -> {}
            }
            if (map.value.pulses >= burnPulses) {
                world.regionRepository.fromPosition(map.key).removeEntity(map.value.obj)
                for (player in world.playerRepository) {
                    val region = world.regionRepository.fromPosition(map.value.obj.position)
                    if (region.contains(player.position)) {
                        val pos = Position(map.value.obj.position.localX, map.value.obj.position.localY)
                        player.send(SendTileItemMessage(Item(592), pos))
                    }
                }
            }
        }
    }