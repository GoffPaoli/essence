package essence.inject;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

final class ImplementationBinding<T> extends AbstractBinding<T> {

	static <T> ImplementationBinding<T> get(Key<T> key,
			Key<? extends T> implementation) {
		return new ImplementationBinding<>(key, implementation);
	}

	private final Key<? extends T> implementation;

	private ImplementationBinding(Key<T> key, Key<? extends T> implementation) {
		super(key);
		this.implementation = implementation;
	}

	@Override
	public T getInstance(Key<T> key, Injector injector) throws Exception {
		// TODO needs serious refactoring
		Constructor<T> constructor = findConstructor(implementation.getType());
		constructor.setAccessible(true);
		Class<?>[] types = constructor.getParameterTypes();
		Annotation[][] annotations = constructor.getParameterAnnotations();
		Object[] parameters = new Object[types.length];
		parameters: for (int i = 0; i < parameters.length; i++) {
			Class<?> parameter = types[i];
			if (annotations.length > 0 && annotations[i].length > 0) {
				for (Annotation annotation : annotations[i])
					parameters[i] = injector.getInstance(Key.get(parameter,
							annotation.annotationType()));
				continue parameters;
			}
			parameters[i] = injector.getInstance(parameter);
		}
		return constructor.newInstance(parameters);
	}

	@SuppressWarnings("unchecked")
	private Constructor<T> findConstructor(Class<? extends T> implementation)
			throws NoSuchMethodException, SecurityException {
		for (Constructor<?> constructor : implementation
				.getDeclaredConstructors())
			if (constructor.isAnnotationPresent(Inject.class)
					|| constructor.getParameterCount() == 0)
				return (Constructor<T>) constructor;
		throw new NullPointerException();
	}

}
