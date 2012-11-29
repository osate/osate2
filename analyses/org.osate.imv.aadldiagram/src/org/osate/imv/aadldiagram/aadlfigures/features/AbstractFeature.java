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
import org.eclipse.swt.SWT;
import org.osate.imv.aadldiagram.adapters.FeatureDirectionType;


public class AbstractFeature extends DirectedFeatureFigure {

	private static final int V_EXTENT = 19; // Must be odd #
	private static final int H_EXTENT = 19; // Must be odd #

	private static final int CIRCLE_DIAMETER = 11;

	private int triangleHeight;
	private int triangleBase;
	private int circleDiameter;

	public AbstractFeature(String label, FeatureDirectionType direction, FeatureLabelStyle labelStyle) {
		super(label, direction, labelStyle);
		this.triangleHeight = (int) (V_EXTENT - (CIRCLE_DIAMETER / 2.0f));
		this.triangleBase = H_EXTENT;
		this.circleDiameter = CIRCLE_DIAMETER;
	}

	@Override
	protected void drawSymbol(Graphics g) {
		super.drawSymbol(g);

		// Configure GC.
		g.setForegroundColor(this.getForegroundColor());
		g.setBackgroundColor(this.getBackgroundColor());
		g.setLineWidth(2);
		g.setLineCap(SWT.CAP_ROUND);

		int centerPoint = (int)Math.ceil((triangleBase / 2.0f)); // Center point of odd #.
		int circleStartX = (int) Math.ceil((0.5f * (this.getSymbolHorizontalExtent() - this.circleDiameter)));

		if(this.getDirection() != FeatureDirectionType.IN_OUT) {
			// Draw triangle.
			g.drawLine(centerPoint, 0, 0, triangleHeight);
			g.drawLine(centerPoint, 0, triangleBase, triangleHeight);

			// Fill circle.
			g.fillOval(circleStartX, this.getSymbolVerticalExtent() - this.circleDiameter, this.circleDiameter, this.circleDiameter);
		} else {
			// Fill circle.
			g.fillOval(circleStartX, 0, this.circleDiameter, this.circleDiameter);
		}
	}

	protected int getSymbolHorizontalExtent() {
		return H_EXTENT;
	}

	protected int getSymbolVerticalExtent() {
		return V_EXTENT;
	}

}
