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
import org.eclipse.swt.SWT;
import org.osate.imv.aadldiagram.adapters.FeatureDirectionType;


public class EventDataPortFeature extends PortFeatureFigure {
	private static final int TRIANGLE_SIZE_DIFF = 6;  // Must be an even #

	private int outerTriangleHeight;

	private int outerTriangleBase;
	private int innerTriangleBase;

	public EventDataPortFeature(String label,
			FeatureDirectionType direction, FeatureLabelStyle labelStyle) {
		super(label, direction, labelStyle);
		setTriangleDimensions();
	}

	private void setTriangleDimensions(){
		// Set dimensions for outer triangle.
		outerTriangleHeight = V_EXTENT;
		outerTriangleBase = H_EXTENT;
		// Set dimensions for inner triangle.
		innerTriangleBase = outerTriangleBase - TRIANGLE_SIZE_DIFF;
	}


	@Override
	protected void drawSymbol(Graphics g) {
		super.drawSymbol(g);

		// Create point list that defines the symbol.
		PointList points = new PointList();

		int centerPoint = (int)Math.ceil((outerTriangleBase / 2.0f)); // Center point of odd #.

		/* Populate point list. */
		int baseOffset = (int)(TRIANGLE_SIZE_DIFF / 2.0f);
		points.addPoint(centerPoint, TRIANGLE_SIZE_DIFF);
		points.addPoint(baseOffset + 1, outerTriangleHeight);
		points.addPoint(baseOffset + innerTriangleBase, outerTriangleHeight);

		// Configure GC.
		g.setForegroundColor(this.getForegroundColor());
		g.setBackgroundColor(this.getBackgroundColor());

		// Draw symbol.
		g.fillPolygon(points);

		g.setLineWidth(2);
		g.setLineCap(SWT.CAP_ROUND);

		/* Draw outline for outer triangle.*/
		g.drawLine(centerPoint, 0, 0, outerTriangleHeight); // Left side of triangle.
		g.drawLine(centerPoint, 0, outerTriangleBase, outerTriangleHeight); // Right side of triangle.
	}

}
