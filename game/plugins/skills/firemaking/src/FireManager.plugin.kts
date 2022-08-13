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
                    player.sendMessage(Item)
                }
            }
        }
    }