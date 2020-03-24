package org.osate.ge.swt.prototypes;

import org.osate.ge.swt.ObservableModel;
import org.osate.ge.swt.direction.Direction;

/**
 * View Model used by {@link PrototypeEditor}
 *
 */
public interface PrototypeEditorModel extends ObservableModel {
	/**
	 * Returns whether the view should be enabled.
	 * @return true is the view shoudl be enabled.
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
	 * See {@link org.osate.ge.swt.direction.DirectionEditorModel#getDirection()}
	 * @return the direction of the prototype. Returns null if the prototype does not have a direction value available.
	 */
	Direction getDirection();

	/**
	 * See {@link org.osate.ge.swt.direction.DirectionEditorModel#setDirection(Direction)}
	 * @param value is the new direction for the prototype.
	 */
	void setDirection(final Direction value);

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
}
