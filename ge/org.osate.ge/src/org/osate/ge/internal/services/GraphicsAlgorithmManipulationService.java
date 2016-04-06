/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.services;

import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;

/**
 * Contains methods for manipulating graphics algorithms
 *
 */
public interface GraphicsAlgorithmManipulationService {
	/**
	 * Mirrors a graphics algorithm in the x axis
	 * @param ga the graphics algorithm to mirror
	 */
	void mirror(GraphicsAlgorithm ga);

	// TODO: Make note of when this method causes issues(out of bounds drawing)
	void shrink(GraphicsAlgorithm ga);

}