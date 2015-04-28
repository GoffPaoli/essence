package essence.inject;

import java.util.function.Supplier;

final class SupplierBinding<T> extends AbstractBinding<T> {

	static <T> SupplierBinding<T> get(Key<T> key, Supplier<T> supplier) {
		return new SupplierBinding<>(key, supplier);
	}

	private SupplierBinding(Key<T> key, Supplier<T> supplier) {
		super(key);
		this.supplier = supplier;
	}

	private final Supplier<T> supplier;
	private T result;

	@Override
	public T getInstance(Key<T> key, Injector injector) throws Exception {
		if (result != null)
			return result;
		return result = supplier.get();
	}

}
