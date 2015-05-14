package essence.packet;

final class DummyPacketDecoder implements PacketDecoder<OutgoingPacket> {

	@Override
	public PacketMessage decode(OutgoingPacket packet) {
		return null;
	}

}
