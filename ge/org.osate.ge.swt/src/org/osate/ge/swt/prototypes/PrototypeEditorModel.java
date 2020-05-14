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
package org.osate.ge.swt.prototypes;

import java.util.stream.Stream;

import org.osate.ge.swt.ObservableModel;

/**
 * View Model used by {@link PrototypeEditor}
 *
 * @param <C> the type used for the constraining classifier of the prototype.
 */
interface PrototypeEditorModel<C> extends ObservableModel {
	/**
	 * Returns whether the view should be enabled.
	 * @return true is the view should be enabled.
	 */
	boolean isEnabled();

	/**
	 * See {@link org.osate.ge.swt.name.NameEditorModel#getName()}
	 * @return the name of the prototype.
	 */
	String getName();

	/**
	 * See {@link org.osate.ge.swt.name.NameEditorModel#validateName(String)}
	 * @param value is the potential new name of the prototype to be validated.
	 * @return null is the validation succeeds. Otherwise, a message for display to the user describing the problem with the provided value.
	 */
	String validateName(String value);

	/**
	 * See {@link org.osate.ge.swt.name.NameEditorModel#setName(String)}
	 * @param value the new name for the prototype.
	 */
	void setName(String value);

	/**
	 * Gets the prototype's direction
	 * @return the direction of the prototype. Returns null if the prototype does not have a direction value available.
	 */
	PrototypeDirection getDirection();

	/**
	 * Updates the prototype's direction
	 * @param value is the new direction for the prototype.
	 */
	void setDirection(final PrototypeDirection value);

	/**
	 * Returns the current value for type.
	 * @return the type to display in the editor.
	 */
	PrototypeType getType();

	/**
	 * Updates the value for the type.
	 * @param value is the new value for type.
	 */
	void setType(final PrototypeType value);

	/**
	 * Returns a stream of classifiers based on the current prototype type.
	 * @return a stream of potential classifiers based on the current prototype type
	 */
	Stream<C> getConstrainingClassifierOptions();

	/**
	 * Returns the label for the specified classifier.
	 * @param classifier is the classifier for which to return the label.
	 * @return is the label for the specified classifier
	 */
	String getClassifierLabel(C classifier);

	/**
	 * Get the current set constraining classifier.
	 * @return the constraining classifier for the prototype.
	 */
	C getConstrainingClassifier();

	/**
	 * Updates the constraining classifier.
	 * @param value the new constraining classifier.
	 */
	void setConstrainingClassifier(C value);

	/**
	 * Returns whether the prototype is an array.
	 * @return whether the prototype is an array. Returns null if it is indeterminate.
	 */
	Boolean isArray();

	/**
	 * Updates whether the prototype is an array.
	 * @param value whether the prototype is an array.
	 */
	void setArray(boolean value);

	/**
	 * Returns a string identifying the element(s) that can be or is been refined.
	 * @return a string appropriate for display to the user. null if the prototype cannot be refined
	 */
	String getRefineableElementLabel();

	/**
	 * Returns whether the prototype is refined.
	 * @return whether the prototype is refined.
	 */
	Boolean isRefined();

	/**
	 * Updates whether the prototype is refined.
	 * @param value whether the prototype is refined.
	 */
	void setRefined(boolean value);
}
