/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package edu.uah.rsesc.aadl.age.diagrams.componentImplementation.features;

import javax.inject.Inject;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.NamedElement;

import edu.uah.rsesc.aadl.age.services.AadlModificationService;
import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;
import edu.uah.rsesc.aadl.age.services.DiagramModificationService;
import edu.uah.rsesc.aadl.age.services.NamingService;
import edu.uah.rsesc.aadl.age.services.AadlModificationService.AbstractModifier;
import edu.uah.rsesc.aadl.age.services.ShapeService;

public class RenameConnectionFeature extends AbstractDirectEditingFeature {
	private final ShapeService shapeService;
	private final AadlModificationService aadlModService;
	private final DiagramModificationService diagramModService;
	private final NamingService namingService;
	private final BusinessObjectResolutionService bor;
	
	@Inject
	public RenameConnectionFeature(final IFeatureProvider fp, final ShapeService shapeService, AadlModificationService aadlModService, final DiagramModificationService diagramModService, 
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
		final ComponentImplementation ci = getComponentImplementation(connection);

		return bo instanceof org.osate.aadl2.Connection && ((org.osate.aadl2.Connection)bo).getRefined() == null && ci != null && ((org.osate.aadl2.Connection)bo).getContainingClassifier() == ci;
	}
    
	/**
	 * Returns the first component implementation associated with the specified or a containing shape.
	 * @param shape
	 * @return
	 */
	private ComponentImplementation getComponentImplementation(final Connection connection) {
		final AnchorContainer startContainer = connection.getStart().getParent();
		if(!(startContainer instanceof Shape)) {
			return null;
		}
		
		return shapeService.getClosestBusinessObjectOfType((Shape)startContainer, ComponentImplementation.class);
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
		final org.osate.aadl2.Connection connection = (org.osate.aadl2.Connection)bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
		if(connection != null) {
			return connection.getName();
		}
		return "";
	}
	
	public void setValue(final String value, final IDirectEditingContext context) {
    	final org.osate.aadl2.Connection aadlConnection = (org.osate.aadl2.Connection)bor.getBusinessObjectForPictogramElement(context.getPictogramElement());    	   	
    	aadlModService.modify(aadlConnection, new RenameConnectionModifier(value, diagramModService));  
    }
	    
    private static class RenameConnectionModifier extends AbstractModifier<org.osate.aadl2.Connection, Object> {
    	private final String newName;
		private final DiagramModificationService diagramModService;
		private DiagramModificationService.Modification diagramMod;
		
 		public RenameConnectionModifier(final String newName, final DiagramModificationService diagramModService) {
			this.newName = newName;
			this.diagramModService = diagramModService;
		}
 		
 		@Override
		public Object modify(final Resource resource, final org.osate.aadl2.Connection aadlConnection) {
 			// Resolving allows the name change to propagate when editing without an Xtext document
 			EcoreUtil.resolveAll(resource.getResourceSet());

 			// Start the diagram modification
 			diagramMod = diagramModService.startModification();
 			
 			// Mark linkages to refinements as dirty
 			updateRefinees(aadlConnection, resource.getResourceSet());
 			
 			// Mark linkages to the subcomponent as dirty 			
 			diagramMod.markLinkagesAsDirty(aadlConnection);
 			
 			// Set the subcomponent's name
			aadlConnection.setName(newName); 			
			
			return null;
		}	

 		@Override
		public void beforeCommit(final Resource resource, final org.osate.aadl2.Connection aadlConnection, final Object modificationResult) {
			diagramMod.commit();
		}
 		
 		/**
 		 * Recursive method that updates refinees as dirty and ensures that the source is regenerated with the name of the refined element
 		 * @param element
 		 * @param resourceSet
 		 */
 	    private void updateRefinees(final org.osate.aadl2.Connection element, final ResourceSet resourceSet) {
 			// Mark linkages to refinements as dirty
 			for(final Setting s : EcoreUtil.UsageCrossReferencer.find(element, resourceSet)) {
 				final EStructuralFeature sf = s.getEStructuralFeature();
 				if(!sf.isDerived() && sf.isChangeable()) {
 					final EObject obj = s.getEObject();
 					if(obj instanceof org.osate.aadl2.Connection && ((org.osate.aadl2.Connection)obj).getRefined() == element) {
 						final org.osate.aadl2.Connection refinee = (org.osate.aadl2.Connection)obj;
 						
 						diagramMod.markLinkagesAsDirty(refinee);
 						
 						// Set the refined connection to null and then set it again to trigger the change 
 						refinee.setRefined(null);
 						refinee.setRefined(element);
 						
 						updateRefinees(refinee, resourceSet);
 					}
 				}
 			}
 	    }
 	}
}
