package essence.plugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import essence.inject.Injector;

public final class PluginController {

	public static PluginController get(String directory, Injector injector) {
		return new PluginController(directory, new PluginLoader(), injector);
	}

	private final File directory;
	private final PluginLoader loader;

	private final Injector injector;

	PluginController(String directory, PluginLoader loader, Injector injector) {
		this(new File(directory), loader, injector);
	}

	PluginController(File directory, PluginLoader loader, Injector injector) {
		this.directory = directory;
		this.loader = loader;
		this.injector = injector;
	}

	public void install(Plugin plugin) {
		injector.install(plugin);
	}

	public void activate(Plugin plugin) {
		plugin.activate();
	}

	public void activate() {
		List<Plugin> plugins = new ArrayList<>();

		// Add all parent plugins
		plugins.addAll(loader.loadAll(directory));

		// Add our manifests
		for (Plugin plugin : new ArrayList<>(plugins)) {
			PluginManifest manifest = plugin.getClass().getAnnotation(PluginManifest.class);
			if (manifest != null) {
				for (Class<? extends Plugin> child : manifest.children()) {
					Plugin childPlugin = injector.getInstance(child);
					if (childPlugin != null)
						plugins.add(childPlugin);
				}
			}
		}

		plugins.forEach(this::install);
		plugins.forEach(this::activate);
	}
}
