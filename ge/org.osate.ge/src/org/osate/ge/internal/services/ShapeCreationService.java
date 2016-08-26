/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.services;

import java.util.List;

import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.Mode;

/**
 * Contains methods for creating shapes
 *
 */
public interface ShapeCreationService {
	/**
	 * 
	 * @param shape
	 * @param features should be a list of features, internal features, or processor features
	 */
	void createUpdateFeatureShapes(ContainerShape shape,
			List<? extends Object> features);
	
	void createUpdateModeShapes(ContainerShape shape, List<Mode> modes);

	void createUpdateShapes(ContainerShape shape,
			List<? extends Object> elements, int startX, boolean incX,
			int xPadding, int startY, boolean incY, int yPadding);
	
	/**
	 * Returns whether add or update was called
	 * @param shape
	 * @param bo
	 * @return
	 */
	boolean createUpdateShape(ContainerShape shape, Object bo);
	
	/**
	 * Create a shape for the specified element in the specified container if one does not exist. Otherwise, it sets the shapes position.
	 * @param container
	 * @param bo
	 * @param x
	 * @param y
	 * @return
	 */
	Shape createShape(final ContainerShape container, final Object bo, final int x, final int y);
}