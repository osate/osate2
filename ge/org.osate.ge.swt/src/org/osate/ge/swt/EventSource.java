package org.osate.ge.swt;

import java.util.function.Consumer;

/**
 * Interface for registering a function to be called when an event is triggered.
 *
 */
public interface EventSource<T> {
	/**
	 * Registers a listener that will be called when the event is triggered.
	 * @param listener is the listener to register.
	 */
	void addListener(Consumer<T> listener);
}
