/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.services.impl;

import org.eclipse.graphiti.datatypes.ILocation;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.ILayoutService;
import org.osate.aadl2.ModeTransition;
import org.osate.ge.diagrams.common.connections.AadlConnectionInfoProvider;
import org.osate.ge.diagrams.common.connections.BindingConnectionInfoProvider;
import org.osate.ge.diagrams.common.connections.ConnectionInfoProvider;
import org.osate.ge.diagrams.common.connections.FlowSpecificationInfoProvider;
import org.osate.ge.diagrams.common.connections.GeneralizationInfoProvider;
import org.osate.ge.diagrams.common.connections.InitialModeConnectionInfoProvider;
import org.osate.ge.diagrams.common.connections.ModeTransitionInfoProvider;
import org.osate.ge.diagrams.common.connections.ModeTransitionTriggerInfoProvider;
import org.osate.ge.diagrams.common.connections.SubprogramCallOrderInfoProvider;
import org.osate.ge.diagrams.common.patterns.ModeTransitionPattern;
import org.osate.ge.services.AnchorService;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.ConnectionService;
import org.osate.ge.services.PropertyService;
import org.osate.ge.services.SerializableReferenceService;
import org.osate.ge.services.ShapeService;

//TODO:Split class so that one will be the utility class and one will be the delegate to the extensions
public class DefaultConnectionService implements ConnectionService {
	private final AnchorService anchorService;
	private final SerializableReferenceService referenceService;
	private final BusinessObjectResolutionService bor;
	private final IFeatureProvider fp;
	private final ConnectionInfoProvider[] infoProviders;
	
