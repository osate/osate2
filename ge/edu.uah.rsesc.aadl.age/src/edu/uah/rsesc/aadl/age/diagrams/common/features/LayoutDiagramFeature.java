/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package edu.uah.rsesc.aadl.age.diagrams.common.features;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.zest.layouts.InvalidLayoutConfiguration;
import org.eclipse.zest.layouts.LayoutAlgorithm;
import org.eclipse.zest.layouts.LayoutEntity;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.CompositeLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.DirectedGraphLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.HorizontalShift;
import org.eclipse.zest.layouts.exampleStructures.SimpleNode;
import org.eclipse.zest.layouts.exampleStructures.SimpleRelationship;
import org.osate.aadl2.Feature;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.services.LayoutService;
import edu.uah.rsesc.aadl.age.services.PropertyService;
import edu.uah.rsesc.aadl.age.services.VisibilityService;

public class LayoutDiagramFeature extends AbstractCustomFeature {
	private static String RELAYOUT_SHAPES_PROPERTY_KEY = "relayout";
	private final VisibilityService visibilityHelper;
	private final LayoutService resizeHelper;
	private final PropertyService propertyUtil;
	
	@Inject
	public LayoutDiagramFeature(final IFeatureProvider fp, final VisibilityService visibilityHelper, final LayoutService resizeHelper, final PropertyService propertyUtil) {
		super(fp);
		this.visibilityHelper = visibilityHelper;
		this.resizeHelper = resizeHelper;
		this.propertyUtil = propertyUtil;
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
		//Checks if inner Graphics algorithm is null if yes the right clicked area was the empty space.
		if(customCtx.getInnerGraphicsAlgorithm() != null) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean canExecute(ICustomContext context) {
		return true;
	}

	@Override
	public boolean canUndo(IContext context) {
		return false;
	}

	// Helper method to create a context for executing the feature
	public static ICustomContext createContext(final boolean relayoutShapes) {
		final ICustomContext context = new CustomContext();
		context.putProperty(RELAYOUT_SHAPES_PROPERTY_KEY, relayoutShapes);
		return context;
	}

		
	@Override
	public void execute(final ICustomContext context) {
		try {
			boolean relayoutShapes = !Boolean.FALSE.equals(context.getProperty(RELAYOUT_SHAPES_PROPERTY_KEY)); // Defaults to true
			
			final ContainerShape shape = getDiagram();			
			
			// TODO: Horizontal shift sometimes doesn't work. Can result in overlapping shapes... Implement alternative
			// Also, the positioning is off.. Only spacing horizontally... sometimes excessively..
			// Exacerbated by many of the shapes being unmoveable?
			
			// Create the layout algorithm
			final int layoutStyles = LayoutStyles.NO_LAYOUT_NODE_RESIZING;
			final LayoutAlgorithm alg = new CompositeLayoutAlgorithm( new LayoutAlgorithm[] {
					new DirectedGraphLayoutAlgorithm(layoutStyles),
					new HorizontalShift(layoutStyles)
			});

			layout(shape, alg, relayoutShapes);			
		} catch (final InvalidLayoutConfiguration e) {
			throw new RuntimeException(e);
		}
	}
	
	private void layout(final ContainerShape shape, final LayoutAlgorithm alg, final boolean relayoutShapes) throws InvalidLayoutConfiguration {
		final List<Shape> children = visibilityHelper.getNonGhostChildren(shape);

		// Layout the inside of the child shapes
		for(final Shape child : children) {
			if(child instanceof ContainerShape) {
				layout((ContainerShape)child, alg, relayoutShapes);
			}
		}		
		
		// Don't perform any automatic layout if there is not more than 1 child shape
		if(children.size() <= 1) {
			return;
		}

		final Map<Shape, SimpleNode> shapeToNodeMap = new HashMap<Shape, SimpleNode>();

		boolean performLayout = false; // Flag used to short-circuit execution when all child objects are not going to be touched by layout algorithm
		for(int i = 0; i < children.size(); i++) {
			final Shape child = children.get(i);
			final SimpleNode node = createLayoutEntity(child);
			if(shouldIgnoreShape(child, relayoutShapes)) {
				node.ignoreInLayout(true);
			} else {
				performLayout = true;
			}
			
			shapeToNodeMap.put(child, node);
		}						
		
		if(!performLayout) {
			return;
		}
		
		// Create relationships between every node and it's container
		final List<SimpleRelationship> relationships = new ArrayList<SimpleRelationship>();
		for(final Connection connection : getDiagram().getConnections()) {				
			final LayoutEntity startNode = getLayoutEntity(connection.getStart(), shapeToNodeMap);
			final LayoutEntity endNode = getLayoutEntity(connection.getEnd(), shapeToNodeMap);
			if(startNode != null && endNode != null && startNode != endNode) {
				relationships.add(new SimpleRelationship(startNode, endNode, true));
			}			
		}
		
		final GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();
		final int width = ga.getWidth();
		final int height = ga.getHeight();
		
		alg.applyLayout(shapeToNodeMap.values().toArray(new SimpleNode[0]), relationships.toArray(new SimpleRelationship[0]), 0, 0, width, height, false, false);			

		// Update the shapes
		for(final SimpleNode entity : shapeToNodeMap.values()) {
			updateShape(entity);
		}
		
		// Use the resize helper to resize the shape
		if(!(shape instanceof Diagram)) {
			resizeHelper.checkSize(shape);
		}
	}
	
	private boolean shouldIgnoreShape(final Shape shape, final boolean relayoutShapes) {
		final Object bo = AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(shape));
		return bo == null || bo instanceof Feature || (propertyUtil.isLayedOut(shape) && !relayoutShapes);
	}
	/**
	 * Gets the layout entity that is the closest match to the specified anchor
	 * @param anchor
	 * @param shapeToNodeMap
	 * @return
	 */
	private static LayoutEntity getLayoutEntity(final Anchor anchor, final Map<Shape, SimpleNode> shapeToNodeMap) {
		if(anchor != null && anchor.getParent() instanceof Shape) {
			Shape shape = (Shape)anchor.getParent();
			while(shape != null) {
				final LayoutEntity entity = shapeToNodeMap.get(shape);
				if(entity != null) {
					return entity;
				}

				shape = shape.getContainer();
			}
		}
		return null;	
				
	}

	private static SimpleNode createLayoutEntity(final Shape shape) {
		final GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();
		return new SimpleNode(shape, ga.getX(), ga.getY(), ga.getWidth()+50, ga.getHeight()+50);		
	}

	/**
	 * Updates the shapes position
	 * @param entity
	 */
	private void updateShape(final SimpleNode entity) {
		final Shape shape = (Shape)entity.getRealObject();
		final GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();
		if(!entity.hasPreferredLocation()) {
			//System.out.println("SETTING LOCATION");
			//System.out.println(((int)entity.getXInLayout()) + "," + ((int)entity.getYInLayout()) + " - " + ((int)entity.getWidthInLayout()) + "," + ((int)entity.getHeightInLayout()));
			ga.setX((int)entity.getXInLayout());
			ga.setY((int)entity.getYInLayout());
			propertyUtil.setIsLayedOut(shape, true);
		}
	}
}
