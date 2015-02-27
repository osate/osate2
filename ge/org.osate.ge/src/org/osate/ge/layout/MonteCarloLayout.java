/*******************************************************************************
 * Copyright (C) 2015 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.osate.ge.layout;

import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.osate.ge.layout.Shape.PositionMode;

/**
 * An instance of this class is used to arrange shapes in an optimal manner. It arranges the shapes a number of times in a random layout. It produces a score for each layout based on
 * user defined weighting factors. The layout with the lowest score(most optimal) is used to adjust the the shapes.
 * @author philip.alldredge
 *
 */
public class MonteCarloLayout 
{
	private int shapePadding; // Additional padding used for shapes when determining if shapes are too close to one another.
	private int minimumSidePadding; // The minimum padding between a shape and a side to which the shape is not docked.
	private int snappedShapePadding = 30; // Spacing between snapped shapes. For left and right snapped shapes it is the vertical spacing.
	private double targetConnectionLength;
	private double shapeIntersectionsWeight = 1;
	private double connectionIntersectionsWeight = 1;
	private double shapeConnectionIntersectionsWeight = 1;
	private double targetConnectionLengthWeight = 1;
	private int[] diagramSize;
	
	public MonteCarloLayout(int shapePadding, int minimumSidePadding, double targetConnectionLength) 
	{
		this.shapePadding = shapePadding;
		this.minimumSidePadding = minimumSidePadding;
		this.targetConnectionLength = targetConnectionLength;
	}
	
	public MonteCarloLayout() {
		this(10, 80, 100);
	}
	
	public void setShapeIntersectionsWeight(double intersectionOfShapes)
	{
		this.shapeIntersectionsWeight = intersectionOfShapes;
	}
	
	public void setConnectionIntersectionsWeight(double intersectionOfConnections)
	{
		this.connectionIntersectionsWeight = intersectionOfConnections;
	}
	
	public void setShapeConnectionIntersectionsWeight(double value)
	{
		this.shapeConnectionIntersectionsWeight = value;
	}
	
	public void setTargetConnectionLengthWeight(double targetConnectionLengthFactor)
	{
		this.targetConnectionLengthWeight = targetConnectionLengthFactor;
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
		private final List<Shape> shapes;
		private final List<Connection> connections;
		private final Random seedGenerator = new Random();
		private double bestScore = Integer.MAX_VALUE;		
		private long bestSeed = 0;
		
		private LayoutOperation(final List<Shape> shapes, final List<Connection> connections) {
			this.shapes = shapes;
			this.connections = connections;
			
			adjustShapeSizes(shapes);
			determineDiagramArea(shapes);
		}
		
		public final void next() {
			final long seed = seedGenerator.nextLong();
			final double score = layout(shapes, connections, new Random(seed));
			
			// Store the seed if it beat the last best score
			if(score < bestScore) 
			{
				bestScore = score;
				bestSeed = seed;
			}
		}

		// Repositions the shapes based on the best layout as determined by the best score
		public void accept() {
			layout(shapes, connections, new Random(bestSeed));
		}
		
		public final long getBestSeed() {
			return bestSeed;
		}
		
		public final double getBestScore() {
			return bestScore;
		}
	}
	
	/**
	 * Layouts the shapes, returns the score. Lower is better
	 * @param rand
	 * @return
	 */
	private double layout(final List<Shape> shapes, final List<Connection> connections, final Random rand) 
	{	
		//Total score for calculated layout.
		double score = 0; 
		
		positionShapes(shapes, rand);
		final Map<Shape, Rectangle> shapeToRectangleMap = createShapeToRectangleMap(shapes);
		
		//The following factor functions are called and their individual scores are added to the overall score.
		score += calculateShapeIntersectionScore(shapes, shapeToRectangleMap, rand);
		score += calculateConnectionIntersectionScore(connections, shapeToRectangleMap);
		score += calculateShapeConnectionIntersectionsScore(shapes, connections, shapeToRectangleMap);
		score += calculateTargetConnectionLengthDifferenceScore(connections, shapeToRectangleMap);
		return score / 4.0;
	}
	
