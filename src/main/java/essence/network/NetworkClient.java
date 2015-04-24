package essence.network;

import java.util.UUID;

public interface NetworkClient<M extends NetworkMessage> {

	UUID getUUID();

	void write(M message);

}
