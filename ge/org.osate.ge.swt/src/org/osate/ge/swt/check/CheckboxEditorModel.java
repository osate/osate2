package org.osate.ge.swt.check;

import org.osate.ge.swt.ObservableModel;

/**
 * View Model interface for {@link CheckboxEditor}
 *
 */
public interface CheckboxEditorModel extends ObservableModel {
	/**
	 * Returns whether the view should be enabled.
	 * @return true if the view should be enabled.
	 */
	boolean isEnabled();

	/**
	 * Returns the label for the checkbox.
	 * @return the label for the checkbox. Must not be null.
	 */
	String getLabel();

	/**
	 * Returns the value.
	 * @return is the state of the checkbox. A null value indicates that the checkbox value is indeterminate and should be greyed.
	 */
	Boolean getValue();

	/**
	 * Updates the value.
	 * @param value is the new value.
	 */
	void setValue(boolean value);

}
