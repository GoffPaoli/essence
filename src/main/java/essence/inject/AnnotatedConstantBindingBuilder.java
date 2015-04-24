package essence.inject;

import java.lang.annotation.Annotation;

public final class AnnotatedConstantBindingBuilder<T> extends AbstractBindingBuilder<T> {

	private final T value;

	@SuppressWarnings("unchecked")
	AnnotatedConstantBindingBuilder(Binder binder, T value) {
		super(binder, (Class<T>) value.getClass());
		this.value = value;
	}

	public void to(Class<? extends Annotation> annotation) {
		getBinder().bind(AnnotatedConstantBinding.get(value, annotation));
	}

}
