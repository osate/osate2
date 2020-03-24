package org.osate.ge.swt.name;

/**
 * View Model interface for {@link NameEditorDialog}
 *
 */
public interface NameEditorDialogModel {
	/**
	 * Returns the name being edited.
	 * @return is the initial value for the name being edited.
	 */
	String getName();

	/**
	 * Validates a potential new name. Should be called before calling {@link #setName(String)}.
	 * @param value is the potential new name.
	 * @return null is the validation succeeds. Otherwise, a message for display to the user describing the problem with the provided value.
	 */
	String validateName(String value);

	/**
	 * Updates the name.
	 * @param value is the new name for the name.
	 */
	void setName(String value);
}
