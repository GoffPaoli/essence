package essence.inject;

final class ScopeBinding<T> extends AbstractBinding<T> {

	static <T> ScopeBinding<T> get(Key<T> key, Binding<T> binding, Scope scope) {
		return new ScopeBinding<>(key, binding, scope);
	}

	private final Binding<T> binding;
	private final Scope scope;

	private ScopeBinding(Key<T> key, Binding<T> binding, Scope scope) {
		super(key);
		this.binding = binding;
		this.scope = scope;
	}

	@Override
	public T getInstance(Key<T> key, Injector injector) throws Exception {
		return scope.apply(key, binding.getInstance(key, injector));
	}

}
