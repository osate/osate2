package org.osate.ge.internal.diagram.runtime.filtering;

import java.util.Optional;

import org.osate.ge.ContentFilter;
import org.osate.ge.FundamentalContentFilter;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;

public interface ContentFilterProvider {
	ImmutableCollection<ContentFilter> getConfigurableContentFilters();

	ImmutableCollection<FundamentalContentFilter> getFundamentalContentFilters();

	/**
	 * Returns the configurable content filter by ID
	 * @param id
	 * @return
	 */
	default Optional<ContentFilter> getContentFilterById(String id) {
		for (final ContentFilter contentFilter : getConfigurableContentFilters()) {
			if (contentFilter.getId().equals(id)) {
				return Optional.of(contentFilter);
			}
		}

		return Optional.empty();
	}

	default ImmutableSet<ContentFilter> getApplicableContentFilters(final Object bo) {
		return getConfigurableContentFilters().stream().filter(cf -> cf.isApplicable(bo)).collect(ImmutableSet.toImmutableSet());
	}

	default boolean isFundamental(final Object bo) {
		return getFundamentalContentFilters().stream().anyMatch(cf -> cf.test(bo));
	}
}
