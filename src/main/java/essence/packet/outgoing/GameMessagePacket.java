package essence.packet.outgoing;

import essence.packet.OutgoingPacket;

public final class GameMessagePacket implements OutgoingPacket {

	public static GameMessagePacket get(String message) {
		return new GameMessagePacket(message);
	}

	private final String message;

	private GameMessagePacket(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
