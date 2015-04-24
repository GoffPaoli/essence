package essence.network;

public abstract class AbstractNetworkMessage implements NetworkMessage {

	private final byte[] data;

	protected AbstractNetworkMessage(byte[] data) {
		this.data = data;
	}

	@Override
	public byte[] getData() {
		return data.clone();
	}

}
