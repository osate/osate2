/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package edu.uah.rsesc.aadl.age.diagrams.type.features;

import javax.inject.Inject;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FlowSpecification;

import edu.uah.rsesc.aadl.age.services.AadlModificationService.AbstractModifier;
import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.services.AadlModificationService;
import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;
import edu.uah.rsesc.aadl.age.services.DiagramModificationService;
import edu.uah.rsesc.aadl.age.services.ShapeService;

public class RefineFlowSpecificationFeature extends AbstractCustomFeature {
	private final ShapeService shapeService;
	private final AadlModificationService aadlModService;
	private final DiagramModificationService diagramModService;
	private final BusinessObjectResolutionService bor;
	
	@Inject
	public RefineFlowSpecificationFeature(final ShapeService shapeService, final AadlModificationService aadlModService, final DiagramModificationService diagramModService, final BusinessObjectResolutionService bor, final IFeatureProvider fp) {
		super(fp);
		this.shapeService = shapeService;
		this.aadlModService = aadlModService;
		this.diagramModService = diagramModService;
		this.bor = bor;
	}

	@Override
    public String getName() {
        return "Refine";
    }
	
	@Override
	public boolean canUndo(final IContext context) {
		return false;
	}
	
    @Override
	public boolean isAvailable(final IContext context) {
		final ICustomContext customCtx = (ICustomContext)context;
		final PictogramElement[] pes = customCtx.getPictogramElements();		
		if(customCtx.getPictogramElements().length < 1 || !(customCtx.getPictogramElements()[0] instanceof Connection)) {
			return false;
		}
		
		// Check that the connection represents a flow specification and that the flow specification is not owned by the classifier represented by the shape's container
		final PictogramElement pe = pes[0];		
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		final ComponentType ct = getComponentType((Connection)pe);
		if(!(bo instanceof FlowSpecification && ct instanceof ComponentType)) {
			return false;
		}
		
		final FlowSpecification fs = (FlowSpecification)bo;	
		return fs.getContainingClassifier() != ct;
	}
    
	/**
	 * Returns the first component type associated with the specified or a containing shape.
	 * @param shape
	 * @return
	 */
	private ComponentType getComponentType(final Connection connection) {
		final AnchorContainer startContainer = connection.getStart().getParent();
		if(!(startContainer instanceof Shape)) {
			return null;
		}
		
		return shapeService.getClosestBusinessObjectOfType((Shape)startContainer, ComponentType.class);
	}
	
    @Override
    public boolean canExecute(final ICustomContext context) {
    	return true;
    }
        
	@Override
	public void execute(final ICustomContext context) {
		final Connection fsConnection = (Connection)context.getPictogramElements()[0];
		final FlowSpecification fs = (FlowSpecification)bor.getBusinessObjectForPictogramElement(fsConnection);
		final ComponentType ct = getComponentType(fsConnection);
		
		// Set the classifier
		aadlModService.modify(fs, new AbstractModifier<FlowSpecification, FlowSpecification>() {
			private DiagramModificationService.Modification diagramMod;    	
			
			@Override
			public FlowSpecification modify(final Resource resource, final FlowSpecification fs) {
				// Start the diagram modification
     			diagramMod = diagramModService.startModification();
     			
				// Refine the flow specification
				final FlowSpecification newFs = ct.createOwnedFlowSpecification();
				newFs.setKind(fs.getKind());
				newFs.setRefined(fs);
				
				diagramMod.markRelatedDiagramsAsDirty(ct);
				
				return newFs;
			}			
			
			@Override
			public void beforeCommit(final Resource resource, final FlowSpecification fs, final FlowSpecification newFs) {
				// Relink the shape
				getFeatureProvider().link(fsConnection, new AadlElementWrapper(newFs));
				
				diagramMod.commit();
			}
		});
	}	
}
