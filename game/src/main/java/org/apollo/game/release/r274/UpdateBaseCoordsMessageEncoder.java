package org.apollo.game.release.r274;

import org.apollo.game.message.impl.UpdateBaseCoordsMessage;
import org.apollo.game.message.impl.UpdateWeightMessage;
import org.apollo.net.codec.game.DataType;
import org.apollo.net.codec.game.GamePacket;
import org.apollo.net.codec.game.GamePacketBuilder;
import org.apollo.net.release.MessageEncoder;

public final class UpdateBaseCoordsMessageEncoder extends MessageEncoder<UpdateBaseCoordsMessage> {
	@Override
	public GamePacket encode(UpdateBaseCoordsMessage message) {
		GamePacketBuilder builder = new GamePacketBuilder(32);
		builder.put(DataType.INT, message.baseX);
	  	builder.put(DataType.INT, message.baseY);
		return builder.toGamePacket();
	}
}