package org.osate.ge.swt.selectors;

import java.util.stream.Stream;

import org.osate.ge.swt.ObservableModel;

/**
 * View model for various selector views contained in this package.
 *
 * @param <T> is the type of element provided by the model.
 */
public interface SelectorModel<T> extends ObservableModel {
	/**
	 * Returns whether the view should be enabled.
	 * @return true if the view should be enabled.
	 */
	default boolean isEnabled() {
		return true;
	}

	/**
	 * Returns a steam of object to display in the selector.
	 * @return a stream of objects to be included in the selector. Must not return null.
	 */
	Stream<T> getElements();

	/**
	 * Returns the currently selected element
	 * @return is the object for the selected element.
	 */
	T getSelectedElement();

	/**
	 * Sets the currently selected element
	 * @param value is the newly selected element.
	 */
	void setSelectedElement(T value);

	/**
	 * Returns the label for the specified element.
	 * @param element is the element for which to return the label.
	 * @return is the label for the specified element.
	 */
	String getLabel(T element);
}
