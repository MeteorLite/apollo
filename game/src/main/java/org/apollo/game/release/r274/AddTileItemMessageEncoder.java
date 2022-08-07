package org.apollo.game.release.r274;

import org.apollo.game.message.impl.SendTileItemMessage;
import org.apollo.net.codec.game.DataOrder;
import org.apollo.net.codec.game.DataTransformation;
import org.apollo.net.codec.game.DataType;
import org.apollo.net.codec.game.GamePacket;
import org.apollo.net.codec.game.GamePacketBuilder;
import org.apollo.net.release.MessageEncoder;

/**
 * A {@link MessageEncoder} for the {@link SendTileItemMessage}.
 *
 * @author Major
 */
public final class AddTileItemMessageEncoder extends MessageEncoder<SendTileItemMessage> {

	@Override
	public GamePacket encode(SendTileItemMessage message) {
	  	System.out.println("encoded sendTileItem");
		GamePacketBuilder builder = new GamePacketBuilder(81);
		builder.put(DataType.SHORT, message.getX());
	  	builder.put(DataType.SHORT, message.getY());
	  	builder.put(DataType.SHORT, message.getId());
		builder.put(DataType.SHORT, message.getAmount());

		return builder.toGamePacket();
	}
}