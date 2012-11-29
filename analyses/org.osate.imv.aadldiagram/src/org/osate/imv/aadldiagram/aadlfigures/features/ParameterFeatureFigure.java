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

package org.osate.imv.aadldiagram.aadlfigures.features;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.PointList;
import org.osate.imv.aadldiagram.adapters.FeatureDirectionType;


public class ParameterFeatureFigure extends DirectedFeatureFigure {

	public static final int V_EXTENT = 15; // Must be odd #
	public static final int H_EXTENT = 15; // Must be odd #

	private int triangleHeight = V_EXTENT;
	private int triangleBase = H_EXTENT;

	public ParameterFeatureFigure(String label, FeatureDirectionType direction,
			FeatureLabelStyle labelStyle) {
		super(label, direction, labelStyle);
	}

	@Override
	protected void drawSymbol(Graphics g) {
		super.drawSymbol(g);

		// Create point list that defines the symbol.
		PointList points = new PointList();

		int centerPoint = (int)Math.ceil((triangleBase / 2.0f)); // Center point of odd #.

		/* Populate point list. */
		points.addPoint(centerPoint, 0);
		points.addPoint(0, triangleHeight);
		points.addPoint(triangleBase, triangleHeight);


		// Configure GC.
		g.setForegroundColor(this.getForegroundColor());
		g.setBackgroundColor(this.getBackgroundColor());

		// Draw symbol.
		g.fillPolygon(points);
	}

	protected int getSymbolHorizontalExtent() {
		return H_EXTENT;
	}

	protected int getSymbolVerticalExtent() {
		return V_EXTENT;
	}
}
