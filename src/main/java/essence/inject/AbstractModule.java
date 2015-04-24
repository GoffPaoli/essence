package essence.inject;

public abstract class AbstractModule implements Module {

	private Binder binder;

	@Override
	public final void configure(Binder binder) {
		if (this.binder != null)
			throw new IllegalStateException(
					"Modules can only be configured once!");

		this.binder = binder;

		configure();
	}

	protected abstract void configure();

	protected final void install(Module module) {
		binder.install(module);
	}

	protected final <T> TypeBindingBuilder<T> bind(Class<T> type) {
		return new TypeBindingBuilder<>(binder, type);
	}

	protected final <T> AnnotatedConstantBindingBuilder<T> bind(T value) {
		return new AnnotatedConstantBindingBuilder<>(binder, value);
	}

}
