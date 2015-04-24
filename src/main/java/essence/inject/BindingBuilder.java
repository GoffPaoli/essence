package essence.inject;

interface BindingBuilder<T> {

	Binder getBinder();

	Class<T> getType();

}
