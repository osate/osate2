/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.diagrams.common.features;

import javax.inject.Inject;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.NamedElement;
import org.osate.ge.services.AadlModificationService;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.DiagramModificationService;
import org.osate.ge.services.NamingService;
import org.osate.ge.services.ShapeService;
import org.osate.ge.services.AadlModificationService.AbstractModifier;

public class RenameModeTransitionFeature extends AbstractDirectEditingFeature {
	private final ShapeService shapeService;
	private final AadlModificationService aadlModService;
	private final DiagramModificationService diagramModService;
	private final NamingService namingService;
	private final BusinessObjectResolutionService bor;
	
	@Inject
	public RenameModeTransitionFeature(final IFeatureProvider fp, final ShapeService shapeService, AadlModificationService aadlModService, final DiagramModificationService diagramModService, 
			final NamingService namingService, final BusinessObjectResolutionService bor) {
		super(fp);
		this.shapeService = shapeService;
		this.aadlModService = aadlModService;
		this.diagramModService = diagramModService;
		this.namingService = namingService;
		this.bor = bor;
	}

	@Override
    public boolean canDirectEdit(final IDirectEditingContext context) {
		if(!(context.getPictogramElement() instanceof ConnectionDecorator)) {
			return false;
		}

		final Connection connection = ((ConnectionDecorator)context.getPictogramElement()).getConnection();		
		final Object bo = bor.getBusinessObjectForPictogramElement(connection);
		final ComponentClassifier cc = getComponentClassifier(connection);

		return bo instanceof ModeTransition && cc != null && ((ModeTransition)bo).getContainingClassifier() == cc;
	}
    
	/**
	 * Returns the first component classifier associated with the specified or a containing shape.
	 * @param shape
	 * @return
	 */
	private ComponentClassifier getComponentClassifier(final Connection connection) {
		final AnchorContainer startContainer = connection.getStart().getParent();
		if(!(startContainer instanceof Shape)) {
			return null;
		}
		
		return shapeService.getClosestBusinessObjectOfType((Shape)startContainer, ComponentClassifier.class);
	}
	
	@Override
	public int getEditingType() {
		return TYPE_TEXT;
	}
	
	@Override
	public boolean stretchFieldToFitText() {
		return true;
	}

    @Override
    public String checkValueValid(final String value, final IDirectEditingContext context) {
    	return namingService.checkNameValidity((NamedElement)bor.getBusinessObjectForPictogramElement(context.getPictogramElement()), value);
    }    
	
	@Override
	public String getInitialValue(final IDirectEditingContext context) {
		final ModeTransition mt = (ModeTransition)bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
		if(mt != null) {
			return mt.getName();
		}
		return "";
	}
	
	public void setValue(final String value, final IDirectEditingContext context) {
    	final ModeTransition mt = (ModeTransition)bor.getBusinessObjectForPictogramElement(context.getPictogramElement());    	   	
    	aadlModService.modify(mt, new AbstractModifier<ModeTransition, Object>() {
    		private DiagramModificationService.Modification diagramMod;    		
     		
     		@Override
    		public Object modify(final Resource resource, final ModeTransition mt) {
     			// Resolving allows the name change to propagate when editing without an Xtext document
     			EcoreUtil.resolveAll(resource.getResourceSet());

     			// Start the diagram modification
     			diagramMod = diagramModService.startModification();
     			 			
     			// Mark linkages to the element as dirty 			
     			diagramMod.markLinkagesAsDirty(mt);
     			
     			// Set the element's name
    			mt.setName(value); 			
    			
    			return null;
    		}	

     		@Override
    		public void beforeCommit(final Resource resource, final ModeTransition mt, final Object modificationResult) {
    			diagramMod.commit();
    		}
     	});
    }
}
