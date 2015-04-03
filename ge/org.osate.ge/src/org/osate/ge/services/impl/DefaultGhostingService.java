/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.ConnectionService;
import org.osate.ge.services.PropertyService;
import org.osate.ge.services.GhostingService;
public class DefaultGhostingService implements GhostingService {
	private final PropertyService propertyService;
	private final ConnectionService connectionService;
	private final BusinessObjectResolutionService bor;
	private final IFeatureProvider fp;
	
	public DefaultGhostingService(final PropertyService propertyUtil, final ConnectionService connectionService, final BusinessObjectResolutionService bor, final IFeatureProvider fp) {
		this.propertyService = propertyUtil;
		this.connectionService = connectionService;
		this.bor = bor;
		this.fp = fp;
	}

	@Override
	public void setIsGhost(final PictogramElement pe, final boolean isGhost) {
		propertyService.setIsGhost(pe, isGhost);
		updateVisibility(pe);	
	}
	
	/**
	 * Updates the visibility of a pictogram element based on its properties
	 * @param pe
	 */
	private void updateVisibility(final PictogramElement pe) {
		final boolean visible = !propertyService.isGhost(pe);
		pe.setVisible(visible);
		if(pe instanceof Connection) {
			final Connection c = (Connection)pe;
			for(final ConnectionDecorator cd : c.getConnectionDecorators()) {
				cd.setVisible(visible);
			}
		}
	}
	
	@Override
	public void ghostInvalidChildShapes(final ContainerShape shape) {
		final Set<Object> updatedBos = new HashSet<Object>(); // Set used to track if an object already associated with a business object has not-been ghosted(considered valid)
		final List<Shape> shapesToDelete = new ArrayList<Shape>(); // Shapes that should be deleted rather than ghosted
		
		for(final Shape childShape : shape.getChildren()) {
			if(propertyService.isTransient(childShape)) {
				shapesToDelete.add(childShape);
			} else {
				// Check if the shape has a business object and can be updated
				final Object bo = bor.getBusinessObjectForPictogramElement(childShape);
				final UpdateContext updateContext = new UpdateContext(childShape);
				final IUpdateFeature updateFeature = fp.getUpdateFeature(updateContext);
				
				// Determine whether to ghost the shape
				boolean ghost = false;
				if(updatedBos.contains(bo)) {
					ghost = true;
				} else {
					if(bo == null || updateFeature == null || !updateFeature.canUpdate(updateContext)) {
						ghost = true;
					} else {
						EObject emfBusinessObject = (EObject)bo;
						if(emfBusinessObject.eIsProxy()) {
							emfBusinessObject = EcoreUtil.resolve(emfBusinessObject, emfBusinessObject.eResource().getResourceSet());
						}
			
						if(emfBusinessObject.eIsProxy()) {
							ghost = true;
						}
					}
				}
				
				// Ghost the shape
				if(ghost) {
					setIsGhost(childShape, true);
				} else {
					updatedBos.add(bo);
				}
			}
		}
		
		// Delete all shapes that were marked for deletion
		for(final Shape s : shapesToDelete) {
			EcoreUtil.delete(s, true);
		}
	}
	
	@Override
	public void ghostConnections(final ContainerShape shape) {
		// Populate the list with connections that are owned by the specified shape
		final List<Connection> connectionsToDelete = new ArrayList<Connection>();
		for(final Connection c : getDiagram().getConnections()) {
			final ContainerShape owner = connectionService.getOwnerShape(c);

			if(owner == shape || owner == null) {
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
