import org.apollo.cache.def.ItemDefinition
import org.apollo.game.action.ActionBlock
import org.apollo.game.action.AsyncDistancedAction
import org.apollo.game.def.Animations
import org.apollo.game.def.GameObjects
import org.apollo.game.def.Items
import org.apollo.game.def.SoundEffects
import org.apollo.game.message.impl.ItemOnItemMessage
import org.apollo.game.message.impl.ObjectActionMessage
import org.apollo.game.message.impl.SoundEffectMessage
import org.apollo.game.model.Animation
import org.apollo.game.model.Position
import org.apollo.game.model.entity.Player
import org.apollo.game.model.entity.Skill
import org.apollo.game.model.entity.obj.DynamicGameObject
import org.apollo.game.plugin.api.woodcutting
import org.apollo.game.plugin.skills.woodcutting.Axe
import java.util.*

on { ItemOnItemMessage::class }
    .then { player ->
        val log = Logs.getFromIDs(id, targetId)
        log?.let {
            if (player.inventory.contains(it.id) && player.inventory.contains(Items.TINDERBOX.id)) {
                FiremakingAction.start(this, player, it)
            }
        }
    }

class FiremakingAction(
    player: Player
) : AsyncDistancedAction<Player>(DELAY, true, player, player.position, 0) {

    companion object {
        private const val DELAY = 0
        val minChance = 65.0
        val perLvlChance = 4.57
        val rand = Random(257)
        var logs: Logs? = null

        /**
         * Starts a [WoodcuttingAction] for the specified [Player], terminating the [ObjectActionMessage] that triggered
         * it.
         */
        fun start(message: ItemOnItemMessage, player: Player, logs: Logs) {
            Companion.logs = logs
            val axe = Axe.bestFor(player)
            if (axe != null) {
                if (player.inventory.freeSlots() == 0) {
                    player.inventory.forceCapacityExceeded()
                    return
                }

                val action = FiremakingAction(
                    player
                )
                player.startAction(action)
            } else {
                player.sendMessage("You do not have an axe for which you have the level to use.")
            }

            message.terminate()
        }
    }

    override fun action(): ActionBlock = {
        mob.turnTo(position)

        val level = mob.woodcutting.current
        if (level < logs!!.level) {
            val itemName = ItemDefinition.lookup(logs!!.id).name
            mob.sendMessage("You need a firemaking level of ${logs!!.level} to light $itemName")
            stop()
        }

        while (isRunning) {
            val playerChance =
                ((mob.skillSet.getSkill(Skill.FIREMAKING).currentLevel - 1) * perLvlChance) + minChance
            val nextRand = rand.nextDouble(256.0)
            val successful = (nextRand < playerChance)

            mob.playAnimation(Animations.FIREMAKING.id, 0)
            mob.sendMessage("pChance $playerChance : rand $nextRand")

            if (successful) {
                mob.playAnimation(Animations.STOP.id, 0)
                mob.send(SoundEffectMessage(SoundEffects.FIRE_SUCCESSFUL.id))
                var firePos = Position(mob.position.x + 1, mob.position.y, mob.position.height)
                //never award xp without checking a successful input removal
                if (mob.inventory.remove(logs!!.id)) {
                    mob.skillSet.addExperience(Skill.FIREMAKING, logs!!.experience)
                    val fireSpawn = DynamicGameObject.createPublic(
                        mob.world, GameObjects.FIRE_NORMAL.id, firePos, 10, 1)
                    mob.world.regionRepository.fromPosition(position).addEntity(fireSpawn)
                    stop()
                }
            }

            wait(3)
        }
    }
}