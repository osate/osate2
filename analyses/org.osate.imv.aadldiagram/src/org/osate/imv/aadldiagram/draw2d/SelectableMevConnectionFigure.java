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

import java.util.Arrays;

import org.eclipse.draw2d.Bendpoint;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.widgets.Display;

public class SelectableMevConnectionFigure extends PolylineConnection {

	public static final int SELECTION_HANDLE_SIZE = 8; // Size in pixels.

	public static final int SETECTED_LINE_WIDTH = 2;

	protected boolean isSelected;
	protected boolean isMoveInProgress;

	private CursorHelper cursorHelper;

	private int lineWidth;

	public SelectableMevConnectionFigure() {
		// Initially the connection is NOT selected.
		this.isSelected = false;
		this.isMoveInProgress = false;
		this.cursorHelper = new CursorHelper();
	}


	public void setSelected(boolean isSelected) {
		if(this.isSelected == isSelected)
			return; // No changes need to be made.

		this.isSelected = isSelected;

		if(isSelected) {
			this.lineWidth = this.getLineWidth();
			super.setLineWidth(SETECTED_LINE_WIDTH);
		} else {
			super.setLineWidth(this.lineWidth);
		}
		this.repaint();
	}

	@Override
	public void setLineWidth(int lineWidth) {
		if(this.isSelected)
			this.lineWidth = lineWidth;
		else
			super.setLineWidth(lineWidth);
	}

	public boolean isSelected() {
		return this.isSelected;
	}

	protected Rectangle[] getSelectionHandles() {

		// Get the points which define this connection.
		PointList points = this.getPoints();

		Rectangle[] handles = new Rectangle[3];

		int halfWidth = (int) Math.ceil(SELECTION_HANDLE_SIZE / 2.0f);

		Point point = points.getFirstPoint();
		handles[0] = new Rectangle(point.x - halfWidth, point.y - halfWidth, SELECTION_HANDLE_SIZE, SELECTION_HANDLE_SIZE);

		point = points.getPoint(1);
		handles[1] = new Rectangle(point.x - halfWidth, point.y - halfWidth, SELECTION_HANDLE_SIZE, SELECTION_HANDLE_SIZE);

		point = points.getLastPoint();
		handles[2] = new Rectangle(point.x - halfWidth, point.y - halfWidth, SELECTION_HANDLE_SIZE, SELECTION_HANDLE_SIZE);

		return handles;
	}


	protected boolean intersectsSelectionHandle(Point location) {
		Point midPoint = this.getPoints().getMidpoint();
		Rectangle rect = Rectangle.SINGLETON;
		rect.setLocation(midPoint);
		rect.setWidth(SELECTION_HANDLE_SIZE);
		rect.setHeight(SELECTION_HANDLE_SIZE);
		int halfWidth = (int) Math.ceil(SELECTION_HANDLE_SIZE / 2.0f);
		rect.translate(-halfWidth, -halfWidth);
		return rect.contains(location);
	}

	public void mousePressed(MouseEvent me) {
		if (this.intersectsSelectionHandle(me.getLocation())) {
			me.consume();
			this.isMoveInProgress = true;
		}
		this.setSelected(true);
	}


	public void mouseReleased(MouseEvent me) {
		if(this.isMoveInProgress) {
			me.consume();
			this.isMoveInProgress = false;

		}
	}


	public void mouseDragged(MouseEvent me) {

		if (this.isMoveInProgress) {
			me.consume();

			// Create absolute bendpoint.
			Point location = me.getLocation();
			Bendpoint bp = BendpointHelper.calculateRelativeBendpoint(location, this.getPoints().getFirstPoint(), this.getPoints().getLastPoint(), this);

			ConnectionRouter router = this.getConnectionRouter();
			router.setConstraint(this, Arrays.asList(new Bendpoint[] {bp}));
			this.layout();
		}
	}


	public void mouseMoved(MouseEvent me) {
		this.cursorHelper.updateCursor(this.intersectsSelectionHandle(me.getLocation()));
	}

	@Override
	public void paintFigure(Graphics g){
		super.paintFigure(g);

		// Highlight figure if it is selected.
		if(this.isSelected){
			// Save graphics state.
			g.pushState();

			// Configure context.
			g.setBackgroundColor(ColorConstants.black);
			g.setForegroundColor(ColorConstants.white);
			g.setLineWidth(1);

			/* Draw selection handles. */

			// Get the selection handles.
			Rectangle[] handles = this.getSelectionHandles();
			for(int i = 0; i < handles.length; i++) {
				// Draw handles.
				g.fillRectangle(handles[i]);
				g.drawRectangle(handles[i]);
			}

			// Restore graphics state.
			g.popState();
		}
	}


	@Override
	public void removeNotify() {
		// This is a workaround to prevent the router constraint from being removed when
		// the connection is removed from its parent figure.
		Object constraint = this.getRoutingConstraint();
		super.removeNotify();
		this.setRoutingConstraint(constraint);
	}


	public void mouseEntered(MouseEvent me) {
	}


	public void mouseExited(MouseEvent me) {
		this.cursorHelper.updateCursor(false);
	}


	public void mouseHover(MouseEvent me) {
		// Not used.
	}


	public void mouseDoubleClicked(MouseEvent me) {
		// Not used.
	}


	private class CursorHelper {
		private boolean handCursorSet = false;
		private final Cursor handCursor = Display.getCurrent().getSystemCursor(SWT.CURSOR_HAND);

		public void updateCursor(boolean showHandCursor) {
			if(showHandCursor && !handCursorSet) {
				setHandCursor(true);
			} else if(!showHandCursor && handCursorSet) {
				setHandCursor(false);
			}
		}

		private void setHandCursor(boolean setHandCursor) {
			if (setHandCursor)
				setCursor(handCursor);
			else
				setCursor(null);

			handCursorSet = setHandCursor;
		}
	}

}
