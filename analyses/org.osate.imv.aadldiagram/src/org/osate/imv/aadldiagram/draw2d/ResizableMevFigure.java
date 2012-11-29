/************************************************************************************
 * Copyright (c) 2012 Brandon Breuil. Contributions by Peter Feiler.                                               *
 *                                                                                  *
 * All rights reserved. This program and the accompanying materials are made        *
 * available under the terms of the Eclipse Public License v1.0 which accompanies   *
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html *
 *                                                                                  *
 * Use is subject to the terms of Eclipse Public License v1.0.                      *
 *                                                                                  *
 ************************************************************************************/

package org.osate.imv.aadldiagram.draw2d;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.UpdateManager;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

public class ResizableMevFigure extends SelectableMevFigure {

	public static final int SELECTION_HANDLE_WIDTH = 6; // Must be an even number of pixels.

	/* Resize handle indexes. */
	protected static final int TOP_LEFT_HANDLE = 0;
	protected static final int TOP_RIGHT_HANDLE = 1;
	protected static final int BOTTOM_RIGHT_HANDLE = 2;
	protected static final int BOTTOM_LEFT_HANDLE = 3;

	public static enum ResizeType {NW, NE, SW, SE};

	/**
	 * The location of the initial mouse press.
	 */
	private Point location;

	/**
	 * Indicates that a resizing operation is in progress.
	 */
	private boolean resizeInProgress;

	protected Rectangle[] resizeHandles;

	private ResizeType resizeType;

	private IResizableFigureDelegate delegate;

	/**
	 *
	 * @param modelElement
	 * @param viewer
	 * @param active
	 */
	public ResizableMevFigure() {
		this.resizeInProgress = false;
		resizeHandles = new Rectangle[4];
		for(int i = 0; i < resizeHandles.length; i++)
			resizeHandles[i] = new Rectangle();
	}

	private int getResizeCursor(int handleIndex) {
		int cursorType = 0;

		switch(handleIndex) {
		case TOP_LEFT_HANDLE:
			cursorType = SWT.CURSOR_SIZENW;
			break;
		case TOP_RIGHT_HANDLE:
			cursorType = SWT.CURSOR_SIZENE;
			break;
		case BOTTOM_RIGHT_HANDLE:
			cursorType = SWT.CURSOR_SIZESE;
			break;
		case BOTTOM_LEFT_HANDLE:
			cursorType = SWT.CURSOR_SIZESW;
			break;
		default:
			cursorType = SWT.CURSOR_ARROW; // Default cursor.
			break;
		}

		return cursorType;
	}

	private Rectangle getNewBounds(ResizeType resizeType, Point location, Rectangle bounds) {
		Point origin = new Point();
		Dimension dimension = new Dimension();

		switch(resizeType) {
		case NW:
			origin.x = location.x;
			origin.y = location.y;
			dimension.width = bounds.getRight().x - location.x;
			dimension.height = bounds.getBottom().y - location.y;
			break;
		case NE:
			origin.x = bounds.x;
			origin.y = location.y;
			dimension.width = location.x - bounds.x;
			dimension.height = bounds.getBottom().y - location.y;
			break;
		case SE:
			origin.x = bounds.x;
			origin.y = bounds.y;
			dimension.width = location.x - bounds.x;
			dimension.height = location.y - bounds.y;
			break;
		case SW:
			origin.x = location.x;
			origin.y = bounds.y;
			dimension.width = bounds.getRight().x - location.x;
			dimension.height = location.y - bounds.y;
			break;
		}

		return bounds.getCopy().setBounds(
				origin, dimension);
	}


	public void mousePressed(MouseEvent event) {

		// Check if the mouse press was within the bounds of a resize handle.
		for(int i = 0; i < resizeHandles.length; i++){
			if(resizeHandles[i].contains(event.getLocation())){
				event.consume();
				setCursor(Display.getCurrent().getSystemCursor(getResizeCursor(i)));
				resizeType = this.getResizeType(i);
				location = event.getLocation();
				resizeInProgress = true;
				break;
			}
		}

	}

