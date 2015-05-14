package essence.packet;

public final class PacketWrittenEvent extends PacketClientEvent {

	public static PacketWrittenEvent get(PacketClient client, Packet packet) {
		return new PacketWrittenEvent(client, packet);
	}

	private PacketWrittenEvent(PacketClient client, Packet packet) {
		super(client, packet);
	}

}
