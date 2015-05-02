package essence.packet;

import essence.inject.AbstractModule;
import essence.inject.Scopes;

public final class PacketModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(PacketController.class).toSelf().in(Scopes.SINGLETON);
	}

}
