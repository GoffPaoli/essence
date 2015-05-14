package essence.packet;

public abstract class PacketClientEvent {

	private final PacketClient client;
	private final Packet packet;

	protected PacketClientEvent(PacketClient client, Packet packet) {
		this.client = client;
		this.packet = packet;
	}

	public final PacketClient getClient() {
		return client;
	}

	public final Packet getPacket() {
		return packet;
	}

}
