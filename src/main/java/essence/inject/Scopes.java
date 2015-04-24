package essence.inject;

import java.util.HashMap;
import java.util.Map;

public enum Scopes implements Scope {

	DEFAULT,

	SINGLETON {

		private final Map<Key<?>, Object> singletons = new HashMap<>();

		@Override
		@SuppressWarnings("unchecked")
		public <T> T apply(Key<T> key, T instance) {
			Object o = singletons.get(key);
			if (o == null)
				singletons.put(key, o = instance);
			return (T) o;
		}
	};

	@Override
	public <T> T apply(Key<T> key, T instance) {
		return instance;
	}

}
