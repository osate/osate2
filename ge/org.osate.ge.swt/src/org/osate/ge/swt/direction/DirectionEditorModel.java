package org.osate.ge.swt.direction;

import org.osate.ge.swt.ObservableModel;

/**
 * View Model used by {@link DirectionEditor}
 *
 */
public interface DirectionEditorModel extends ObservableModel {
	/**
	 * Returns whether the view should be enabled.
	 * @return whether the view should be enabled.
	 */
	boolean isEnabled();

	/**
	 * Returns the current value of the direction.
	 * @return the direction to display in the editor.
	 */
	Direction getDirection();

	/**
	 * Updates the value of the direction.
	 * @param value is the new value for the direction.
	 */
	void setDirection(final Direction value);
}
