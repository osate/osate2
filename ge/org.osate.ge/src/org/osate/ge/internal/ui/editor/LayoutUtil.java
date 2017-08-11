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
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.graphics.GraphicUtil;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;

class LayoutUtil {
	public static boolean areAllUndockedMoveableShapes(final PictogramElement[] pes, final GraphitiAgeDiagram graphitiAgeDiagram) {
		if(graphitiAgeDiagram == null) {
			return false;
		}
		
		for(final PictogramElement pe : pes) {
			if(!(pe instanceof Shape)) {
				return false;
			}
			
			final DiagramElement de = graphitiAgeDiagram.getDiagramElement(pe);
			if(de == null) {
				return false;
			}
			
			if(de.getDockArea() != null) {
				return false;
			}
			
			if(!GraphicUtil.isMoveableShape(de.getGraphic())) {
				return false;
			}
			
		}
		
		return true;
	}
	
	public static boolean areAllResizableShapes(final PictogramElement[] pes, final GraphitiAgeDiagram graphitiAgeDiagram) {
		if(graphitiAgeDiagram == null) {
			return false;
		}
		
		for(final PictogramElement pe : pes) {
			if(!(pe instanceof Shape)) {
				return false;
			}
			
			final DiagramElement de = graphitiAgeDiagram.getDiagramElement(pe);
			if(de == null) {
				return false;
			}
			
			if(!GraphicUtil.isResizableShape(de.getGraphic())) {
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
