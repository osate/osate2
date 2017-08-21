/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.ui.editor;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.platform.GraphitiConnectionEditPart;
import org.eclipse.graphiti.ui.platform.GraphitiShapeEditPart;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.ui.properties.AadlElementPropertySource;
import org.osate.ge.internal.ui.xtext.AgeXtextUtil;
import org.osate.xtext.aadl2.ui.propertyview.IAadlPropertySource;

/**
 * Adapter implementation for adapting selections to IAadlPropertySource for integration with the AADL Property Values view.
 *
 */
public class GraphitiEditPartAdapterFactory implements IAdapterFactory {
	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Object adaptableObject, @SuppressWarnings("rawtypes") Class adapterType) {
		// Get the business object
		final PictogramElement pe;		
		final EditPart editPart;
		if (adaptableObject instanceof GraphitiShapeEditPart) {
			final GraphitiShapeEditPart part = (GraphitiShapeEditPart)adaptableObject;
			pe = part.getPictogramElement();
			editPart = part;
		} else if (adaptableObject instanceof GraphitiConnectionEditPart) {
			final GraphitiConnectionEditPart part = (GraphitiConnectionEditPart)adaptableObject;
			pe = part.getPictogramElement();
			editPart = part;
		} else {
			return null;
		}
		
		final EditDomain editDomain = editPart.getViewer().getEditDomain();
		if(!(editDomain instanceof DefaultEditDomain)){
			return null;
		}
						
		final DefaultEditDomain defaultEditDomain = (DefaultEditDomain)editDomain;
		final IEditorPart editorPart = defaultEditDomain.getEditorPart();
		if(!(editorPart instanceof AgeDiagramEditor)) {
			return null;
		}

		final AgeDiagramEditor diagramEditor = (AgeDiagramEditor)editorPart;
		if(AgeDiagramEditor.class.equals(adapterType)) {
			return diagramEditor;
		}
		
		final AgeDiagram ageDiagram = diagramEditor.getGraphitiAgeDiagram().getAgeDiagram();
		if(ageDiagram == null) {
			return null;
		}

		final DiagramElement de = diagramEditor.getGraphitiAgeDiagram().getClosestDiagramElement(pe);
		if(de == null) {
			return null;
		}

		if(IAadlPropertySource.class.equals(adapterType)) {
			// If the business object is an AADL Named Element
			if(de.getBusinessObject() instanceof NamedElement) {
				final NamedElement namedElement = (NamedElement)de.getBusinessObject();		
				return new IAadlPropertySource() {
					private final IXtextDocument document = AgeXtextUtil.getDocumentByRootElement(namedElement.getElementRoot());
					private final NamedElement element = namedElement;
					
					@Override
					public IXtextDocument getDocument() {
						return document;
					}
	
					@Override
					public NamedElement getNamedElement() {
						return element;
					}				
				};
			}
		} else if(IPropertySource.class.equals(adapterType)) {
			if(de.getBusinessObject() instanceof Element) {
				return new AadlElementPropertySource((Element)de.getBusinessObject());
			}
		} else if(DiagramElement.class.equals(adapterType)) {
			return de;
		}
		
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Class[] getAdapterList() {
		return new Class[] { IAadlPropertySource.class, IPropertySource.class};
	}
}
