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
import java.util.Objects;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.graphiti.datatypes.ILocation;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.styles.PrecisionPoint;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.CurvedConnection;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.ILayoutService;
import org.osate.ge.di.CreateParentQuery;
import org.osate.ge.internal.connections.AadlConnectionInfoProvider;
import org.osate.ge.internal.connections.BindingConnectionInfoProvider;
import org.osate.ge.internal.connections.ConnectionInfoProvider;
import org.osate.ge.internal.connections.FlowSpecificationInfoProvider;
import org.osate.ge.internal.connections.BusinessObjectHandlerConnectionInfoProvider;
import org.osate.ge.internal.query.Query;
import org.osate.ge.internal.query.QueryRunner;
import org.osate.ge.internal.query.RootPictogramQuery;
import org.osate.ge.internal.services.AnchorService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.CachingService;
import org.osate.ge.internal.services.CachingService.Cache;
import org.osate.ge.services.ReferenceBuilderService;
import org.osate.ge.internal.services.ConnectionService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.InternalReferenceBuilderService;
import org.osate.ge.internal.services.ShapeService;

public class DefaultConnectionService implements ConnectionService {
	private final AnchorService anchorService;
	private final PropertyService propertyService;
	private final BusinessObjectResolutionService bor;
	private final ReferenceBuilderService refBuilder;
	private final IFeatureProvider fp;
	private final CachingService cachingService;
	private final List<ConnectionInfoProvider> infoProviders = new ArrayList<>();
	private final Map<PictogramElement, Map<Object, Connection>> ownerToBusinessObjectToConnectionMap = new HashMap<>();
	final Map<Connection, ConnectionInfoProvider> connectionToProviderMap = new HashMap<>();
	private final Cache cache = new Cache() {
		@Override
		public void invalidate() {
			ownerToBusinessObjectToConnectionMap.clear();
			connectionToProviderMap.clear();
		}			
	};
	
	private final Query<Object> ancestorsQuery = new RootPictogramQuery(() -> this.ancestorsRootValue).ancestors();
	private PictogramElement ancestorsRootValue;
	private final QueryRunner queryRunner;
	
	public DefaultConnectionService(final AnchorService anchorUtil, 
			final ShapeService shapeHelper, 
			final PropertyService propertyService,
			final BusinessObjectResolutionService bor,
			final CachingService cachingService, 
			final ExtensionService extService, 
			final InternalReferenceBuilderService refBuilder, 
			final IFeatureProvider fp) {
		this.anchorService = anchorUtil;
		this.propertyService = Objects.requireNonNull(propertyService, "propertyService must not be null");
		this.bor = bor;
		this.refBuilder = refBuilder;
		this.fp = fp;
		this.cachingService = cachingService;
		
		final Diagram diagram = getDiagram();

		infoProviders.add(new AadlConnectionInfoProvider(bor, diagram, anchorUtil, shapeHelper));
		infoProviders.add(new FlowSpecificationInfoProvider(bor, diagram, anchorUtil, shapeHelper));
		infoProviders.add(new BindingConnectionInfoProvider(bor, diagram, propertyService, shapeHelper));

		// Create a query runner for use internally and by connection info providers
		queryRunner = new QueryRunner(propertyService, this, bor, refBuilder);
		
		// Create ConnectionInfoProvider for business object handlers.
		for(final Object handler : extService.getBusinessObjectHandlers()) {
			// Look for a method which is used if and only if the business object handler handles connections
			for(final Method m : handler.getClass().getMethods()) {
				if(m.isAnnotationPresent(CreateParentQuery.class)) {
					infoProviders.add(new BusinessObjectHandlerConnectionInfoProvider(this, propertyService, extService, bor, handler, queryRunner));
					break;
				}
			}
		}
		
		this.cachingService.registerCache(cache);
	}
	
