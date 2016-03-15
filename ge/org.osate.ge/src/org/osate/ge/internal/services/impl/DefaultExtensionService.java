package org.osate.ge.internal.services.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.services.ExtensionService;

public class DefaultExtensionService implements ExtensionService {
	private final ExtensionRegistryService globalExtService;
	private final IEclipseContext baseCtx;
	
	// TODO: Rather than accepting a base context, accept a limited set of services which will be made available to extensions
	public DefaultExtensionService(final ExtensionRegistryService globalExtService, final IEclipseContext baseCtx) {
		this.globalExtService = globalExtService;
		this.baseCtx = baseCtx;
	}
	
	@Override
	public Collection<Object> getTools() {
		return globalExtService.getTools();
	}
	
	@Override
	public Collection<Object> getPictogramHandlers() {
    	return globalExtService.getPictogramHandlers();
    }
	
	@Override
	public Object getApplicablePictogramHandler(final Object bo) {
		return globalExtService.getApplicablePictogramHandler(bo);
	}
	
	@Override
	public IEclipseContext createChildContext() {
		final IEclipseContext ctx = baseCtx.createChild();
		return ctx;
	}

	@Override
	public List<Category> getCategories() {
		return globalExtService.getCategories();
	}
}
