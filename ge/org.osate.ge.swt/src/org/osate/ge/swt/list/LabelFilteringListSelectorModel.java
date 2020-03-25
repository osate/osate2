package org.osate.ge.swt.list;

import java.lang.reflect.Array;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.osate.ge.swt.BaseObservableModel;
import org.osate.ge.swt.ChangeEvent;

/**
 * Implements {@link FilterableListSelectorModel} by filtering elements provided by a {@link ListEditorModel}.
 * Case-insensitive. Supports * and ? wildcards. Implicitly adds "*" to start and end of filter.
 *
 * @param <T> is the type of element provided by the model.
 */
public class LabelFilteringListSelectorModel<T> extends BaseObservableModel implements FilterableListSelectorModel<T> {
	private final ListEditorModel<T> inner;
	private String filter;
	private Pattern regex;
	private final Consumer<ChangeEvent> changeListener = e -> triggerChangeEvent();

	public LabelFilteringListSelectorModel(final ListEditorModel<T> inner) {
		this.inner = Objects.requireNonNull(inner);
		this.setFilter("");
		this.inner.changed().addListener(changeListener);
	}

	@Override
	public String getPrompt() {
		return "Select an element.";
	}

	@Override
	public String getFilter() {
		return filter;
	}

	@Override
	public void setFilter(final String value) {
		Objects.requireNonNull(value);

		// Update the filter and regular expression
		if (!Objects.equals(filter, value)) {
			this.filter = value;

			// Update the regex
			int flags = Pattern.CASE_INSENSITIVE;

			// Build a regular expression based on the pattern. The expression should add wildcards to each end and optionally process wildcards in the pattern
			String regexPattern = filter.replaceAll("\\\\E", Matcher.quoteReplacement("\\E\\\\E\\Q"));
			regexPattern = regexPattern.replaceAll("\\*", Matcher.quoteReplacement("\\E.*\\Q"));
			regexPattern = regexPattern.replaceAll("\\?", Matcher.quoteReplacement("\\E.?\\Q"));
			regexPattern = ".*\\Q" + regexPattern + "\\E.*"; // Add quotes and wildcards
			this.regex = Pattern.compile(regexPattern, flags);

			triggerChangeEvent();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] getElements() {
		final T[] original = inner.getElements();

		// Filter elements by label using the regular expression
		return Stream.of(original).filter(e -> regex.matcher(inner.getLabel(e)).matches())
				.toArray(s -> (T[]) Array.newInstance(original.getClass().getComponentType(), s));
	}

	@Override
	public T getSelectedElement() {
		return inner.getSelectedElement();
	}

	@Override
	public void setSelectedElement(T element) {
		inner.setSelectedElement(element);
	}
}
