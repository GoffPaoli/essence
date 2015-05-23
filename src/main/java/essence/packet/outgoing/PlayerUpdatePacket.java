package essence.packet.outgoing;

import essence.game.Player;
import essence.packet.OutgoingPlayerPacket;

public final class PlayerUpdatePacket extends OutgoingPlayerPacket {

	public static PlayerUpdatePacket get(Player player) {
		return new PlayerUpdatePacket(player);
	}

	private PlayerUpdatePacket(Player player) {
		super(player);
	}

}
