package org.osate.ge.swt;

import java.util.function.Consumer;

/**
 * Interface for registering a function to be called when an event is triggered.
 *
 */
public interface EventSource<T> {
	/**
	 * Registers a listener that will be called when the event is triggered.
	 * Beware: only a weak reference to the listener is stored. It is the caller's responsibility to keep a reference to the listener
	 * to avoid it being garbage collected.
	 *
	 * Should only be called on the UI thread.
	 *
	 * @param listener is the listener to register.
	 */
	void addListener(Consumer<T> listener);
}
