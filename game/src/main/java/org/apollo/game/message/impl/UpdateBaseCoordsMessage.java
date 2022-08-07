package org.apollo.game.message.impl;

import org.apollo.net.message.Message;

public final class UpdateBaseCoordsMessage extends Message {

	public final int baseX;

  	public final int baseY;

	public UpdateBaseCoordsMessage(int baseX, int baseY) {
		this.baseX = baseX;
		this.baseY = baseY;
	}
}