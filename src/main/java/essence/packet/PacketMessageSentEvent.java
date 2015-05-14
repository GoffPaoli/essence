package essence.packet;

import essence.network.NetworkMessageSentEvent;

public class PacketMessageSentEvent extends NetworkMessageSentEvent<PacketMessage> {

	public static PacketMessageSentEvent get(PacketMessage message) {
		return new PacketMessageSentEvent(message);
	}

	private PacketMessageSentEvent(PacketMessage message) {
		super(message);
	}

}
