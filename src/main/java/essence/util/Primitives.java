package essence.util;

import java.util.HashMap;
import java.util.Map;

public final class Primitives {

	private static final Map<Class<?>, Class<?>> wrappers = new HashMap<>();

	static {
		wrappers.put(boolean.class, Boolean.class);
		wrappers.put(byte.class, Byte.class);
		wrappers.put(short.class, Short.class);
		wrappers.put(char.class, Character.class);
		wrappers.put(int.class, Integer.class);
		wrappers.put(long.class, Long.class);
		wrappers.put(float.class, Float.class);
		wrappers.put(double.class, Double.class);
	}

	public static Class<?> wrap(Class<?> type) {
		if (!type.isPrimitive())
			return type;
		return wrappers.get(type);
	}

}
