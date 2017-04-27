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
package org.osate.ge.internal.features;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IResizeConfiguration;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.context.impl.LayoutContext;
import org.eclipse.graphiti.features.context.impl.MoveShapeContext;
import org.eclipse.graphiti.features.context.impl.ResizeShapeContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.Feature;
import org.osate.aadl2.InternalFeature;
import org.osate.aadl2.ProcessorFeature;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.ge.internal.AgeResizeConfiguration;
import org.osate.ge.internal.layout.LayoutAlgorithm;
import org.osate.ge.internal.layout.SimpleLayoutAlgorithm;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.ShapeService;

/**
 * Lays out the pictogram elements included in a diagram using an algorithm.
 * To specify a minimum size for a shape, the resize feature or pattern for the shape must return a resize configuration that implements AgeResizeConfiguration.
 *
 */
public class LayoutDiagramFeature extends AbstractCustomFeature {
	private static String relayoutShapesPropertyKey = "relayout";
	// Settings that determine how many different layouts to test. See usage for more details.
	private final BusinessObjectResolutionService bor;
	private final ShapeService shapeService;
	private final PropertyService propertyService;
	
	@Inject
	public LayoutDiagramFeature(final IFeatureProvider fp, final ShapeService shapeService, final PropertyService propertyService, final BusinessObjectResolutionService bor) {
		super(fp);
		this.shapeService = shapeService;
		this.propertyService = propertyService;
		this.bor = bor;
	}

	@Override
	public String getDescription() {
		return "Layout diagram automatically";
	}

	@Override
	public String getName() {
		return "Layout Diagram";
	}
	
	@Override
	public boolean isAvailable(final IContext context) {
		final ICustomContext customCtx = (ICustomContext)context;
		// Only make the feature available if the user is right clicking on the outer diagram.
		return customCtx.getPictogramElements().length == 1 && customCtx.getPictogramElements()[0] instanceof Diagram;
	}
	
	@Override
	public boolean canExecute(final ICustomContext context) {
		return true;
	}

	@Override
	public boolean canUndo(IContext context) {
		return false;
	}

	// Helper method to create a context for executing the feature
	public static ICustomContext createContext(final boolean relayoutShapes) {
		final ICustomContext context = new CustomContext();
		context.putProperty(relayoutShapesPropertyKey, relayoutShapes);
		return context;
	}
		
	@Override
	public void execute(final ICustomContext context) {
		boolean relayoutShapes = !Boolean.FALSE.equals(context.getProperty(relayoutShapesPropertyKey)); // Defaults to true
		layout(getDiagram(), relayoutShapes);
	}
	
	private boolean layout(final Diagram diagram, final boolean relayoutShapes) {
		// Convert the diagram shapes to shapes used by the layout algorithm
		final List<org.osate.ge.internal.layout.Shape> rootLayoutShapes = new ArrayList<org.osate.ge.internal.layout.Shape>();
		final Map<Object, Object> shapeMap = new HashMap<Object, Object>(); // Map that contains a mapping from layout/diagram shapes to the other one.
		for(final Shape shape : shapeService.getNonGhostChildren(diagram)) {
			final org.osate.ge.internal.layout.Shape newLayoutShape = createLayoutShape(shape, shapeMap, null, relayoutShapes);
			if(newLayoutShape != null) {
				rootLayoutShapes.add(newLayoutShape);
			}
		}
				
		// Don't perform any automatic layout if there is not more than 1 child shape
		if(!hasUnlockedShapes(rootLayoutShapes)) {
			return false;
		}	

		// Create layout connections
		final List<org.osate.ge.internal.layout.Connection> layoutConnections = new ArrayList<org.osate.ge.internal.layout.Connection>();		
		for(final Connection connection : getDiagram().getConnections()) {
			// Prevents connections such as binding connections that aren't handled properly from being used during the layout process
			if(bor.getBusinessObjectForPictogramElement(connection) != null) {
				final org.osate.ge.internal.layout.Shape startLayoutShape = getLayoutShape(connection.getStart(), shapeMap);
				final org.osate.ge.internal.layout.Shape endLayoutShape = getLayoutShape(connection.getEnd(), shapeMap);
				if(startLayoutShape != null && endLayoutShape != null && startLayoutShape != endLayoutShape) {
					layoutConnections.add(new org.osate.ge.internal.layout.Connection(startLayoutShape, endLayoutShape));
					
					// Remove all bendpoints because the layout algorithm assumes that all connections are straight lines
					// Even though it may produce a less than optimal layout, only do this if all shapes are being relayed out. 
					if(relayoutShapes && connection instanceof FreeFormConnection) {
						final FreeFormConnection ffc = (FreeFormConnection)connection;
						ffc.getBendpoints().clear();
					}
				}
			}			
		}
	
		//final LayoutAlgorithm layoutAlg = new MonteCarloLayoutAlgorithm();
		final LayoutAlgorithm layoutAlg = new SimpleLayoutAlgorithm();
		layoutAlg.layout(rootLayoutShapes, layoutConnections);

		// Update the diagram's shapes
		for(final org.osate.ge.internal.layout.Shape layoutShape : rootLayoutShapes) {
			updateShape(layoutShape, shapeMap);
		}
		
		return true;
	}
	
