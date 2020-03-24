package org.osate.ge.swt.prototypes;

import org.osate.ge.swt.ObservableModel;
import org.osate.ge.swt.direction.Direction;

/**
 * View Model interface for {@link PrototypesEditor}
 *
 */
public interface PrototypesEditorModel extends ObservableModel {
	/**
	 * Returns an array of prototypes. See {@link org.osate.ge.swt.list.ListEditorModel#getElements()}
	 * @return is an array of prototypes.
	 */
	Object[] getPrototypes();

	/**
	 * Creates a new prototype. See {@link org.osate.ge.swt.list.ListEditorModel#addElement()}
	 */
	void addPrototype();

	/**
	 * Removes a prototype. See {@link org.osate.ge.swt.list.ListEditorModel#removeElement(Object)}
	 * @param prototype is the prototype to remove.
	 */
	void removePrototype(Object prototype);

	/**
	 * Returns the currently selected prototype. See {@link org.osate.ge.swt.list.ListEditorModel#getSelectedElement()}
	 * @return is the currently selected prototype.
	 */
	Object getSelectedPrototype();

	/**
	 * Sets the currently selected prototype. See {@link org.osate.ge.swt.list.ListEditorModel#setSelectedElement(Object)}
	 * @param value is the newly selected prototype.
	 */
	void setSelectedPrototype(Object value);

	/**
	 * Get the name of the specified prototype.
	 * @param prototype is the prototype for which to return the name.
	 * @return the name of the specified prototype.
	 */
	String getPrototypeName(Object prototype);

	/**
	 * Updates the name of the specified prototype to the specified value.
	 * @param prototype is the prototype for which to set the name.
	 * @param value is the new name for the prototype.
	 */
	void setPrototypeName(Object prototype, String value);

	/**
	 * Validates a potential new name of the specified prototype. Should be called before calling {@link #setPrototypeName(Object, String)}.
	 * @param prototype is the name of the prototype for which to validate the name
	 * @param newName is the potential new name.
	 * @return null is the validation succeeds. Otherwise, a message for display to the user describing the problem with the provided value.
	 */
	String validatePrototypeName(Object prototype, String newName);

	/**
	 * Get the direction of the specified prototype.
	 * @param prototype is the prototype for which to return the direction.
	 * @return the direction of the specified prototype. Returns null if the prototype does not have a direction value available.
	 */
	Direction getPrototypeDirection(Object prototype);

	/**
	 * Updates the direction of the specified prototype
	 * @param prototype is the prototype for which to set the direction.
	 * @param value is the new direction for the specified prototype.
	 */
	void setPrototypeDirection(Object prototype, Direction value);

	/**
	 * Get the type of the specified prototype.
	 * @param prototype is the prototype for which to return the type.
	 * @return the type of the specified prototype. Returns null if the prototype does not have a type value available.
	 */
	PrototypeType getPrototypeType(Object prototype);

	/**
	 * Updates the direction of the specified prototype
	 * @param prototype is the prototype for which to set the type.
	 * @param value is the new type for the specified prototype.
	 */
	void setPrototypeType(Object prototype, PrototypeType value);
}
