package essence.plugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import essence.inject.Inject;
import essence.inject.Injector;

public final class PluginController {

	public static PluginController get(String directory, Injector injector) {
		return new PluginController(directory, injector.getInstance(PluginLoader.class), injector);
	}

	private final File directory;
	private final PluginLoader loader;

	private final Injector injector;

	@Inject
	private PluginController(@PluginDirectory String directory, PluginLoader loader, Injector injector) {
		this(new File(directory), loader, injector);
	}

	private PluginController(File directory, PluginLoader loader, Injector injector) {
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
		plugins.addAll(loader.loadAll(directory, injector));

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
