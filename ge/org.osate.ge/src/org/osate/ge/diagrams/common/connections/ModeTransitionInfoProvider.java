/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.diagrams.common.connections;

import javax.inject.Inject;

import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.diagrams.common.patterns.AgePattern;
import org.osate.ge.diagrams.common.patterns.ModePattern;
import org.osate.ge.services.AnchorService;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.ShapeService;

public class ModeTransitionInfoProvider extends AbstractConnectionInfoProvider {
	private final AnchorService anchorUtil;
	private final ShapeService shapeHelper;
	
	@Inject
	public ModeTransitionInfoProvider(final BusinessObjectResolutionService bor, final Diagram diagram, final AnchorService anchorUtil, final ShapeService shapeHelper) {
		super(bor, diagram);
		this.anchorUtil = anchorUtil;
		this.shapeHelper = shapeHelper;
	}

	@Override
	public boolean isBusinessObjectApplicable(final Object bo) {
		return bo instanceof ModeTransition;
	}

	@Override
	public ContainerShape getOwnerShape(final Connection connection) {
		if(connection.getStart() != null && connection.getStart().getParent() instanceof ContainerShape) {
			ContainerShape temp = (ContainerShape)connection.getStart().getParent();
			while(temp != null) {
				final Object tempBo = getBusinessObjectResolver().getBusinessObjectForPictogramElement(temp);
				if(tempBo instanceof ComponentClassifier || tempBo instanceof Subcomponent) {
					return temp;
				}
				temp = temp.getContainer();
			}
			
		}

		return null;
	}
	
	@Override
	public Anchor[] getAnchors(final ContainerShape ownerShape, final Object bo) {
		final ModeTransition mt = (ModeTransition)bo;
		final ContainerShape srcShape = (ContainerShape)shapeHelper.getChildShapeByElementName(ownerShape, mt.getSource());
		final ContainerShape dstShape = (ContainerShape)shapeHelper.getChildShapeByElementName(ownerShape, mt.getDestination());
		if(srcShape == null || dstShape == null) {
			return null;
		}				
		
		final Anchor a1 = anchorUtil.getAnchorByName(shapeHelper.getChildShapeByName(srcShape, ModePattern.innerModeShapeName), AgePattern.chopboxAnchorName);
		final Anchor a2 = anchorUtil.getAnchorByName(shapeHelper.getChildShapeByName(dstShape, ModePattern.innerModeShapeName), AgePattern.chopboxAnchorName);	
		if(a1 == null || a2 == null) {
			return null;
		}

		return new Anchor[] {a1, a2};
	}
}
