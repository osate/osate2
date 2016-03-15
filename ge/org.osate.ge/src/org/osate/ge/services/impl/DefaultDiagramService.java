/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105
 *******************************************************************************/
package org.osate.ge.services.impl;

import java.util.Objects;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osate.ge.internal.services.InternalDiagramService;
import org.osate.ge.internal.services.impl.SimpleServiceContextFunction;
import org.osate.ge.services.DiagramService;

public class DefaultDiagramService implements DiagramService {
	private final InternalDiagramService internalDiagramService;
	
	public static class ContextFunction extends SimpleServiceContextFunction<DiagramService> {
		@Override
		public DiagramService createService(final IEclipseContext context) {
			return new DefaultDiagramService(context.get(InternalDiagramService.class));
		}		
	}
	
	public DefaultDiagramService(final InternalDiagramService internalDiagramService) {
		this.internalDiagramService = Objects.requireNonNull(internalDiagramService, "internalDiagramService must not be null");
	}
	
	@Override
	public void openOrCreateDiagramBusinessObject(final Object bo) {
		internalDiagramService.openOrCreateDiagramBusinessObject(bo);
	}
}
