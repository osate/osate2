/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.ui.editor;

import org.eclipse.graphiti.features.context.impl.MoveShapeContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

class LayoutUtil {
	public static boolean areAllShapes(final PictogramElement[] pes) {
		for(final PictogramElement pe : pes) {
			if(!(pe instanceof Shape)) {
				return false;
			}
		}
		
		return true;
	}	
	
	public static boolean haveSameContainerShapes(final Shape[] shapes) {
		if(shapes.length == 0) {
			throw new RuntimeException("shapes is empty");
		}
		
		final ContainerShape containerShape = shapes[0].getContainer();
		for (int i=1;i<shapes.length;i++) {
			if (shapes[i].getContainer() != containerShape) {
				return false;
			}
		}
		
		return true;
	}
	
	public static MoveShapeContext getDistributeMoveShapeContext(final Shape shape, final int xValue, final int yValue, final ContainerShape container) {
		final MoveShapeContext moveCtx = new MoveShapeContext(shape);
		moveCtx.setLocation(xValue, yValue);
		moveCtx.setSourceContainer(container);
		moveCtx.setTargetContainer(container);
		moveCtx.setDeltaX(xValue);
		moveCtx.setDeltaY(yValue);
		
		return moveCtx;
	}
}
