// Based on OSATE Graphical Editor. Modifications are: 
/*
Copyright (c) 2016, Rockwell Collins.
Developed with the sponsorship of Defense Advanced Research Projects Agency (DARPA).

Permission is hereby granted, free of charge, to any person obtaining a copy of this data, 
including any software or models in source or binary form, as well as any drawings, specifications, 
and documentation (collectively "the Data"), to deal in the Data without restriction, including
without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or 
substantial portions of the Data.

THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE 
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
*/
/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.diagram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.osate.ge.internal.graphics.AgeConnection;
import org.osate.ge.internal.graphics.AgeShape;
import org.osate.ge.internal.layout.LayoutAlgorithm;
import org.osate.ge.internal.layout.SimpleLayoutAlgorithm;

/**
 * Lays out diagram elements included in a diagram using an algorithm.
 */
public class DiagramLayoutUtil {	
	public static boolean layout(final AgeDiagram diagram, final DiagramModification mod, final boolean fullLayout) {
		// Convert the diagram shapes to shapes used by the layout algorithm
		final List<org.osate.ge.internal.layout.Shape> rootLayoutShapes = new ArrayList<org.osate.ge.internal.layout.Shape>();
		final Map<Object, Object> shapeMap = new HashMap<Object, Object>(); // Map that contains a mapping from layout/diagram element shapes to the other one.
		for(final DiagramElement diagramElement : diagram.getDiagramElements()) {
			if(diagramElement.getGraphic() instanceof AgeShape) {
				final org.osate.ge.internal.layout.Shape newLayoutShape = createLayoutShape(diagramElement, shapeMap, null, fullLayout);
				if(newLayoutShape != null) {
					rootLayoutShapes.add(newLayoutShape);
				}				
			}
		}
				
		// Don't perform any automatic layout if there is not more than 1 child shape
		if(!hasUnlockedShapes(rootLayoutShapes)) {
			return false;
		}	

		// Create layout connections
		final List<org.osate.ge.internal.layout.Connection> layoutConnections = new ArrayList<org.osate.ge.internal.layout.Connection>();
		for(final DiagramElement diagramElement : diagram.getDiagramElements()) {
			createLayoutConnections(diagramElement, shapeMap, fullLayout, layoutConnections);
		}
	
		//final LayoutAlgorithm layoutAlg = new MonteCarloLayoutAlgorithm();
		final LayoutAlgorithm layoutAlg = new SimpleLayoutAlgorithm();
		layoutAlg.layout(rootLayoutShapes, layoutConnections);

		// Remove all bendpoints
		if(fullLayout) {
			for(final DiagramElement diagramElement : diagram.getDiagramElements()) {
				removeAllBendpoints(mod, diagramElement);
			}
		}
		
		// Update the diagram's shapes
		for(final org.osate.ge.internal.layout.Shape layoutShape : rootLayoutShapes) {
			updateShape(mod, layoutShape, shapeMap);
		}
		
		return true;
	}
	
	private static void createLayoutConnections(final DiagramElement diagramElement, 
			final Map<Object, Object> shapeMap, 
			final boolean fullLayout,
			final List<org.osate.ge.internal.layout.Connection> layoutConnections) {
		if(diagramElement.getGraphic() instanceof AgeConnection) {
			final org.osate.ge.internal.layout.Shape startLayoutShape = (org.osate.ge.internal.layout.Shape)shapeMap.get(diagramElement.getStartElement());
			final org.osate.ge.internal.layout.Shape endLayoutShape = (org.osate.ge.internal.layout.Shape)shapeMap.get(diagramElement.getEndElement());
			if(startLayoutShape != null && endLayoutShape != null && startLayoutShape != endLayoutShape) {
				layoutConnections.add(new org.osate.ge.internal.layout.Connection(startLayoutShape, endLayoutShape));
			}			
		}
		
		for(final DiagramElement child : diagramElement.getDiagramElements()) {
			createLayoutConnections(child, shapeMap, fullLayout, layoutConnections);
		}
	}
	
