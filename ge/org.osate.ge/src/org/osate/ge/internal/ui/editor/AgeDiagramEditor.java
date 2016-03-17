/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.ui.editor;

import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.ui.PlatformUI;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.GraphicalEditor;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.impl.DefaultPropertyService;
import org.osate.ge.internal.ui.util.impl.DefaultGhostPurger;

public class AgeDiagramEditor extends DiagramEditor implements GraphicalEditor {
	public static final String DIAGRAM_EDITOR_ID = "org.osate.ge.editor.AgeDiagramEditor";
	public static final String EXTENSION_NO_DOT = "aadl_diagram";
	public static final String EXTENSION = "." + EXTENSION_NO_DOT;
	
	public AgeDiagramEditor() {
	}
	
	protected DiagramBehavior createDiagramBehavior() {
		final PropertyService propertyService = new DefaultPropertyService();
		final DiagramService diagramService = (DiagramService)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getService(DiagramService.class);
		return new AgeDiagramBehavior(this, new DefaultGhostPurger(propertyService), diagramService, propertyService);
	}
	
	/*
	 * Calls the Update feature to update the diagram from the model if the editor is visible. If it is not, it will do so the next time the editor is made visible.
	 */
	public void updateDiagramWhenVisible() {
		((AgeDiagramBehavior)getDiagramBehavior()).updateDiagramWhenVisible();
	}
}