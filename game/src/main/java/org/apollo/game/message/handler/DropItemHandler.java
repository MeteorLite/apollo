package org.apollo.game.message.handler;

import static org.apollo.game.model.entity.EquipmentConstants.SHIELD;
import static org.apollo.game.model.entity.EquipmentConstants.WEAPON;
import static org.apollo.game.model.inv.SynchronizationInventoryListener.INVENTORY_ID;
import org.apollo.cache.def.EquipmentDefinition;
import org.apollo.game.message.impl.ItemOptionMessage;
import org.apollo.game.message.impl.SendTileItemMessage;
import org.apollo.game.model.Item;
import org.apollo.game.model.Position;
import org.apollo.game.model.World;
import org.apollo.game.model.area.Region;
import org.apollo.game.model.entity.GroundItem;
import org.apollo.game.model.entity.Player;
import org.apollo.game.model.entity.Skill;
import org.apollo.game.model.entity.SkillSet;
import org.apollo.game.model.inv.Inventory;
import org.apollo.util.LanguageUtil;

/**
 * A {@link MessageHandler} that equips items.
 *
 * @author Major
 * @author Graham
 * @author Ryley
 */
public final class DropItemHandler extends MessageHandler<ItemOptionMessage> {

	/**
	 * The option used when equipping an item.
	 */
	private static final int DROP_OPTION = 4;

	/**
	 * Creates the EquipItemHandler.
	 *
	 * @param world The {@link World} the {@link ItemOptionMessage} occurred in.
	 */
	public DropItemHandler(World world) {
		super(world);
	}

	@Override
	public void handle(Player player, ItemOptionMessage message) {
		if (message.getInterfaceId() != INVENTORY_ID) {
			return;
		}

		if (message.getOption() != DROP_OPTION) {
		  return;
		}

		int inventorySlot = message.getSlot();
		Inventory inventory = player.getInventory();

		Item dropping = inventory.get(inventorySlot);
		int droppingID = dropping.getId();

		//player.getInventory().removeSlot(inventorySlot, droppingID);
		Position position = player.getPosition();
		player.send(new SendTileItemMessage(dropping, position.getX(), position.getY()));
	}
}