	public void mouseDragged(MouseEvent event) {
		if(resizeInProgress && location != null){
			event.consume();
			// Get the current mouse position.
			Point newLocation = new Point(event.x, event.y);
			//translateToAbsolute(newLocation);

			if (newLocation != null) {
				Dimension offset = newLocation.getDifference(location);

				if (offset.width != 0 || offset.height != 0) {
					location = newLocation;

					UpdateManager updateMngr = getUpdateManager();
					LayoutManager layoutMngr = getParent().getLayoutManager();
					Rectangle oldBounds = getBounds();
					updateMngr.addDirtyRegion(getParent(), oldBounds);

					Rectangle newBounds = null;
					if(this.delegate != null)
						newBounds = this.delegate.getNewBounds(this.resizeType, this.location, this.bounds.getCopy());

					if(newBounds != null) {
						layoutMngr.setConstraint(this, newBounds);
						this.setBounds(newBounds);
						this.revalidate();
						updateMngr.addDirtyRegion(getParent(), newBounds);
					}
				}
			}
		}
	}

	@Override
	public boolean containsPoint(int x, int y){
		if(resizeInProgress)
			return true;
		else
			return getBounds().contains(x, y);
	}

	public void mouseReleased(MouseEvent event) {
		if(resizeInProgress){
			event.consume();
			resizeInProgress = false;
			setCursor(null); // Default cursor.
		}
	}


	@Override
	public void paintFigure(Graphics g){
		super.paintFigure(g);

		// Draw selection handles if figure is selected.
		if(selected){
			// Save graphics state.
			g.pushState();

			g.setLineWidth(1);

			Color color = this.getSelectionColor();
			g.setForegroundColor(color);
			g.setBackgroundColor(color);

			// Get bounds.
			Rectangle r = Rectangle.SINGLETON.setBounds(getBounds());

			/* Draw resize handles. */
			resizeHandles[TOP_LEFT_HANDLE].setBounds(r.x, r.y, SELECTION_HANDLE_WIDTH, SELECTION_HANDLE_WIDTH);
			g.fillRectangle(resizeHandles[TOP_LEFT_HANDLE]); // Top left

			resizeHandles[TOP_RIGHT_HANDLE].setBounds(r.x + r.width - SELECTION_HANDLE_WIDTH, r.y, SELECTION_HANDLE_WIDTH, SELECTION_HANDLE_WIDTH);
			g.fillRectangle(resizeHandles[TOP_RIGHT_HANDLE]); // Top right

			resizeHandles[BOTTOM_RIGHT_HANDLE].setBounds(r.x + r.width - SELECTION_HANDLE_WIDTH, bounds.y + r.height - SELECTION_HANDLE_WIDTH, SELECTION_HANDLE_WIDTH, SELECTION_HANDLE_WIDTH);
			g.fillRectangle(resizeHandles[BOTTOM_RIGHT_HANDLE]); // Bottom right

			resizeHandles[BOTTOM_LEFT_HANDLE].setBounds(r.x, bounds.y + r.height - SELECTION_HANDLE_WIDTH, SELECTION_HANDLE_WIDTH, SELECTION_HANDLE_WIDTH);
			g.fillRectangle(resizeHandles[BOTTOM_LEFT_HANDLE]); // Bottom left

			// Restore graphics state.
			g.popState();
		}
	}

	public boolean isResizeInProgress() {
		return resizeInProgress;
	}

	public IResizableFigureDelegate getResizableFigureDelegate() {
		return delegate;
	}

	public void setResizableFigureDelegate(IResizableFigureDelegate delegate) {
		this.delegate = delegate;
	}

	private ResizeType getResizeType(int handleIndex) {
		ResizeType type = null;
		switch(handleIndex) {
		case TOP_LEFT_HANDLE:
			type = ResizeType.NW;
			break;
		case TOP_RIGHT_HANDLE:
			type = ResizeType.NE;
			break;
		case BOTTOM_RIGHT_HANDLE:
			type = ResizeType.SE;
			break;
		case BOTTOM_LEFT_HANDLE:
			type = ResizeType.SW;
			break;
		default:
			type = ResizeType.SE; // Should never occur.
			break;
		}
		return type;
	}

}
