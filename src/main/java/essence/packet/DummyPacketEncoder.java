package essence.packet;

final class DummyPacketEncoder implements PacketEncoder<IncomingPacket> {

	@Override
	public IncomingPacket encode(PacketClient client, PacketMessage message) {
		return null;
	}

}
