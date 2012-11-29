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

package org.osate.imv.aadldiagram.figuremovers;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.UpdateManager;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.osate.imv.aadldiagram.aadlfigures.components.ComponentFigure;


public class SubComponentFigureMover implements IFigureMoverDelegate{

	/**
	 * The target figure (i.e. the figure that will be moved).
	 */
	private ComponentFigure targetFigure;

	/**
	* The initial point where the mouse press occurs.
	*/
	private Point location = null;

	public SubComponentFigureMover(ComponentFigure figure){
		this.targetFigure = figure;
	}


	@Override
	public void mousePressed(MouseEvent event) {
		location = event.getLocation();
		event.consume();
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		if(location == null)
			return;

		Point newLocation = event.getLocation();
		if(newLocation == null)
			return;

		Dimension offset = newLocation.getDifference(location);
		if(offset.width == 0 && offset.height == 0)
			return;

		// Check for negative bounds.
		if(checkForNegativeBounds(offset.width, offset.height))
			return;

		location = newLocation;

		// Get the target figure's bounds.
		Rectangle bounds = targetFigure.getBounds();

		UpdateManager updateMngr = targetFigure.getUpdateManager();
		LayoutManager layoutMngr = targetFigure.getParent().getLayoutManager();
		updateMngr.addDirtyRegion(targetFigure.getParent(), bounds);

		bounds = bounds.getCopy().translate(offset.width, offset.height);
		// Update the figure's layout constraint.
		layoutMngr.setConstraint(targetFigure, bounds);

		targetFigure.translate(offset.width, offset.height);
		updateMngr.addDirtyRegion(targetFigure.getParent(), bounds);

		updateContainerSize();

		event.consume();
	}

	protected boolean checkForNegativeBounds(int dx, int dy){
		// The container's insets.
		Insets insets = targetFigure.getParent().getInsets();
		// Create translated bounds.
		Rectangle tRect = targetFigure.getBounds().getCopy().translate(dx, dy);
		// Check for negative coordinates.
		return ((tRect.x - insets.left < 0) || (tRect.y - insets.top < 0));
	}

	protected void updateContainerSize(){
		IFigure container = targetFigure.getParent();
		// A copy of the container's bounds.
		Rectangle cBounds = container.getBounds().getCopy();
		// The container's client area.
		Rectangle clientBounds = container.getClientArea();
		// The target figure's bounds after being moved.
		Rectangle tBounds = targetFigure.getBounds();
		// The container's insets.
		Insets insets = container.getInsets();

		int x = cBounds.x;
		int y = cBounds.y;
		int width = cBounds.width;
		int height = cBounds.height;
		// Adjust the size of the parent container's bounds to contain the target figure.
		if(tBounds.x < clientBounds.x){
			x = tBounds.x - insets.left;
			width += clientBounds.x - tBounds.x;
		}
		if(tBounds.y < clientBounds.y){
			y = tBounds.y - insets.top;
			height += clientBounds.y - tBounds.y;
		}
		if(tBounds.right() > clientBounds.right()){
			width += tBounds.right() - clientBounds.right();
		}
		if(tBounds.bottom() > clientBounds.bottom()){
			height += tBounds.bottom() - clientBounds.bottom();
		}

		UpdateManager updateMngr = container.getUpdateManager();
		LayoutManager layoutMngr = container.getParent().getLayoutManager();
		Rectangle oldBounds = container.getBounds();
		updateMngr.addDirtyRegion(container.getParent(), oldBounds);

		// Update the container's bounds.
		cBounds.setBounds(x, y, width, height);

		layoutMngr.setConstraint(container, cBounds);
		container.setBounds(cBounds);
		container.revalidate();
		updateMngr.addDirtyRegion(container.getParent(), cBounds);
	}

	private void checkContainment(Point hitPoint){
		// Get the target figure's bounds.
		Rectangle tBounds = targetFigure.getBounds();
		// Get the container's client area.
		Rectangle cBounds = targetFigure.getParent().getClientArea();
		// Find offset.
		Dimension offset = hitPoint.getDifference(location);
		// Create new rectangle to represent the future location of the figure.
		Rectangle futureBounds = tBounds.getCopy().translate(offset.width, offset.height);

		if(!cBounds.contains(futureBounds)){
			// Adjust the size of the parent container's bounds to contain the target figure.
			// TODO
		}
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		if(location == null)
			return;
		location = null;
		event.consume();
	}


}
