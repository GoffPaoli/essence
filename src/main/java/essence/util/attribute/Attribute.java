package essence.util.attribute;

public interface Attribute<T> {

	static <T> Attribute<T> get() {
		return new Attribute<T>() {
		};
	}

}
