/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.services;

import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

/**
 * Provides methods for ghosting pictogram. A ghost object is an object that is in the diagram
 * but is hidden because it is not longer valid. Ghosts are purged(deleted) when the diagram is saved.
 * @author philip.alldredge
 *
 */
public interface GhostingService {
	void setIsGhost(PictogramElement pe, boolean isGhost);
	
	/**
	 * Ghosts invalid child shapes. An invalid shape is defined as a shape that is not associated with a business object or can not be updated
	 * @param diagram
	 */
	void ghostInvalidChildShapes(ContainerShape shape);
	
	/**
	 * Turns connections owned by the specified shape that are invalid and of a specified type into ghosts. 
	 * Such as ones that do not have a valid business object associated with them or cannot be updated.
	 * Also ghosts connections for which the owner cannot be determined.
	 */
	void ghostInvalidConnections(ContainerShape shape);
}