package org.osate.ge.ba.ui.swt;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.NamedElement;

/**
 * Model for editing embedded AADL models
 * @since 2.0
 */
interface EmbeddedTextValueEditModel {
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
