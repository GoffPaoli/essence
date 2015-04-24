package essence.packet;

public interface PacketDecomposer<T extends Packet> {

	PacketMessage decompose(Packet packet);

}
