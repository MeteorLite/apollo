package org.apollo.cache.def;

import com.google.common.base.Preconditions;

/**
 * Represents a VarBit.
 *
 * @author Major
 */
public final class VarBitDefinition {

  public static VarBitDefinition[] definitions;

  public final int id;
  public final boolean updateInCache;

  public final int leastSignificantBit;

  public final int mostSignificantBit;

  public final int baseVarp;

  public VarBitDefinition(int id,
      boolean updateInCache, int leastSignificantBit,
      int mostSignificantBit, int baseVarp) {
    this.id = id;
    this.updateInCache = updateInCache;
    this.leastSignificantBit = leastSignificantBit;
    this.mostSignificantBit = mostSignificantBit;
    this.baseVarp = baseVarp;
  }

  public static VarBitDefinition get(int id) {
    return definitions[id];
  }
}