package essence.plugin;

import essence.inject.AbstractModule;
import essence.inject.Scopes;

public final class PluginModule extends AbstractModule {

	private static final String PLUGIN_DIRECTORY = "plugins/";

	@Override
	protected void configure() {
		bind(PLUGIN_DIRECTORY).to(PluginDirectory.class);
		bind(PluginController.class).toSelf().in(Scopes.SINGLETON);
		bind(PluginLoader.class).toSelf().in(Scopes.SINGLETON);
	}

}
