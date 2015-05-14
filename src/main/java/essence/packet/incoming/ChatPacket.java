package essence.packet.incoming;

import essence.packet.AbstractIncomingPacket;
import essence.packet.PacketClient;

public final class ChatPacket extends AbstractIncomingPacket {

	public static ChatPacket get(PacketClient client, String message, int effects, int color) {
		return new ChatPacket(client, message, effects, color);
	}

	private final String message;
	private final int effect, color;

	private ChatPacket(PacketClient client, String message, int effect, int color) {
		super(client);
		this.message = message;
		this.effect = effect;
		this.color = color;
	}

	public String getMessage() {
		return message;
	}

	public int getEffect() {
		return effect;
	}

	public int getColor() {
		return color;
	}

}
