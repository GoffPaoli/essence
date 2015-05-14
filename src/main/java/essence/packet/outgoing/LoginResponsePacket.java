package essence.packet.outgoing;

import essence.packet.OutgoingPacket;

public final class LoginResponsePacket implements OutgoingPacket {

	public static LoginResponsePacket get(int id, int crown, boolean flagged) {
		return new LoginResponsePacket(id, crown, flagged);
	}

	private final int id;
	private final int crown;
	private final boolean flagged;

	private LoginResponsePacket(int id, int crown, boolean flagged) {
		this.id = id;
		this.crown = crown;
		this.flagged = flagged;
	}

	public int getID() {
		return id;
	}

	public int getCrown() {
		return crown;
	}

	public boolean isFlagged() {
		return flagged;
	}

}
