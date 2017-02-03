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
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

/**
 * Contains methods for working with Graphiti connections
 *
 */
public interface ConnectionService {
	/**
	 *
	 * @param owner
	 * @return all connections owned by the specified pictogram element
	 */
	Collection<Connection> getConnections(PictogramElement owner);
	
	Connection getConnection(PictogramElement owner, Object bo);

	Anchor[] getAnchors(PictogramElement owner, Object bo);

	PictogramElement getOwner(Connection connection);
		
	/**
	 * Updates a connection's midpoint anchor. Does not create an anchor if it doesn't exist.
	 * @param connection
	 */
	void updateConnectionAnchor(Connection connection);
	
	/**
	 * Creates/Updates a connection's midpoint anchor. Creates the anchor if it doesn't exist.
	 * @param connection
	 */
	Anchor createUpdateConnectionAnchor(Connection connection);
	
	/**
	 * Updates connection anchors for all connections that are connected to the shape.
	 * @param shape
	 */
	void updateConnectionAnchors(Shape shape);

	// Called to notify the connection service of a new connection. Must be called to ensure cache contains all connections
	void onConnectionCreated(final PictogramElement owner, final Object bo, final Connection c);
}