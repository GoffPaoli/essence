package essence.packet;

public interface PacketParser<T extends Packet> {

	T parse(PacketMessage message);

}
