package org.osate.ge.ba.ui.properties;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.NamedElement;

/**
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
	 *
	 * @param bo
	 * @param newText
	 * @return
	 */
	boolean isValidModification(final EObject bo, final String editableText);

	/**
	 * @return the element being modified
	 */
	NamedElement getElementToModify();

	/**
	 * Modify the AADL source using the {@link EmbeddedTextValue} prefix and suffix
	 * that is needed to test whether the edited text is valid
	 * @param embeddedTextValue the current embedded text value
	 * @param editableText the edited editable text
	 * @return an optional of the modified AADL source to validate the
	 * edited text.  Empty of no modification is required.
	 */
	default Optional<String> getModifiedAADLSourceForNewEditableText(final String editableText) {
		return Optional.empty();
	}
}
