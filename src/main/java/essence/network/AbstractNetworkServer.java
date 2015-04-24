package essence.network;

import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public abstract class AbstractNetworkServer<M extends NetworkMessage> implements NetworkServer<M> {

	private final ConcurrentMap<UUID, NetworkClient<M>> clients;

	protected AbstractNetworkServer(int clientCapacity) {
		clients = new ConcurrentHashMap<>(clientCapacity);
	}

	@Override
	public final Collection<NetworkClient<M>> getClients() {
		return clients.values();
	}

	@Override
	public final NetworkClient<M> getClient(UUID uuid) {
		return clients.get(uuid);
	}

}
