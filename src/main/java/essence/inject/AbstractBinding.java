package essence.inject;

abstract class AbstractBinding<T> implements Binding<T> {

	private final Key<T> key;

	AbstractBinding(Key<T> key) {
		this.key = key;
	}

	@Override
	public final Key<T> getKey() {
		return key;
	}

}
