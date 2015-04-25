package essence.packet;

public final class PacketController {

	public void useComposer(PacketComposer<?> composer) {
		// TODO
	}

	public <T extends Packet> void useDecomposer(PacketDecomposer<T> decomposer) {
		// TODO
	}

	public <T extends Packet> T compose(PacketMessage message) {
		// TODO

		return null;
	}

	public <T extends Packet> PacketMessage decompose(T packet) {
		// TODO

		return null;
	}

}
