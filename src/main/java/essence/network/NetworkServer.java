package essence.network;

import java.util.Collection;
import java.util.UUID;

public interface NetworkServer<M extends NetworkMessage> {

	Collection<NetworkClient<M>> getClients();

	NetworkClient<M> getClient(UUID uuid);

	void start(int port);

}
