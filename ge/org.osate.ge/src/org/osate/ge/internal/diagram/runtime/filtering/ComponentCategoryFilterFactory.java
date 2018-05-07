package org.osate.ge.internal.diagram.runtime.filtering;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IExecutableExtensionFactory;
import org.osate.aadl2.ComponentCategory;

/**
 * Factory for creating various filters for each component category.
 *
 */
public class ComponentCategoryFilterFactory implements IExecutableExtensionFactory {
	@Override
	public Object create() throws CoreException {
		return Arrays.stream(ComponentCategory.values()).flatMap(
				cc -> Stream.of(new ComponentTypeCategoryFilter(cc), new ComponentImplementationCategoryFilter(cc),
						new SubcomponentCategoryFilter(cc)))
				.collect(Collectors.toList());
	}
}
