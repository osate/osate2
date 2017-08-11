package org.osate.ge.internal.diagram.runtime;

/**
 * Interface used to receive notifications regarding diagram modifications.
 * The notifier will not provide notifications for each change. Instead, the caller will notifier will notify after a sequence of related changes have been made.
 * For example, if an element is added and then a series of updates is performed on that element, only a single added notification should be provided.
 * This allows a more fully initialized element to be provided to listeners and prevents unnecessary notifications.
 * 
 * However, multiple notifications of an element may be updated will be supplied if other elements are updated between updates of the original element.
 */
public interface DiagramModificationListener {
	void elementAdded(ElementAddedEvent e);
	void elementRemoved(ElementRemovedEvent e);
	void elementUpdated(ElementUpdatedEvent e);
	void modificationsCompleted(ModificationsCompletedEvent e);
}