package essence.inject;

import java.util.HashMap;
import java.util.Map;

public final class Binder {

	private final Map<Key<?>, Binding<?>> bindings = new HashMap<>();

	public void install(Module module) {
		module.configure(this);
	}

	public <T> void bind(Binding<T> binding) {
		bindings.put(binding.getKey(), binding);
	}

	@SuppressWarnings("unchecked")
	<T> Binding<T> getBinding(Key<T> key) {
		return (Binding<T>) bindings.get(key);
	}

}
