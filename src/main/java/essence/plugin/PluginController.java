package essence.plugin;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import essence.inject.Injector;

public final class PluginController {

	public static PluginController get(String directory, Injector injector) {
		return new PluginController(directory, new PluginLoader(), injector);
	}

	private final File directory;
	private final PluginLoader loader;

	private final Injector injector;

	private final Map<PluginManifest, Plugin> plugins = new HashMap<>();

	PluginController(String directory, PluginLoader loader, Injector injector) {
		this(new File(directory), loader, injector);
	}

	PluginController(File directory, PluginLoader loader, Injector injector) {
		this.directory = directory;
		this.loader = loader;
		this.injector = injector;
	}

	public void enable(Plugin plugin) {
		injector.install(plugin);
		plugin.enable();
	}

	public void disable(Plugin plugin) {
		plugin.disable();
	}

	public void activate() {
		for (Plugin plugin : loader.loadAll(directory)) {
			PluginManifest manifest = plugin.getClass().getAnnotation(PluginManifest.class);
			if (manifest != null)
				plugins.put(manifest, plugin);
		}
		for (Plugin plugin : plugins.values())
			enable(plugin);
	}

}
