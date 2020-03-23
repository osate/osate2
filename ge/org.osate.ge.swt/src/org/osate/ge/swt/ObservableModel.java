package org.osate.ge.swt;

/**
 * An interface used by View Models which notify views of changes.
 *
 */
public interface ObservableModel {
	/**
	 * Event source for change events. A change event is dispatched when the data provided from the view model may have changed.
	 * View models should avoid sending change events unless a change has actually occurred.
	 * @return an {@link EventSource} for change events.
	 */
	EventSource<ChangeEvent> changed();
}
