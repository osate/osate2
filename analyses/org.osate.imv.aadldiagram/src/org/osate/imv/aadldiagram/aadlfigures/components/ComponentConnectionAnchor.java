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

package org.osate.imv.aadldiagram.aadlfigures.components;

import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

public class ComponentConnectionAnchor extends AbstractConnectionAnchor implements MouseListener, MouseMotionListener {

	private static final double MAX_DISTANCE = 10;

	private enum SideType {NORTH, SOUTH, EAST, WEST};

	private ComponentFigure owner;
	private Connection connection;

	private boolean moveInProgress;

	private ConnectionEndLocation location;

	private Point initialAbsoluteLocation;

	public ComponentConnectionAnchor(ComponentFigure owner, Connection connection) {
		super(owner);

		Assert.isNotNull(owner);
		Assert.isNotNull(connection);

		this.owner = owner;
		this.connection = connection;
		this.moveInProgress = false;

		// Default connection location is the center of the components top edge.
		this.location = new ConnectionEndLocation(SideType.NORTH, 0.5f);

		// Register mouse listener and mouse motion listener.
		this.registerListeners();
	}

	public void setInitialAbsoluteLocation(Point absoluteLocation) {
		this.initialAbsoluteLocation = absoluteLocation;
	}

	@Override
	public Point getLocation(Point reference) {
		Rectangle bounds = this.owner.getClientArea();
		Point retPoint = new Point();

		if(this.initialAbsoluteLocation != null) {
			this.location.sideType = findInitialSideTypeFromAbsolutePoint(this.initialAbsoluteLocation);
			this.location.weight = this.getWeight(this.initialAbsoluteLocation, this.location.sideType);
			this.initialAbsoluteLocation = null;
		}

		switch(this.location.getSideType()) {
		case NORTH:
			retPoint.x = (int) (bounds.x + (bounds.width * this.location.getWeight()));
			retPoint.y = bounds.y;
			break;
		case SOUTH:
			retPoint.x = (int) (bounds.x + (bounds.width * this.location.getWeight()));
			retPoint.y = bounds.getBottom().y;
			break;
		case EAST:
			retPoint.x = bounds.getRight().x;
			retPoint.y = (int) (bounds.y + (bounds.height * this.location.getWeight()));
			break;
		case WEST:
			retPoint.x = bounds.x;
			retPoint.y = (int) (bounds.y + (bounds.height * this.location.getWeight()));
			break;
		}

		// Translate location to absolute coordinates.
		this.owner.translateToAbsolute(retPoint);
		return retPoint;
	}

	@Override
	public Point getReferencePoint() {
		return this.getLocation(null);
	}

