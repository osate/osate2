/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.swt.selectors;

import java.util.stream.Stream;

import org.osate.ge.swt.ObservableModel;

/**
 * View model for various selector views contained in this package.
 *
 * @param <T> is the type of element provided by the model.
 */
public interface SelectorModel<T> extends ObservableModel {
	/**
	 * Returns whether the view should be enabled.
	 * @return true if the view should be enabled.
	 */
	default boolean isEnabled() {
		return true;
	}

	/**
	 * Returns a steam of object to display in the selector.
	 * @return a stream of objects to be included in the selector. Must not return null.
	 */
	Stream<T> getElements();

	/**
	 * Returns the currently selected element
	 * @return is the object for the selected element.
	 */
	T getSelectedElement();

	/**
	 * Sets the currently selected element
	 * @param value is the newly selected element.
	 */
	void setSelectedElement(T value);

	/**
	 * Returns the label for the specified element.
	 * @param element is the element for which to return the label.
	 * @return is the label for the specified element.
	 */
	String getLabel(T element);
}
