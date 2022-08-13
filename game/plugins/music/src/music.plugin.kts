import org.apollo.game.def.Songs
import org.apollo.game.message.impl.SongMessage
import org.apollo.game.model.event.impl.ChangedRegion

on_player_event { ChangedRegion::class }
    .then {
        val regionID = world.regionRepository.fromPosition(it.position).regionID
        Songs.get(regionID)?.let { song ->
            it.send(SongMessage(song.id))
        }
    }