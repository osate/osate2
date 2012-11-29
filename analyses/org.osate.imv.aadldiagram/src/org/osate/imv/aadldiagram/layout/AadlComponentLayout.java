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

package org.osate.imv.aadldiagram.layout;

import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.osate.imv.aadldiagram.aadlfigures.components.ComponentFigure;
import org.osate.imv.aadldiagram.aadlfigures.features.FeatureFigure;
import org.osate.imv.aadldiagram.aadlfigures.features.FeatureOrientation;
import org.osate.imv.aadldiagram.draw2d.ResizableMevFigure;


public class AadlComponentLayout extends AbstractLayout {

	private static final int FEATURE_SPACING = 5;
	private static final int COMPONENT_SPACING = 5;

	/** The layout constraints */
	protected Map<IFigure, Rectangle> constraints = new HashMap<IFigure, Rectangle>();

	@Override
	public void layout(IFigure container) {
		// Get the containers client area.
		Rectangle bounds = container.getClientArea();
		// Keeps track of where to place features.
		int offset = (int)(ResizableMevFigure.SELECTION_HANDLE_WIDTH / 2.0f);
		Point nextFeatureLocation = new Point(bounds.x - offset, bounds.y);
		// Keeps track of where to place components.
		Point nextComponentLocation = new Point(bounds.x + 50, bounds.y + 50);

		Iterator children = container.getChildren().iterator();

		IFigure f;
		while (children.hasNext()) {
			f = (IFigure) children.next();
			Rectangle locationHint = (Rectangle) getConstraint(f);

			// Connections are not handled by the layout manager (i.e. a {@link ConnectionRouter} is used).
			if(f instanceof Connection)
				continue;

			if (locationHint == null){
				Dimension d = f.getPreferredSize();
				if(f instanceof FeatureFigure){
					Rectangle constraint = new Rectangle(nextFeatureLocation, d);
					f.setBounds(constraint);
					// Update layout constraint.
					setConstraint(f, convertToLocalCoordinates(constraint, container.getBounds()));
					// Update the next feature location.
					nextFeatureLocation.translate(0, d.height() + FEATURE_SPACING);
					// Set the features orientation.
					((FeatureFigure)f).setOrientation(FeatureOrientation.WEST);
				}else{
					Rectangle constraint = new Rectangle(nextComponentLocation, d);
					f.setBounds(constraint);
					// Update layout constraint.
					setConstraint(f, convertToLocalCoordinates(constraint, container.getBounds()));
					// Update the next component location.
					nextComponentLocation.translate(d.width() + COMPONENT_SPACING, 0);
				}
			}else{
				if(f instanceof FeatureFigure){
					FeatureFigure featureFigure = (FeatureFigure)f;

					// Transform location hint into global coordinates.
					convertToGlobalCoordinates(locationHint, container.getBounds());

					// Get the enclosing container's bounds.
					Rectangle featureBounds = ((ComponentFigure)container).getFeatureBounds();

					// Update the figure's bounds so that it is closest to its
					// desired location.
					int w = featureFigure.getPreferredSize().width;
					int h = featureFigure.getPreferredSize().height;
					int x = 0;
					int y = 0;
					FeatureOrientation orientation = featureFigure.getOrientation();
					switch (orientation) {
					case NORTH:
					case SOUTH:
						if(orientation.equals(FeatureOrientation.NORTH))
							y = featureBounds.y;
						else
							y = featureBounds.bottom() - h;

						if(locationHint.x >= featureBounds.x && locationHint.x <= featureBounds.right() - w) x = locationHint.x;
						else if(locationHint.x > featureBounds.right() - w) x = featureBounds.right() - w;
						else if(locationHint.x < featureBounds.x) x = featureBounds.x;

						featureFigure.getBounds().setLocation(x, y);

						break;
					case EAST:
					case WEST:
						if(orientation.equals(FeatureOrientation.EAST))
							x = featureBounds.right() - w;
						else
							x = featureBounds.x;

						if(locationHint.y >= featureBounds.y && locationHint.y <= featureBounds.bottom() - h) y = locationHint.y;
						else if(locationHint.y > featureBounds.bottom() - h) y = featureBounds.bottom() - h;
						else if(locationHint.y < featureBounds.y) y = featureBounds.y;

						featureFigure.getBounds().setLocation(x, y);

						break;
					}

					convertToLocalCoordinates(locationHint, container.getBounds());

				}else{
					// phf: only set bounds if it was not already set before
					if (f.getBounds() == null)
						f.setBounds(locationHint.getCopy());
				}

			}

		}
	}

	private Rectangle convertToLocalCoordinates(Rectangle rect, Rectangle parent){
		rect.setLocation(rect.x - parent.x, rect.y - parent.y);
		return rect;
	}

	private Rectangle convertToGlobalCoordinates(Rectangle rect, Rectangle parent){
		rect.setLocation(rect.x + parent.x, rect.y + parent.y);
		return rect;
	}


	@Override
	protected Dimension calculatePreferredSize(IFigure container, int wHint,
			int hHint) {
		Dimension size = new Dimension();

		// Validate the container figure.
		container.validate();

		int maxX = 0, maxY = 0;
		ListIterator children = container.getChildren().listIterator();

		// Check if figure does not have any children.
		if(!children.hasNext()) {
			// Set default size.
			size.expand(100, 50);
		}

		while (children.hasNext()) {
			IFigure child = (IFigure) children.next();
			int rightX = child.getBounds().right();
			int bottomY = child.getBounds().bottom();
			// Calculate amount to expand the size.
			int dx = 0, dy = 0;
			if(rightX > maxX){
				dx = rightX - maxX;
				maxX = rightX;
			}
			if(bottomY > maxY){
				dy = bottomY - maxY;
				maxY = bottomY;
			}
			// Expand size.
			size.expand(dx, dy);
		}

		Insets insets = container.getInsets();
		// Account for insets.
		size.expand(insets.getWidth(), insets.getHeight());

		return size;
	}

	/**
	 * @see LayoutManager#remove(IFigure)
	 */
	public void remove(IFigure figure) {
		super.remove(figure);
		constraints.remove(figure);
	}

	/**
	 * @see LayoutManager#getConstraint(IFigure)
	 */
	public Object getConstraint(IFigure figure) {
		return constraints.get(figure);
	}

	/**
	 * Returns the origin for the given figure.
	 *
	 * @param parent
	 *            the figure whose origin is requested
	 * @return the origin
	 */
	public Point getOrigin(IFigure parent) {
		return parent.getClientArea().getLocation();
	}

	/**
	 * Sets the layout constraint of the given figure. The constraints can only
	 * be of type {@link Point}.
	 *
	 * @see LayoutManager#setConstraint(IFigure, Object)
	 */
	public void setConstraint(IFigure figure, Object newConstraint) {
		super.setConstraint(figure, newConstraint);
		if (newConstraint != null && newConstraint instanceof Rectangle)
			constraints.put(figure, (Rectangle)newConstraint);
	}

}
