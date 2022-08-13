package org.apollo.game.model.var;

import org.apollo.cache.def.VarBitDefinition;
import org.apollo.game.message.impl.ConfigMessage;
import org.apollo.game.model.entity.Player;

public class VarsManager {

	public static final int[] masklookup = new int[32];

	static {
		int i = 2;
		for (int i2 = 0; i2 < 32; i2++) {
			masklookup[i2] = i - 1;
			i += i;
		}
	}

	private int[] values;

	public VarsManager() {
		values = new int[VarBitDefinition.definitions.length];
	}

	@Deprecated
	public void sendVarOld(int id, int value) {
		// sendVar(id, value, false);
	}

	@Deprecated
	public void forceSendVarOld(int id, int value) {
		// sendVar(id, value, true);
	}


	private boolean sendVar(int id, int value, boolean force, Player p) {
		if (id < 0 || id >= values.length) // temporarly
			return false;
		if (!force && values[id] == value)
			return false;
		setVar(id, value);
		sendVarPacket(p, id);
		return true;
	}

	public void setVar(int id, int value) {
		values[id] = value;
	}
	
	public int getValue(int id) {
		//System.out.println("CosmeticConditionType.VAR, "+id+", ");
		return values[id];
	}

	@Deprecated
	public void forceSendVarBitOld(int id, int value) {
		// setVarBit(id, value, 0x1 | 0x2);
	}

	public void forceSendVarBit(int id, int value, Player p) {
		if (!setVarBit(id, value, 0x1 | 0x2, p))
      System.out.println("Didnt update varbit " + id);
	}

	@Deprecated
	public void sendVarBitOld(int id, int value) {
		// setVarBit(id, value, 0x1);
	}

	@Deprecated
	public void setVarBitOld(int id, int value, Player p) {
		setVarBit(id, value, 0, p);
	}


	public int getBitValue(int id) {
		VarBitDefinition defs = VarBitDefinition.get(id);
		return values[defs.baseVarp] >> defs.leastSignificantBit & masklookup[defs.mostSignificantBit - defs.leastSignificantBit];
	}
	
	public int getBitValue(int var, int shift) {
		for (int id = VarBitDefinition.definitions.length - 1; id >= 0; id--) {
			VarBitDefinition def = VarBitDefinition.get(id);
			
			if (def.baseVarp == var && def.leastSignificantBit == shift && def.mostSignificantBit == shift)
				return getBitValue(id);
		}
		
		return (getValue(var)  >> shift) & 0x1;
	}
	
	public int getPrintBitValue(int var, int shift) {
		for (int id = VarBitDefinition.definitions.length - 1; id >= 0; id--) {
      VarBitDefinition def = VarBitDefinition.get(id);
			
			if (def.baseVarp == var && def.leastSignificantBit == shift && def.mostSignificantBit == shift)
				return getPrintBitValue(id);
		}
		//System.out.print(var + " VAR_SHIFT: "+shift);
		return (getValue(var)  >> shift) & 0x1;
	}
	
	public int getPrintBitValue(int id) {
    VarBitDefinition defs = VarBitDefinition.get(id);
		int value = values[defs.baseVarp] >> defs.leastSignificantBit & masklookup[defs.mostSignificantBit - defs.leastSignificantBit];
		
		//System.out.print(id);
		return value;
	}
	
	public boolean isBit(int type, int id, int check) {
    VarBitDefinition defs = VarBitDefinition.get(id);
		int value = values[defs.baseVarp] >> defs.leastSignificantBit & masklookup[defs.mostSignificantBit - defs.leastSignificantBit];

		if (type == 0)
			return value == check;
		else if (type == 1)
			return value > check;
		else if (type == 2)
			return value < check;
		throw new IllegalStateException();
	}

	private boolean setVarBit(int id, int value, int flag, Player p) {
		VarBitDefinition defs = VarBitDefinition.get(id);
		int mask = masklookup[defs.mostSignificantBit - defs.leastSignificantBit];
		if (value < 0 || value > mask)
			return false;
		mask <<= defs.leastSignificantBit;
		int varpValue = (values[defs.baseVarp] & (~mask) | value << defs.leastSignificantBit & mask);
		if ((flag & 0x2) != 0 || varpValue != values[defs.baseVarp]) {
			setVar(defs.baseVarp, varpValue);
			if ((flag & 0x1) != 0)
				sendVarPacket(p, defs.baseVarp);
			return true;
		}
		return false;
	}

	@SuppressWarnings("deprecation")
	private void sendVarPacket(Player p, int id) {
    p.send(new ConfigMessage(id, values[id]));
	}
}