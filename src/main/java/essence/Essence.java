package essence;

import essence.event.EventModule;
import essence.inject.Inject;
import essence.inject.Injector;
import essence.network.NetworkServer;
import essence.plugin.PluginController;
import essence.util.logging.Logger;
import essence.util.logging.LoggingModule;

public final class Essence {

	private static final String PLUGINS_DIRECTORY = "plugins/";
	private static final int PORT = 43594;

	public static void main(String[] args) {
		Injector injector = Injector.get(new LoggingModule(), new EventModule());

		// TODO Make plugin controller created by injector? (Hard TBH)
		PluginController plugins = PluginController.get(PLUGINS_DIRECTORY, injector);
		plugins.activate();

		Essence essence = injector.getInstance(Essence.class);
		essence.activate();
	}

	private final Logger logger;
	private final NetworkServer<?> server;

	@Inject
	private Essence(Logger logger, NetworkServer<?> server) {
		this.logger = logger;
		this.server = server;
	}

	private void activate() {
		server.start(PORT);

		logger.info("Essence is ready.");
	}

}
