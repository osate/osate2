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

import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.UpdateManager;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.osate.imv.aadldiagram.aadlfigures.components.ComponentFigure;
import org.osate.imv.aadldiagram.aadlfigures.features.FeatureFigure;
import org.osate.imv.aadldiagram.aadlfigures.features.FeatureOrientation;


public class FeatureFigureMover implements IFigureMoverDelegate {

	/**
	 * The target figure (i.e. the figure that will be moved).
	 */
	private FeatureFigure targetFigure;

	/**
	* The initial point where the mouse press occurs.
	*/
	private Point location = null;


	public FeatureFigureMover(FeatureFigure figure){
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

		// The subcomponent cannot be moved outside the bounds of its parent component.
		Rectangle bounds = targetFigure.getParent().getBounds();

		// Get the new region.
		FeatureOrientation region = getRegion(newLocation);
		if(region == null)
			return;

		targetFigure.setOrientation(region);

		// Snap origin to region.
		this.snapToRegion(newLocation, region);

		offset = newLocation.getDifference(targetFigure.getLocation());

		location = newLocation;

		UpdateManager updateMngr = targetFigure.getUpdateManager();
		LayoutManager layoutMngr = targetFigure.getParent().getLayoutManager();
		bounds = targetFigure.getBounds();
		updateMngr.addDirtyRegion(targetFigure.getParent(), bounds);
		bounds = bounds.getCopy().translate(offset.width, offset.height);

		// Adjust the bound's dimensions based on the figures preferred size.
		bounds.setWidth(targetFigure.getPreferredSize().width);
		bounds.setHeight(targetFigure.getPreferredSize().height);

		targetFigure.setBounds(bounds);

		// Layout bounds must be relative to the features container.
		Rectangle containerBounds = targetFigure.getParent().getBounds();
		layoutMngr.setConstraint(targetFigure, bounds.setLocation(bounds.x - containerBounds.x, bounds.y - containerBounds.y));

		updateMngr.addDirtyRegion(targetFigure.getParent(), bounds);
		event.consume();
	}

	private FeatureOrientation getRegion(Point point){
		FeatureOrientation region = null;

		// Get the parent figure bounds.
		Rectangle bounds = targetFigure.getParent().getClientArea();

		// Verify that the mouse is within the bounds of the parent component.
		if(bounds.contains(point)){
			int y = point.y;
			int x = point.x;

			// First check if the location is within the edge area.
			int edgeArea = (int)(targetFigure.getPreferredSize().height / 2.0f);
			if(y >= bounds.y && y <= bounds.y + edgeArea)
				region = FeatureOrientation.NORTH;
			else if(y <= bounds.y + bounds.height && y >= bounds.y + bounds.height - edgeArea)
				region = FeatureOrientation.SOUTH;


			if(region == null){
				int sectorWidth = (int)(bounds.width / 3.0f);
				// Check if the location is within the left or right sector.
				if(x >= bounds.x && x <= bounds.x + sectorWidth)
					region = FeatureOrientation.WEST;
				else if(x <= bounds.x + bounds.width && x >= bounds.x + bounds.width - sectorWidth)
					region = FeatureOrientation.EAST;
			}

			if(region == null){
				int midpoint = bounds.y + (int)(bounds.height / 2.0f);
				if(y >= bounds.y && y <= midpoint)
					region = FeatureOrientation.NORTH;
				else if(y <= bounds.y + bounds.height && y > bounds.y + midpoint)
					region = FeatureOrientation.SOUTH;
			}

		}

		return region;
	}

	private void snapToRegion(Point location, FeatureOrientation region) {
		// Get the container's feature bounds.
		Rectangle drawingBounds = ((ComponentFigure) targetFigure.getParent()).getFeatureBounds();

		int x = 0, y = 0;
		int maxX = drawingBounds.getRight().x;
		int maxY = drawingBounds.getBottom().y;
		int w = targetFigure.getPreferredSize().width;
		int h = targetFigure.getPreferredSize().height;

		switch (region) {
		case NORTH:
			x = (location.x + w) > maxX ? (maxX - w) : location.x;
			y = drawingBounds.y;
			break;
		case SOUTH:
			x = (location.x + w) > maxX ? (maxX - w) : location.x;
			y = maxY - h;
			break;
		case EAST:
			x = maxX - w;
			y = (location.y + h) > maxY ? (maxY - h) : location.y;
			break;
		case WEST:
			x = drawingBounds.x;
			y = (location.y + h) > maxY ? (maxY - h) : location.y;
			break;
		}

		location.setLocation(x, y);
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		if(location == null)
			return;
		location = null;
		event.consume();
	}

}
