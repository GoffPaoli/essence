package essence.packet.game;

public final class PingPacket {

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
