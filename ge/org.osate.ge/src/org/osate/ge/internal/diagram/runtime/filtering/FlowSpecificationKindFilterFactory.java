package org.osate.ge.internal.diagram.runtime.filtering;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IExecutableExtensionFactory;
import org.osate.aadl2.FlowKind;

/**
 * Factory for creating a filter for a specific flow specification kind
 *
 */
public class FlowSpecificationKindFilterFactory implements IExecutableExtensionFactory {
	@Override
	public Object create() throws CoreException {
		return Arrays.stream(FlowKind.values()).map(kind -> new FlowSpecificationKindFilter(kind))
				.collect(Collectors.toList());
	}
}
