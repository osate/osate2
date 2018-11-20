package org.osate.ge.errormodel.filters;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IExecutableExtensionFactory;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.RecoverEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.RepairEvent;

import com.google.common.collect.ImmutableList;

/**
 * Factory for creating a filters for specific error behavior event
 *
 */
public class ErrorBehaviorEventTypeFilterFactory implements IExecutableExtensionFactory {
	@Override
	public Object create() throws CoreException {
		return ImmutableList.of(new ErrorBehaviorEventTypeFilter(ErrorEvent.class),
				new ErrorBehaviorEventTypeFilter(RecoverEvent.class),
				new ErrorBehaviorEventTypeFilter(RepairEvent.class));
	}
}
