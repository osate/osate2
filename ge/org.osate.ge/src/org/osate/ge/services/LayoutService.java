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

/**
 * Contains methods for aiding in laying out shapes
 * @author philip.alldredge
 *
 */
public interface LayoutService {		
	/**
	 * Checks that the shape fits in its container.  If it does not, the container's layout feature is called and the ancestor is checked as well.
	 * @param shape
	 * @return
	 */
	boolean checkShapeBoundsWithAncestors(ContainerShape shape);
	boolean checkShapeBounds(final ContainerShape shape);
	
	void layoutChildren(ContainerShape shape);

	/**
	 * Gets the minimum size of the shape. Taken into account child shapes. Never returns a size smaller than the current size.
	 * The first element is the x-coordinate, the second element is the y-coordinate.
	 * @param shape
	 * @param fp
	 */
	int[] getMinimumSize(ContainerShape shape);
	
	/**
	 * Returns the minimum width and height for a shape layed out in accordance to adjustChildShapePosition
	 * @return
	 */
	int getMinimumWidth();
	int getMinimumHeight();
}