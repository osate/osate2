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
package org.osate.ge.ba.ui.properties;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.NamedElement;

/**
 * Model for editing embedded AADL models
 * @since 2.0
 */
public interface EmbeddedTextValueEditModel {
	/**
	 * The title of the dialog used to edit an {@link EditableEmbeddedTextValue}
	 * @return the title of the dialog for editing embedded text
	 */
	String getEditDialogTitle();

	/**
	 * The message of the dialog used to edit an {@link EditableEmbeddedTextValue}
	 * @return the message of the dialog for editing embedded text
	 */
	String getEditDialogMessage();

	/**
	 * The label for the modification when an {@link EditableEmbeddedTextValue} is executed
	 * @return the message
	 */
	String getModificationLabel();

	/**
	 * Determines if the new text is a valid replacement for the editable text of an {@link EditableEmbeddedTextValue} for the AADL model
	 * @param bo the business object being modified
	 * @param newText the text to replace editable text in an {@link EditableEmbeddedTextValue}
	 * @return whether the new text is valid replacement
	 */
	boolean isValidModification(final EObject bo, final String newText);

	/**
	 * @return the {@link NamedElement} being modified
	 */
	NamedElement getElementToModify();

	/**
	 * Modify the AADL source using the {@link EditableEmbeddedTextValue} prefix and suffix
	 * that is needed to test whether the edited text is valid
	 * @param newText the modified text
	 * @return an optional of the modified AADL source to validate the
	 * new text.  Empty if no modification is required.
	 */
	default Optional<String> getModifiedAADLSourceForNewText(final String newText) {
		return Optional.empty();
	}
}
