package essence.packet.incoming;

import essence.packet.AbstractIncomingPacket;
import essence.packet.PacketClient;

public final class PingPacket extends AbstractIncomingPacket {

	public static PingPacket get(PacketClient client, long timestamp) {
		return new PingPacket(client, timestamp);
	}

	private final long timestamp;

	private PingPacket(PacketClient client, long timestamp) {
		super(client);
		this.timestamp = timestamp;
	}

	public long getTimestamp() {
		return timestamp;
	}

}
