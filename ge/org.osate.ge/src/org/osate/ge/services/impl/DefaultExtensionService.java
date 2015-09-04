package org.osate.ge.services.impl;

import java.util.Collection;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osate.ge.services.ExtensionService;
import org.osate.ge.services.ExtensionRegistryService;

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
	public IEclipseContext createChildContext() {
		return baseCtx.createChild();
	}
}
