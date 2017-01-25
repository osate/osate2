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
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IPeService;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ShapeService;

public class ModeTransitionInfoProvider extends AbstractConnectionInfoProvider {
	private final ShapeService shapeHelper;
	
	@Inject
	public ModeTransitionInfoProvider(final BusinessObjectResolutionService bor, final Diagram diagram, final ShapeService shapeHelper) {
		super(bor, diagram);
		this.shapeHelper = shapeHelper;
	}

	@Override
	public boolean isBusinessObjectApplicable(final Object bo) {
		return bo instanceof ModeTransition;
	}

	@Override
	public ContainerShape getOwnerShape(final Connection connection) {
		// Find the subcomponent or component classifier that owns the mode transition connection. Look a fixed distance instead of walking up the hierarchy because 
		// the business object may have been deleted and needs to be identified as being ownerless.
		if(connection.getStart() != null && connection.getStart().getParent() instanceof ContainerShape) {
			final ContainerShape startAnchorParent = (ContainerShape)connection.getStart().getParent();
			if(startAnchorParent != null && startAnchorParent.getContainer() != null && startAnchorParent.getContainer().getContainer() != null) {
				final ContainerShape potentialOwnerShape = startAnchorParent.getContainer().getContainer();
				final Object potentialOwnerBo = getBusinessObjectResolver().getBusinessObjectForPictogramElement(potentialOwnerShape);
				if(potentialOwnerBo instanceof ComponentClassifier || potentialOwnerBo instanceof Subcomponent) {
					return potentialOwnerShape;
				}
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

		final IPeService peService = Graphiti.getPeService();
		final Anchor a1 = peService.getChopboxAnchor(srcShape);
		final Anchor a2 = peService.getChopboxAnchor(dstShape);	
		if(a1 == null || a2 == null) {
			return null;
		}

		return new Anchor[] {a1, a2};
	}
}
