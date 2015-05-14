package essence.packet;

public interface PacketDecoder<T extends OutgoingPacket> {

	PacketMessage decode(T packet);

}
