import org.apollo.game.model.Position
import org.apollo.game.model.entity.obj.DynamicGameObject

object Fires {
    val fireMap = HashMap<Position, Fire>()

    fun getFireAt(position: Position) : Fire? {
        for (pos in fireMap.keys) {
            if (position == pos)
                return fireMap[position]!!
        }
        return null
    }

    fun setFireAt(position: Position, fire: Fire) {
        fireMap[position] = fire
    }
}

class Fire(val obj: DynamicGameObject, val logInfo: Logs, var pulses: Int)