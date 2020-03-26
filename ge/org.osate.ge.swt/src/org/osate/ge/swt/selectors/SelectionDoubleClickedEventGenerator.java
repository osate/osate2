package org.osate.ge.swt.selectors;

import org.osate.ge.swt.EventSource;

/**
 * Interface for selectors which generate selection double clicked events.
 *
 */
public interface SelectionDoubleClickedEventGenerator {
	EventSource<SelectionDoubleClickedEvent> selectionDoubleClicked();
}
