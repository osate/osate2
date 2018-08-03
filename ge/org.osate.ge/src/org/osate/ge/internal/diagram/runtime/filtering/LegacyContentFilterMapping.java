package org.osate.ge.internal.diagram.runtime.filtering;

import java.util.Optional;

import com.google.common.collect.ImmutableSet;

public enum LegacyContentFilterMapping {
	ALLOW_FUNDAMENTAL("allow_fundamental",
			getFundamentalFilters()), ALLOW_TYPE("allow_type",
					getTypeFilters()), ALLOW_ALL("allow_all", getAllFilters());

	private final String id;
	private final ImmutableSet<String> contentFilterIds;

	LegacyContentFilterMapping(final String id, final ImmutableSet<String> contentFilterIds) {
		this.id = id;
		this.contentFilterIds = contentFilterIds;
	}

	public String getId() {
		return id;
	}

	public ImmutableSet<String> getContentFilterIds() {
		return contentFilterIds;
	}

	public static Optional<LegacyContentFilterMapping> getById(final String id) {
		for (final LegacyContentFilterMapping m : values()) {
			if (m.id.equals(id)) {
				return Optional.of(m);
			}
		}

		return Optional.empty();
	}

	private static ImmutableSet<String> getFundamentalFilters() {
		return ImmutableSet.of(GeneralizationFilter.ID, SubprogramCallOrderFilter.ID, CalledSubprogramFilter.ID);
	}

	private static ImmutableSet<String> getTypeFilters() {
		final ImmutableSet.Builder<String> builder = ImmutableSet.builder();
		builder.addAll(getFundamentalFilters());
		builder.add(FeatureFilter.ID);
		builder.add(FlowSpecificationFilter.ID);
		builder.add(ModeFilter.ID);
		builder.add(ModeTransitionFilter.ID);
		builder.add(SubcomponentTypeFilter.ID);
		// There isn't a filter for mode transition triggers. Those are handled manually by the conversion process.
		return builder.build();
	}

	private static ImmutableSet<String> getAllFilters() {
		final ImmutableSet.Builder<String> builder = ImmutableSet.builder();
		builder.addAll(getTypeFilters());
		builder.add(ClassifierFilter.ID);
		builder.add(ConnectionFilter.ID);
		builder.add(InternalFeatureFilter.ID);
		builder.add(ProcessorFeatureFilter.ID);
		builder.add(ModeTransitionTriggerNameFilter.ID);
		builder.add(SubcomponentFilter.ID);
		builder.add(SubprogramCallFilter.ID);
		builder.add(SubprogramCallSequenceFilter.ID);
		return builder.build();
	}
}
