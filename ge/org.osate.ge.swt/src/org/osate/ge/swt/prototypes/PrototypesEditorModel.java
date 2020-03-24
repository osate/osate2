package org.osate.ge.swt.prototypes;

import org.osate.ge.swt.ObservableModel;

/**
 * View Model interface for {@link PrototypesEditor}
 *
 */
public interface PrototypesEditorModel<T> extends ObservableModel {
	/**
	 * Returns an array of prototypes. See {@link org.osate.ge.swt.list.ListEditorModel#getElements()}
	 * @return is an array of prototypes.
	 */
	T[] getPrototypes();

	/**
	 * Creates a new prototype. See {@link org.osate.ge.swt.list.ListEditorModel#addElement()}
	 */
	void addPrototype();

	/**
	 * Removes a prototype. See {@link org.osate.ge.swt.list.ListEditorModel#removeElement(Object)}
	 * @param prototype is the prototype to remove.
	 */
	void removePrototype(T prototype);

	/**
	 * Returns the currently selected prototype. See {@link org.osate.ge.swt.list.ListEditorModel#getSelectedElement()}
	 * @return is the currently selected prototype.
	 */
	T getSelectedPrototype();

	/**
	 * Sets the currently selected prototype. See {@link org.osate.ge.swt.list.ListEditorModel#setSelectedElement(Object)}
	 * @param value is the newly selected prototype.
	 */
	void setSelectedPrototype(T value);

	/**
	 * Get the name of the specified prototype.
	 * @param prototype is the prototype for which to return the name.
	 * @return the name of the specified prototype.
	 */
	String getPrototypeName(T prototype);

	/**
	 * Updates the name of the specified prototype to the specified value.
	 * @param prototype is the prototype for which to set the name.
	 * @param value is the new name for the prototype.
	 */
	void setPrototypeName(T prototype, String value);

	/**
	 * Validates a potential new name of the specified prototype. Should be called before calling {@link #setPrototypeName(Object, String)}.
	 * @param prototype is the name of the prototype for which to validate the name
	 * @param newName is the potential new name.
	 * @return null is the validation succeeds. Otherwise, a message for display to the user describing the problem with the provided value.
	 */
	String validatePrototypeName(T prototype, String newName);

	/**
	 * Get the direction of the specified prototype.
	 * @param prototype is the prototype for which to return the direction.
	 * @return the direction of the specified prototype. Returns null if the prototype does not have a direction value available.
	 */
	PrototypeDirection getPrototypeDirection(T prototype);

	/**
	 * Updates the direction of the specified prototype
	 * @param prototype is the prototype for which to set the direction.
	 * @param value is the new direction for the specified prototype.
	 */
	void setPrototypeDirection(T prototype, PrototypeDirection value);

	/**
	 * Get the type of the specified prototype.
	 * @param prototype is the prototype for which to return the type.
	 * @return the type of the specified prototype. Returns null if the prototype does not have a type value available.
	 */
	PrototypeType getPrototypeType(T prototype);

	/**
	 * Updates the direction of the specified prototype
	 * @param prototype is the prototype for which to set the type.
	 * @param value is the new type for the specified prototype.
	 */
	void setPrototypeType(T prototype, PrototypeType value);
}
