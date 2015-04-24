package essence.inject;

final class ConstantBinding<T> extends AbstractBinding<T> {

	static <T> ConstantBinding<T> get(Key<T> key, T value) {
		return new ConstantBinding<>(key, value);
	}

	private final T value;

	private ConstantBinding(Key<T> key, T value) {
		super(key);
		this.value = value;
	}

	@Override
	public T getInstance(Key<T> key, Injector injector) throws Exception {
		return value;
	}

}
