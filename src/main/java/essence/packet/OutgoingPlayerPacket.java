package essence.packet;

import essence.game.Player;

public abstract class OutgoingPlayerPacket implements OutgoingPacket, PlayerPacket {

	private final Player player;

	protected OutgoingPlayerPacket(Player player) {
		this.player = player;
	}

	@Override
	public final Player getPlayer() {
		return player;
	}

}
