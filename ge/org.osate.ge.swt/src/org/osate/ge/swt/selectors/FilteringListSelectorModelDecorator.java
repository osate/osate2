package org.osate.ge.swt.selectors;

import java.util.Objects;

public class FilteringListSelectorModelDecorator<T> extends SelectorModelDecorator<T>
		implements FilteringSelectorModel<T> {
	private final FilteringSelectorModel<T> inner;

	public FilteringListSelectorModelDecorator(FilteringSelectorModel<T> inner) {
		super(inner);
		this.inner = Objects.requireNonNull(inner, "inner must not be null");
	}

	@Override
	public String getFilter() {
		return inner.getFilter();
	}

	@Override
	public void setFilter(final String value) {
		inner.setFilter(value);
	}
}
