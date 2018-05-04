package org.osate.ge.internal.diagram.runtime.filtering;

import java.util.Objects;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.ge.ContentFilter;

public class SubcomponentCategoryFilter implements ContentFilter {
	private final ComponentCategory category;
	private final String id;

	public SubcomponentCategoryFilter(final ComponentCategory category) {
		this.category = Objects.requireNonNull(category, "category must not be null");
		this.id = getId(category);
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getParentId() {
		return SubcomponentFilter.ID;
	}

	@Override
	public String getName() {
		switch (category) {
		case ABSTRACT:
			return "Abstract Subcomponents";
		case BUS:
			return "Buses";
		case DATA:
			return "Data";
		case DEVICE:
			return "Devices";
		case MEMORY:
			return "Memories";
		case PROCESS:
			return "Processes";
		case PROCESSOR:
			return "Processors";
		case SUBPROGRAM:
			return "Subprograms";
		case SUBPROGRAM_GROUP:
			return "Subprogram Groups";
		case SYSTEM:
			return "Systems";
		case THREAD:
			return "Threads";
		case THREAD_GROUP:
			return "Thread Groups";
		case VIRTUAL_BUS:
			return "Virtual Buses";
		case VIRTUAL_PROCESSOR:
			return "Virtual Processors";
		default:
			throw new RuntimeException("Unsupported category: " + category);

		}
	}

	@Override
	public boolean isApplicable(final Object bo) {
		return bo instanceof ComponentImplementation || bo instanceof Subcomponent || bo instanceof ComponentInstance;
	}

	@Override
	public boolean test(Object bo) {
		return (bo instanceof Subcomponent && ((Subcomponent) bo).getCategory() == category)
				|| (bo instanceof ComponentInstance && ((ComponentInstance) bo).getCategory() == category);
	}

	public static String getId(final ComponentCategory category) {
		return FilterUtil.componentCategoryToIdPrefix(category) + "Subcomponents";
	}
}
