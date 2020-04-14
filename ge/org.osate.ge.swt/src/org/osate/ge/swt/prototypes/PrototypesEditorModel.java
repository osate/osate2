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
 * View Model interface for {@link PrototypesEditor}
 *
 * @param <P> the type of the prototypes being edited.
 * @param <C> the type used for the constraining classifier of the prototypes.
 */
public interface PrototypesEditorModel<P, C> extends ObservableModel {
	/**
	 * Returns a stream of prototypes. See {@link org.osate.ge.swt.selectors.ListEditorModel#getElements()}
	 * @return is a stream of prototypes.
	 */
	Stream<P> getPrototypes();

	/**
	 * Returns whether a new prototype can be created. See {@link org.osate.ge.swt.selectors.ListEditorModel#canAdd()}
	 * @return whether a new prototype can be created.
	 */
	boolean canAddPrototype();

	/**
	 * Creates a new prototype. See {@link org.osate.ge.swt.selectors.ListEditorModel#addElement()}
	 */
	void addPrototype();

	/**
	 * Removes a prototype. See {@link org.osate.ge.swt.selectors.ListEditorModel#removeElement(Object)}
	 * @param prototype is the prototype to remove.
	 */
	void removePrototype(P prototype);

	/**
	 * Get a string that can be shown to the user to identify the specified prototype.
	 * @param prototype is the prototype for which to return the label.
	 * @return the label of the specified prototype.
	 */
	String getPrototypeLabel(P prototype);

	/**
	 * Returns the currently selected prototype. See {@link org.osate.ge.swt.selectors.ListEditorModel#getSelectedElement()}
	 * @return is the currently selected prototype.
	 */
	P getSelectedPrototype();

	/**
	 * Sets the currently selected prototype. See {@link org.osate.ge.swt.selectors.ListEditorModel#setSelectedElement(Object)}
	 * @param value is the newly selected prototype.
	 */
	void setSelectedPrototype(P value);

	/**
	 * Get the name of the specified prototype.
	 * @param prototype is the prototype for which to return the name.
	 * @return the name of the specified prototype.
	 */
	String getPrototypeName(P prototype);

	/**
	 * Updates the name of the specified prototype to the specified value.
	 * @param prototype is the prototype for which to set the name.
	 * @param value is the new name for the prototype.
	 */
	void setPrototypeName(P prototype, String value);

	/**
	 * Validates a potential new name of the specified prototype. Should be called before calling {@link #setPrototypeName(Object, String)}.
	 * @param prototype is the name of the prototype for which to validate the name
	 * @param newName is the potential new name.
	 * @return null is the validation succeeds. Otherwise, a message for display to the user describing the problem with the provided value.
	 */
	String validatePrototypeName(P prototype, String newName);

	/**
	 * Get the direction of the specified prototype.
	 * @param prototype is the prototype for which to return the direction.
	 * @return the direction of the specified prototype. Returns null if the prototype does not have a direction value available.
	 */
	PrototypeDirection getPrototypeDirection(P prototype);

	/**
	 * Updates the direction of the specified prototype
	 * @param prototype is the prototype for which to set the direction.
	 * @param value is the new direction for the specified prototype.
	 */
	void setPrototypeDirection(P prototype, PrototypeDirection value);

	/**
	 * Get the type of the specified prototype.
	 * @param prototype is the prototype for which to return the type.
	 * @return the type of the specified prototype. Returns null if the prototype does not have a type value available.
	 */
	PrototypeType getPrototypeType(P prototype);

	/**
	 * Updates the direction of the specified prototype
	 * @param prototype is the prototype for which to set the type.
	 * @param value is the new type for the specified prototype.
	 */
	void setPrototypeType(P prototype, PrototypeType value);

	/**
	 * Returns a stream of classifiers based on the current prototype type.
	 * @param prototype is the prototype for which to get the options.
	 * @return a stream of potential classifiers based on the current prototype type
	 */
	Stream<C> getConstrainingClassifierOptions(P prototype);

	/**
	 * Returns the label for the specified classifier.
	 * @param classifier is the classifier for which to return the label.
	 * @return is the label for the specified classifier
	 */
	String getClassifierLabel(C classifier);

	/**
	 * Get the current set constraining classifier.
	 * @param prototype is the prototype for which to get the constraining classifier.
	 * @return the constraining classifier for the prototype.
	 */
	C getConstrainingClassifier(P prototype);

	/**
	 * Updates the constraining classifier.
	 * @param prototype is the prototype for which to set the constraining classifier.
	 * @param value the new constraining classifier.
	 */
	void setConstrainingClassifier(P prototype, C value);

	/**
	 * Returns whether the prototype is an array.
	 * @param prototype is the prototype for which to return whether it is an array.
	 * @return whether the prototype is an array. Returns null if is indeterminate.
	 */
	Boolean isArray(P prototype);

	/**
	 * Updates whether the prototype is an array.
	 * @param prototype is the prototype for which to set whether it is an array.
	 * @param value whether the prototype is an array.
	 */
	void setArray(P prototype, boolean value);

	/**
	 * Returns a string identifying the element(s) that can be or is been refined.
	 * @param prototype is the prototype for which to get the refineable element label.
	 * @return a string appropriate for display to the user. null if the prototype cannot be refined.
	 */
	String getRefineableElementLabel(P prototype);

	/**
	 * Returns whether the prototype is refined.
	 * @param prototype is the prototype for which to return whether it is refined.
	 * @return whether the prototype is refined.
	 */
	Boolean isRefined(P prototype);

	/**
	 * Updates whether the prototype is refined. Should not be called unless {@link #getRefineableElementLabel(Object)} returns non-null.
	 * @param prototype is the prototype for which to set whether it is refined.
	 * @param value whether the prototype is refined.
	 */
	void setRefined(P prototype, boolean value);
}
