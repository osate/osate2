package org.osate.ge.services.impl;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;

/**
 *  ContextFunction for use with global services. Delegates creation of the service to the child class.
 */
public abstract class SimpleServiceContextFunction<ServiceInterface> extends ContextFunction {
	private ServiceInterface service = null;
	
	public Object compute(IEclipseContext context, String contextKey) {
		if(service == null) {
			service = createService(context);
			context.set(contextKey, service);
		}
		
		return service;
	}
	
	protected abstract ServiceInterface createService(final IEclipseContext context);
	
	protected ServiceInterface getService() { return service; }
	
	protected void deactivate() {
		this.service = null;
	}
}
