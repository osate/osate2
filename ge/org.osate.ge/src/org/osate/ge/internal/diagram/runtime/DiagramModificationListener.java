/**
 * Copyright (c) 2004-2024 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.internal.diagram.runtime;

/**
 * Interface used to receive notifications regarding diagram modifications.
 * The notifier may not provide notifications for each change. Instead, the caller will notifier will notify after a sequence of related
 * changes have been made. For example, if an element is added and then a series of updates is performed on that element, only a single added
 * notification should be provided. This allows a more fully initialized element to be provided to listeners and prevents unnecessary notifications.
 *
 * Notifications are not guaranteed to be sent immediately after a change is made. Element change notifications will be sent before
 * {@link #beforeModificationsCompleted(BeforeModificationsCompletedEvent)} is called.
 *
 * However, multiple notifications of an element may be sent if other elements are updated between updates of the original element.
 */
public interface DiagramModificationListener {
	/**
	 * Called after the diagram configuration is changed
	 * @param e the event details
	 */
	void diagramConfigurationChanged(DiagramConfigurationChangedEvent e);

	/**
	 * Called after a diagram element is added
	 * @param e the event details
	 */
	void elementAdded(ElementAddedEvent e);

	/**
	 * Called after a diagram element is removed
	 * @param e the event details
	 */
	void elementRemoved(ElementRemovedEvent e);

	/**
	 * Called after a diagram element is updated
	 * @param e the event details
	 */
	void elementUpdated(ElementUpdatedEvent e);

	/**
	 * Provides a mechanism to perform additional changes before {@link #modificationsCompleted} is called.
	 * If additional modifications are made during this method, events will not be generated for them.
	 * @param e the event details
	 */
	void beforeModificationsCompleted(BeforeModificationsCompletedEvent e);

	/**
	 * Called when a modification is complete. Must not make modifications to the diagram.
	 * @param e the event details.
	 */
	void modificationsCompleted(ModificationsCompletedEvent e);
}