package essence.inject;

class AbstractBindingBuilder<T> implements BindingBuilder<T> {

	private final Binder binder;
	private final Class<T> type;

	AbstractBindingBuilder(Binder binder, Class<T> type) {
		this.binder = binder;
		this.type = type;
	}

	@Override
	public final Binder getBinder() {
		return binder;
	}

	@Override
	public Class<T> getType() {
		return type;
	}

}
