package essence.network;

import java.util.UUID;

public abstract class AbstractNetworkClient<M extends NetworkMessage> implements NetworkClient<M> {

	private final UUID uuid;

	protected AbstractNetworkClient(UUID uuid) {
		this.uuid = uuid;
	}

	protected AbstractNetworkClient() {
		this(UUID.randomUUID());
	}

	@Override
	public final UUID getUUID() {
		return uuid;
	}

}
