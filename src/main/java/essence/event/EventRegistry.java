package essence.event;

import static java.util.Collections.unmodifiableCollection;

import java.lang.reflect.Method;
import java.util.Collection;

import essence.util.multimap.Multimap;
import essence.util.multimap.Multimaps;

final class EventRegistry {

	private final Multimap<Class<?>, EventSubscription> subscriptions = Multimaps.hash();

	void subscribe(Object subscriber) {
		for (Method method : subscriber.getClass().getDeclaredMethods()) {
			if (!method.isAnnotationPresent(Subscribe.class))
				continue;

			method.setAccessible(true);

			Class<?>[] parameters = method.getParameterTypes();
			Class<?> event = parameters[0];

			subscriptions.put(event, new EventSubscription(subscriber, method));
		}
	}

	Collection<EventSubscription> subscribersOf(Object event) {
		return unmodifiableCollection(subscriptions.get(event.getClass()));
	}

}
