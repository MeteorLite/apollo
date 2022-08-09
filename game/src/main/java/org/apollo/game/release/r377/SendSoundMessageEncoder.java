package org.apollo.game.release.r377;

import org.apollo.game.message.impl.SoundEffectMessage;
import org.apollo.net.codec.game.DataType;
import org.apollo.net.codec.game.GamePacket;
import org.apollo.net.codec.game.GamePacketBuilder;
import org.apollo.net.meta.PacketType;
import org.apollo.net.release.MessageEncoder;

/**
 * A {@link MessageEncoder} for the {@link SoundEffectMessage}.
 *
 * @author tlf30
 */
public final class SendSoundMessageEncoder extends MessageEncoder<SoundEffectMessage> {

  @Override
  public GamePacket encode(SoundEffectMessage message) {
    GamePacketBuilder builder = new GamePacketBuilder(26, PacketType.FIXED);
    builder.put(DataType.SHORT, message.getId());
    builder.put(DataType.BYTE,  message.getType());
    builder.put(DataType.SHORT, message.getDelay());
    return builder.toGamePacket();
  }
}