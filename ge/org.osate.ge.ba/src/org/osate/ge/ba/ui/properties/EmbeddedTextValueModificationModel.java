package org.osate.ge.ba.ui.properties;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.NamedElement;

/**
 * Model for editing {@link EmbeddedTextValue}
 * @since 2.0
 */
public interface EmbeddedTextValueModificationModel {
	/**
	 * The title of the dialog used to edit an {@link EmbeddedTextValue}
	 * @return the title of the dialog for editing embedded text
	 */
	String getEditDialogTitle();

	/**
	 * The message of the dialog used to edit an {@link EmbeddedTextValue}
	 * @return the message of the dialog for editing embedded text
	 */
	String getEditDialogMessage();

	/**
	 * The label for the modification when an {@link EmbeddedTextValue} is executed
	 * @return the message
	 */
	String getModificationLabel();

	/**
	 * Determines if the new text is valid replacement for the editable text of an {@link EmbeddedTextValue} for the AADL model
	 * @param bo the business object being modified
	 * @param newText the text to replace editable text in an {@link EmbeddedTextValue}
	 * @return whether the new text is valid replacement
	 */
	boolean isValidModification(final EObject bo, final String newText);

	/**
	 * @return the {@link NamedElement} being modified
	 */
	NamedElement getElementToModify();

	/**
	 * Modify the AADL source using the {@link EmbeddedTextValue} prefix and suffix
	 * that is needed to test whether the edited text is valid
	 * @param newText the modified text
	 * @return an optional of the modified AADL source to validate the
	 * modified text.  Empty if no modification is required.
	 */
	default Optional<String> getModifiedAADLSourceForNewText(final String newText) {
		return Optional.empty();
	}
}
