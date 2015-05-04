package essence.packet;

public interface PacketEncoder<T extends Packet> {

	T encode(PacketMessage message);

}
