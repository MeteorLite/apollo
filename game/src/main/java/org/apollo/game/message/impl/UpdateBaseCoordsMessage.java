package org.apollo.game.message.impl;

import org.apollo.game.model.Item;
import org.apollo.net.message.Message;

/**
 * A {@link Message} sent to the client that updates all the items in an interface.
 *
 * @author Graham
 */
public final class UpdateBaseCoordsMessage extends Message {

  private final int baseX;

  private final int baseY;


  public UpdateBaseCoordsMessage(int baseX, int baseY) {
    this.baseX = baseX;
    this.baseY = baseY;
  }

  public int getBaseX() {
    return baseX;
  }

  public int getBaseY() {
    return baseY;
  }

}