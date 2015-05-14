package essence.network;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public abstract class AbstractNetworkServer<M extends NetworkMessage, C extends NetworkClient<M>> implements
		NetworkServer<M, C> {

	private final ConcurrentMap<UUID, C> clients;

	protected AbstractNetworkServer(int clientCapacity) {
		clients = new ConcurrentHashMap<>(clientCapacity);
	}

	@Override
	public final Collection<C> getClients() {
		return Collections.unmodifiableCollection(clients.values());
	}

	@Override
	public final C getClient(UUID uuid) {
		return clients.get(uuid);
	}

	@Override
	public final void addClient(C client) {
		clients.put(client.getUUID(), client);
	}

	@Override
	public final void removeClient(C client) {
		clients.remove(client.getUUID());
	}

}
