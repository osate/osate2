package org.osate.ge.internal.diagram.runtime.types;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.ge.DiagramType;
import org.osate.ge.internal.diagram.runtime.filtering.SubcomponentCategoryFilter;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;

public class ProcessorBindingDiagramType implements DiagramType {
	private final ImmutableSet<String> defaultClassifierOrSubcomponentFilters = ImmutableSet.of(
			SubcomponentCategoryFilter.getId(ComponentCategory.SYSTEM),
			SubcomponentCategoryFilter.getId(ComponentCategory.PROCESSOR),
			SubcomponentCategoryFilter.getId(ComponentCategory.VIRTUAL_PROCESSOR),
			SubcomponentCategoryFilter.getId(ComponentCategory.DEVICE),
			SubcomponentCategoryFilter.getId(ComponentCategory.THREAD),
			SubcomponentCategoryFilter.getId(ComponentCategory.THREAD_GROUP),
			SubcomponentCategoryFilter.getId(ComponentCategory.PROCESS));

	@Override
	public String getId() {
		return "processorBinding";
	}

	@Override
	public String getName() {
		return "Processor Binding Diagram";
	}

	@Override
	public boolean isApplicableToContext(final Object contextBo) {
		return contextBo instanceof ComponentImplementation
				|| contextBo instanceof SystemInstance;
	}

	@Override
	public ImmutableSet<String> getDefaultContentFilters(final Object bo) {
		if (bo instanceof Classifier || bo instanceof Subcomponent || bo instanceof ComponentInstance) {
			return defaultClassifierOrSubcomponentFilters;
		}

		return DiagramTypeUtil.getDefaultContentFilters(bo);
	}

	@Override
	public ImmutableCollection<String> getDefaultAadlPropertyNames() {
		return ImmutableSet.of("deployment_properties::actual_processor_binding");
	}
}
