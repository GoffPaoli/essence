package essence.inject;

public final class TypeBindingBuilder<T> extends AbstractBindingBuilder<T> {

	TypeBindingBuilder(Binder binder, Class<T> type) {
		super(binder, type);
	}

	public ScopeBindingBuilder<T> to(Class<? extends T> implementation) {
		ImplementationBinding<T> binding = ImplementationBinding.get(Key.get(getType()), Key.get(implementation));
		getBinder().bind(binding);
		return new ScopeBindingBuilder<>(getBinder(), getType(), binding);
	}

	public ScopeBindingBuilder<T> toSelf() {
		return to(getType());
	}

	public void to(T value) {
		ConstantBinding<T> binding = ConstantBinding.get(Key.get(getType()), value);
		getBinder().bind(binding);
	}

}
