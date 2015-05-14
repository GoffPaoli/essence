package essence;

import essence.event.EventModule;
import essence.inject.Inject;
import essence.inject.Injector;
import essence.inject.Module;
import essence.packet.PacketModule;
import essence.packet.PacketNetworkServer;
import essence.plugin.PluginController;
import essence.plugin.PluginModule;
import essence.task.TaskModule;
import essence.task.TaskService;
import essence.util.logging.Level;
import essence.util.logging.Levels;
import essence.util.logging.Logger;
import essence.util.logging.LoggingModule;

public final class Essence {

	private static final int DEFAULT_PORT = 43594;
	private static final Level DEFAULT_LOG_LEVEL = Levels.ALL;

	private static final Module[] defaultModules = { new LoggingModule(), new PluginModule(), new EventModule(),
			new PacketModule(), new TaskModule() };

	public static void main(String[] args) {
		Injector injector = Injector.get(defaultModules);

		PluginController plugins = injector.getInstance(PluginController.class);
		plugins.activate();

		Essence essence = injector.getInstance(Essence.class);
		essence.activate();
	}

	private final Logger logger;
	private final PacketNetworkServer<?> server;
	private final TaskService taskService;

	@Inject
	private Essence(Logger logger, PacketNetworkServer<?> server, TaskService taskService) {
		this.logger = logger;
		this.server = server;
		this.taskService = taskService;
	}

	private void activate() {
		logger.setLevel(DEFAULT_LOG_LEVEL);

		server.start(DEFAULT_PORT);
		taskService.start();

		logger.info("Essence is ready.");
	}

}
