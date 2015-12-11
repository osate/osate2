package org.osate.ge.layout;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple layout algorithm that lays all free non-edge shapes out in a grid.
 */
public class SimpleLayoutAlgorithm implements LayoutAlgorithm {
	private static int minChildPadding = 20;
	private static int minXSpacing = 20;
	private static int minYSpacing = 20;
	
	@Override
	public void layout(final List<Shape> shapes, final List<Connection> connections) {
		layoutShapes(shapes, new ArrayList<>(), new ArrayList<>());
	}
	
	/**
	 * Returns the required size for the parent
	 * @param shapes
	 * @param freeEdgeShapes an empty list that can be used to store free edge shapes
	 * @param freeNonEdgeShapes an empty list that can be used to store free non-edge shapes
	 * @return
	 */
	private static int[] layoutShapes(final List<Shape> shapes, final ArrayList<Shape> freeEdgeShapes, final ArrayList<Shape> freeNonEdgeShapes) {
		// TOOD: In real testing, shapes are being placed on top of each other
		final int[] minSize = { 0, 0 };
		final int[] maxLockedNonEdgeSize = { 0, 0 };

		// Layout Children
		for(final Shape shape : shapes) {
			if(!shape.isLocked()) {
				final int[] shapeSize = layoutShapes(shape.getChildren(), freeEdgeShapes, freeNonEdgeShapes);
				
				// Handle sizing. Handle resizable flag
				if(shape.isResizable()) {
					if(shape.hasMinimumSize()) {
						shapeSize[0] = Math.max(shapeSize[0], shape.getMinimumWidth());
						shapeSize[1] = Math.max(shapeSize[1], shape.getMinimumHeight());
					}
					
					shape.setWidth(shapeSize[0]);
					shape.setHeight(shapeSize[1]);
				}
			}		
		}

		// Ensure lists have sufficient capacity to avoid unnecessary resizing
		freeEdgeShapes.ensureCapacity(shapes.size());
		freeNonEdgeShapes.ensureCapacity(shapes.size());
		
		for(final Shape child : shapes) {
			if(child.positionOnEdge()) {
				if(child.isUnlocked()) {
					freeEdgeShapes.add(child);
				}			
			} else {
				if(child.isUnlocked()) {
					freeNonEdgeShapes.add(child);
				} else {
					maxLockedNonEdgeSize[0] = Math.max(minSize[0], child.getWidth());
					maxLockedNonEdgeSize[1] = Math.max(minSize[1], child.getHeight());
				}
			}	
			
			// Assume any locked shapes are sized appropriately and use them as the initial minimum size
			if(child.isLocked()) {
				minSize[0] = Math.max(minSize[0], child.getWidth());
				minSize[1] = Math.max(minSize[1], child.getHeight());
			}
		}

		// Position Left Edge Shapes and determine the max width of left edge shapes
		final int leftStopIndex = Math.min(Math.max(1, freeEdgeShapes.size() / 2), freeEdgeShapes.size());
		int leftWidth = 0;
		int nextY = minChildPadding;
		for(int i = 0; i < leftStopIndex; i++) {
			final Shape shape = freeEdgeShapes.get(i);
			shape.setX(0);
			shape.setY(nextY);
			
			leftWidth = Math.max(leftWidth, shape.getWidth());			
			minSize[0] = Math.max(minSize[0], shape.getWidth());
			minSize[1] = Math.max(minSize[1], nextY +  + shape.getHeight() + minChildPadding);
			
			nextY += shape.getHeight() + minYSpacing;
		}
		
		// Number of non edge shapes per dimension
		final int startNonEdgeX = Math.max(leftWidth, minChildPadding);
		final int numberOfRows = (int)Math.ceil(Math.sqrt(freeNonEdgeShapes.size()));
		final int numberOfCols = (int)Math.ceil(((double)freeNonEdgeShapes.size()) / numberOfRows);
		int rowIndex = 0;
		int nextX = startNonEdgeX;
		nextY = minChildPadding;
		
		int colWidth = 0;
		
		// Determine row heights
		final int[] rowHeights = new int[numberOfRows];
		for(int r = 0; r < numberOfRows; r++) {
			int rowHeight = 0;
			for(int c = r; c < freeNonEdgeShapes.size(); c += numberOfCols) {
				rowHeight = Math.max(rowHeight, freeNonEdgeShapes.get(c).getHeight());	
			}
			rowHeights[r] = rowHeight;
		}		
		
		// Take into account labels
		final int minStartRight = nextX + maxLockedNonEdgeSize[0];
		
		// Position Non-edge Shapes into a Grid
		for(int i = 0 ; i < freeNonEdgeShapes.size(); i++) {
			final Shape shape = freeNonEdgeShapes.get(i);
			
			// Position shape
			shape.setX(nextX);
			shape.setY(nextY);

			// Adjust the minimum size that is returned
			minSize[0] = Math.max(minSize[0], nextX + shape.getWidth() + minChildPadding);
			minSize[1] = Math.max(minSize[1], nextY + shape.getHeight() + minChildPadding);
			
			// Determine next x and y
			nextY += rowHeights[rowIndex] + minYSpacing;
			colWidth = Math.max(colWidth, shape.getWidth());
			
			rowIndex++;
			
			// Update the X and Y values for the new column.
			if(rowIndex == numberOfRows || i == (freeNonEdgeShapes.size() - 1)) {
				rowIndex = 0;
				nextX += colWidth + minXSpacing;
				nextY = minChildPadding;
			}
		}
		
		// Right Edge Shapes
		nextX = Math.max(nextX, minStartRight);
		nextY = minChildPadding;
		for(int i = leftStopIndex; i < freeEdgeShapes.size(); i++) {
			final Shape shape = freeEdgeShapes.get(i);
			shape.setX(nextX);
			shape.setY(nextY);
			minSize[0] = Math.max(minSize[0], nextX + shape.getWidth());
			minSize[1] = Math.max(minSize[1], nextY + shape.getHeight() + minChildPadding);
			
			nextY += shape.getHeight() + minYSpacing;
		}

		// Clear reused data structures
		freeEdgeShapes.clear();
		freeNonEdgeShapes.clear();
		
		return minSize;
	}
	
}
