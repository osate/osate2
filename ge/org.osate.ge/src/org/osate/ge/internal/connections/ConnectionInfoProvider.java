/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.connections;

import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

/**
 * Should not be implemented. Implement AbstractConnectionInfoProvider instead
 *
 */
public interface ConnectionInfoProvider {	
	/**
	 * Returns whether or not the connection info provider applies to connections with the specified business object.
	 * @param bo
	 * @return
	 */
	boolean isBusinessObjectApplicable(final Object bo);
	
	/**
	 * Returns whether or not the connection info provider applies to a connection.
	 * @return
	 */
	boolean isApplicable(final Connection connection);

	/**
	 * Returns the "owner" pictogram element. That is, the pictogram element that is responsible for updating the connection. Should be the same pictogram element that created the connection.
	 * @param connection a fully created connection. It must have a business object associated with it and anchors should be set
	 * @return
	 */
	PictogramElement getOwner(final Connection connection);

	/**
	 * Returns the anchors for the connection based on the specified owner shape
	 * @param ownerShape
	 * @param bo
	 * @return an array containing the anchors or null if both anchors could not be found. The first element should be the start anchor and the second should be the end anchor.
	 */
	Anchor[] getAnchors(final PictogramElement owner, final Object bo);
}
