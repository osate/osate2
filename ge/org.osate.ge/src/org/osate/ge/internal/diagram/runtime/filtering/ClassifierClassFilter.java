package org.osate.ge.internal.diagram.runtime.filtering;

import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentCategory;
import org.osate.ge.ContentFilter;

public abstract class ClassifierClassFilter implements ContentFilter {
	@Override
	public String getParentId() {
		return ClassifierFilter.ID;
	}

	@Override
	public boolean isApplicable(final Object bo) {
		return bo instanceof AadlPackage;
	}

	protected String categoryToSingularName(final ComponentCategory category) {
		switch (category) {
		case ABSTRACT:
			return "Abstract";
		case BUS:
			return "Bus";
		case DATA:
			return "Data";
		case DEVICE:
			return "Device";
		case MEMORY:
			return "Memory";
		case PROCESS:
			return "Process";
		case PROCESSOR:
			return "Processor";
		case SUBPROGRAM:
			return "Subprogram";
		case SUBPROGRAM_GROUP:
			return "Subprogram Group";
		case SYSTEM:
			return "System";
		case THREAD:
			return "Thread";
		case THREAD_GROUP:
			return "Thread Group";
		case VIRTUAL_BUS:
			return "Virtual Bus";
		case VIRTUAL_PROCESSOR:
			return "Virtual Processor";
		default:
			throw new RuntimeException("Unsupported category: " + category);
		}
	}
}