	// Builds a map from the shapes contained in the specified list and their children to Rectangle objects. The Rectangle objects use absolute coordinates and include shape padding.
	private Map<Shape, Rectangle> createShapeToRectangleMap(final List<Shape> shapes) {
		final Map<Shape, Rectangle> result = new HashMap<Shape, Rectangle>();
		createShapeToRectangleMap(shapes, result, 0, 0);
		return result;
	}
	
	private void createShapeToRectangleMap(final List<Shape> shapes, final Map<Shape, Rectangle> map, int offsetX, int offsetY) {
		for(final Shape s : shapes) {
			int absXNoPadding = offsetX + s.getX();
			int absYNoPadding = offsetY + s.getY();
			final Rectangle rect = new Rectangle(
					absXNoPadding - shapePadding, 
					absYNoPadding - shapePadding,
					s.getWidth() + 2 * shapePadding,
					s.getHeight() + 2 * shapePadding);
			map.put(s, rect);
			createShapeToRectangleMap(s.getChildren(), map, absXNoPadding, absYNoPadding);
		}
	}
	
	private void positionShapes(final List<Shape> shapes, final Random rand) {
		// Position shapes that are snapped to the left/right
		// Get all the snapped shapes
		final List<Shape> snappedShapes = new ArrayList<Shape>(shapes.size());
		for(final Shape shape : shapes) {
			if(shape.getPositionMode() == PositionMode.SNAP_LEFT_RIGHT) {
				snappedShapes.add(shape);
			}
		}
		
		// Shuffle Them
		Collections.shuffle(snappedShapes, rand);
		
		// Position Them
		int leftY = minimumSidePadding;
		int rightY = minimumSidePadding;
		for(int snappedShapeIndex = 0; snappedShapeIndex < snappedShapes.size(); snappedShapeIndex++) {
			final Shape shape = snappedShapes.get(snappedShapeIndex);
			
			// Randomly choose left or right..
			if((snappedShapeIndex % 2) == 0) {
				shape.setX(0);	
				shape.setY(leftY);
				leftY += shape.getHeight() + snappedShapePadding;
			} else {
				final Shape parent = shape.getParent();
				shape.setX(Math.max(0, parent.getWidth() - shape.getWidth()));
				shape.setY(rightY);
				rightY += shape.getHeight() + snappedShapePadding;
			}
		}
		
		// Assign X and Y for each Shape depending on PositionMode value 
		for(final Shape shape : shapes) {
			final Shape parent = shape.getParent();
			final int maxX;
			final int maxY;
			if(parent == null) {
				maxX = diagramSize[0];
				maxY = diagramSize[1];
			} else {
				maxX = Math.max(minimumSidePadding, parent.getWidth() - shape.getWidth());
				maxY = Math.max(minimumSidePadding, parent.getHeight() - shape.getHeight());
			}
			
			switch(shape.getPositionMode())
			{
			case SNAP_LEFT_RIGHT:
				/*
				// Randomly choose left or right..
				if(rand.nextBoolean()) {
					shape.setX(0);	
				} else {
					shape.setX(maxX);
				}

				shape.setY(nextInt(rand, minimumSidePadding, maxY - minimumSidePadding));
				*/
				break;
			case LOCKED:
				//Do Nothing
				break;
			case FREE:
				if(shapes.size() == 1) {
					shape.setX(minimumSidePadding);
					shape.setY(minimumSidePadding);
				} else {	
					shape.setX(nextInt(rand, minimumSidePadding, maxX - minimumSidePadding));
					shape.setY(nextInt(rand, minimumSidePadding, maxY - minimumSidePadding));
				}
				
				break;
			}
			
			positionShapes(shape.getChildren(), rand);
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
	
	//Determines the number of Shape intersections in diagram
	private double calculateShapeIntersectionScore(final List <Shape> shapes, final Map<Shape, Rectangle> shapeToRectangleMap, final Random rand)
	{
		// Determine the number of shape intersections and the maximum potential number of shape intersections
		final ShapeIntersectionStats shapeIntersections = getShapeIntersectionStats(shapes, shapeToRectangleMap);
		double normalizedValue = (shapeIntersections.numberOfIntersections/(double)shapeIntersections.maxNumberOfIntersections);

		// Multiply the normalized value by the user-set weight for Shape intersections.
		return normalizedValue * shapeIntersectionsWeight;
	}
	
	private static class ShapeIntersectionStats {
		public int numberOfIntersections = 0;
		public int maxNumberOfIntersections = 0;
	}

	private ShapeIntersectionStats getShapeIntersectionStats(final List<Shape> shapes, final Map<Shape, Rectangle> shapeToRectangleMap) {
		final ShapeIntersectionStats result = new ShapeIntersectionStats();
		getShapeIntersectionStats(shapes, shapeToRectangleMap, result);
		return result;
	}
	
	private void getShapeIntersectionStats(final List<Shape> shapes, final Map<Shape, Rectangle> shapeToRectangleMap, final ShapeIntersectionStats result) {
		/*
		* The following loop will run through the entire list of shapes to determine if they
		* are intersecting. It is built with a nested loop structure to prevent
		* repeated shapes to be compared. If there was a sample of 5 shapes, the loop's comparison
		* will resemble the following: 0->1, 0->2, 0->3, 0->4, 1->2, 1->3, 1->4, 2->3, 2->4, 3->4
		*/
		for(int i = 0; i < shapes.size(); i++) {
			final Shape shape = shapes.get(i);
			final Rectangle r1 = shapeToRectangleMap.get(shape);
			for(int j = i+1; j < shapes.size(); j++) {
				final Shape shape2 = shapes.get(j);
				if(shape.getPositionMode() != PositionMode.LOCKED || shape2.getPositionMode() != PositionMode.LOCKED) {
					final Rectangle r2 = shapeToRectangleMap.get(shape2);
					result.maxNumberOfIntersections++;
					if(r1.intersects(r2)) {
						result.numberOfIntersections++;
					}
				}
			}

			getShapeIntersectionStats(shape.getChildren(), shapeToRectangleMap, result);
		}
	}

	// Determine total number of Connection intersections in diagram 
	private double calculateConnectionIntersectionScore(final List<Connection> connections, final Map<Shape, Rectangle> shapeToRectangleMap)
	{
		if(connections.size() <= 1) {
			return 0;
		}		
		
		double totalConnectionIntersections = 0;

		/*
		* The following loop will run through the entire list of Connections to determine if they
		* are intersecting. It is built with a nested loop structure to prevent
		* repeated Connections to be compared. If there was a sample of 5 Connections, the loop's comparison
		* will resemble the following: 0->1, 0->2, 0->3, 0->4, 1->2, 1->3, 1->4, 2->3, 2->4, 3->4
		*/
		for(int i = 0; i < connections.size() - 1; i++)
		{
			// Determine the start and end points of the first connection
			final Connection c1 = connections.get(i);
			final Rectangle c1SrcRect = shapeToRectangleMap.get(c1.getSource());
			final Rectangle c1DstRect = shapeToRectangleMap.get(c1.getDestination());
			
			for(int j = i+1; j < connections.size(); j++)
			{
				// Determine the start and end points of the second connection
				final Connection c2 = connections.get(j);
				final Rectangle c2SrcRect = shapeToRectangleMap.get(c2.getSource());
				final Rectangle c2DstRect = shapeToRectangleMap.get(c2.getDestination());
				if(Line2D.linesIntersect(c1SrcRect.getCenterX(), c1SrcRect.getCenterY(), 
						c1DstRect.getCenterX(), c1DstRect.getCenterY(), 
						c2SrcRect.getCenterX(), c2SrcRect.getCenterY(), 
						c2DstRect.getCenterX(), c2DstRect.getCenterY())) {
					totalConnectionIntersections++;
				}
			}		
		}
		
		//Normalize the total number of Connection intersections found by dividing it by the total UNIQUE Connection intersections that could have occurred.
		final int maxNumberOfConnectionIntersections = getMaxNumberOfPairs(connections);
		final double normalizedValue = totalConnectionIntersections/(double)maxNumberOfConnectionIntersections;
		return normalizedValue * connectionIntersectionsWeight;
	}
	
	private void adjustShapeSizes(final List<Shape> shapes) {
		for(Shape shape : shapes) {
			adjustShapeSizes(shape.getChildren());
			
			if(shape.isResizable()) {
				final int[] minContainerSize = getMinimumContainerSize(shape);
				if(shape.getPositionMode() == PositionMode.LOCKED) {
					// This interferes with setting size of shape...
					shape.setWidth(Math.max(shape.getWidth(), minContainerSize[0]));
					shape.setHeight(Math.max(shape.getHeight(), minContainerSize[1]));
				} else {
					final int totalArea = shape.getChildren().size() == 0 ? 100 : getTotalArea(shape.getChildren());
					final int targetArea = totalArea * 6;
					final int squareSize = (int)Math.sqrt(targetArea);
					int width = (int)(squareSize * 1.5);
					int height = (int)(targetArea / width);

					// All shapes with children must have at least the space for padding
					if(shape.getChildren().size() > 0 ) {
						width = Math.max(width, minimumSidePadding*2);
						height = Math.max(height, minimumSidePadding*2);
					}
				
					shape.setWidth((int)Math.max(minContainerSize[0], width));
					shape.setHeight((int)Math.max(minContainerSize[1], height));
				}
			}
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
			
			if(shape.getPositionMode() == PositionMode.LOCKED) {
				newMinWidth = shape.getX() + shape.getWidth();
				newMinHeight = shape.getY() + shape.getHeight();
			} else if(shape.getPositionMode() == PositionMode.FREE) {
				newMinWidth = minimumSidePadding + shape.getWidth();
				newMinHeight = minimumSidePadding + shape.getHeight();
			} else {
				newMinWidth = shape.getWidth();
				newMinHeight = shape.getHeight();
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
	
	private double calculateShapeConnectionIntersectionsScore(final List<Shape> rootShapes, final List<Connection> connections, final Map<Shape, Rectangle> shapeToRectangleMap) {
		// Check for intersections
		int numberOfShapesChecked = 0;
		int numberOfIntersections = 0;

		for(final Connection connection : connections) {
			// Determine what shapes to check
			// Get the ancestry for the connection's endpoints.
			// Use it to determine which shapes to check and which shapes to exclude from the check
			// If the connection and source share a common ancestor, check that ancestor's siblings. Otherwise, check the root shapes			
			final CommonAncestry ancestry = determineCommonAncestry(connection.getSource(), connection.getDestination());
			final List<Shape> shapesToCheck;
			final Shape s1ToIgnore = ancestry.s1Ancestor;
			final Shape s2ToIgnore = ancestry.s2Ancestor;
			if(ancestry.commonAncestor== null) {
				shapesToCheck = rootShapes;
			} else {
				shapesToCheck = ancestry.commonAncestor.getChildren();
			}
			
			// Get absolute coordinates for the connection.
			final Rectangle srcRect = shapeToRectangleMap.get(connection.getSource());
			final Rectangle dstRect = shapeToRectangleMap.get(connection.getDestination());
			double srcX = srcRect.getCenterX();
			double srcY = srcRect.getCenterY();
			double dstX = dstRect.getCenterX();
			double dstY = dstRect.getCenterY();
			
			// Check for intersections. Keep track of the number of shapes checked and the number of intersections found
			for(final Shape shape : shapesToCheck) {
				if(shape != s1ToIgnore && shape != s2ToIgnore) {
					numberOfShapesChecked++;

					final Rectangle shapeRect = shapeToRectangleMap.get(shape);
					if(shapeRect.intersectsLine(srcX, srcY, dstX, dstY)) {
						numberOfIntersections++;
					}
				}
			}
		}

		if(numberOfShapesChecked == 0 || connections.size() == 0) {
			return 0.0;
		}
		
		final int maxNumberOfIntersections = getMaxNumberOfPairs(numberOfShapesChecked + connections.size());
		
		// Return result
		return shapeConnectionIntersectionsWeight * (numberOfIntersections/(double)maxNumberOfIntersections);
	}
	
	// Determines the average difference of all the Connections from the target Connection Length originally passed in
	// the constructor.
	private double calculateTargetConnectionLengthDifferenceScore(final List<Connection> connections, final Map<Shape, Rectangle> shapeToRectangleMap)
	{
		if(connections.size() == 0) {
			return 0;
		}
		
		//Initialization of variables used to calculate average difference of Connections.
		double totalLineDifference=0;
		double idealMaxLineDifference;
		double lineLength;
		double diagonalLengthOfDiagram;
		double averageDifference;
		double normalizedValue;
		
		//score will hold the normalized value * weight factor for the Connection Length difference.
		double score=0;
		
		//Determine the total Connection Length difference of all the Connections from the target Connection length.
		for(Connection connection: connections) {
			final Rectangle srcRect = shapeToRectangleMap.get(connection.getSource());
			final Rectangle dstRect = shapeToRectangleMap.get(connection.getDestination());
			lineLength = Math.sqrt(Math.pow((dstRect.getX() - srcRect.getX()), 2) + Math.pow((dstRect.getY() - srcRect.getY()), 2));
		    totalLineDifference += Math.abs(targetConnectionLength - lineLength);
		}
		
		//Calculate the average Connection Length difference.
		averageDifference = totalLineDifference/connections.size();
		//Determine the longest Connection Length possible for diagram(the diagonal of the diagram)
		diagonalLengthOfDiagram = Math.sqrt(Math.pow(diagramSize[0], 2) + Math.pow(diagramSize[1], 2));
		//Calculate the maximum Connection Length difference average using the diagonalLengthOfDiagram value.
		idealMaxLineDifference = diagonalLengthOfDiagram - targetConnectionLength;
		//Normalize the averageDifference calculated by dividing by idealMaxLineDifference.
		normalizedValue = averageDifference/idealMaxLineDifference;

		//Multiply the normalized value by the weight for the targetConnectionLength factor.
		score = normalizedValue * targetConnectionLengthWeight;
		//Return score to the calling function.
		return score;
	}
		

	private static class CommonAncestry {
		public final Shape commonAncestor;
		public final Shape s1Ancestor; // The ancestor of first shape that is a child of the common ancestor or the top level ancestor for the first shape.
		public final Shape s2Ancestor; // The ancestor of second shape that is a child of the common ancestor or the top level ancestor for the second shape.
		
		public CommonAncestry(final Shape commonAncestor, final Shape s1Ancestor, final Shape s2Ancestor) {
			this.commonAncestor = commonAncestor;
			this.s1Ancestor = s1Ancestor;
			this.s2Ancestor = s2Ancestor;
		}
	}
	
	/**
	 * Determine the common ancestry of two shapes. 
	 * @param s1
	 * @param s2
	 * @return an object containing information regarding the common ancestry of the shapes. See the CommonAncestry object for details. 
	 */
	private CommonAncestry determineCommonAncestry(final Shape s1, final Shape s2) {
		final Shape s1Parent = s1.getParent();
		if(s1Parent == null) {
			// Determine the "oldest" ancestor of s2;
			Shape s2OldestAncestor = s2;
			while(s2OldestAncestor.getParent() != null) {
				s2OldestAncestor = s2OldestAncestor.getParent();
			}
			return new CommonAncestry(null, s1, s2OldestAncestor);
		}
		
		Shape s2Ancestor = s2.getParent();
		while(s2Ancestor != null) {
			if(s2Ancestor == s1Parent) {
				return new CommonAncestry(s1Parent, s1, s2Ancestor);
			}
			
			s2Ancestor = s2Ancestor.getParent();
		}

		return determineCommonAncestry(s1Parent, s2);
	}
	
	// Returns the number of unique (order independent) pair combination possible for a given collection
	private <T> int getMaxNumberOfPairs(List<T> theCollection)
	{
		return getMaxNumberOfPairs(theCollection.size());
	}
	
	private int getMaxNumberOfPairs(int elementCount)
	{
		int potential=0;
		for(int collectionCounter = elementCount-1; collectionCounter > 0; collectionCounter--)
		{
			potential+= collectionCounter;
		}
		return potential;
	}
}
