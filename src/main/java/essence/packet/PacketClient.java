package essence.packet;

import essence.network.AbstractNetworkClient;

public abstract class PacketClient extends AbstractNetworkClient<PacketMessage> {

	private final PacketController controller;

	protected PacketClient(PacketController controller) {
		this.controller = controller;
	}

	public final PacketController getController() {
		return controller;
	}

	public void write(OutgoingPacket packet) {
		PacketMessage message = controller.decode(packet);
		if (message != null)
			write(message);
	}

}
