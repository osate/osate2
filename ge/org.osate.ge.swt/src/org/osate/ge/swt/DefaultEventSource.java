package org.osate.ge.swt;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

/**
 * A basic EventSource implementation. Manages a thread-safe list of listeners.
 *
 */
public class DefaultEventSource<T> implements EventSource<T> {
	private final CopyOnWriteArrayList<Consumer<T>> listeners = new CopyOnWriteArrayList<>();

	@Override
	public void addListener(Consumer<T> listener) {
		listeners.add(listener);
	}

	/**
	 * Dispatches the event. Calls all registered listeners
	 * @param event is the event to send to listeners.
	 */
	public void triggerEvent(T event) {
		for (final Consumer<T> l : listeners) {
			l.accept(event);
		}
	}
}
