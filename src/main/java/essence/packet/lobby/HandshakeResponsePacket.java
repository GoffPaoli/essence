package essence.packet.lobby;

import essence.packet.Packet;

public final class HandshakeResponsePacket implements Packet {

	public static HandshakeResponsePacket get(int id, long sessionKey) {
		return new HandshakeResponsePacket(id, sessionKey);
	}

	private final int id;
	private final long sessionKey;

	private HandshakeResponsePacket(int id, long sessionKey) {
		this.id = id;
		this.sessionKey = sessionKey;
	}

	public int getID() {
		return id;
	}

	public long getSessionKey() {
		return sessionKey;
	}

}
