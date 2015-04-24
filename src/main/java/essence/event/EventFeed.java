package essence.event;

import java.lang.reflect.InvocationTargetException;

public final class EventFeed {

	private final EventRegistry registry = new EventRegistry();

	public void subscribe(Object subscriber) {
		registry.subscribe(subscriber);
	}

	public void post(Object event) {
		registry.subscribersOf(event).forEach(subscription -> invoke(event, subscription));
	}

	private void invoke(Object event, EventSubscription subscription) {
		try {
			subscription.method().invoke(subscription.subscriber(), event);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException(e); // delegate up
		}
	}

}