	private static void removeAllBendpoints(final DiagramModification mod, final DiagramElement e) {
		if(e.getGraphic() instanceof AgeConnection) {
			mod.setBendpoints(e, Collections.emptyList());
		}
		
		for(final DiagramElement child : e.getDiagramElements()) {
			removeAllBendpoints(mod, child);
		}	
	}
	
	private static org.osate.ge.internal.layout.Shape createLayoutShape(final DiagramElement shapeElement, Map<Object, Object> shapeMap, final org.osate.ge.internal.layout.Shape parentLayoutShape, final boolean fullLayout) {
		// Determine whether the shape may be moved 			
		// Don't change the position of shapes that have already been positioned if not repositioning all shapes
		final boolean locked;
		if(((shapeElement.hasSize() && shapeElement.hasPosition()) && !fullLayout) || shapeElement.isDecoration()) {
			locked = true;			
		} else {
			locked = false;
		}
		
		final boolean positionOnEdge = shapeElement.getDockArea() != null;
		
		// Create the layout shape
		final boolean canResize = ((AgeShape)shapeElement.getGraphic()).isResizeable();
		final org.osate.ge.internal.layout.Shape newLayoutShape = new org.osate.ge.internal.layout.Shape(parentLayoutShape, 
				shapeElement.getX(), 
				shapeElement.getY(), 
				shapeElement.getWidth(), 
				shapeElement.getHeight(), 
				canResize, 
				locked, 
				positionOnEdge);
		
		// Layout shapes without shrinking them
		newLayoutShape.setMinimumSize(Math.max(shapeElement.getWidth(), 50), Math.max(shapeElement.getHeight(), 50));
		
		shapeMap.put(newLayoutShape, shapeElement);
		shapeMap.put(shapeElement, newLayoutShape);

		// Create layout shape for the diagram shape's children
		for(final DiagramElement child : shapeElement.getDiagramElements()) {
			if(child.getGraphic() instanceof AgeShape) {
				createLayoutShape(child, shapeMap, newLayoutShape, fullLayout);
			}
		}

		return newLayoutShape;
	}
	
	private static boolean hasUnlockedShapes(final List<org.osate.ge.internal.layout.Shape> shapes) {
		for(final org.osate.ge.internal.layout.Shape shape : shapes) {
			if(shape.isUnlocked() || hasUnlockedShapes(shape.getChildren())) {
				return true;
			}
		}
		
		return false;
	}
	
	private static void updateShape(final DiagramModification mod, final org.osate.ge.internal.layout.Shape layoutShape, final Map<Object, Object> shapeMap) {
		final DiagramElement diagramElement = (DiagramElement)shapeMap.get(layoutShape);
		if(layoutShape.isUnlocked()) {
			mod.setPosition(diagramElement, new Point(layoutShape.getX(), layoutShape.getY()));
			if(layoutShape.isResizable()) {
				mod.setSize(diagramElement, new Dimension(layoutShape.getWidth(), layoutShape.getHeight()));
			}
		}
		
		for(final org.osate.ge.internal.layout.Shape childLayoutShape : layoutShape.getChildren()) {
			if(!childLayoutShape.positionOnEdge()) {
				updateShape(mod, childLayoutShape, shapeMap);
			}
		}
		
		// Move/resize the shape again. Resizing again ensures that the size isn't larger than needed.
		if(layoutShape.isUnlocked()) {
			mod.setPosition(diagramElement, new Point(layoutShape.getX(), layoutShape.getY()));
			if(layoutShape.isResizable()) {
				mod.setSize(diagramElement, new Dimension(layoutShape.getWidth(), layoutShape.getHeight()));
			}
		}
				
		// Reposition docked shapes after the container has layed out to ensure the shapes are docked to the appropriate edge
		for(final org.osate.ge.internal.layout.Shape childLayoutShape : layoutShape.getChildren()) {
			if(childLayoutShape.positionOnEdge()) {
				updateShape(mod, childLayoutShape, shapeMap);
			}
		}
	}	
}
