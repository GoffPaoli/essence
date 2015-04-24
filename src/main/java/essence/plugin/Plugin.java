package essence.plugin;

import essence.inject.Binder;
import essence.inject.Module;

public interface Plugin extends Module {

	default void enable() {
	}

	default void disable() {
	}

	@Override
	default void configure(Binder binder) {
		// intended to be overridden by choice
	}

}
