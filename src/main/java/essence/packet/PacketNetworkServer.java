package essence.packet;

import essence.game.World;
import essence.network.AbstractNetworkServer;

public abstract class PacketNetworkServer<C extends PacketClient> extends AbstractNetworkServer<PacketMessage, C> {

	private final PacketController controller;
	private final PacketMessageEncoder encoder;
	private final PacketMessageDecoder decoder;

	protected PacketNetworkServer(PacketController controller, PacketMessageEncoder encoder,
			PacketMessageDecoder decoder) {
		super(World.PLAYER_CAPACITY);
		this.controller = controller;
		this.encoder = encoder;
		this.decoder = decoder;
	}

	public final PacketController getController() {
		return controller;
	}

	public final PacketMessageEncoder getEncoder() {
		return encoder;
	}

	public final PacketMessageDecoder getDecoder() {
		return decoder;
	}

}
