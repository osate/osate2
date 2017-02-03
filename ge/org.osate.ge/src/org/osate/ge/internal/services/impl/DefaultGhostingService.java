/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.services.impl;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.ge.internal.services.ConnectionService;
import org.osate.ge.internal.services.GhostingService;
import org.osate.ge.internal.services.PropertyService;

public class DefaultGhostingService implements GhostingService {
	private final PropertyService propertyService;
	private final ConnectionService connectionService;
	private final IFeatureProvider fp;
	
	public DefaultGhostingService(final PropertyService propertyUtil, final ConnectionService connectionService, final IFeatureProvider fp) {
		this.propertyService = propertyUtil;
		this.connectionService = connectionService;
		this.fp = fp;
	}

	@Override
	public final void setIsGhost(final PictogramElement pe, final boolean isGhost) {
		propertyService.setIsGhost(pe, isGhost);
		updateVisibility(pe, !isGhost);	
	}
	
	/**
	 * Updates the visibility of a pictogram element based on its properties
	 * @param pe
	 */
	private void updateVisibility(final PictogramElement pe, final boolean visible) {
		pe.setVisible(visible);
		if(pe instanceof Connection) {
			final Connection c = (Connection)pe;
			for(final ConnectionDecorator cd : c.getConnectionDecorators()) {
				cd.setVisible(visible);
			}
		}
	}	
	
	@Override
	public void ghostChildren(PictogramElement container) {
		if(container instanceof ContainerShape) {
			ghostChildShapes((ContainerShape)container);
		}
		ghostOwnedConnections(container);
	}
	
	@Override
	public final void ghostChildShapes(final ContainerShape shape) {
		final List<Shape> shapesToDelete = new ArrayList<Shape>(); // Shapes that should be deleted rather than ghosted		
		for(final Shape childShape : shape.getChildren()) {
			if(propertyService.isTransient(childShape)) {
				shapesToDelete.add(childShape);
			} else {
				setIsGhost(childShape, true);
			}
		}
		
		// Delete all shapes that were marked for deletion
		for(final Shape s : shapesToDelete) {
			EcoreUtil.delete(s, true);
		}
	}
	
	@Override
	public final void ghostOwnedConnections(final PictogramElement pe) {
		// Populate the list with connections that are owned by the specified shape
		final List<Connection> connectionsToDelete = new ArrayList<Connection>();
		for(final Connection c : getDiagram().getConnections()) {
			final PictogramElement owner = connectionService.getOwner(c);
			if(owner == pe || owner == null) {
				// Remove transient connections instead of ghosting because they are never resurrected and will otherwise result in a large number of ghosted connections.
				if(propertyService.isTransient(c)) {
					connectionsToDelete.add(c);
				} else {
					setIsGhost(c, true);
				}
			}
		}
		
		// Delete all connections that were marked for deletion
		for(final Connection c : connectionsToDelete) {
			EcoreUtil.delete(c, true);
		}
	}
	
	private Diagram getDiagram() {
		return fp.getDiagramTypeProvider().getDiagram();
	}
}
