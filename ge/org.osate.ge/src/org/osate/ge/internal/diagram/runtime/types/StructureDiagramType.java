package org.osate.ge.internal.diagram.runtime.types;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.ge.DiagramType;
import org.osate.ge.internal.diagram.runtime.filtering.ConnectionFilter;
import org.osate.ge.internal.diagram.runtime.filtering.FeatureFilter;
import org.osate.ge.internal.diagram.runtime.filtering.FlowSpecificationFilter;
import org.osate.ge.internal.diagram.runtime.filtering.InternalFeatureFilter;
import org.osate.ge.internal.diagram.runtime.filtering.ProcessorFeatureFilter;
import org.osate.ge.internal.diagram.runtime.filtering.SubcomponentFilter;
import org.osate.ge.internal.diagram.runtime.filtering.SubprogramCallFilter;
import org.osate.ge.internal.diagram.runtime.filtering.SubprogramCallOrderFilter;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;

public class StructureDiagramType implements DiagramType {
	public static final String ID = "structure";

	private final ImmutableSet<String> defaultClassifierFilters = ImmutableSet.of(FeatureFilter.ID,
			InternalFeatureFilter.ID, ProcessorFeatureFilter.ID, ConnectionFilter.ID, FlowSpecificationFilter.ID,
			SubcomponentFilter.ID);
	private final ImmutableSet<String> defaultSubcomponentFilters = ImmutableSet.of(FeatureFilter.ID,
			InternalFeatureFilter.ID, ProcessorFeatureFilter.ID, ConnectionFilter.ID, FlowSpecificationFilter.ID);
	private final ImmutableSet<String> defaultSubprogramCallSequenceFilters = ImmutableSet
			.of(SubprogramCallOrderFilter.ID, SubprogramCallFilter.ID);
	private final ImmutableSet<String> defaultSubprogramCallFilters = ImmutableSet.of(FeatureFilter.ID,
			FlowSpecificationFilter.ID);

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public String getName() {
		return "Structure Diagram";
	}

	@Override
	public boolean isApplicableToContext(final Object contextBo) {
		return contextBo instanceof Classifier
				|| contextBo instanceof SystemInstance;
	}

	@Override
	public ImmutableSet<String> getDefaultContentFilters(final Object bo) {
		if (bo instanceof Classifier || bo instanceof SystemInstance) {
			return defaultClassifierFilters;
		} else if (bo instanceof Subcomponent || bo instanceof ComponentInstance) {
			return defaultSubcomponentFilters;
		} else if (bo instanceof SubprogramCallSequence) {
			return defaultSubprogramCallSequenceFilters;
		} else if (bo instanceof SubprogramCall) {
			return defaultSubprogramCallFilters;
		}

		return DiagramTypeUtil.getDefaultContentFilters(bo);
	}

	@Override
	public ImmutableCollection<String> getDefaultAadlPropertyNames() {
		return ImmutableSet.of();
	}
}
