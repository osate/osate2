/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.ui.properties;

import java.util.Objects;

import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PlatformUI;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;

/**
 * Property filter for determining whether the property section should be shown.
 *
 */

public class ConnectionsFilter extends AbstractPropertySectionFilter {
	@Override
	protected boolean accept(final PictogramElement pictogramElement) {
		if(pictogramElement instanceof FreeFormConnection) {		
			final Diagram diagram = ((org.eclipse.graphiti.mm.pictograms.Connection)pictogramElement).getParent();
			
			for(final IEditorReference editorRef : PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences()) {
				final IEditorPart editorPart = editorRef.getEditor(false);
				if(editorPart instanceof AgeDiagramEditor) {
					final AgeDiagramEditor diagramEditor = (AgeDiagramEditor)editorPart;
					if((diagramEditor.getDiagramTypeProvider().getDiagram()) == diagram && (diagramEditor.getSelectedPictogramElements().length == 1)) {
						final BusinessObjectResolutionService bor = Objects.requireNonNull((BusinessObjectResolutionService)diagramEditor.getAdapter(BusinessObjectResolutionService.class), "unable to get business object resolution service");
						final Object bo = bor.getBusinessObjectForPictogramElement(pictogramElement);
						return bo instanceof org.osate.aadl2.Connection;
					}
				}
			}
		}
		return false;
	}
}
