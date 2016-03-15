/*******************************************************************************
 * Copyright (C) 2015 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.osate.ge.internal.layout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * An instance of this class is used to arrange shapes in an optimal manner. It arranges the shapes a number of times in a random layout. It produces a score for each layout based on
 * user defined weighting factors. The layout with the lowest score(most optimal) is used to adjust the the shapes.
 *
 */
public class MonteCarloLayout 
{
	private final LayoutScorer scorer;
	private int minimumSidePadding; // The minimum padding between a shape and a side to which the shape is not docked.
	private int snappedShapePadding = 4; // Spacing between snapped shapes. For left and right snapped shapes it is the vertical spacing.
	private int[] diagramSize;	
	
	private static final Comparator<Shape> yComparator = new Comparator<Shape>() {
		@Override
		public int compare(final Shape s1, final Shape s2) {
			return Integer.compare(s1.getY(), s2.getY());
		}		
	};
	
	public MonteCarloLayout(final LayoutScorer scorer, int minimumSidePadding) 
	{
		this.scorer = scorer;
		this.minimumSidePadding = minimumSidePadding;
	}
	
	public MonteCarloLayout(final LayoutScorer scorer) {
		this(scorer, 80);
	}
	
	/**
	 * Returns a LayoutOperation instance that is used to control the layout process. The specified shapes are modified in-place during the layout process.
	 * @param shapes
	 * @param connections
	 * @return
	 */
	public LayoutOperation start(final List<Shape> shapes, final List<Connection> connections) {
		return new LayoutOperation(shapes, connections);
	}
	
	public class LayoutOperation {
		private final ShapeInfo rootShapeInfo;
		private final Map<Shape, ShapeInfo> shapeInfoMap = new HashMap<>();
		private final List<Connection> connections;
		private final Random seedGenerator = new Random();
		private double bestScore = Integer.MAX_VALUE;		
		private long bestSeed = 0;
		
		private LayoutOperation(final List<Shape> shapes, final List<Connection> connections) {
			this.rootShapeInfo = new ShapeInfo(shapes);
			this.connections = connections;
			
			adjustShapeSizes(rootShapeInfo);
			determineDiagramArea(shapes);
		}
		
		public final void next() {
			final long seed = seedGenerator.nextLong();
			final double score = layout(rootShapeInfo, connections, scorer, new Random(seed));
			
			// Store the seed if it beat the last best score
			if(score < bestScore) 
			{
				bestScore = score;
				bestSeed = seed;
			}
		}

		// Repositions the shapes based on the best layout as determined by the best score
		public void accept() {
			layout(rootShapeInfo, connections, scorer, new Random(bestSeed));
		}
		
		public final long getBestSeed() {
			return bestSeed;
		}
		
		public final double getBestScore() {
			return bestScore;
		}		
		
		/**
		 * Layouts the shapes, returns the score. Lower is better
		 * @param rand
		 * @return
		 */
		private double layout(final ShapeInfo rootShapeInfo, final List<Connection> connections, final LayoutScorer scorer, final Random rand) 
		{	
			positionChildren(rootShapeInfo, rand);
			return scorer.calculateScore(rootShapeInfo.allChildren, connections, diagramSize);
		}		
		
		private void positionChildren(final ShapeInfo shapeInfo, final Random rand) {
			final Shape parent = shapeInfo.parent;
			
			// Shuffle Them
			Collections.shuffle(shapeInfo.freeEdgeChildren, rand);
			
			// Position Them
			int leftY = getNextY(shapeInfo.lockedEdgeChildren, true, minimumSidePadding);
			int rightY = getNextY(shapeInfo.lockedEdgeChildren, false, minimumSidePadding);
			for(int snappedShapeIndex = 0; snappedShapeIndex < shapeInfo.freeEdgeChildren.size(); snappedShapeIndex++) {
				final Shape child = shapeInfo.freeEdgeChildren.get(snappedShapeIndex);
				
				// Randomly choose left or right..
				if((snappedShapeIndex % 2) == 0) {
					child.setX(0);	
					child.setY(leftY);
					leftY = getNextY(shapeInfo.lockedEdgeChildren, true, leftY + child.getHeight() + snappedShapePadding);
				} else {
					child.setX(Math.max(0, parent.getWidth() - child.getWidth()));
					child.setY(rightY);
					rightY = getNextY(shapeInfo.lockedEdgeChildren, false, rightY + child.getHeight() + snappedShapePadding);
				}
			}
			
			// Assign X and Y for each Shape depending on PositionMode value 
			for(final Shape child : shapeInfo.freeNonEdgeChildren) {
				final int maxX;
				final int maxY;
				if(parent == null) {
					maxX = diagramSize[0];
					maxY = diagramSize[1];
				} else {
					maxX = Math.max(minimumSidePadding, parent.getWidth() - child.getWidth());
					maxY = Math.max(minimumSidePadding, parent.getHeight() - child.getHeight());
				}
				
				if(shapeInfo.allChildren.size() == 1) {
					child.setX(minimumSidePadding);
					child.setY(minimumSidePadding);
				} else {	
					child.setX(nextInt(rand, minimumSidePadding, maxX - minimumSidePadding));
					child.setY(nextInt(rand, minimumSidePadding, maxY - minimumSidePadding));
				}
			}
				
			for(final Shape shape : shapeInfo.allChildren) {
				positionChildren(getShapeInfo(shape), rand);
			}
		}
		
