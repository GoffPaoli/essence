package essence.packet;

import essence.network.AbstractNetworkMessage;

public final class PacketMessage extends AbstractNetworkMessage {

	private static final int HEADLESS = -1;

	public static PacketMessage get(byte[] data, int id) {
		return new PacketMessage(data, id);
	}

	public static PacketMessage headless(byte[] data) {
		return get(data, HEADLESS);
	}

	private final int id;

	private PacketMessage(byte[] data, int id) {
		super(data);
		this.id = id;
	}

	public int getID() {
		return id;
	}

	public boolean isHeadless() {
		return id == HEADLESS;
	}

}