	@Override
	public Collection<Connection> getConnections(final PictogramElement owner) {
		ensureCacheIsPopulated();
		return getBusinessObjectToConnectionMap(owner).values();	
	}
	
	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.ConnectionService#getConnection(org.eclipse.graphiti.mm.pictograms.ContainerShape, java.lang.Object)
	 */
	@Override
	public Connection getConnection(final PictogramElement owner, final Object bo) {
		ensureCacheIsPopulated();
		final Connection result = getBusinessObjectToConnectionMap(owner).get(bo);
		return result;
	}

	/* (non-Javadoc)
	 * @see org.osate.ge.diagrams.common.util.ConnectionService#getAnchors(org.eclipse.graphiti.mm.pictograms.ContainerShape, java.lang.Object)
	 */
	@Override
	public Anchor[] getAnchors(final PictogramElement owner, final Object bo) {
		final ConnectionInfoProvider p = getInfoProviderByBusinessObject(bo);
		if(p != null) {
			final Anchor[] anchors = p.getAnchors(owner, bo);
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
	public PictogramElement getOwner(final Connection connection) {
		final ConnectionInfoProvider p = getInfoProviderByConnection(connection);
		if(p != null) {
			return p.getOwner(connection);
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
	public void updateConnectionAnchor(final Connection connection) {
		createUpdateConnectionAnchor(connection, true);
	}

	@Override
	public Anchor createUpdateConnectionAnchor(Connection connection) {
		return createUpdateConnectionAnchor(connection, false);
	}
	
	@Override
	public void updateConnectionAnchors(final Shape shape) {
		for(final Anchor anchor : shape.getAnchors()) {
			for(final Connection connection : anchor.getIncomingConnections()) {
				updateConnectionAnchor(connection);
			}
			
			for(final Connection connection : anchor.getOutgoingConnections()) {
				updateConnectionAnchor(connection);
			}
		}
	}
	
	@Override
	public void onConnectionCreated(final PictogramElement owner, final Object bo, final Connection c) {
		addToCache(owner, bo, c);
	}
	
	// Caching
	private void populateCache() {
		final Diagram diagram = getDiagram();
		for(final Connection c : diagram.getConnections()) {
			final Object bo = bor.getBusinessObjectForPictogramElement(c);
			if(bo != null) {
				final PictogramElement owner = getOwner(c);
				if(owner != null) {		
					addToCache(owner, bo, c);
				}
			}
		}
	}
	
	private void addToCache(final PictogramElement owner, final Object bo, final Connection c) {
		final Map<Object, Connection> boToConnectionMap = getBusinessObjectToConnectionMap(owner);					
		boToConnectionMap.put(bo, c);
	}
	
	private void ensureCacheIsPopulated() {
		if(ownerToBusinessObjectToConnectionMap.size() == 0) {
			populateCache();
		}
	}
	
	private Map<Object, Connection> getBusinessObjectToConnectionMap(final PictogramElement owner) {		
		Map<Object, Connection> boToConnectionMap = ownerToBusinessObjectToConnectionMap.get(owner);
		if(boToConnectionMap == null) {
			boToConnectionMap = new HashMap<>();
			ownerToBusinessObjectToConnectionMap.put(owner, boToConnectionMap);
		}
		
		return boToConnectionMap;
	}
	
	private Anchor createUpdateConnectionAnchor(final Connection connection, final boolean updateOnly) {
		// Get the first non-connection owner
		PictogramElement owner = connection;
		do {
			owner = getOwner((Connection)owner);
		} while(owner instanceof Connection);
		
		if(!(owner instanceof Shape)) {
			return null;
		}
		
		final Shape ownerShape = (Shape)owner;
		final ILayoutService layoutService = Graphiti.getLayoutService();
		final ILocation ownerLocation = layoutService.getLocationRelativeToDiagram(ownerShape);
		
		final Point connectionMidpoint = getConnectionMidpoint(connection, 0.5);
		final String midpointAnchorName = getUniqueReference(connection);
		if(midpointAnchorName == null || connectionMidpoint == null) {
			return null;
		}
		
		final int anchorX = connectionMidpoint.x - ownerLocation.getX();
		final int anchorY = connectionMidpoint.y - ownerLocation.getY();	
		final Anchor anchor = anchorService.createOrUpdateFixPointAnchor(ownerShape, midpointAnchorName, anchorX, anchorY, updateOnly);
		if(anchor == null) {
			return null;			
		}
		
		// Make the anchor as a connection anchor
		propertyService.setIsConnectionAnchor(anchor, true);
		
		return anchor;
	}
	
	private String getUniqueReference(final Connection connection) {
		final Object connectionBo = bor.getBusinessObjectForPictogramElement(connection);
		if(connectionBo == null) {
			return null;			
		}
		
		String result = "";
		result = concatPictogramReferenceSegment(result, refBuilder.getReference(connectionBo));
		
		try {
			ancestorsRootValue = connection;
			for(final PictogramElement ancestor : queryRunner.getPictogramElements(ancestorsQuery, null)) {
				final Object ancestorBo = bor.getBusinessObjectForPictogramElement(ancestor);
				if(ancestorBo == null) {
					return null;			
				}
				
				result = concatPictogramReferenceSegment(result, refBuilder.getReference(ancestorBo));
			}
		} finally {
			ancestorsRootValue = null;
		}
		
		return result;
	}
	
	private static String concatPictogramReferenceSegment(final String value, final String seg) {
		if(value == null) {
			return null;
		}
		
		if(seg == null) {
			return null;
		}
	
		return value + " " + seg.toLowerCase();
	}
	
	private static Point getConnectionMidpoint(final Connection connection, final double d) {
		if(!(connection instanceof CurvedConnection)) {
			final ILocation location = Graphiti.getLayoutService().getConnectionMidpoint(connection, 0.5);
			return new Point(location.getX(), location.getY());
		}
		
		final ILayoutService layoutService = Graphiti.getLayoutService();

		// Should be end point?
		final Shape startShape = (Shape)connection.getStart().getParent();
		final Shape endShape = (Shape)connection.getEnd().getParent();
		final ILocation startShapeLocation = layoutService.getLocationRelativeToDiagram(startShape);
		final ILocation endShapeLocation = layoutService.getLocationRelativeToDiagram(endShape);
		
		final GraphicsAlgorithm startShapeGa = startShape.getGraphicsAlgorithm();
		final GraphicsAlgorithm endShapeGa = endShape.getGraphicsAlgorithm();
		
		final Rectangle startShapeRect = new Rectangle(startShapeLocation.getX(), startShapeLocation.getY(), startShapeGa.getWidth(), startShapeGa.getHeight());
		final Rectangle endShapeRect = new Rectangle(endShapeLocation.getX(), endShapeLocation.getY(), endShapeGa.getWidth(), endShapeGa.getHeight());
		
		// Find a point on the the line
		if(connection instanceof CurvedConnection) {			
			final Point startPoint = new Point(startShapeLocation.getX() + startShapeRect.width/2, startShapeLocation.getY() + startShapeRect.height/2);
			final Point endPoint = new Point(endShapeLocation.getX() + endShapeRect.width/2, endShapeLocation.getY() + endShapeRect.height/2);
	
			final CurvedConnection cc = (CurvedConnection)connection;
			final BezierRouter router = new BezierRouter(cc.getControlPoints());
			final List<org.eclipse.draw2d.geometry.PrecisionPoint> altResults = router.route(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
			
			// Not technically the midpoint but in practice the point is a reasonable substitute
			final org.eclipse.draw2d.geometry.PrecisionPoint altPoint = altResults.get(altResults.size()/2-2);
			return new Point(altPoint.x, altPoint.y);
		}
		
		final ILocation startLoc = layoutService.getLocationRelativeToDiagram(connection.getStart());
		final ILocation endLoc = layoutService.getLocationRelativeToDiagram(connection.getEnd());
		
		// Need a method that will work with CurvedConnections
		return new Point((int)(startLoc.getX() + (endLoc.getX() - startLoc.getX()) * d), (int)(startLoc.getY() + (endLoc.getY() - startLoc.getY()) * d));
	}	
	
	// Copied and adapted from: org.eclipse.graphiti.ui.internal.parts.CurvedConnectionEditPart.BezierRouter
	private static class BezierRouter {
		private List<PrecisionPoint> bezierPoints;

		public BezierRouter(List<PrecisionPoint> bezierPoints) {
			this.bezierPoints = bezierPoints;
		}

		public List<org.eclipse.draw2d.geometry.PrecisionPoint> route(final int startX, final int startY, final int endX, final int endY) {
			final List<org.eclipse.draw2d.geometry.PrecisionPoint> points = new ArrayList<org.eclipse.draw2d.geometry.PrecisionPoint>();
			List<org.eclipse.draw2d.geometry.PrecisionPoint> controllPoints = new ArrayList<org.eclipse.draw2d.geometry.PrecisionPoint>();
			org.eclipse.draw2d.geometry.PrecisionPoint start = new org.eclipse.draw2d.geometry.PrecisionPoint();
			org.eclipse.draw2d.geometry.PrecisionPoint end = new org.eclipse.draw2d.geometry.PrecisionPoint();
			start.setLocation(startX, startY);
			end.setLocation(endX, endY);
			controllPoints.add(start);
			double gradient = (end.preciseY() - start.preciseY()) / (-end.preciseX() + start.preciseX());
			double ortho_gradient = -Math.pow(gradient, -1);
			double orthovector_x = 1;
			double orthovector_y = ortho_gradient;
			double factor_to_length = 1 / Math.sqrt((Math.pow(orthovector_y, 2) + Math.pow(orthovector_x, 2)));
			for (PrecisionPoint precisionPoint : this.bezierPoints) {

				double orthovector_x_cp = factor_to_length * orthovector_x * precisionPoint.getY();
				double orthovector_y_cp = factor_to_length * orthovector_y * precisionPoint.getY();
				if (Double.isNaN(orthovector_x_cp)) {
					orthovector_x_cp = 0;
				}
				if (Double.isNaN(orthovector_y_cp)) {
					orthovector_y_cp = 1 * precisionPoint.getY();
				}
				org.eclipse.draw2d.geometry.PrecisionPoint anchor = new org.eclipse.draw2d.geometry.PrecisionPoint(
						(start.x + (end.x - start.x) * precisionPoint.getX() - orthovector_x_cp),
						(start.y - (start.y - end.y) * precisionPoint.getX()) + orthovector_y_cp);

				controllPoints.add(anchor);
			}
			controllPoints.add(end);
			int precision = 10;
			double factor = 1.0d / precision;
			points.add(start);
			for (int i = 1; i < precision; i++) {
				int j = 0;
				double sum_x = 0;
				double sum_y = 0;
				for (Point point : controllPoints) {
					sum_x += (bezier(j, controllPoints.size() - 1, i * factor) * point.preciseX());
					sum_y += (bezier(j, controllPoints.size() - 1, i * factor) * point.preciseY());
					j++;
				}
				org.eclipse.draw2d.geometry.PrecisionPoint bezierPoint = new org.eclipse.draw2d.geometry.PrecisionPoint(
						sum_x, sum_y);
				points.add(bezierPoint);
			}
			points.add(end);
			
			return points;
		}

		private double bezier(int i, int n, double t) {
			return binomialCoefficients(n, i) * Math.pow(t, i) * Math.pow((1 - t), (n - i));
		}

		private long binomialCoefficients(int n, int k) {
			long coeff = 1;
			for (int i = n - k + 1; i <= n; i++) {
				coeff *= i;
			}
			for (int i = 1; i <= k; i++) {
				coeff /= i;
			}
			return coeff;
		}
	}
}
