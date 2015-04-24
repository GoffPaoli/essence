package essence.plugin;

import essence.inject.AbstractModule;

public abstract class AbstractPlugin extends AbstractModule implements Plugin {

	@Override
	protected void configure() {
		// intended to be overridden by choice
	}

}
