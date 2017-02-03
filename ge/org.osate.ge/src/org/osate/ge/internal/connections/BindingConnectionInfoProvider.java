/*******************************************************************************
 * Copyright (C) 2014 University of Alabama in Huntsville (UAH)
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
import org.osate.aadl2.Classifier;
import org.osate.ge.internal.patterns.ClassifierPattern;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.ShapeService;

/**
 * Connection Info Provider for bindings(connection, processor, memory, etc)
 * They are owned by the classifier shape that is responsible for their creation.
 */
public class BindingConnectionInfoProvider extends AbstractConnectionInfoProvider {
	private final PropertyService propertyService;
	private final ShapeService shapeService;
	
	@Inject
	public BindingConnectionInfoProvider(final BusinessObjectResolutionService bor, final Diagram diagram, final PropertyService propertyService, final ShapeService shapeService) {
		super(bor, diagram);
		this.propertyService = propertyService;
		this.shapeService = shapeService;
	}

	@Override
	public boolean isBusinessObjectApplicable(final Object bo) {
		return false;
	}

	@Override
	public boolean isApplicable(final Connection connection) {
		return ClassifierPattern.BINDING_CONNECTION_TYPE.equals(propertyService.getConnectionType(connection));
	}
	
	@Override
	public ContainerShape getOwner(final Connection connection) {
		if(connection.getStart() == null) {
			return null;
		}
		
		final AnchorContainer parent = connection.getStart().getParent();
		if(parent instanceof ContainerShape) {
			return (ContainerShape)shapeService.getClosestAncestorWithBusinessObjectType((ContainerShape)parent, Classifier.class);
		}

		return null;
	}

	@Override
	public Anchor[] getAnchors(final PictogramElement owner, final Object bo) {
		// Not supported. The classifier will recreate the binding connection on every update.
		return null;
	}
}
