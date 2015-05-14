package essence.task;

import essence.inject.AbstractModule;
import essence.inject.Scopes;

public final class TaskModule extends AbstractModule {

	private static final int TICK_MILLIS = 600;

	@Override
	protected void configure() {
		bind(TICK_MILLIS).to(Tick.class);
		bind(TaskService.class).toSelf().in(Scopes.SINGLETON);
	}

}
