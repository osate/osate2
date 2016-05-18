/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.services.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.services.ExtensionService;

public class DefaultExtensionService implements ExtensionService {
	private final ExtensionRegistryService globalExtService;
	private final IEclipseContext baseCtx;
	
	// TODO: Rather than accepting a base context, consider accepting a limited set of services which will be made available to extensions
	public DefaultExtensionService(final ExtensionRegistryService globalExtService, final IEclipseContext baseCtx) {
		this.globalExtService = globalExtService;
		this.baseCtx = baseCtx;
	}
	
	@Override
	public Collection<Object> getTools() {
		return globalExtService.getTools();
	}
	
	@Override
	public Collection<Object> getBusinessObjectHandlers() {
    	return globalExtService.getBusinessObjectHandlers();
    }
	
	@Override
	public Object getApplicableBusinessObjectHandler(final Object bo) {
		return globalExtService.getApplicableBusinessObjectHandler(bo);
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
