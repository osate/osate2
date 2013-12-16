/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package edu.uah.rsesc.aadl.age.services;

import java.util.List;

import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

/**
 * Provides methods for checking and affecting the visibility of objects. A ghost object is an object that is in the diagram
 * but is hidden because it has been deleted.
 * @author philip.alldredge
 *
 */
public interface VisibilityService {
	void setIsGhost(PictogramElement pe, boolean isGhost);

	List<Shape> getNonGhostChildren(ContainerShape shape);
	
	/**
	 * Ghosts invalid shapes from a diagram. An invalid shape is defined as a top level shape that is not associated with a business object or can not be updated
	 * @param diagram
	 */
	void ghostInvalidShapes(ContainerShape shape);
	
	/**
	 * Turns connections that are invalid and of a specified type into ghosts. Such as ones that do not have a valid business object associated with them.
	 * @param connectionTypeFilter is the type of connections to turn into ghost. If null, turns only connections that do not have a connection type property set into ghosts
	 */
	void ghostInvalidConnections(final String connectionTypeFilter);
}