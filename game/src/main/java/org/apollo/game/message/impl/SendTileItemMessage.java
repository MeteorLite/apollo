package org.apollo.game.message.impl;

import org.apollo.game.model.Item;
import org.apollo.net.message.Message;

/**
 * A {@link Message} sent to the client that adds an item to a tile.
 *
 * @author Major
 */
public final class SendTileItemMessage extends RegionUpdateMessage {

	/**
	 * The item to add to the tile.
	 */
	private final Item item;

	/**
	 * The position offset
	 */
	private final int x;

  	private final int y;

	/**
	 * Creates the SendTileItemMessage.
	 *
	 * @param item The item to add to the tile.
	 * @param x The world X coordinate
	 * @param y The world Y coordinate
	 */
	public SendTileItemMessage(Item item, int x, int y) {
		this.item = item;
		this.x = x;
		this.y = y;
	}

	/**
	 * Gets the id of the item.
	 *
	 * @return The id.
	 */
	public int getId() {
		return item.getId();
	}

  public int getX() {
	return x;
  }

  public int getY() {
	return y;
  }

	/**
	 * Gets the amount of the item.
	 *
	 * @return The amount.
	 */
	public int getAmount() {
		return item.getAmount();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SendTileItemMessage) {
			SendTileItemMessage other = (SendTileItemMessage) obj;
			return item.equals(other.item) && x == other.x && other.y == y;
		}

		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		return item.hashCode() * prime + x * prime + y * prime;
	}

	@Override
	public int priority() {
		return LOW_PRIORITY;
	}

}