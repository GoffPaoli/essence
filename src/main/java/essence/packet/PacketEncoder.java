package essence.packet;

public interface PacketEncoder<T extends IncomingPacket> {

	T encode(PacketClient client, PacketMessage message);

}
