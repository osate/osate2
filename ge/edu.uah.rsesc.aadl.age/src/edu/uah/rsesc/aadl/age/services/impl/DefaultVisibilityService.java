/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package edu.uah.rsesc.aadl.age.services.impl;

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
import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;
import edu.uah.rsesc.aadl.age.services.PropertyService;
import edu.uah.rsesc.aadl.age.services.VisibilityService;

public class DefaultVisibilityService implements VisibilityService {
	private final PropertyService propertyUtil;
	private final BusinessObjectResolutionService bor;
	private final IFeatureProvider fp;
	
	public DefaultVisibilityService(final PropertyService propertyUtil, final BusinessObjectResolutionService bor, final IFeatureProvider fp) {
		this.propertyUtil = propertyUtil;
		this.bor = bor;
		this.fp = fp;
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.VisibilityService#setIsGhost(org.eclipse.graphiti.mm.pictograms.PictogramElement, boolean)
	 */
	@Override
	public void setIsGhost(final PictogramElement pe, final boolean isGhost) {
		propertyUtil.setIsGhost(pe, isGhost);
		updateVisibility(pe);	
	}
	
	/**
	 * Updates the visibility of a pictogram element based on its properties
	 * @param pe
	 */
	private void updateVisibility(final PictogramElement pe) {
		final boolean visible = !propertyUtil.isGhost(pe);
		pe.setVisible(visible);
		if(pe instanceof Connection) {
			final Connection c = (Connection)pe;
			for(final ConnectionDecorator cd : c.getConnectionDecorators()) {
				cd.setVisible(visible);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.VisibilityService#getNonGhostChildren(org.eclipse.graphiti.mm.pictograms.ContainerShape)
	 */
	@Override
	public List<Shape> getNonGhostChildren(final ContainerShape shape) {
		final List<Shape> children = new ArrayList<Shape>();
		for(final Shape child : shape.getChildren()) {
			if(!propertyUtil.isGhost(child)) {
				children.add(child);
			}
		}
		
		return children;
	}
	
	@Override
	public void ghostInvalidShapes(final ContainerShape shape) {
		final Set<Object> updatedBos = new HashSet<Object>(); // Set used to track if an object already associated with a business object has not-been ghosted(considered valid)
		
		for(final Shape childShape : shape.getChildren()) {
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
	
	@Override
	public void ghostInvalidConnections() {
		for(final Connection connection : getDiagram().getConnections()) {
			boolean ghost = false;
			final Object bo = bor.getBusinessObjectForPictogramElement(connection);
			// If the business object is not valid, ghost the connection
			if(!(bo instanceof EObject)) {
				ghost = true;
			} else {				
				// If there is not a pattern to update the connection, ghost it
				final UpdateContext updateContext = new UpdateContext(connection);
				final IUpdateFeature updateFeature = fp.getUpdateFeature(updateContext);
				if(updateFeature == null || !updateFeature.canUpdate(updateContext)) {
					ghost = true;
				}
			}
			
			if(ghost) {
				setIsGhost(connection, true);
			}
		}
	}
	
	private Diagram getDiagram() {
		return fp.getDiagramTypeProvider().getDiagram();
	}
}
