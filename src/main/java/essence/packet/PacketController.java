package essence.packet;

import java.util.HashMap;
import java.util.Map;

public final class PacketController {

	private final Map<Class<? extends Packet>, PacketBuilder<?>> builders = new HashMap<>();
	private final Map<Integer, PacketParser<?>> parsers = new HashMap<>();

	public void addParser(PacketParser<?> parser) {
		ParsesPacket annotation = parser.getClass().getAnnotation(ParsesPacket.class);
		for (int id : annotation.value())
			parsers.put(id, parser);
	}

	public <T extends Packet> void addBuilder(PacketBuilder<T> builder) {
		BuildsPacket annotation = builder.getClass().getAnnotation(BuildsPacket.class);
		builders.put(annotation.value(), builder);
	}

	@SuppressWarnings("unchecked")
	public <T extends Packet> T parse(PacketMessage message) {
		return (T) parsers.get(message.getID()).parse(message);
	}

	@SuppressWarnings("unchecked")
	public <T extends Packet> PacketMessage build(T packet) {
		return ((PacketBuilder<T>) builders.get(packet.getClass())).build(packet);
	}

}