		private void adjustShapeSizes(final ShapeInfo shapeInfo) {
			for(Shape child : shapeInfo.allChildren) {
				final ShapeInfo childShapeInfo = getShapeInfo(child);
				adjustShapeSizes(childShapeInfo);
				
				if(child.isResizable()) {
					final int[] minContainerSize = getMinimumContainerSize(child);
					if(child.isUnlocked()) {
						final int totalArea = child.getChildren().size() == 0 ? 100 : getTotalArea(child.getChildren());
						final int targetArea = totalArea * 6;
						final int squareSize = (int)Math.sqrt(targetArea);
						int width = (int)(squareSize * 1.5);
						int height = (int)(targetArea / width);

						// All shapes with children must have at least the space for padding
						if(childShapeInfo.hasEdgeChildren()) {
							width = Math.max(width, minimumSidePadding*2);
							height = Math.max(height, minimumSidePadding*2);
						}
					
						child.setWidth((int)Math.max(minContainerSize[0], width));
						child.setHeight((int)Math.max(minContainerSize[1], height));
					} else {
						// This interferes with setting size of shape...
						child.setWidth(Math.max(child.getWidth(), minContainerSize[0]));
						child.setHeight(Math.max(child.getHeight(), minContainerSize[1]));
					} 
				}
			}
		}
		
		private ShapeInfo getShapeInfo(final Shape shape) {
			ShapeInfo info = shapeInfoMap.get(shape);
			if(info != null) {
				return info;
			}
			
			info = new ShapeInfo(shape);
			shapeInfoMap.put(shape, info);
			return info;
		}		
	}
	
	private int getNextY(final List<Shape> lockedEdgeShapes, final boolean left, int minY) {
		for(final Shape lockedEdgeShape : lockedEdgeShapes) {
			if((left && lockedEdgeShape.getX() == 0) || (!left && lockedEdgeShape.getX() != 0)) {
				final int lockedEdgeShapeEndReservedY = lockedEdgeShape.getY() + lockedEdgeShape.getHeight() + snappedShapePadding;
				if(minY >= lockedEdgeShape.getY() && minY < lockedEdgeShapeEndReservedY) {
					minY = lockedEdgeShapeEndReservedY;
				}
			}
		}
		
		return minY;
	}
	
	/**
	 * Stores information about a shape that doesn't change between layouts
	 */
	private static class ShapeInfo {
		final Shape parent;
		final List<Shape> allChildren; // Refernece to the shapes children. Not a copy.
		final List<Shape> freeEdgeChildren;
		final List<Shape> lockedEdgeChildren;
		final List<Shape> freeNonEdgeChildren;
		
		private ShapeInfo(final Shape parent, final List<Shape> children) {
			this.parent = parent;
			this.allChildren = children;
			this.freeEdgeChildren = new ArrayList<Shape>(allChildren.size());
			this.lockedEdgeChildren = new ArrayList<Shape>(allChildren.size());
			this.freeNonEdgeChildren = new ArrayList<Shape>(allChildren.size());
			
			for(final Shape child : allChildren) {
				if(child.positionOnEdge()) {
					if(child.isUnlocked()) {
						freeEdgeChildren.add(child);
					} else {
						lockedEdgeChildren.add(child);
					}				
				} else {
					if(child.isUnlocked()) {
						freeNonEdgeChildren.add(child);
					}
				}
			}
			
			Collections.sort(lockedEdgeChildren, yComparator);
		}
		
		public ShapeInfo(final List<Shape> children) {
			this(null, children);
		}
		
		public ShapeInfo(final Shape shape) {
			this(shape, shape.getChildren());
		}
		
		public final boolean hasEdgeChildren() {
			return freeEdgeChildren.size() + lockedEdgeChildren.size() > 0;
		}
	}
	
	private int nextInt(final Random rand, final int min, final int max) {
		final int range = max - min;
		if(range <= 0) {
			return min;
		} else {
			return min + rand.nextInt(range+1);
		}
	}	
	
	private int[] getMinimumContainerSize(final Shape container) {
		final int[] result = getMinimumContainerSize(container.getChildren());
		
		if(container.hasMinimumSize()) {
			result[0] = Math.max(result[0], container.getMinimumWidth());
			result[1] = Math.max(result[1], container.getMinimumHeight());
		}
		
		return result;
	}
	
	private int[] getMinimumContainerSize(final List<Shape> shapes) {
		int minContainerWidth = 1;
		int minContainerHeight = 1;
		for(final Shape shape : shapes) {
			// Determine the minimum container size needed for the shape
			final int newMinWidth;
			final int newMinHeight;
			
			if(shape.positionOnEdge()) {
				newMinWidth = shape.getWidth();
				newMinHeight = shape.getHeight();
			} else {
				if(shape.isUnlocked()) {
					newMinWidth = minimumSidePadding + shape.getWidth();
					newMinHeight = minimumSidePadding + shape.getHeight();
				} else {				
					newMinWidth = shape.getX() + shape.getWidth();
					newMinHeight = shape.getY() + shape.getHeight();
				}	
			}
			
			// Find the max with the previous value
			minContainerWidth = Math.max(minContainerWidth, newMinWidth);
			minContainerHeight = Math.max(minContainerHeight, newMinHeight);
		}

		return new int[] { minContainerWidth, minContainerHeight };
	}
	
	private int getTotalArea(final List<Shape> shapes) {
		int area = 0;
		for(final Shape shape : shapes) {
			area += shape.getWidth() * shape.getHeight();
		}

		return area;
	}
	
	// Determine most efficient width and height parameters for total diagram.
	private void determineDiagramArea(final List <Shape> shapes)
	{
		final int[] minDiagramSize = getMinimumContainerSize(shapes);
		final int totalArea = getTotalArea(shapes);
		final int targetArea = totalArea * 8;
		final int size = (int)Math.sqrt(targetArea);
		diagramSize = new int[] { Math.max(minDiagramSize[0], size), Math.max(minDiagramSize[1], size)};		
	}		
}
