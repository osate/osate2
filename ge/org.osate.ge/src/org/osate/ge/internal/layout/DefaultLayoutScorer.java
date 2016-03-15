package org.osate.ge.internal.layout;

import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultLayoutScorer implements LayoutScorer {	
	private static class ShapeIntersectionStats {
		public int numberOfIntersections = 0;
		public int maxNumberOfIntersections = 0;
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
	
	private double shapeIntersectionsWeight = 1;
	private double connectionIntersectionsWeight = 1;
	private double shapeConnectionIntersectionsWeight = 1;
	private double targetConnectionLengthWeight = 1;
	private final int shapePadding; // Additional padding used for shapes when determining if shapes are too close to one another.
	private final double targetConnectionLength;
	
	public DefaultLayoutScorer(int shapePadding, final double targetConnectionLength) {
		this.shapePadding = shapePadding;
		this.targetConnectionLength = targetConnectionLength;
	}
	
	public DefaultLayoutScorer() {
		this(10, 100);
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
	
	public double calculateScore(final List<Shape> shapes, final List<Connection> connections, final int[] diagramSize) {
		double score = 0; 
		
		final Map<Shape, Rectangle> shapeToRectangleMap = createShapeToRectangleMap(shapes);
		
		//The following factor functions are called and their individual scores are added to the overall score.
		score += calculateShapeIntersectionScore(shapes, shapeToRectangleMap);
		score += calculateConnectionIntersectionScore(connections, shapeToRectangleMap);
		score += calculateShapeConnectionIntersectionsScore(shapes, connections, shapeToRectangleMap);
		score += calculateTargetConnectionLengthDifferenceScore(connections, shapeToRectangleMap, diagramSize);
		return score / 4.0;
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
	private double calculateTargetConnectionLengthDifferenceScore(final List<Connection> connections, final Map<Shape, Rectangle> shapeToRectangleMap, final int[] diagramSize)
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
	
	//Determines the number of Shape intersections in diagram
	private double calculateShapeIntersectionScore(final List <Shape> shapes, final Map<Shape, Rectangle> shapeToRectangleMap)
	{
		// Determine the number of shape intersections and the maximum potential number of shape intersections
		final ShapeIntersectionStats shapeIntersections = getShapeIntersectionStats(shapes, shapeToRectangleMap);
		double normalizedValue = (shapeIntersections.numberOfIntersections/(double)shapeIntersections.maxNumberOfIntersections);

		// Multiply the normalized value by the user-set weight for Shape intersections.
		return normalizedValue * shapeIntersectionsWeight;
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
				if(shape.isUnlocked() || shape2.isUnlocked()) {
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
	private static <T> int getMaxNumberOfPairs(List<T> theCollection)
	{
		return getMaxNumberOfPairs(theCollection.size());
	}
	
	private static int getMaxNumberOfPairs(int elementCount)
	{
		int potential=0;
		for(int collectionCounter = elementCount-1; collectionCounter > 0; collectionCounter--)
		{
			potential+= collectionCounter;
		}
		return potential;
	}
}