	@Override
	public void mousePressed(MouseEvent me) {
		if(!this.moveInProgress) {
			// Check if mouse press was within proximity to the connections end point.
			Point endLocation = this.getLocation(null);
			Point pressLocation = me.getLocation();
			// Translate to absolute coordinates because the end location is in absolute coordinates.
			this.getOwner().translateToAbsolute(pressLocation);
			if(endLocation.getDistance(pressLocation) <= MAX_DISTANCE) {
				me.consume();
				this.moveInProgress = true;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		if(this.moveInProgress) {
			me.consume();
			this.moveInProgress = false;
		}
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		if(this.moveInProgress) {
			me.consume();
			Point mouseLocation = me.getLocation();
			this.updateLocation(mouseLocation);
			// Repaint the connection since it has moved.
			this.connection.revalidate();
		}
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		// Not used.
	}

	@Override
	public void mouseExited(MouseEvent me) {
		// Not used.
	}

	@Override
	public void mouseHover(MouseEvent me) {
		// TO DO: Set mouse hover icon.
	}

	@Override
	public void mouseMoved(MouseEvent me) {
		// Not used.
	}

	@Override
	public void mouseDoubleClicked(MouseEvent me) {
		// Not used.

	}

	private void updateLocation(Point absoluteLocation) {
		SideType newSideType = this.getSideType(absoluteLocation);
		this.location.setSideType(newSideType);
		this.location.setWeight(this.getWeight(absoluteLocation, newSideType));
	}

	private float getWeight(Point mouseLocation, SideType sideType) {
		float weight = 0;
		Rectangle bounds = this.owner.getBounds();

		switch (sideType) {
		case NORTH:
		case SOUTH:
			weight = (mouseLocation.x - bounds.x) / (float)bounds.width;
			break;
		case EAST:
		case WEST:
			weight = (mouseLocation.y - bounds.y) / (float)bounds.height;
			break;
		}

		if(weight < 0)
			weight = 0;

		if(weight > 1)
			weight = 1;

		return weight;
	}

	private SideType getSideType(Point mouseLocation) {
		SideType sideType = null;
		Rectangle bounds = this.owner.getBounds();
		int x = mouseLocation.x, y = mouseLocation.y;
		Point left = bounds.getLeft(), right = bounds.getRight(),
				top = bounds.getTop(), bottom = bounds.getBottom(), center = bounds.getCenter();

		boolean isContained = bounds.contains(mouseLocation);

		if (!isContained) {
			if (y <= top.y && x >= left.x && x <= right.x) // north
				sideType = SideType.NORTH;
			else if (y >= bottom.y && x >= left.x && x <= right.x) // south
				sideType = SideType.SOUTH;
			else if (x >= right.x && y >= top.y && y <= bottom.y) // east
				sideType = SideType.EAST;
			else if (x <= left.x && y >= top.y && y <= bottom.y) // west
				sideType = SideType.WEST;
		}

		// If the side type has not been determined yet.
		if (sideType == null) {
			// Get current side type.
			SideType curSideType = this.location.getSideType();
			switch (curSideType) {
			case NORTH:
				if (isContained) {
					if(y > center.y)
						sideType = SideType.SOUTH;
				} else {
					if(y < top.y && x < left.x)
						sideType = SideType.WEST;
					else if (y < top.y && x > right.x)
						sideType = SideType.EAST;
					else
						sideType = SideType.SOUTH;
				}
				break;
			case SOUTH:
				if (isContained) {
					if(y < center.y)
						sideType = SideType.NORTH;
				} else {
					if(y > bottom.y && x < left.x)
						sideType = SideType.WEST;
					else if (y > bottom.y && x > right.x)
						sideType = SideType.EAST;
					else
						sideType = SideType.NORTH;
				}
				break;
			case EAST:
				if (isContained) {
					if(x < center.x)
						sideType = SideType.WEST;
				} else {
					if(x > right.x && y < top.y)
						sideType = SideType.NORTH;
					else if (x > right.x && y > bottom.y)
						sideType = SideType.SOUTH;
					else
						sideType = SideType.WEST;
				}
				break;
			case WEST:
				if (isContained) {
					if(x > center.x)
						sideType = SideType.EAST;
				} else {
					if(x < left.x && y < top.y)
						sideType = SideType.NORTH;
					else if (x < left.x && y > bottom.y)
						sideType = SideType.SOUTH;
					else
						sideType = SideType.EAST;
				}
				break;

			}

		}

		if(sideType == null)
			sideType = this.location.getSideType();

		return sideType;
	}

	private SideType findInitialSideTypeFromAbsolutePoint(Point absolutePoint) {
		SideType sideType = SideType.NORTH; // Default to North in case of calculation error.
		Rectangle bounds = this.owner.getBounds();
		int x = absolutePoint.x, y = absolutePoint.y;
		Point left = bounds.getLeft(), right = bounds.getRight(),
				top = bounds.getTop(), bottom = bounds.getBottom(), center = bounds.getCenter();

		if(x == left.x)
			sideType = SideType.WEST;
		else if(x == right.x)
			sideType = SideType.EAST;
		else if(y == top.y)
			sideType = SideType.NORTH;
		else if(y == bottom.y)
			sideType = SideType.SOUTH;

		return sideType;
	}

	private void registerListeners() {
		this.connection.addMouseListener(this);
		this.connection.addMouseMotionListener(this);
	}

	private class ConnectionEndLocation {
		private SideType sideType;
		private float weight;

		public ConnectionEndLocation(SideType sideType, float weight) {
			this.sideType = sideType;
			this.weight = weight;
		}

		public SideType getSideType() {
			return sideType;
		}

		public void setSideType(SideType sideType) {
			this.sideType = sideType;
		}

		public float getWeight() {
			return weight;
		}

		public void setWeight(float weight) {
			this.weight = weight;
		}


	};

}
