package org.osate.ge.swt.list;

/**
 * View Model used by {@link ListEditor}
 *
 */
public interface ListEditorModel extends ListViewerModel {
	/**
	 * Creates a new element and adds it to the list.
	 */
	void addElement();

	/**
	 * Removes an element from the list
	 * @param element is the element to remove. Must be an object contained in the array returned by {@link #getElements()}
	 */
	void removeElement(Object element);
}
