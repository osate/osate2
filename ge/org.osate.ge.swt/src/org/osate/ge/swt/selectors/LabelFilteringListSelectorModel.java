package org.osate.ge.swt.selectors;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Implements {@link FilteringSelectorModel} by filtering elements provided by a {@link ListEditorModel}.
 * Case-insensitive. Supports * and ? wildcards. Implicitly adds "*" to start and end of filter.
 *
 * @param <T> is the type of element provided by the model.
 */
public class LabelFilteringListSelectorModel<T> extends SelectorModelDecorator<T>
		implements FilteringSelectorModel<T> {
	private String filter;
	private Pattern regex;

	public LabelFilteringListSelectorModel(final SelectorModel<T> inner) {
		super(inner);
		this.setFilter("");
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

	@Override
	public Stream<T> getElements() {
		return super.getElements().filter(e -> regex.matcher(getLabel(e)).matches());
	}
}
