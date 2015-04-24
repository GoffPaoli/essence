package essence.util.logging;

public interface Logger {

	LogFormatter getFormatter();

	Level getLevel();

	void log(Level level, Object message);

	default void error(Object message) {
		log(Levels.ERROR, message);
	}

	default void warning(Object message) {
		log(Levels.WARNING, message);
	}

	default void info(Object message) {
		log(Levels.INFO, message);
	}

	default void debug(Object message) {
		log(Levels.DEBUG, message);
	}

	default void config(Object message) {
		log(Levels.CONFIG, message);
	}

	void setLevel(Level level);

}
