package essence.packet;

public interface PacketBuilder<T extends Packet> {

	PacketMessage build(T packet);

}
