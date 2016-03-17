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
import org.osate.ge.GraphicalEditor;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.services.impl.SimpleServiceContextFunction;
import org.osate.ge.services.GraphicalEditorService;

public class DefaultGraphicalEditorService implements GraphicalEditorService {
	private final DiagramService diagramService;
	
	public static class ContextFunction extends SimpleServiceContextFunction<GraphicalEditorService> {
		@Override
		public GraphicalEditorService createService(final IEclipseContext context) {
			return new DefaultGraphicalEditorService(context.get(DiagramService.class));
		}		
	}
	
	public DefaultGraphicalEditorService(final DiagramService diagramService) {
		this.diagramService = Objects.requireNonNull(diagramService, "diagramService must not be null");
	}
	
	@Override
	public GraphicalEditor openBusinessObject(final Object bo) {
		return diagramService.openOrCreateDiagramForRootBusinessObject(bo);
	}}
