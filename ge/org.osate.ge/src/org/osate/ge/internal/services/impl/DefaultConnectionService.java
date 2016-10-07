// Based on OSATE Graphical Editor. Modifications are: 
/*
Copyright (c) 2016, Rockwell Collins.
Developed with the sponsorship of Defense Advanced Research Projects Agency (DARPA).

Permission is hereby granted, free of charge, to any person obtaining a copy of this data, 
including any software or models in source or binary form, as well as any drawings, specifications, 
and documentation (collectively "the Data"), to deal in the Data without restriction, including
without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or 
substantial portions of the Data.

THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE 
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
*/
/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.services.impl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.osate.ge.di.CreateParentQuery;
import org.osate.ge.internal.connections.AadlConnectionInfoProvider;
import org.osate.ge.internal.connections.BindingConnectionInfoProvider;
import org.osate.ge.internal.connections.ConnectionInfoProvider;
import org.osate.ge.internal.connections.ConnectionReferenceInfoProvider;
import org.osate.ge.internal.connections.FlowSpecificationInfoProvider;
import org.osate.ge.internal.connections.InitialModeConnectionInfoProvider;
import org.osate.ge.internal.connections.ModeTransitionInfoProvider;
import org.osate.ge.internal.connections.ModeTransitionTriggerInfoProvider;
import org.osate.ge.internal.connections.BusinessObjectHandlerConnectionInfoProvider;
import org.osate.ge.internal.connections.SubprogramCallOrderInfoProvider;
import org.osate.ge.internal.patterns.ModeTransitionPattern;
import org.osate.ge.internal.query.QueryRunner;
import org.osate.ge.internal.services.AnchorService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.CachingService;
import org.osate.ge.internal.services.CachingService.Cache;
import org.osate.ge.internal.services.ConnectionService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.InternalReferenceBuilderService;
import org.osate.ge.internal.services.SerializableReferenceService;
import org.osate.ge.internal.services.ShapeService;

public class DefaultConnectionService implements ConnectionService {
	private final AnchorService anchorService;
	private final SerializableReferenceService referenceService;
	private final BusinessObjectResolutionService bor;
	private final IFeatureProvider fp;
	private final CachingService cachingService;
	private final List<ConnectionInfoProvider> infoProviders = new ArrayList<>();
	private final Map<Shape, Map<Object, Connection>> ownerShapeToBusinessObjectToConnectionMap = new HashMap<>();
	final Map<Connection, ConnectionInfoProvider> connectionToProviderMap = new HashMap<>();
	private final Cache cache = new Cache() {
		@Override
		public void invalidate() {
			ownerShapeToBusinessObjectToConnectionMap.clear();
			connectionToProviderMap.clear();
		}			
	};

	public DefaultConnectionService(final AnchorService anchorUtil, final SerializableReferenceService referenceService, final ShapeService shapeHelper, 
			final PropertyService propertyService, final BusinessObjectResolutionService bor, final CachingService cachingService, 
			final ExtensionService extService, final InternalReferenceBuilderService refBuilder, final IFeatureProvider fp) {
		this.anchorService = anchorUtil;
		this.referenceService = referenceService;
		this.bor = bor;
		this.fp = fp;
		this.cachingService = cachingService;
		
		final Diagram diagram = getDiagram();

		infoProviders.add(new AadlConnectionInfoProvider(bor, diagram, anchorUtil, shapeHelper));
		infoProviders.add(new FlowSpecificationInfoProvider(bor, diagram, anchorUtil, shapeHelper));
		infoProviders.add(new ModeTransitionInfoProvider(bor, diagram, anchorUtil, shapeHelper));
		infoProviders.add(new InitialModeConnectionInfoProvider(bor, diagram, propertyService));
		infoProviders.add(new ModeTransitionTriggerInfoProvider(bor, diagram, propertyService));
		infoProviders.add(new BindingConnectionInfoProvider(bor, diagram, propertyService, shapeHelper));
		infoProviders.add(new SubprogramCallOrderInfoProvider(bor, diagram, shapeHelper));
		infoProviders.add(new ConnectionReferenceInfoProvider(bor, diagram, anchorUtil, shapeHelper));

		// Create ConnectionInfoProvider for business object handlers.
		final QueryRunner queryRunner = new QueryRunner(propertyService, this, bor, refBuilder);
		for(final Object handler : extService.getBusinessObjectHandlers()) {
			// Look for a method which is used if and only if the business object handler handles connections
			for(final Method m : handler.getClass().getMethods()) {
				if(m.isAnnotationPresent(CreateParentQuery.class)) {
					infoProviders.add(new BusinessObjectHandlerConnectionInfoProvider(extService, bor, handler, queryRunner));
					break;
				}
			}
		}
		
		this.cachingService.registerCache(cache);
	}
	
	@Override
	public Collection<Connection> getConnections(ContainerShape ownerShape) {
		ensureCacheIsPopulated();
		return getBusinessObjectToConnectionMap(ownerShape).values();	
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.ConnectionService#getConnection(org.eclipse.graphiti.mm.pictograms.ContainerShape, java.lang.Object)
	 */
	@Override
	public Connection getConnection(final ContainerShape ownerShape, final Object bo) {
		ensureCacheIsPopulated();
		final Connection result = getBusinessObjectToConnectionMap(ownerShape).get(bo);
		return result;
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
		final ConnectionInfoProvider infoProvider = connectionToProviderMap.get(c);
		if(infoProvider != null) {
			return infoProvider;			
		}
		
		for(final ConnectionInfoProvider p : infoProviders) {
			if(p.isApplicable(c)) {
				connectionToProviderMap.put(c, p);
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
		
		// Determine the name of the anchor
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
				if(midpointAnchorName != null && connectionMidpoint != null) {
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
		final ConnectionInfoProvider connectionInfoProvider = getInfoProviderByConnection(connection);
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
	
	@Override
	public void onConnectionCreated(final Shape ownerShape, final Object bo, final Connection c) {
		addToCache(ownerShape, bo, c);
	}
	
	// Caching
	private void populateCache() {
		final Diagram diagram = getDiagram();
		for(final Connection c : diagram.getConnections()) {
			final Object bo = bor.getBusinessObjectForPictogramElement(c);
			if(bo != null) {
				final Shape ownerShape = getOwnerShape(c);
				if(ownerShape != null) {					
					addToCache(ownerShape, bo, c);
				}
			}
		}
	}
	
	private void addToCache(final Shape ownerShape, final Object bo, final Connection c) {
		final Map<Object, Connection> boToConnectionMap = getBusinessObjectToConnectionMap(ownerShape);					
		boToConnectionMap.put(bo, c);
	}
	
	private void ensureCacheIsPopulated() {
		if(ownerShapeToBusinessObjectToConnectionMap.size() == 0) {
			populateCache();
		}
	}
	
	private Map<Object, Connection> getBusinessObjectToConnectionMap(final Shape ownerShape) {		
		Map<Object, Connection> boToConnectionMap = ownerShapeToBusinessObjectToConnectionMap.get(ownerShape);
		if(boToConnectionMap == null) {
			boToConnectionMap = new HashMap<>();
			ownerShapeToBusinessObjectToConnectionMap.put(ownerShape, boToConnectionMap);
		}
		
		return boToConnectionMap;
	}
}
