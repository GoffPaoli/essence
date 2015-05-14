package essence.packet.incoming;

import essence.packet.AbstractIncomingPacket;
import essence.packet.PacketClient;

public final class HandshakePacket extends AbstractIncomingPacket {

	public static HandshakePacket get(PacketClient client, int nameHash) {
		return new HandshakePacket(client, nameHash);
	}

	private final int nameHash;

	private HandshakePacket(PacketClient client, int nameHash) {
		super(client);
		this.nameHash = nameHash;
	}

	public int getNameHash() {
		return nameHash;
	}

}
