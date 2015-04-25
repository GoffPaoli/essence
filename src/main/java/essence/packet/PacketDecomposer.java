package essence.packet;

public interface PacketDecomposer<T extends Packet> {

	PacketMessage decompose(T packet);

}
