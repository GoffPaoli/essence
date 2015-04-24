package essence.util.logging;

import java.io.PrintStream;

import essence.inject.AbstractModule;
import essence.inject.Scopes;

public final class LoggingModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Level.class).to(Levels.INFO);
		bind(PrintStream.class).to(System.out);

		bind(LogFormatter.class).to(DefaultLogFormatter.class).in(Scopes.SINGLETON);
		bind(Logger.class).to(PrintStreamLogger.class).in(Scopes.SINGLETON);
	}

}
