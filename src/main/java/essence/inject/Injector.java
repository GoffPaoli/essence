package essence.inject;

public final class Injector {

	public static Injector get(Module... modules) {
		Binder binder = new Binder();
		for (Module module : modules)
			binder.install(module);
		return new Injector(binder);
	}

	private final Binder binder;

	Injector(Binder binder) {
		this.binder = binder;
	}

	<T> T getInstance(Key<T> key) {
		Binding<T> binding = binder.getBinding(key);
		try {
			boolean bind = binding == null;
			if (bind)
				binding = ImplementationBinding.get(key, key);
			T instance = binding.getInstance(key, this);
			if (bind)
				binder.bind(binding);
			return instance;
		} catch (Exception e) {
			throw new RuntimeException(e); // delegate up
		}
	}

	public <T> T getInstance(Class<T> type) {
		return getInstance(Key.get(type));
	}

	public void install(Module module) {
		binder.install(module);
	}

}