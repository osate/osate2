package org.osate.ge.internal.diagram.runtime.filtering;

import java.util.Objects;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentImplementation;

public class ComponentImplementationCategoryFilter extends ClassifierClassFilter {
	private final ComponentCategory category;
	private final String id;

	public ComponentImplementationCategoryFilter(final ComponentCategory category) {
		this.category = Objects.requireNonNull(category, "category must not be null");
		this.id = getId(category);
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getName() {
		return categoryToSingularName(category) + " Implementations";
	}

	@Override
	public boolean test(Object bo) {
		return bo instanceof ComponentImplementation && ((ComponentImplementation) bo).getCategory() == category;
	}

	public static String getId(final ComponentCategory category) {
		return FilterUtil.componentCategoryToIdPrefix(category) + "Implementations";
	}
}
