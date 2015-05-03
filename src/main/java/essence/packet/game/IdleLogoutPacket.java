package essence.packet.game;

import essence.packet.Packet;

public final class IdleLogoutPacket implements Packet {

	public static IdleLogoutPacket get() {
		return new IdleLogoutPacket();
	}

	private IdleLogoutPacket() {
	}

}
