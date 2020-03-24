package org.osate.ge.swt.list;

import org.osate.ge.swt.ObservableModel;

// TODO: Consider: if generic.. could be more typesafe.. Would that heart the ability to reuse the compoinent.. Don't think so..
// TODO: This is a strict subset of listeditormodel
// TODO: REname
public interface ListViewerModel extends ObservableModel {
	/**
	 * Returns an array of objects. Each object represents a member of the list.
	 * @return an array of objects representing the elements of the list.
	 */
	Object[] getElements();

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
