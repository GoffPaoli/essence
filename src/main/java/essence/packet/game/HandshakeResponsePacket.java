package essence.packet.game;

import essence.packet.Packet;

public final class HandshakeResponsePacket implements Packet {

	public static HandshakeResponsePacket get(int response, long sessionKey) {
		return new HandshakeResponsePacket(response, sessionKey);
	}

	private final int response;
	private final long sessionKey;

	private HandshakeResponsePacket(int response, long sessionKey) {
		this.response = response;
		this.sessionKey = sessionKey;
	}

	public int getResponse() {
		return response;
	}

	public long getSessionKey() {
		return sessionKey;
	}

}
