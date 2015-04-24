package essence.inject;

import java.lang.annotation.Annotation;
import java.util.Optional;

final class Key<T> {

	static <T> Key<T> get(Class<T> type, Class<? extends Annotation> annotation) {
		return new Key<>(type, Optional.ofNullable(annotation));
	}

	static <T> Key<T> get(Class<T> type) {
		return get(type, null);
	}

	private final Class<T> type;
	private Optional<Class<? extends Annotation>> annotation;

	private Key(Class<T> type, Optional<Class<? extends Annotation>> annotation) {
		this.type = type;
		this.annotation = annotation;
	}

	Class<T> getType() {
		return type;
	}

	Optional<Class<? extends Annotation>> getAnnotation() {
		return annotation;
	}

	@Override
	public int hashCode() {
		int hash = type.hashCode();
		if (annotation.isPresent())
			hash ^= annotation.get().hashCode();
		return hash;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Key))
			return false;
		return hashCode() == o.hashCode();
	}

}
