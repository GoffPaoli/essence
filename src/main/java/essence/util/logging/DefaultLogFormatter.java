package essence.util.logging;

final class DefaultLogFormatter implements LogFormatter {

	@Override
	public String format(Level level, Object message) {
		return level.getName() + ": " + message;
	}

}
