package essence.plugin;

import essence.inject.Binder;
import essence.inject.Module;

public interface Plugin extends Module {

	default void activate() {
	}

	@Override
	default void configure(Binder binder) {
		// intended to be overridden by choice
	}

}
