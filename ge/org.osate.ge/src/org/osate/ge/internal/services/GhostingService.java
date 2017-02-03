/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.services;

import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

/**
 * Provides methods for ghosting pictogram. A ghost object is an object that is in the diagram
 * but is hidden because it is not longer valid. Ghosts are purged(deleted) when the diagram is saved.
 * 
 * The usual process for refreshing a shape involves ghosting all children and then unghosting children which should be in the diagram.
 *
 */
public interface GhostingService {
	void setIsGhost(PictogramElement pe, boolean isGhost);
	
	/**
	 * Helper method which combines ghostChildShapes() and ghostOwnedConnections() as applicable
	 */
	void ghostChildren(PictogramElement container);
	
	/**
	 * Ghosts all child shapes and deletes transient shapes.
	 */
	void ghostChildShapes(ContainerShape shape);
	
	/**
	 * Ghosts all connections owned by the shape and any connections for which an owner cannot be determined. Deletes transient connections
	 */
	void ghostOwnedConnections(final PictogramElement pe);
}