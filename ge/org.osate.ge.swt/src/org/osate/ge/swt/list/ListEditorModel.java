package org.osate.ge.swt.list;

import org.osate.ge.swt.ObservableModel;

/**
 * View Model used by {@link ListEditor}
 *
 */
public interface ListEditorModel extends ObservableModel {
	/**
	 * Returns an array of objects. Each object represents a member of the list.
	 * @return an array of objects representing the elements of the list.
	 */
	Object[] getElements();

	/**
	 * Creates a new element and adds it to the list.
	 */
	void addElement();

	/**
	 * Removes an element from the list
	 * @param element is the element to remove. Must be an object contained in the array returned by {@link #getElements()}
	 */
	void removeElement(Object element);

	/**
	 * Returns the currently selected element
	 * @return is the object for the selected element.
	 */
	Object getSelectedElement();

	/**
	 * Sets the currently selected element
	 * @param element is the newly selected element.
	 */
	void setSelectedElement(Object element);

	/**
	 * Returns the label for the element.
	 * @param element is the element for which to return the label.
	 * @return is the label for the specified element.
	 */
	String getLabel(Object element);
}
