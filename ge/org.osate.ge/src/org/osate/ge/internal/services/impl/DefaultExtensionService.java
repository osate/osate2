// Based on OSATE Graphical Editor. Modifications are:
/*
Copyright (c) 2016, Rockwell Collins.
Developed with the sponsorship of Defense Advanced Research Projects Agency (DARPA).

Permission is hereby granted, free of charge, to any person obtaining a copy of this data,
including any software or models in source or binary form, as well as any drawings, specifications,
and documentation (collectively "the Data"), to deal in the Data without restriction, including
without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or
substantial portions of the Data.

THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
 */
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
import org.osate.ge.ContentFilter;
import org.osate.ge.DiagramType;
import org.osate.ge.FundamentalContentFilter;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.services.ExtensionService;

import com.google.common.collect.ImmutableCollection;

public class DefaultExtensionService implements ExtensionService {
	private final ExtensionRegistryService globalExtService;
	private final IEclipseContext baseCtx;

	public DefaultExtensionService(final ExtensionRegistryService globalExtService, final IEclipseContext baseCtx) {
		this.globalExtService = globalExtService;
		this.baseCtx = baseCtx;
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
	public Collection<Object> getTooltipContributors() {
		return globalExtService.getTooltipContributors();
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

	@Override
	public Collection<Object> getBusinessObjectProviders() {
		return globalExtService.getBusinessObjectProviders();
	}

	@Override
	public ImmutableCollection<ContentFilter> getConfigurableContentFilters() {
		return globalExtService.getConfigurableContentFilters();
	}

	@Override
	public ImmutableCollection<FundamentalContentFilter> getFundamentalContentFilters() {
		return globalExtService.getFundamentalContentFilters();
	}

	@Override
	public ImmutableCollection<DiagramType> getDiagramTypes() {
		return globalExtService.getDiagramTypes();
	}
}
