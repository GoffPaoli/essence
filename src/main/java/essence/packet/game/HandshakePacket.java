package essence.packet.game;

import essence.packet.Packet;

public final class HandshakePacket implements Packet {

	public static HandshakePacket get(int nameHash) {
		return new HandshakePacket(nameHash);
	}

	private final int nameHash;

	private HandshakePacket(int nameHash) {
		this.nameHash = nameHash;
	}

	public int getNameHash() {
		return nameHash;
	}

}
