package org.osate.ge.swt.list;

/**
 * View Model used by {@link FilteringListSelector}. It is the view models responsibility to keep track of and apply the filter
 * to returned results.
 */
public interface FilterableListSelectorModel<T> extends ListSelectorModel<T> {
	/**
	 * Returns the prompt to be displayed to the user.
	 * @return the prompt to be displayed to the user. Must not be null.
	 */
	String getPrompt();

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
