package org.osate.ge.swt.selectors;

/**
 * View Model used by {@link ListEditor}
 *
 */
public interface ListEditorModel<T> extends SelectorModel<T> {
	/**
	 * Returns whether an element is allowed to be added to the list.
	 * @return whether an element is allowed be added.
	 */
	boolean canAdd();

	/**
	 * Creates a new element and adds it to the list. This method should only be called if {@link #canAdd()} returns true.
	 */
	void addElement();

	/**
	 * Removes an element from the list
	 * @param value is the element to remove. Must be an object contained in the array returned by {@link #getElements()}
	 */
	void removeElement(T value);
}
