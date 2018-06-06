package org.osate.ge.internal.diagram.runtime.types;

import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.ge.internal.diagram.runtime.filtering.ModeTransitionTriggerNameFilter;
import org.osate.ge.internal.diagram.runtime.filtering.SubprogramCallOrderFilter;

import com.google.common.collect.ImmutableSet;

/**
 * Class containing methods which are shared between the various diagram types.
 *
 */
public class DiagramTypeUtil {
	private static final ImmutableSet<String> defaultModeTransitionFilters = ImmutableSet
			.of(ModeTransitionTriggerNameFilter.ID);

	private static final ImmutableSet<String> defaultSubprogramCallSequenceFilters = ImmutableSet
			.of(SubprogramCallOrderFilter.ID);

	static ImmutableSet<String> getDefaultContentFilters(final Object bo) {
		if (bo instanceof ModeTransition) {
			return defaultModeTransitionFilters;
		} else if (bo instanceof SubprogramCallSequence) {
			return defaultSubprogramCallSequenceFilters;
		}


		return ImmutableSet.of();
	}
}
