package essence.packet.game;

import essence.packet.Packet;

public final class PingPacket implements Packet {

	public static PingPacket get(long timestamp) {
		return new PingPacket(timestamp);
	}

	private final long timestamp;

	private PingPacket(long timestamp) {
		this.timestamp = timestamp;
	}

	public long getTimestamp() {
		return timestamp;
	}

}
