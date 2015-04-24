package essence.util.logging;

import java.io.PrintStream;

import essence.inject.Inject;

public final class PrintStreamLogger extends AbstractLogger {

	public static PrintStreamLogger get(LogFormatter formatter, Level defaultLevel, PrintStream printStream) {
		return new PrintStreamLogger(formatter, defaultLevel, printStream);
	}

	private final PrintStream printStream;

	@Inject
	private PrintStreamLogger(LogFormatter formatter, Level defaultLevel, PrintStream printStream) {
		super(formatter, defaultLevel);
		this.printStream = printStream;
	}

	@Override
	protected void display(String formattedLog) {
		printStream.println(formattedLog);
	}

}