	public DefaultConnectionService(final AnchorService anchorUtil, final SerializableReferenceService referenceService, final ShapeService shapeHelper, final PropertyService propertyService, final BusinessObjectResolutionService bor, final IFeatureProvider fp) {
		this.anchorService = anchorUtil;
		this.referenceService = referenceService;
		this.bor = bor;
		this.fp = fp;
		
		// TODO: Use extension point or something
		final Diagram diagram = getDiagram();
		infoProviders = new ConnectionInfoProvider[] {
				new AadlConnectionInfoProvider(bor, diagram, anchorUtil, shapeHelper),
				new FlowSpecificationInfoProvider(bor, diagram, anchorUtil, shapeHelper),
				new GeneralizationInfoProvider(bor, diagram, shapeHelper),
				new ModeTransitionInfoProvider(bor, diagram, anchorUtil, shapeHelper),
				new InitialModeConnectionInfoProvider(bor, diagram, propertyService),
				new ModeTransitionTriggerInfoProvider(bor, diagram, propertyService),
				new BindingConnectionInfoProvider(bor, diagram, propertyService, shapeHelper),
				new SubprogramCallOrderInfoProvider(bor, diagram, shapeHelper)
		};
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.ConnectionService#getConnection(org.eclipse.graphiti.mm.pictograms.ContainerShape, java.lang.Object)
	 */
	@Override
	public Connection getConnection(final ContainerShape ownerShape, final Object bo) {
		// Find all connections that match the anchors
		final Diagram diagram = getDiagram();
		for(final Connection c : diagram.getConnections()) {
			if(getOwnerShape(c) == ownerShape && bor.areBusinessObjectsEqual(bor.getBusinessObjectForPictogramElement(c), bo)) {
				return c;
			}
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.ConnectionService#getAnchors(org.eclipse.graphiti.mm.pictograms.ContainerShape, java.lang.Object)
	 */
	@Override
	public Anchor[] getAnchors(final ContainerShape ownerShape, final Object bo) {
		final ConnectionInfoProvider p = getInfoProviderByBusinessObject(bo);
		if(p != null) {
			final Anchor[] anchors = p.getAnchors(ownerShape, bo);
			if(anchors != null && isVisible(anchors[0]) && isVisible(anchors[1])) {
				return anchors;
			}
		}

		return null;
	}	
	
	private boolean isVisible(final Anchor anchor) {
		boolean result = true;
		if(result && anchor.getParent() instanceof Shape) {
			Shape shape = (Shape)anchor.getParent();
			do {
				result = shape.isVisible();
				shape = shape.getContainer();
			} while(shape != null && result);
		}
		
		return result;
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.ConnectionService#getOwnerShape(org.eclipse.graphiti.mm.pictograms.Connection)
	 */
	@Override
	public ContainerShape getOwnerShape(final Connection connection) {
		final ConnectionInfoProvider p = getInfoProviderByConnection(connection);
		if(p != null) {
			return p.getOwnerShape(connection);
		}
		
		return null;
	}

	private ConnectionInfoProvider getInfoProviderByBusinessObject(final Object bo) {
		for(final ConnectionInfoProvider p : infoProviders) {
			if(p.isBusinessObjectApplicable(bo)) {
				return p;
			}
		}
		
		return null;
	}
	
	private ConnectionInfoProvider getInfoProviderByConnection(final Connection c) {
		for(final ConnectionInfoProvider p : infoProviders) {
			if(p.isApplicable(c)) {
				return p;
			}
		}
		
		return null;
	}
	
	private Diagram getDiagram() {
		return fp.getDiagramTypeProvider().getDiagram();
	}
	
	@Override
	public Anchor getMidpointAnchor(final Connection connection) {
		// Get the connection's owner
		final Shape connectionOwnerShape = getOwnerShape(connection);
		if(connectionOwnerShape == null) {
			return null;
		}
		
		// DEtermine the name of the anchor
		final String anchorName = getMidpointAnchorName(connection);
		if(anchorName == null) {
			return null;
		}
		
		final Anchor connectionAnchor = anchorService.getAnchorByName(connectionOwnerShape, anchorName);
		return connectionAnchor;
	}
	
	@Override
	public void createUpdateMidpointAnchor(final Connection connection) {
		if(allowMidpointAnchor(connection)) {
			final Shape ownerShape = getOwnerShape(connection);
			if(ownerShape != null) {
				final ILayoutService layoutService = Graphiti.getLayoutService();
				final ILocation ownerLocation = layoutService.getLocationRelativeToDiagram(ownerShape);
				final ILocation connectionMidpoint = layoutService.getConnectionMidpoint(connection, 0.5);
				final String midpointAnchorName = getMidpointAnchorName(connection);
				if(midpointAnchorName != null) {
					anchorService.createOrUpdateFixPointAnchor(ownerShape, midpointAnchorName, connectionMidpoint.getX() - ownerLocation.getX(), connectionMidpoint.getY() - ownerLocation.getY());
				}
			}
		}
		
		// TODO: Need to expand the abstraction for midpoint anchors and connection anchors to incorporate curved connections.
		final Object connectionBo = bor.getBusinessObjectForPictogramElement(connection);
		if(connectionBo instanceof ModeTransition) {
			ModeTransitionPattern.updateControlPoints(connection);
			ModeTransitionPattern.updateAnchors(referenceService, connection, (ModeTransition)connectionBo, anchorService);
		}
	}

	private boolean allowMidpointAnchor(final Connection connection) {
		final Object connectionBo = bor.getBusinessObjectForPictogramElement(connection);
		final ConnectionInfoProvider connectionInfoProvider = getInfoProviderByBusinessObject(connectionBo);
		return connectionInfoProvider != null && connectionInfoProvider.allowMidpointAnchor();
	}
	
	private String getMidpointAnchorName(final Connection connection) {
		final Object bo = bor.getBusinessObjectForPictogramElement(connection);
		return bo == null ? null : referenceService.getReference(bo) + "_midpoint";
	}
	
	@Override
	public void updateConnectionAnchors(final Shape shape) {
		for(final Anchor anchor : shape.getAnchors()) {
			for(final Connection connection : anchor.getIncomingConnections()) {
				createUpdateMidpointAnchor(connection);
			}
			
			for(final Connection connection : anchor.getOutgoingConnections()) {
				createUpdateMidpointAnchor(connection);
			}
		}
	}
}
