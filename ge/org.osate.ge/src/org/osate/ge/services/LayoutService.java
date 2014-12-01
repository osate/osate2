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
	 * Checks the size of the specified shape's container and resizes it if necessary. If resizing takes place, it also recursively checks the container's container.
	 * @returns whether or not the shape was layed out.
	 */
	boolean checkContainerSize(ContainerShape shape);

	/**
	 * Checks that the specified container's children fits in the container. If they do not, the container's update feature is called
	 *  @param container
	 *  @returns whether or not the shape was layed out.
	 */
	boolean checkSize(ContainerShape container);
	
	void layoutChildren(ContainerShape shape);

	/**
	 * Adjusts the positions of the child shapes so that they are non-negative and determines the needed size for the container. Never returns a size smaller than the current size.
	 * The first element is the x-coordinate, the second element is the y-coordinate.
	 * @param shape
	 * @param fp
	 */
	int[] adjustChildShapePositions(ContainerShape shape);
}