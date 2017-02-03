/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.services;

import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.ChopboxAnchor;
import org.eclipse.graphiti.mm.pictograms.FixPointAnchor;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

/**
 * Provides methods to make working with anchors easier.
 *
 */
public interface AnchorService {

	Anchor getAnchorByName(PictogramElement pe, String name);

	ChopboxAnchor createOrUpdateChopboxAnchor(AnchorContainer container, String name);

	FixPointAnchor createOrUpdateFixPointAnchor(AnchorContainer shape, String name, int x, int y, boolean updateOnly);

	/**
	 * Removes anchors from a shape if they do not have connections. Not recursive.
	 * @param shape
	 */
	void removeAnchorsWithoutConnections(Shape shape);
}