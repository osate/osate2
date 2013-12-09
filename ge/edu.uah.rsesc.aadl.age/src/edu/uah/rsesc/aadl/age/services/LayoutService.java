/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package edu.uah.rsesc.aadl.age.services;

import org.eclipse.graphiti.mm.pictograms.ContainerShape;

/**
 * Contains methods for aiding in laying out shapes
 * @author philip.alldredge
 *
 */
public interface LayoutService {

	/**
	 * Checks the size of the container and resizes it if necessary
	 */
	void checkContainerSize(ContainerShape shape);

	void checkSize(ContainerShape container);
	
	void layoutChildren(ContainerShape shape);

	/**
	 * Adjusts the positions of the child shapes so that they are non-negative and determines the needed size for the container
	 * @param shape
	 * @param fp
	 */
	int[] adjustChildShapePositions(ContainerShape shape);
}