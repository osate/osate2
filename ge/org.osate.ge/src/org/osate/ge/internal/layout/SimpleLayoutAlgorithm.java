/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.layout;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple layout algorithm that lays all free non-edge shapes out in a grid.
 */
public class SimpleLayoutAlgorithm implements LayoutAlgorithm {
	private static int minChildY = 50;
	private static int minChildPadding = 20;
	private static int minXSpacing = 20;
	private static int minYSpacing = 20;

	@Override
	public void layout(final List<Shape> shapes, final List<Connection> connections) {
		layoutShapes(shapes, new ArrayList<>(), new ArrayList<>(), 0, 0, 0);
	}

	/**
	 * Returns the required size for the parent
	 * @param shapes
	 * @param freeEdgeShapes an empty list that can be used to store free edge shapes
	 * @param freeNonEdgeShapes an empty list that can be used to store free non-edge shapes
	 * @return
	 */
	private static double[] layoutShapes(final List<Shape> shapes, final ArrayList<Shape> freeEdgeShapes,
			final ArrayList<Shape> freeNonEdgeShapes, final double minWidth, final double minHeight,
			final double childStartY) {
		final double[] minSize = { minWidth, minHeight };
		final double[] maxLockedNonEdgeSize = { 0, 0 };

		// Layout Children
		for(final Shape shape : shapes) {
			final double[] shapeSize = layoutShapes(shape.getChildren(), freeEdgeShapes, freeNonEdgeShapes,
					shape.hasMinimumSize() ? shape.getMinimumWidth() : 0,
							shape.hasMinimumSize() ? shape.getMinimumHeight() : 0, minChildY);

			// Handle sizing. Handle resizable flag
			if(!shape.isLocked() && shape.isResizable()) {
				shape.setWidth(shapeSize[0]);
				shape.setHeight(shapeSize[1]);
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
		final int leftStopIndex = Math.min(Math.max(1, (freeEdgeShapes.size() + 1) / 2), freeEdgeShapes.size());
		double leftWidth = 0;
		double nextY = childStartY;

		for(int i = 0; i < leftStopIndex; i++) {
			final Shape shape = freeEdgeShapes.get(i);
			shape.setX(0);
			shape.setY(nextY);

			leftWidth = Math.max(leftWidth, shape.getWidth());
			minSize[0] = Math.max(minSize[0], shape.getWidth());
			minSize[1] = Math.max(minSize[1], nextY + shape.getHeight() + minChildPadding);

			nextY += shape.getHeight() + minYSpacing;
		}

		final double maxLeftHeight = nextY;
		double maxRightHeight = 0;
		for(int i = leftStopIndex; i < freeEdgeShapes.size(); i++) {
			final Shape shape = freeEdgeShapes.get(i);
			maxRightHeight += shape.getHeight() + minChildPadding;
		}

		double maxNonEdgeHeight = 0;
		double totalNonEdgeHeight = 0;
		for(int i = 0 ; i < freeNonEdgeShapes.size(); i++) {
			final Shape shape = freeNonEdgeShapes.get(i);
			final double paddedShapeHeight = shape.getHeight() + minChildPadding;
			maxNonEdgeHeight = Math.max(maxNonEdgeHeight, paddedShapeHeight);
			totalNonEdgeHeight += paddedShapeHeight;
		}
		final double avgNonEdgeHeight = freeNonEdgeShapes.size() == 0 ? 0
				: totalNonEdgeHeight / freeNonEdgeShapes.size();

		// Number of non edge shapes per dimension
		final double startNonEdgeX = Math.max(leftWidth, minChildPadding);
		final int targetNumberOfRows = (int)Math.ceil(Math.sqrt(freeNonEdgeShapes.size()));
		double nextX = startNonEdgeX;
		nextY = childStartY;

		double colWidth = 0;

		// Take into account labels
		final double minStartRight = nextX + maxLockedNonEdgeSize[0];
		final double targetHeight = Math.max(Math.max(maxLeftHeight, maxRightHeight),
				Math.max(avgNonEdgeHeight * targetNumberOfRows, maxNonEdgeHeight));

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
			nextY += shape.getHeight() + minYSpacing;
			colWidth = Math.max(colWidth, shape.getWidth());

			final boolean startNewRow;
			if(i == (freeNonEdgeShapes.size() - 1)) {
				startNewRow = true;
			} else {
				final Shape nextShape = freeNonEdgeShapes.get(i+1);
				startNewRow = (nextY + nextShape.getHeight()) > targetHeight;
			}

			if(startNewRow) {
				nextX += colWidth + minXSpacing;
				nextY = childStartY;
				colWidth = 0;
			}
		}

		// Right Edge Shapes
		nextX = Math.max(Math.max(nextX, minStartRight), minWidth/2);
		nextY = childStartY;
		for(int i = leftStopIndex; i < freeEdgeShapes.size(); i++) {
			final Shape shape = freeEdgeShapes.get(i);
			shape.setY(nextY);

			minSize[0] = Math.max(minSize[0], nextX + shape.getWidth());
			minSize[1] = Math.max(minSize[1], nextY + shape.getHeight() + minChildPadding);

			nextY += shape.getHeight() + minYSpacing;
		}

		// Set X value of right edge shapes. This ensures the shapes are docked to the right side of the container.
		for(int i = leftStopIndex; i < freeEdgeShapes.size(); i++) {
			final Shape shape = freeEdgeShapes.get(i);
			shape.setX(minSize[0]);
		}

		// Clear reused data structures
		freeEdgeShapes.clear();
		freeNonEdgeShapes.clear();

		return minSize;
	}

}
