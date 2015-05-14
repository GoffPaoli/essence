package essence.network;

public abstract class NetworkMessageEvent<M extends NetworkMessage> {

	private final M message;

	protected NetworkMessageEvent(M message) {
		this.message = message;
	}

	public M getMessage() {
		return message;
	}

}
