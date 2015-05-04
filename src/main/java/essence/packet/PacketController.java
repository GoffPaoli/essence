package essence.packet;

import java.util.HashMap;
import java.util.Map;

public final class PacketController {

	private final Map<Integer, PacketEncoder<?>> encoders = new HashMap<>();
	private final Map<Class<? extends Packet>, PacketDecoder<?>> decoders = new HashMap<>();

	public void addEncoder(PacketEncoder<?> encoder) {
		EncodesPacket annotation = encoder.getClass().getAnnotation(EncodesPacket.class);
		for (int id : annotation.value())
			encoders.put(id, encoder);
	}

	public <T extends Packet> void addDecoder(PacketDecoder<T> decoder) {
		DecodesPacket annotation = decoder.getClass().getAnnotation(DecodesPacket.class);
		decoders.put(annotation.value(), decoder);
	}

	@SuppressWarnings("unchecked")
	public <T extends Packet> T encode(PacketMessage message) {
		return (T) encoders.get(message.getID()).encode(message);
	}

	@SuppressWarnings("unchecked")
	public <T extends Packet> PacketMessage decode(T packet) {
		return ((PacketDecoder<T>) decoders.get(packet.getClass())).decode(packet);
	}

}
