package org.apollo.cache.decoder;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.ByteBuffer;
import org.apollo.cache.IndexedFileSystem;
import org.apollo.cache.archive.Archive;
import org.apollo.cache.def.ObjectDefinition;
import org.apollo.cache.def.VarBitDefinition;
import org.apollo.util.BufferUtil;

/**
 * Decodes object data from the {@code loc.dat} file into {@link ObjectDefinition}s.
 *
 * @author Major
 */
public final class VarBitDefinitionDecoder implements Runnable {

  /**
   * The IndexedFileSystem.
   */
  private final IndexedFileSystem fs;

  /**
   * Creates the ObjectDefinitionDecoder.
   *
   * @param fs The {@link IndexedFileSystem}.
   */
  public VarBitDefinitionDecoder(IndexedFileSystem fs) {
    this.fs = fs;
  }

  @Override
  public void run() {
    try {
      Archive config = fs.getArchive(0, 2);
      ByteBuffer data = config.getEntry("varbit.dat").getBuffer();

      int count = data.getShort();

      VarBitDefinition[] definitions = new VarBitDefinition[count];
      for (int i = 0; i < count; i++) {
        definitions[i] = decode(i, data);
      }

      VarBitDefinition.definitions = definitions;
      System.out.println("Loaded varbit defs");
    } catch (IOException e) {
      throw new UncheckedIOException("Error decoding ObjectDefinitions.", e);
    }
  }

  /**
   * Decodes data from the cache into an {@link ObjectDefinition}.
   *
   * @param id   The id of the object.
   * @param data The {@link ByteBuffer} containing the data.
   * @return The object definition.
   */
  private VarBitDefinition decode(int id, ByteBuffer data) {
    boolean updateInCache = false;
    int leastSignificantBit = -1;
    int mostSignificantBit = -1;
    int baseVarp = -1;

    while (true) {
      int opcode = data.get() & 0xFF;

      if (opcode == 0) {
        return new VarBitDefinition(id, updateInCache, leastSignificantBit, mostSignificantBit,
            baseVarp);
      } else if (opcode == 1) {
        baseVarp = data.getShort();
        leastSignificantBit = data.get() & 0xFF;
        mostSignificantBit = data.get() & 0xFF;
      } else if (opcode == 10) {
        BufferUtil.readString(data);; // dummy
      } else if (opcode == 2) {
        updateInCache = true;
      } else if (opcode == 3) {
        data.getInt(); // dummy
      } else if (opcode == 4) {
        data.getInt(); // dummy
      } else if (opcode == 5) {
        updateInCache = false;
      }
    }
  }

}