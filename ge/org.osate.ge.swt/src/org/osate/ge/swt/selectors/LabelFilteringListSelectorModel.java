/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
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
