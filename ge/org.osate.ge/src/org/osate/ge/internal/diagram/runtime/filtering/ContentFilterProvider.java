package org.osate.ge.internal.diagram.runtime.filtering;

import java.util.Optional;

import org.osate.ge.ContentFilter;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;

public interface ContentFilterProvider {
	ImmutableCollection<ContentFilter> getContentFilters();

	default Optional<ContentFilter> getContentFilterById(String id) {
		for (final ContentFilter contentFilter : getContentFilters()) {
			if (contentFilter.getId().equals(id)) {
				return Optional.of(contentFilter);
			}
		}

		return Optional.empty();
	}

	default ImmutableSet<ContentFilter> getApplicableContentFilters(final Object bo) {
		return getContentFilters().stream().filter(cf -> cf.isApplicable(bo)).collect(ImmutableSet.toImmutableSet());
	}
}
