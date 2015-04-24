package essence.util.logging;

@FunctionalInterface
public interface LogFormatter {

	String format(Level level, Object message);

}
