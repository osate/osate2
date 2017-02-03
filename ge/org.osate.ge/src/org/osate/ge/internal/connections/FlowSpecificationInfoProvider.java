/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.connections;

import javax.inject.Inject;

import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.internal.services.AnchorService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ShapeService;

public class FlowSpecificationInfoProvider extends AbstractConnectionInfoProvider {
	private final AnchorService anchorUtil;
	private final ShapeService shapeHelper;
	
	@Inject
	public FlowSpecificationInfoProvider(final BusinessObjectResolutionService bor, final Diagram diagram, final AnchorService anchorUtil, final ShapeService shapeHelper) {
		super(bor, diagram);
		this.anchorUtil = anchorUtil;
		this.shapeHelper = shapeHelper;
	}

	@Override
	public boolean isBusinessObjectApplicable(final Object bo) {
		return bo instanceof FlowSpecification;
	}

	@Override
	public ContainerShape getOwner(final Connection connection) {		
		if(connection.getStart() != null && connection.getStart().getParent() instanceof ContainerShape) {
			ContainerShape temp = (ContainerShape)connection.getStart().getParent();
			while(temp != null) {
				final Object tempBo = getBusinessObjectResolver().getBusinessObjectForPictogramElement(temp);
				if(tempBo instanceof Subcomponent || tempBo instanceof ComponentType || tempBo instanceof ComponentImplementation) {
					return temp;
				}
				temp = temp.getContainer();
			}
			
		}

		return null;
	}	
	
	@Override
	public Anchor[] getAnchors(final PictogramElement owner, final Object bo) {	
		if(!(owner instanceof ContainerShape)) {
			return null;
		}
		
		final ContainerShape ownerShape = (ContainerShape)owner;
		final FlowSpecification fs = (FlowSpecification)bo;
		Anchor a1 = null;
		Anchor a2 = null;
		
		final PictogramElement inPe = getFlowEndPictogramElement(fs.getAllInEnd(), ownerShape);
		final PictogramElement outPe = getFlowEndPictogramElement(fs.getAllOutEnd(), ownerShape);

		if(inPe instanceof AnchorContainer && outPe instanceof AnchorContainer) {
			// Determine the anchors to use for the connection
			switch(fs.getKind()) {
			case PATH:
				{
					a1 = Graphiti.getPeService().getChopboxAnchor((AnchorContainer)inPe);
					a2 = Graphiti.getPeService().getChopboxAnchor((AnchorContainer)outPe);
					break;
				}
				
			case SOURCE:
				{
					a1 = Graphiti.getPeService().getChopboxAnchor((AnchorContainer)outPe);
					a2 = null; // TODO: Disabled during transition anchorUtil.getAnchorByName(outPe, FeaturePattern.flowSpecificationAnchorName);	
					break;
				}
	
			case SINK:
				{
					a1 = Graphiti.getPeService().getChopboxAnchor((AnchorContainer)inPe);
					a2 = null; // TODO: Disabled during transition. anchorUtil.getAnchorByName(inPe, FeaturePattern.flowSpecificationAnchorName);	
					break;		
				}
				
			default:
				throw new RuntimeException("Unhandled case. Unsupported flow kind: " + fs.getKind());
					
			}
		}

		if(a1 == null || a2 == null) {
			return null;
		}
		
		return new Anchor[] {a1, a2};
	}
	
	private PictogramElement getFlowEndPictogramElement(final FlowEnd fe, final ContainerShape ownerShape) {
		if(fe == null || fe.getFeature() == null) {
			return null;
		}
		
		if(fe.getContext() instanceof FeatureGroup) {
			final FeatureGroup fg = (FeatureGroup)fe.getContext();
			final PictogramElement fgPe = shapeHelper.getChildShapeByElementName(ownerShape, fg);
			if(fgPe instanceof ContainerShape) {
				return shapeHelper.getDescendantShapeByElementName((ContainerShape)fgPe, fe.getFeature());
			}
			
		} else {
			return shapeHelper.getChildShapeByElementName(ownerShape, fe.getFeature());
		}
				
		return null;
	}
}
