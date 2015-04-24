package essence.util.logging;

public interface Level {

	String getName();

	int getValue();

	default boolean permits(Level level) {
		return getValue() >= level.getValue();
	}

}
