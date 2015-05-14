package essence.packet.outgoing;

import essence.packet.OutgoingPacket;

public final class PlayerDetailsPacket implements OutgoingPacket {

	public static PlayerDetailsPacket get(boolean isMember, int playerIndex) {
		return new PlayerDetailsPacket(isMember, playerIndex);
	}

	private final boolean isMember;
	private final int playerIndex;

	private PlayerDetailsPacket(boolean isMember, int playerIndex) {
		this.isMember = isMember;
		this.playerIndex = playerIndex;
	}

	public boolean isMember() {
		return isMember;
	}

	public int getPlayerIndex() {
		return playerIndex;
	}

}
