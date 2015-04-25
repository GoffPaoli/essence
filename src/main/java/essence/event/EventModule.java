package essence.event;

import essence.inject.AbstractModule;
import essence.inject.Scopes;

public final class EventModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(EventFeed.class).toSelf().in(Scopes.SINGLETON);
	}

}
