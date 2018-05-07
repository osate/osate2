package org.osate.ge.internal.diagram.runtime.filtering;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IExecutableExtensionFactory;
import org.osate.aadl2.instance.FeatureCategory;

/**
 * Factory for creating a filters for specific feature categories.
 *
 */
public class FeatureCategoryFilterFactory implements IExecutableExtensionFactory {
	@Override
	public Object create() throws CoreException {
		return Arrays.stream(FeatureCategory.values()).map(category -> new FeatureCategoryFilter(category))
				.collect(Collectors.toList());
	}
}
