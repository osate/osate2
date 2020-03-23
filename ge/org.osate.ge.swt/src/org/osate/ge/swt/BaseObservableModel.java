package org.osate.ge.swt;

/**
 * Base implementation of {@link ObservableModel}. Intended to be extended.
 *
 */
public class BaseObservableModel implements ObservableModel {
	private final DefaultEventSource<ChangeEvent> changeEventSrc = new DefaultEventSource<>();

	@Override
	public EventSource<ChangeEvent> changed() {
		return changeEventSrc;
	}

	protected void triggerChangeEvent() {
		changeEventSrc.triggerEvent(new ChangeEvent());
	}
}
