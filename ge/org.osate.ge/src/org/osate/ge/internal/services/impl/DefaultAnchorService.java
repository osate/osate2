/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.services.impl;

import java.util.Iterator;

import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.ChopboxAnchor;
import org.eclipse.graphiti.mm.pictograms.FixPointAnchor;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.services.IPeService;
import org.osate.ge.internal.services.AnchorService;
import org.osate.ge.internal.services.PropertyService;

/**
 * Class the contains miscellaneous methods for dealing with anchors
 *
 */
public class DefaultAnchorService implements AnchorService {
	private final PropertyService propertyUtil;

	public DefaultAnchorService(final PropertyService propertyUtil) {
		this.propertyUtil = propertyUtil;
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.AnchorService#getAnchorByName(org.eclipse.graphiti.mm.pictograms.PictogramElement, java.lang.String)
	 */
	@Override
	public Anchor getAnchorByName(final PictogramElement pe, final String name) {
		if(pe instanceof AnchorContainer) {
			for(final Anchor anchor : ((AnchorContainer)pe).getAnchors()) {
				if(name.equals(propertyUtil.getName(anchor))) {
					return anchor;
				}
			}	
		}

		return null;
	}
	
	@Override
	public ChopboxAnchor createOrUpdateChopboxAnchor(final AnchorContainer container) {
		final IPeService peService = Graphiti.getPeService();
		final Anchor retrievedAnchor = peService.getChopboxAnchor(container);

		if(retrievedAnchor != null) {
			return (ChopboxAnchor)retrievedAnchor;
		}
		
		return peService.createChopboxAnchor(container);
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.AnchorService#createOrUpdateFixPointAnchor(org.eclipse.graphiti.mm.pictograms.AnchorContainer, java.lang.String, int, int)
	 */
	@Override
	public FixPointAnchor createOrUpdateFixPointAnchor(final AnchorContainer shape, final String name, final int x, final int y, boolean updateOnly) {
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		final IGaService gaService = Graphiti.getGaService();
		
		// Create or get the anchor by name
		final Anchor retrievedAnchor = getAnchorByName(shape, name);
		final FixPointAnchor anchor;
		if(retrievedAnchor == null) {
			if(updateOnly) {
				return null;
			}
			
			anchor = peCreateService.createFixPointAnchor(shape);
			propertyUtil.setName(anchor, name);
			// Theoretically this could be done for the retrieved anchor as well to ensure it has the proper graphical algorithm. Practically it causes problem for Graphiti
			// for an unknown reason when moving feature groups. We do it only when creating the anchor for that reason
			gaService.createInvisibleRectangle(anchor);			
		} else {
			if(!(retrievedAnchor instanceof FixPointAnchor)) {
				throw new RuntimeException("Retrieved anchor is of invalid type: " + retrievedAnchor.getClass().getName());	
			}
			
			anchor = (FixPointAnchor)retrievedAnchor;
		}

		// Configure the anchor
        anchor.setLocation(gaService.createPoint(x, y));
        anchor.setUseAnchorLocationAsConnectionEndpoint(true);
        
        return anchor;
	}
	
	@Override
	public void removeAnchorsWithoutConnections(final Shape shape) {
		// Remove anchors that don't have an incoming or outgoing connection
		final Iterator<Anchor> it = shape.getAnchors().iterator();
		while(it.hasNext()) {
			final Anchor anchor = it.next();
			if(anchor.getIncomingConnections().size() + anchor.getOutgoingConnections().size() == 0) {
				it.remove();
			}
		}
	}
}
