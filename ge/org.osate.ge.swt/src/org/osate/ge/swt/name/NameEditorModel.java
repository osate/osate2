package org.osate.ge.swt.name;

import org.osate.ge.swt.ObservableModel;

/**
 * View Model interface for {@link NameEditor}
 *
 */
public interface NameEditorModel extends ObservableModel {
	/**
	 * Returns whether the view should be enabled.
	 * @return true if the view should be enabled.
	 */
	boolean isEnabled();

	/**
	 * Returns the name being displayed/edited.
	 * @return the name to display in the editor.
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
	 * @param value is the new name.
	 */
	void setName(String value);
}
