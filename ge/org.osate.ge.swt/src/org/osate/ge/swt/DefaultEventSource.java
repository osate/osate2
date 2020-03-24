package org.osate.ge.swt;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.function.Consumer;

/**
 * A basic EventSource implementation. Manages a thread-safe list of listeners.
 *
 */
public class DefaultEventSource<T> implements EventSource<T> {
	private final ArrayList<WeakReference<Consumer<T>>> listeners = new ArrayList<>();

	@Override
	public void addListener(Consumer<T> listener) {
		listeners.add(new WeakReference<Consumer<T>>(listener));
	}

	/**
	 * Dispatches the event. Calls all registered listeners
	 * @param event is the event to send to listeners.
	 */
	public void triggerEvent(T event) {
		// Iterate over listeners by index and call each of them. Listeners added during the loop will not be called.
		boolean hasClearedReferences = false;
		final int listenerCount = listeners.size();
		for (int i = 0; i < listenerCount; i++) {
			final WeakReference<Consumer<T>> weakListener = listeners.get(i);
			final Consumer<T> listener = weakListener.get();

			if(listener == null) {
				hasClearedReferences  = true;
			} else {
				listener.accept(event);
			}
		}

		// Remove references which have been cleared
		if(hasClearedReferences) {
			listeners.removeIf(w -> w.get() == null);
		}

		new WeakHashMap<Integer, Integer>();
	}
}
