package org.osate.ge.swt.selectors;

/**
 * View Model used by {@link FilteringListSelector}. It is the view models responsibility to keep track of and apply the filter
 * to returned results.
 */
public interface FilteringSelectorModel<T> extends SelectorModel<T> {
	/**
	 * Returns the current filter.
	 * @return the current filter. Must not be null.
	 */
	String getFilter();

	/**
	 * Updates the filter.
	 * @param value the new filter. Must not be null.
	 */
	void setFilter(String value);

}
