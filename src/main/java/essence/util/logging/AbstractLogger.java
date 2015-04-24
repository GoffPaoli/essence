package essence.util.logging;

public abstract class AbstractLogger implements Logger {

	private final LogFormatter formatter;

	private volatile Level level;

	protected AbstractLogger(LogFormatter formatter, Level defaultLevel) {
		this.formatter = formatter;
		level = defaultLevel;
	}

	@Override
	public final LogFormatter getFormatter() {
		return formatter;
	}

	@Override
	public final Level getLevel() {
		return level;
	}

	@Override
	public final synchronized void log(Level level, Object message) {
		if (getLevel().permits(level))
			display(getFormatter().format(level, message));
	}

	@Override
	public final void setLevel(Level level) {
		this.level = level;
	}

	protected abstract void display(String formattedLog);

}
