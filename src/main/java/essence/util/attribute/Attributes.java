package essence.util.attribute;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Attributes {

	private final ConcurrentMap<Attribute<?>, Object> attributes = new ConcurrentHashMap<>();

	public final <T> T put(Attribute<T> attribute, T value) {
		attributes.put(attribute, value);
		return value;
	}

	@SuppressWarnings("unchecked")
	public final <T> T get(Attribute<T> attribute) {
		return (T) attributes.get(attribute);
	}

	@SuppressWarnings("unchecked")
	public final <T> T getOr(Attribute<T> attribute, T defaultValue) {
		return (T) attributes.getOrDefault(attribute, defaultValue);
	}

}
