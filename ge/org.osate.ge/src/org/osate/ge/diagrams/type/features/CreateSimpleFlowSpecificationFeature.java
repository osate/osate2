/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.diagrams.type.features;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Context;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DirectedFeature;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.FlowKind;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.Port;
import org.osate.ge.services.AadlFeatureService;
import org.osate.ge.services.AadlModificationService;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.DiagramModificationService;
import org.osate.ge.services.NamingService;
import org.osate.ge.services.ShapeService;
import org.osate.ge.services.AadlModificationService.AbstractModifier;
import org.osate.ge.util.StringUtil;

/**
 * Feature for creating a "simple" flow specification. Creates a flow source or sink via a context menu.
 * @author philip.alldredge
 *
 */
public class CreateSimpleFlowSpecificationFeature extends AbstractCustomFeature {
	private final AadlModificationService aadlModService;
	private final DiagramModificationService diagramModService;
	private final ShapeService shapeService;
	private final AadlFeatureService featureService;
	private final NamingService namingService;
	private final BusinessObjectResolutionService bor;
	private final FlowKind flowKind;
	
	@Inject
	public CreateSimpleFlowSpecificationFeature(final AadlModificationService aadlModService, final DiagramModificationService diagramModService, 
			final ShapeService shapeService, final AadlFeatureService featureService, final NamingService namingService, final BusinessObjectResolutionService bor, 
			final IFeatureProvider fp, final @Named("Kind") FlowKind flowKind) {
		super(fp);
		this.aadlModService = aadlModService;
		this.diagramModService = diagramModService;
		this.shapeService = shapeService;
		this.featureService = featureService;
		this.namingService = namingService;
		this.bor = bor;
		this.flowKind = flowKind;
		
		if(flowKind != FlowKind.SINK && flowKind != FlowKind.SOURCE) {
			throw new RuntimeException("Unsupported flow kind: " + flowKind);
		}
	}
	
	@Override
    public String getName() {
      return "Create " + StringUtil.camelCaseToUser(flowKind.getName());
    }
	
	@Override
	public boolean canUndo(final IContext context) {
		return false;
	}
	
    @Override
	public boolean isAvailable(final IContext context) {
		final ICustomContext customCtx = (ICustomContext)context;
		final PictogramElement[] pes = customCtx.getPictogramElements();		
		if(customCtx.getPictogramElements().length != 1) {
			return false;
		}
		
		final PictogramElement pe = pes[0];
		if(!(pe instanceof Shape)) {
			return false;
		}
		
		// Check that the pictogram represents a feature
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		if(!(bo instanceof Feature)) {
			return false;
		}

		final Shape shape = (Shape)pe;
		final Feature feature = (Feature)bo;
		
		// Check that the feature is of the appropriate type
		if(!(feature instanceof Port || feature instanceof Parameter || feature instanceof DataAccess || feature instanceof FeatureGroup || feature instanceof AbstractFeature)) {
			return false;
		}

		// Check direction. Take into account feature group, inverse, etc..
		if(feature instanceof DirectedFeature) {
			// Determine the actual direction of the feature. Since it could effected by things like inverse feature groups, etc
			final DirectedFeature df = (DirectedFeature)feature;
			DirectionType direction = df.getDirection();
	 		if(direction == DirectionType.IN || direction == DirectionType.OUT) {
	 			if(featureService.isFeatureInverted(shape)) {
	 				direction = (direction == DirectionType.IN) ? DirectionType.OUT : DirectionType.IN;
	 			}
	 		}	
	 		
	 		if(flowKind == FlowKind.SOURCE) {
	 			if(direction != DirectionType.OUT && direction != DirectionType.IN_OUT) {
	 				return false;
	 			}
	 		} else if(flowKind == FlowKind.SINK) {
	 			if(direction != DirectionType.IN && direction != DirectionType.IN_OUT) {
	 				return false;
	 			}
	 		}
		}

		return true;
	}
    
	private ComponentType getComponentType(final Shape featureShape) {
		return shapeService.getClosestBusinessObjectOfType(featureShape, ComponentType.class);
	}
	
	private Context getContext(final Shape featureShape) {
		return shapeService.getClosestBusinessObjectOfType(featureShape.getContainer(), Context.class);
	}
	
    @Override
    public boolean canExecute(final ICustomContext context) {
    	return true;
    }
        
	@Override
	public void execute(final ICustomContext context) {
		final Shape featureShape = (Shape)context.getPictogramElements()[0];
		final ComponentType ct = getComponentType(featureShape);
		final Feature feature = (Feature)bor.getBusinessObjectForPictogramElement(featureShape);
		final String newFlowSpecName = namingService.buildUniqueIdentifier(ct, "new_flow_spec");

		// Create the flow specification
		aadlModService.modify(ct, new AbstractModifier<ComponentType, Object>() {
			private DiagramModificationService.Modification diagramMod;    	
			
			@Override
			public Object modify(final Resource resource, final ComponentType ct) {
				// Start the diagram modification
     			diagramMod = diagramModService.startModification();
     			
     			final FlowSpecification fs = ct.createOwnedFlowSpecification();
     			fs.setKind(flowKind);
     			fs.setName(newFlowSpecName);

     			// Create the appropriate flow end depending on the type being created
     			final FlowEnd flowEnd;
     			if(flowKind == FlowKind.SOURCE) {
	     			flowEnd = fs.createOutEnd();
     			} else if(flowKind == FlowKind.SINK) {
     				flowEnd = fs.createInEnd();
     			} else {
     				throw new RuntimeException("Unexpected flow kind: " + flowKind);
     			}     			
     			flowEnd.setFeature(feature);
     			flowEnd.setContext(getContext(featureShape));     			

				diagramMod.markRelatedDiagramsAsDirty(ct);

				return null;
			}
			
	 		@Override
			public void beforeCommit(final Resource resource, final ComponentType ct, final Object modificationResult) {
				diagramMod.commit();
			}
		});
	}
}
