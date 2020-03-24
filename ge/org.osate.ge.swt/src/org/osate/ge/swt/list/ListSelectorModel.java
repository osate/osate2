package org.osate.ge.swt.list;

import org.osate.ge.swt.ObservableModel;

/**
 * View model for various list views contained in this package.
 *
 * @param <T> is the type of element provided by the model.
 */
public interface ListSelectorModel<T> extends ObservableModel {
	/**
	 * Returns whether the view should be enabled.
	 * @return true if the view should be enabled.
	 */
	default boolean isEnabled() {
		return true;
	}

	/**
	 * Returns an array of objects. Each object represents a member of the list.
	 * @return an array of objects representing the elements of the list.
	 */
	T[] getElements();

	/**
	 * Returns the currently selected element
	 * @return is the object for the selected element.
	 */
	T getSelectedElement();

	/**
	 * Sets the currently selected element
	 * @param element is the newly selected element.
	 */
	void setSelectedElement(T element);

	/**
	 * Returns the label for the element.
	 * @param element is the element for which to return the label.
	 * @return is the label for the specified element.
	 */
	default String getLabel(T element) {
		return element.toString();
	}
}
