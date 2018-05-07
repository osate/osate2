package org.osate.ge.internal.diagram.runtime.types;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.DiagramType;
import org.osate.ge.internal.diagram.runtime.filtering.ModeFilter;
import org.osate.ge.internal.diagram.runtime.filtering.ModeTransitionFilter;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;

public class ModeDiagramType implements DiagramType {
	private final ImmutableSet<String> defaultClassifierOrSubcomponentFilters = ImmutableSet.of(ModeFilter.ID,
			ModeTransitionFilter.ID);

	@Override
	public String getId() {
		return "mode";
	}

	@Override
	public String getName() {
		return "Mode Diagram";
	}

	@Override
	public boolean isApplicableToContext(final Object contextBo) {
		return contextBo instanceof ComponentClassifier;
	}

	@Override
	public ImmutableSet<String> getDefaultContentFilters(final Object bo) {
		if (bo instanceof Classifier || bo instanceof Subcomponent) {
			return defaultClassifierOrSubcomponentFilters;
		}

		return DiagramTypeUtil.getDefaultContentFilters(bo);
	}

	@Override
	public ImmutableCollection<String> getDefaultAadlPropertyNames() {
		return ImmutableSet.of();
	}
}
