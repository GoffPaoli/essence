package essence.packet;

public interface PacketDecoder<T extends Packet> {

	PacketMessage decode(T packet);

}
