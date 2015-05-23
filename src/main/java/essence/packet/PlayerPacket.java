package essence.packet;

import essence.game.Player;

public interface PlayerPacket extends Packet {

	Player getPlayer();

}
