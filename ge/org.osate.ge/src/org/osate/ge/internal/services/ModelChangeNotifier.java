package org.osate.ge.internal.services;

import org.eclipse.emf.common.util.URI;

/**
 * Notifies listeners of model changes after the resource has been built.
 *
 */
public interface ModelChangeNotifier {
	static interface ChangeListener {
		// Notifies listener of changes to a relevant resource. At this time, only notifications of AADL resource changes are provided.
		// The change may represent a change in the "live" version of the resource and not the saved version of the resource.
		default void resourceChanged(URI resourceUri) {
		}
		default void modelChanged() {} // Called to notify listeners that change has occurred.
		default void afterModelChangeNotification() {} // A notification that occurs after model change notifications. Used by editor to refresh after other listeners have handled things accordingly.
	}

	void addChangeListener(ChangeListener listener);
	void removeChangeListener(ChangeListener listener);

	static interface Lock extends AutoCloseable {
		@Override
		void close();
	}

	Lock lock(); // Locks the notifier so that any changes are queued until the lock is released.
}
