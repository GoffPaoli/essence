package essence.packet;

public final class PacketController {

	public void useComposer(PacketComposer composer) {

	}

	public <T extends Packet> void useDecomposer(PacketDecomposer<T> decomposer) {

	}

	public <T extends Packet> T compose(PacketMessage message) {
		return null;
	}

	public <T extends Packet> PacketMessage decompose(T packet) {
		return null;
	}

}
