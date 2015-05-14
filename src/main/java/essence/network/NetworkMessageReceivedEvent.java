package essence.network;

public abstract class NetworkMessageReceivedEvent<M extends NetworkMessage> extends NetworkMessageEvent<M> {

	protected NetworkMessageReceivedEvent(M message) {
		super(message);
	}

}
