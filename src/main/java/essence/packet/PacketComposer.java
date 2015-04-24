package essence.packet;

public interface PacketComposer<T extends Packet> {

	T compose(PacketMessage message);

}
