package essence.game;

import java.util.BitSet;

public final class UpdateFlags {

	private final BitSet bitset = new BitSet();

	public void set(UpdateFlag flag, boolean value) {
		bitset.set(flag.ordinal(), value);
	}

	public void flag(UpdateFlag flag) {
		set(flag, true);
	}

	public void unflag(UpdateFlag flag) {
		set(flag, false);
	}

	public boolean isFlagged(UpdateFlag flag) {
		return bitset.get(flag.ordinal());
	}

}
