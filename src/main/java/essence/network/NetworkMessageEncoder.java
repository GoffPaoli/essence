package essence.network;

public interface NetworkMessageEncoder<M extends NetworkMessage> {

	byte[] encode(M message);

}
