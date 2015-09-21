package org.osate.ge.services.impl;

import java.util.Collection;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.osate.ge.services.ExtensionService;
import org.osate.ge.services.ExtensionRegistryService;

public class DefaultExtensionService implements ExtensionService {
	private final ExtensionRegistryService globalExtService;
	private final IEclipseContext baseCtx;
	private final IDiagramTypeProvider diagramTypeProvider;
	
	// TODO: Rather than accepting a base context, accept a limited set of services which will be made available to extensions
	public DefaultExtensionService(final ExtensionRegistryService globalExtService, final IDiagramTypeProvider diagramTypeProvider, final IEclipseContext baseCtx) {
		this.globalExtService = globalExtService;
		this.baseCtx = baseCtx;
		this.diagramTypeProvider = diagramTypeProvider;
	}
	
	@Override
	public Collection<Object> getTools() {
		return globalExtService.getTools();
	}
	
	@Override
	public IEclipseContext createChildContext() {
		final IEclipseContext ctx = baseCtx.createChild();
		ctx.set(Diagram.class, diagramTypeProvider.getDiagram());
		return ctx;
	}
}
