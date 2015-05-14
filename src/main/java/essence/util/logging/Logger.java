package essence.util.logging;

import static java.lang.String.format;

public interface Logger {

	LogFormatter getFormatter();

	Level getLevel();

	void log(Level level, Object message);

	default void logf(Level level, String format, Object... args) {
		log(level, format(format, args));
	}

	default void error(Object message) {
		log(Levels.ERROR, message);
	}

	default void errorf(String format, Object... args) {
		logf(Levels.ERROR, format, args);
	}

	default void warning(Object message) {
		log(Levels.WARNING, message);
	}

	default void warningf(String format, Object... args) {
		logf(Levels.WARNING, format, args);
	}

	default void info(Object message) {
		log(Levels.INFO, message);
	}

	default void infof(String format, Object... args) {
		logf(Levels.INFO, format, args);
	}

	default void debug(Object message) {
		log(Levels.DEBUG, message);
	}

	default void debugf(String format, Object... args) {
		logf(Levels.DEBUG, format, args);
	}

	default void configf(String format, Object... args) {
		logf(Levels.CONFIG, format, args);
	}

	default void config(Object message) {
		log(Levels.CONFIG, message);
	}

	void setLevel(Level level);

}
