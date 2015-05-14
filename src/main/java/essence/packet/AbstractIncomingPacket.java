package essence.packet;

public abstract class AbstractIncomingPacket implements IncomingPacket {

	private final PacketClient client;

	protected AbstractIncomingPacket(PacketClient client) {
		this.client = client;
	}

	@Override
	public final PacketClient getClient() {
		return client;
	}

}
