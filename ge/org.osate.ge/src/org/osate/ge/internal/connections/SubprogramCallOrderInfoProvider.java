/*******************************************************************************
 * Copyright (C) 2015 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.osate.ge.internal.connections;

import javax.inject.Inject;

import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IPeService;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.ge.internal.patterns.SubprogramCallOrder;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ShapeService;

public class SubprogramCallOrderInfoProvider extends AbstractConnectionInfoProvider {
	private final ShapeService shapeHelper;
	
	@Inject
	public SubprogramCallOrderInfoProvider(final BusinessObjectResolutionService bor, final Diagram diagram, final ShapeService shapeHelper) {
		super(bor, diagram);
		this.shapeHelper = shapeHelper;
	}

	@Override
	public boolean isBusinessObjectApplicable(final Object bo) {
		return bo instanceof SubprogramCallOrder;
	}

	@Override
	public ContainerShape getOwner(final Connection connection) {
		if(connection.getStart() != null && connection.getStart().getParent() instanceof ContainerShape) {
			// The anchor's parent should be the subprogram call shape
			final ContainerShape callShape = (ContainerShape)connection.getStart().getParent();
			if(callShape != null) {
				// The subprogram call's parent should be a call sequence
				final ContainerShape callSequenceShape = callShape.getContainer();
				
				// Verify that the shape is a call sequence shape
				final Object bo = getBusinessObjectResolver().getBusinessObjectForPictogramElement(callSequenceShape);
				if(bo instanceof SubprogramCallSequence) {
					return callSequenceShape;
				}
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
		final SubprogramCallOrder sco = (SubprogramCallOrder)bo;
		
		Anchor a1 = null;
		Anchor a2 = null;
		
		final Shape previousSubprogramCallShape = shapeHelper.getDescendantShapeByElementName(ownerShape, sco.previousSubprogramCall);
		final Shape subprogramCallShape = shapeHelper.getDescendantShapeByElementName(ownerShape, sco.subprogramCall);
		if(previousSubprogramCallShape instanceof ContainerShape && subprogramCallShape instanceof ContainerShape) {
			final IPeService peService = Graphiti.getPeService();
			a1 = peService.getChopboxAnchor((ContainerShape)previousSubprogramCallShape);
			a2 = peService.getChopboxAnchor((ContainerShape)subprogramCallShape);
		}
	
		if(a1 == null || a2 == null) {
			return null;
		}
		
		return new Anchor[] {a1, a2};
	}
}
