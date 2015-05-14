package essence.network;

public abstract class NetworkMessageSentEvent<M extends NetworkMessage> extends NetworkMessageEvent<M> {

	protected NetworkMessageSentEvent(M message) {
		super(message);
	}

}
