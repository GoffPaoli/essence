package essence;

import essence.event.EventModule;
import essence.game.World;
import essence.inject.Inject;
import essence.inject.Injector;
import essence.inject.Module;
import essence.packet.PacketModule;
import essence.packet.PacketNetworkServer;
import essence.plugin.PluginController;
import essence.plugin.PluginModule;
import essence.task.TaskModule;
import essence.task.TaskService;
import essence.task.Tasks;
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
	private final World world;

	@Inject
	private Essence(Logger logger, PacketNetworkServer<?> server, TaskService taskService, World world) {
		this.logger = logger;
		this.server = server;
		this.taskService = taskService;
		this.world = world;
	}

	private void activate() {
		logger.setLevel(DEFAULT_LOG_LEVEL);
		taskService.submit(Tasks.continuous(1, world::process));

		server.start(DEFAULT_PORT);
		taskService.start();

		logger.info("Essence is ready.");
	}

}
