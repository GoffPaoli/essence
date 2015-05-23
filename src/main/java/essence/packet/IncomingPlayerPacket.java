package essence.packet;

import essence.game.Player;

public abstract class IncomingPlayerPacket extends AbstractIncomingPacket implements PlayerPacket {

	private final Player player;

	protected IncomingPlayerPacket(PacketClient client, Player player) {
		super(client);
		this.player = player;
	}

	@Override
	public final Player getPlayer() {
		return player;
	}

}
