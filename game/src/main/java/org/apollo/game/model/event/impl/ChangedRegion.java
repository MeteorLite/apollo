package org.apollo.game.model.event.impl;

import org.apollo.game.model.entity.Player;
import org.apollo.game.model.event.PlayerEvent;

/**
 * A {@link PlayerEvent} that is fired when a {@link Player} changes regions.
 *
 * @author Major
 */
public final class ChangedRegion extends PlayerEvent {

  private final int regionID;

  /**
   * Creates the ChangedRegion.
   *
   * @param player The {@link Player} logging in.
   */
  public ChangedRegion(Player player, int regionID) {
    super(player);
    this.regionID = regionID;
  }

}