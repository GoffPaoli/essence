package essence.packet;

import essence.network.NetworkMessageReceivedEvent;

public class PacketMessageReceivedEvent extends NetworkMessageReceivedEvent<PacketMessage> {

	public static PacketMessageReceivedEvent get(PacketMessage message) {
		return new PacketMessageReceivedEvent(message);
	}

	private PacketMessageReceivedEvent(PacketMessage message) {
		super(message);
	}

}
