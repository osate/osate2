/*******************************************************************************
 * Copyright (C) 2015 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.osate.ge.internal.services;

import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;

/**
 * Service for creating and working with label shapes
 *
 */
public interface LabelService {
	// Create a label shape. The label's position is not set.
	Shape createLabelShape(final ContainerShape container, final String shapeName, final Object bo, final String labelValue);
	
	Shape createLabelShape(final ContainerShape container, final String shapeName, final Object bo, final String labelValue, final boolean includeBackground);
	
	void setStyle(Text text);
}
