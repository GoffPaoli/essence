package essence.inject;

interface Binding<T> {

	Key<T> getKey();

	T getInstance(Key<T> key, Injector injector) throws Exception;

}
