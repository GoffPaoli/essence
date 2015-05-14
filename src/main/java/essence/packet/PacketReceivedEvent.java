package essence.packet;

public final class PacketReceivedEvent extends PacketClientEvent {

	public static PacketReceivedEvent get(PacketClient client, Packet packet) {
		return new PacketReceivedEvent(client, packet);
	}

	private PacketReceivedEvent(PacketClient client, Packet packet) {
		super(client, packet);
	}

}
