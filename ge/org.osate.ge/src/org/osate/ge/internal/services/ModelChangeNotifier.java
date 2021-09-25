/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.internal.services;

import org.eclipse.emf.common.util.URI;

/**
 * Notifies listeners of model changes after the resource has been built.
 *
 */
public interface ModelChangeNotifier {
	/**
	 * Interface for receiving model change notifications
	 *
	 */
	static interface ChangeListener {
		/**
		 * Called to notify the listener of changes to a relevant resource. Only notifications of AADL resource changes are provided.
		 * The change may represent a change in the "live" version of the resource and not the saved version of the resource.
		 * @param resourceUri the URI of the changes resource.
		 */
		default void resourceChanged(URI resourceUri) {
		}

		/**
		 * Called to notify the listener that a change has occurred.
		 * @param modelWasLocked true if this notification was generated after changes were made while the model was locked.
		 */
		default void modelChanged(boolean modelWasLocked) {
		}

		/**
		 * Called after {@link #modelChanged(boolean)} has been called for all listeners.
		 */
		default void afterModelChangeNotification() {
		}
	}

	/**
	 * Adds a listener to be notified when the model changes
	 * @param listener the listener to add
	 * @see #removeChangeListener(ChangeListener)
	 */
	void addChangeListener(ChangeListener listener);

	/**
	 * Removes a listener from the collection of listeners notified when the model changes
	 * @param listener the listener to remove
	 * @see #addChangeListener(ChangeListener)
	 */
	void removeChangeListener(ChangeListener listener);

	/**
	 * Returns by {@link #lock()} to allow releasing the lock
	 */
	static interface Lock extends AutoCloseable {
		@Override
		void close();
	}

	/**
	 * Locks the notifier so that any changes are queued and listeners are not notified until the lock is closed
	 * @return the lock
	 * @see Lock#close()
	 */
	Lock lock();
}