	private org.osate.ge.internal.layout.Shape createLayoutShape(final Shape diagramShape, Map<Object, Object> shapeMap, final org.osate.ge.internal.layout.Shape parentLayoutShape, final boolean relayoutShapes) {
		// Restrict what shapes are positioned
		final Object bo = bor.getBusinessObjectForPictogramElement(diagramShape);

		// Determine whether the shape may be moved 			
		// Don't change the position of shapes that have already been positioned if not repositioning all shapes
		final boolean locked;
		if(bo == null || propertyService.isManuallyPositioned(diagramShape) || (propertyService.isLayedOut(diagramShape) && !relayoutShapes)) {
			locked = true;
		} else {
			locked = false;
		}
		
		final boolean positionOnEdge = bo instanceof Feature || bo instanceof InternalFeature || bo instanceof ProcessorFeature || bo instanceof FeatureInstance;
		
		// Create the layout shape
		final GraphicsAlgorithm ga = diagramShape.getGraphicsAlgorithm();
		final IResizeShapeContext resizeContext = createNoOpResizeShapeContext(diagramShape);
		final IResizeShapeFeature resizeFeature = getFeatureProvider().getResizeShapeFeature(resizeContext);
		final boolean canResize = resizeFeature != null && resizeFeature.canResizeShape(resizeContext);
		final org.osate.ge.internal.layout.Shape newLayoutShape = new org.osate.ge.internal.layout.Shape(parentLayoutShape, ga.getX(), ga.getY(), ga.getWidth(), ga.getHeight(), canResize, locked, positionOnEdge);
		final IResizeConfiguration resizeConfiguration = resizeFeature == null ? null : resizeFeature.getResizeConfiguration(resizeContext);
		if(resizeConfiguration instanceof AgeResizeConfiguration) {
			final AgeResizeConfiguration ageConf = (AgeResizeConfiguration)resizeConfiguration;
			if(ageConf.hasMinimumSize()) {
				newLayoutShape.setMinimumSize(ageConf.getMinimumWidth(), ageConf.getMinimumHeight());
			}
		} else {
			newLayoutShape.setMinimumSize(50, 50);
		}

		shapeMap.put(newLayoutShape, diagramShape);
		shapeMap.put(diagramShape, newLayoutShape);

		// Don't layout shapes that are inside locked shapes
		// If bo is not null and it isn't manually positioned, then create layout shapes of its children
		if(bo != null && !propertyService.isManuallyPositioned(diagramShape)) {
			// Create layout shape for the diagram shape's children
			if(diagramShape instanceof ContainerShape) {
				final List<Shape> children = shapeService.getNonGhostChildren((ContainerShape)diagramShape);
				for(final Shape child : children) {
					createLayoutShape(child, shapeMap, newLayoutShape, relayoutShapes);
				}		
			}
		}

		return newLayoutShape;
	}
	
	private boolean hasUnlockedShapes(final List<org.osate.ge.internal.layout.Shape> shapes) {
		for(final org.osate.ge.internal.layout.Shape shape : shapes) {
			if(shape.isUnlocked() || hasUnlockedShapes(shape.getChildren())) {
				return true;
			}
		}
		
		return false;
	}
	
	/** 
	 * Creates a resize shape context that uses the shapes existing location and size. Useful for determining if resizing is supported.
	 * @param shape
	 * @return
	 */
	private IResizeShapeContext createNoOpResizeShapeContext(final Shape shape) {
		final GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();
		if(ga == null) {
			return null;
		}
		
		final ResizeShapeContext context = new ResizeShapeContext(shape);
		context.setSize(ga.getWidth(), ga.getHeight());
		context.setLocation(ga.getX(), ga.getY());
		
		return context;
	}
	
