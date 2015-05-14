package essence.game;

import essence.inject.AbstractModule;
import essence.inject.Scopes;

public final class GameModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(World.class).toSelf().in(Scopes.SINGLETON);
	}

}
