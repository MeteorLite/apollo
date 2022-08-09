package org.apollo.game.release.r377;

import org.apollo.game.message.impl.SongMessage;
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
public final class SendPlaySongMessageEncoder extends MessageEncoder<SongMessage> {

  @Override
  public GamePacket encode(SongMessage message) {
    GamePacketBuilder builder = new GamePacketBuilder(220, PacketType.FIXED);
    builder.put(DataType.SHORT, message.getId());
    return builder.toGamePacket();
  }
}