	private void updateShape(final org.osate.ge.internal.layout.Shape layoutShape, final Map<Object, Object> shapeMap) {
		final Shape diagramShape = (Shape)shapeMap.get(layoutShape);
		ResizeShapeContext resizeShapeContext = null;
		boolean canResize =  false;
		IResizeShapeFeature resizeFeature = null;
		if(layoutShape.isUnlocked()) {
			resizeShapeContext = new ResizeShapeContext(diagramShape);
			resizeShapeContext.setSize(layoutShape.getWidth(), layoutShape.getHeight());
			resizeShapeContext.setLocation(layoutShape.getX(), layoutShape.getY());
			
			// Try to resize the shape
			resizeFeature = getFeatureProvider().getResizeShapeFeature(resizeShapeContext);
			canResize = resizeFeature != null && resizeFeature.canResizeShape(resizeShapeContext);
			if(canResize) {
				resizeFeature.resizeShape(resizeShapeContext);
			}
			
			propertyService.setIsLayedOut(diagramShape, true);
		}
		
		for(final org.osate.ge.internal.layout.Shape childLayoutShape : layoutShape.getChildren()) {
			if(!childLayoutShape.positionOnEdge()) {
				updateShape(childLayoutShape, shapeMap);
			}
		}
		
		// Move/resize the shape. Resizing again ensures that the size isn't larger than needed.
		if(resizeShapeContext != null) {
			// Try to resize the shape
			if(canResize) {
				resizeFeature.resizeShape(resizeShapeContext);
			} else {
				// Try simply moving the shape
				move(diagramShape, layoutShape.getX(), layoutShape.getY());
			}
		}
				
		// Reposition docked shapes after the container has layed out to ensure the shapes are docked to the appropriate edge
		for(final org.osate.ge.internal.layout.Shape childLayoutShape : layoutShape.getChildren()) {
			if(childLayoutShape.positionOnEdge()) {
				updateShape(childLayoutShape, shapeMap);
			}
		}
		
		// Check bounds of children to be safe
		if(diagramShape instanceof ContainerShape) {
			checkBoundsOfChildren((ContainerShape)diagramShape);
		}
	}
	
	
	private void checkBoundsOfChildren(final ContainerShape shape) {
		if(shape instanceof Diagram) {
			return;
		}
		
		boolean layoutShape = false;
		
		// Check if the shape is entirely in the container
		final GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();
		for(final Shape child : shape.getChildren()) {
			final GraphicsAlgorithm childGa = child.getGraphicsAlgorithm();
			final int endX = childGa.getX() + childGa.getWidth();
			final int endY = childGa.getY() + childGa.getHeight();
			if(childGa.getX() < 0 || childGa.getY() < 0 || endX > ga.getWidth()|| endY > ga.getHeight()) {
				layoutShape = true;
			}	
		}

		if(layoutShape) {
			final LayoutContext context = new LayoutContext(shape);
			final ILayoutFeature feature = getFeatureProvider().getLayoutFeature(context);
			if(feature != null && feature.canLayout(context)) {
				feature.layout(context);
			}
		}
	}
	
	private void move(final Shape shape, final int x, final int y) {
		final MoveShapeContext context = new MoveShapeContext(shape);
		context.setLocation(x, y);
		context.setSourceContainer(shape.getContainer());
		context.setTargetContainer(shape.getContainer());
		
		// Move the shape
		final IMoveShapeFeature feature = getFeatureProvider().getMoveShapeFeature(context);
		if(feature != null && feature.canMoveShape(context)) {
			feature.moveShape(context);
		}
	}
	
	/**
	 * Gets the layout shape that is the closest match to the specified anchor
	 * @param anchor
	 * @param shapeToNodeMap
	 * @return
	 */
	private static org.osate.ge.internal.layout.Shape getLayoutShape(final Anchor anchor, final Map<Object, Object> shapeMap) {
		if(anchor != null && anchor.getParent() instanceof Shape) {
			Shape diagramShape = (Shape)anchor.getParent();
			while(diagramShape != null) {
				final org.osate.ge.internal.layout.Shape layoutShape = (org.osate.ge.internal.layout.Shape)shapeMap.get(diagramShape);
				if(layoutShape != null) {
					return layoutShape;
				}

				diagramShape = diagramShape.getContainer();
			}
		}
		return null;	
				
	}
	
}
