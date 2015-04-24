package essence.inject;

@FunctionalInterface
public interface Scope {

	<T> T apply(Key<T> key, T instance);

}
