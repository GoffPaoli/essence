package essence.inject;

public final class ScopeBindingBuilder<T> extends AbstractBindingBuilder<T> {

	private final Binding<T> binding;

	ScopeBindingBuilder(Binder binder, Class<T> type, Binding<T> binding) {
		super(binder, type);
		this.binding = binding;
	}

	public void in(Scope scope) {
		getBinder().bind(ScopeBinding.get(Key.get(getType()), binding, scope));
	}

}
