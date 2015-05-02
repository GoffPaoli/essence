package essence.network;

public interface NetworkMessageDecoder<M extends NetworkMessage> {

	M decode(byte[] data);

}
