package essence.packet.outgoing;

import essence.packet.OutgoingPacket;

public final class IdleLogoutPacket implements OutgoingPacket {

	public static IdleLogoutPacket get() {
		return new IdleLogoutPacket();
	}

	private IdleLogoutPacket() {
	}

}
