package essence.packet;

import java.util.HashMap;
import java.util.Map;

public final class PacketController {

	private static final DummyPacketEncoder DUMMY_ENCODER = new DummyPacketEncoder();
	private static final DummyPacketDecoder DUMMY_DECODER = new DummyPacketDecoder();

	private final Map<Integer, PacketEncoder<?>> encoders = new HashMap<>();
	private final Map<Class<? extends Packet>, PacketDecoder<?>> decoders = new HashMap<>();

	public void addEncoder(PacketEncoder<?> encoder) {
		EncodesPacket annotation = encoder.getClass().getAnnotation(EncodesPacket.class);
		for (int id : annotation.value())
			encoders.put(id, encoder);
	}

	public void addDecoder(PacketDecoder<?> decoder) {
		DecodesPacket annotation = decoder.getClass().getAnnotation(DecodesPacket.class);
		decoders.put(annotation.value(), decoder);
	}

	@SuppressWarnings("unchecked")
	public <T extends IncomingPacket> T encode(PacketClient client, PacketMessage message) {
		return (T) encoders.getOrDefault(message.getID(), DUMMY_ENCODER).encode(client, message);
	}

	@SuppressWarnings("unchecked")
	public <T extends OutgoingPacket> PacketMessage decode(T packet) {
		return ((PacketDecoder<T>) decoders.getOrDefault(packet.getClass(), DUMMY_DECODER)).decode(packet);
	}

}
