/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.services.impl;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.jface.action.IAction;
import org.osate.ge.internal.services.UiService;
import org.osate.ge.internal.ui.editor.AgeDiagramBehavior;

public class DefaultUiService implements UiService {
	private IDiagramTypeProvider dtp;
	
	public DefaultUiService(final IDiagramTypeProvider dtp) {
		this.dtp = dtp;
	}
	
	@Override
	public IAction getActivateToolAction(final String toolId) {
		return getAgeDiagramBehavior().getActivateToolAction(toolId);
	}
	
	@Override
	public void deactivateActiveTool() {
		getAgeDiagramBehavior().deactivateActiveTool();
	}
	
	@Override
	public void clearSelection() {
		getAgeDiagramBehavior().clearSelection();
	}
	
	private AgeDiagramBehavior getAgeDiagramBehavior() {
		if(!(dtp.getDiagramBehavior() instanceof AgeDiagramBehavior)) {
			throw new RuntimeException("Diagram behavior is not of type AgeDiagramBehavior");
		}
		
		final AgeDiagramBehavior diagramBehavior = (AgeDiagramBehavior)dtp.getDiagramBehavior();
		return diagramBehavior;
	}
	
}
