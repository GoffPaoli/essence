package essence.network;

import java.util.Collection;
import java.util.UUID;

public interface NetworkServer<M extends NetworkMessage, C extends NetworkClient<M>> {

	Collection<C> getClients();

	C getClient(UUID uuid);

	void addClient(C client);

	void removeClient(C client);

	void start(int port);

}
