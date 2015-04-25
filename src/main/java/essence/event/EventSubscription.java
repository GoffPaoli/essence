package essence.event;

import java.lang.reflect.Method;

final class EventSubscription {

	private final Object subscriber;
	private final Method method;

	EventSubscription(Object subscriber, Method method) {
		this.subscriber = subscriber;
		this.method = method;
	}

	Object getSubscriber() {
		return subscriber;
	}

	Method getMethod() {
		return method;
	}

}
