package essence.inject;

import java.lang.annotation.Annotation;

final class AnnotatedConstantBinding<T> extends AbstractBinding<T> {

	@SuppressWarnings("unchecked")
	static <T> AnnotatedConstantBinding<T> get(T value, Class<? extends Annotation> annotation) {
		Class<?> type = value.getClass();
		if (type.getSuperclass().isEnum())
			type = type.getSuperclass();
		return new AnnotatedConstantBinding<T>(Key.get((Class<T>) type, annotation), value);
	}
	
	private final T value;
	
	private AnnotatedConstantBinding(Key<T> key, T value) {
		super(key);
		this.value = value;
	}

	@Override
	public T getInstance(Key<T> key, Injector injector) throws Exception {
		return value;
	}

}
