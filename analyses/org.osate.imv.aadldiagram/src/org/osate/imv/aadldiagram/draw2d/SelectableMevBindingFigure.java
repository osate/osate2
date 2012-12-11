/*
 *
 * <copyright>
 * Copyright 2012 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 *
 * </copyright>
 */
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

public class SelectableMevBindingFigure extends PolylineConnection {

	public static final int SELECTION_HANDLE_SIZE = 8; // Size in pixels.

	public static final int SETECTED_LINE_WIDTH = 2;

	protected boolean isSelected;
	protected boolean isMoveInProgress;

	private CursorHelper cursorHelper;

	private int lineWidth;

	public SelectableMevBindingFigure() {
		// Initially the connection is NOT selected.
		
		this.isSelected = false;
		this.isMoveInProgress = false;
		this.cursorHelper = new CursorHelper();
		super.setLineStyle(SWT.LINE_DASH);
		
	} 


	public void setSelected(boolean isSelected) {
		
		if(this.isSelected == isSelected)
			return; // No changes need to be made.
		super.setLineStyle(SWT.LINE_DASH);
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
		this.setLineStyle(SWT.LINE_DASH);
		if(this.isSelected)
		{
			this.lineWidth = lineWidth;
		}
		else
		{
			super.setLineWidth(lineWidth );
		}
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
		int x;
		int y;
		super.paintFigure(g);

		// Highlight figure if it is selected.
		if(this.isSelected){
			// Save graphics state.
			g.pushState();

			// Configure context.
			g.setBackgroundColor(ColorConstants.green);
			g.setForegroundColor(ColorConstants.white);
			

			/* Draw selection handles. */

			// Get the selection handles.
			Rectangle[] handles = this.getSelectionHandles();
			for(int i = 0; i < handles.length - 1 ; i++) {
				// Draw handles.
				//System.out.println (" handle " + i + ", x = " +  handles[i].getCenter().x + ", y = " +  handles[i].getCenter().y);
				g.fillRectangle(handles[i]);
				g.drawRectangle(handles[i]);
			}
			
			
			/*
			 * JD : TODO an FIXME
			 * Here, we try to put an arrow on the target component but 
			 * at this time, the arrow needs to be oriented according to the
			 * other figures (position, etc ...). Check for the rotation parameter.
			 */
			g.setLineWidth(3);
			g.setLineStyle(SWT.LINE_SOLID);
			g.setBackgroundColor(ColorConstants.white);
			g.setForegroundColor(ColorConstants.black);
			x = handles[handles.length - 1].x;
			y = handles[handles.length - 1].y;
			int[] points = {x - 10 , y + 10, x , y , x + 10, y + 10};
			//g.rotate(-90);
			g.drawPolyline(points);

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
