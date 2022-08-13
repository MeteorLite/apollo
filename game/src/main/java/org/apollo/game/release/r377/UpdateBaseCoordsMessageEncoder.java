package org.apollo.game.release.r377;

import org.apollo.game.message.impl.UpdateBaseCoordsMessage;
import org.apollo.game.message.impl.UpdateSkillMessage;
import org.apollo.game.model.entity.Skill;
import org.apollo.net.codec.game.DataTransformation;
import org.apollo.net.codec.game.DataType;
import org.apollo.net.codec.game.GamePacket;
import org.apollo.net.codec.game.GamePacketBuilder;
import org.apollo.net.release.MessageEncoder;

public final class UpdateBaseCoordsMessageEncoder extends MessageEncoder<UpdateBaseCoordsMessage> {

  @Override
  public GamePacket encode(UpdateBaseCoordsMessage message) {
    GamePacketBuilder builder = new GamePacketBuilder(75);

    builder.put(DataType.BYTE, DataTransformation.NEGATE, message.getBaseX());
    builder.put(DataType.BYTE, DataTransformation.ADD, message.getBaseY());

    return builder.toGamePacket();
  }

}
