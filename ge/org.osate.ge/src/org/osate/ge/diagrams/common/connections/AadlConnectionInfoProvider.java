/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.diagrams.common.connections;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IPeService;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.diagrams.common.patterns.FeaturePattern;
import org.osate.ge.services.AnchorService;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.ShapeService;

public class AadlConnectionInfoProvider extends AbstractConnectionInfoProvider {
	private final AnchorService anchorUtil;
	private final ShapeService shapeService;
	
	@Inject
	public AadlConnectionInfoProvider(final BusinessObjectResolutionService bor, final Diagram diagram, final AnchorService anchorUtil, final ShapeService shapeHelper) {
		super(bor, diagram);
		this.anchorUtil = anchorUtil;
		this.shapeService = shapeHelper;
	}

	@Override
	public boolean isBusinessObjectApplicable(final Object bo) {
		return bo instanceof org.osate.aadl2.Connection;
	}

	@Override
	public ContainerShape getOwnerShape(final Connection connection) {
		if(connection.getStart() != null && connection.getStart().getParent() instanceof ContainerShape && 
			connection.getEnd() != null && connection.getEnd().getParent() instanceof ContainerShape) {
			
			final ContainerShape startParent = (ContainerShape)connection.getStart().getParent();
			final ContainerShape endParent = (ContainerShape)connection.getEnd().getParent();
			
			// Get the lowest common ancestor
			ContainerShape temp1 = startParent;
			while(temp1 != null) {
				ContainerShape temp2 = endParent;
				while(temp2 != null) {
					if(temp1 == temp2) {
						final Object temp1Bo = getBusinessObjectResolver().getBusinessObjectForPictogramElement(temp1);
						if(temp1Bo != null) {
							return temp1;
						}						
					}
					temp2 = temp2.getContainer();
				}
				
				temp1 = temp1.getContainer();
			}
		}

		return null;
	}
	
	@Override
	public Anchor[] getAnchors(final ContainerShape ownerShape, final Object bo) {
		final org.osate.aadl2.Connection connection = (org.osate.aadl2.Connection)bo;
		Anchor a1 = null;
		Anchor a2 = null;

		// Get the pictogram elements for the source and destination of the connection
		final PictogramElement sourcePe = getPictogramElement(ownerShape, connection.getAllSource(), connection.getAllSourceContext(), connection.getAllSrcContextComponent());
		final PictogramElement destPe = getPictogramElement(ownerShape, connection.getAllDestination(), connection.getAllDestinationContext(), connection.getAllDstContextComponent());

		// Check if the sourcePe and destPe are valid
		if(sourcePe == null || !(sourcePe instanceof Shape) || destPe == null || !(destPe instanceof Shape)) {
			return null;
		}

		final Shape sourceShape = (Shape)sourcePe;
		final Shape destShape = (Shape)destPe;
		final IPeService peService = Graphiti.getPeService();

		// Get the appropriate anchors
		final Shape srcComponentShape = shapeService.getClosestAncestorWithBusinessObjectType(sourceShape, ComponentImplementation.class, Subcomponent.class);
		a1 = anchorUtil.getAnchorByName(sourcePe, shapeService.doesShapeContain(srcComponentShape, destShape) ? FeaturePattern.innerConnectorAnchorName : FeaturePattern.outerConnectorAnchorName);
		if(a1 == null) {
			a1 = peService.getChopboxAnchor((AnchorContainer)sourcePe);
		}

		final Shape dstComponentShape = shapeService.getClosestAncestorWithBusinessObjectType(destShape, ComponentImplementation.class, Subcomponent.class);
		a2 = anchorUtil.getAnchorByName(destPe, shapeService.doesShapeContain(dstComponentShape, sourceShape) ? FeaturePattern.innerConnectorAnchorName : FeaturePattern.outerConnectorAnchorName);
		if(a2 == null) {
			a2 = peService.getChopboxAnchor((AnchorContainer)destPe);
		}

		if(a1 == null || a2 == null) {
			return null;
		}

		return new Anchor[] {a1, a2};
	}
	
	private PictogramElement getPictogramElement(final ContainerShape ownerShape, final ConnectionEnd ce, final Context context, final NamedElement contextComponent) {
		if(ce == null) {
			return null;
		}
		
		// Get the PE for the context component
		PictogramElement pe = null;
		if(contextComponent != null) {
			// Check if the context matches the BO of the owner shape
			final Object ownerShapeBo = getBusinessObjectResolver().getBusinessObjectForPictogramElement(ownerShape);
			if(contextComponent == ownerShapeBo){
				pe = ownerShape;
			} else {
				if(ownerShapeBo instanceof ComponentImplementation) {
					final ComponentImplementation ci = (ComponentImplementation)ownerShapeBo;
					if(getAllExtended(ci).contains(contextComponent)) {
						pe = ownerShape;
					}
				}
				
				if(pe == null) {
					pe = shapeService.getChildShapeByElementName(ownerShape, contextComponent);
					if(pe == null || !(pe instanceof ContainerShape)) {
						return null;
					}
				}
			}
		} 
		
		if(context != null && contextComponent != context) {
			if(pe == null) {			
				// TODO: Throw exception? Unhandled case. Context without context component
				return null;
			} else {
				// Get the shape for the context
				pe = shapeService.getDescendantShapeByElementName((ContainerShape)pe, context);
				if(pe == null || !(pe instanceof ContainerShape)) {
					return null;
				}
			}
		}
		
		// If the connection end did not have a context
		if(pe == null) {
			pe = ownerShape;
			if(pe == null || !(pe instanceof ContainerShape)) {
				return null;
			}
		}
		
		// Get Descendant PE
		pe = shapeService.getDescendantShapeByElementName((ContainerShape)pe, ce);		
		
		// CLEAN-UP: Clarify or remove comments
		// Case: Just CE is valid. (Probably a feature? could be a component)
		// Return it's PE
		
		// Case: CE is valid. Context and context component is the same.
		// Get the PE of Context. Retrieve PE of the child of the context PE for CE.
		
		// Case: CE is valid. Context is a subcomponent. Context is a feature group
		// 

		return pe;
	}
	
	private List<ComponentImplementation> getAllExtended(final ComponentImplementation ci) {
		final List<ComponentImplementation> results = new ArrayList<ComponentImplementation>();		
		for(ComponentImplementation tmp = ci.getExtended(); tmp != null; tmp = tmp.getExtended()) {
			results.add(tmp);
		}
		return results;
	}
}
