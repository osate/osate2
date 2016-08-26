/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.services;

import java.util.Collection;

import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;

/**
 * Contains methods for working with Graphiti connections
 *
 */
public interface ConnectionService {
	/**
	 *
	 * @param ownerShape
	 * @return all connections owned by the specified shape
	 */
	Collection<Connection> getConnections(ContainerShape ownerShape);
	
	Connection getConnection(ContainerShape ownerShape, Object bo);

	Anchor[] getAnchors(ContainerShape ownerShape, Object bo);

	ContainerShape getOwnerShape(Connection connection);
	
	/**
	 * Used to retrieve an anchor for the connection's midpoint.
	 * @param connection
	 * @return the anchor or null if the anchor does not exist
	 */
	Anchor getMidpointAnchor(Connection connection);
	
	/**
	 * Helper for creating and updating a connection's midpoint anchor.
	 * @param connection
	 */
	void createUpdateMidpointAnchor(Connection connection);
	
	/**
	 * Updates connections that are connecting to anchors owned by the shape
	 * @param shape
	 */
	void updateConnectionAnchors(Shape shape);

	// Called to notify the connection service of a new connection. Must be called to ensure cache contains all connections
	void onConnectionCreated(final Shape ownerShape, final Object bo, final Connection c);
}