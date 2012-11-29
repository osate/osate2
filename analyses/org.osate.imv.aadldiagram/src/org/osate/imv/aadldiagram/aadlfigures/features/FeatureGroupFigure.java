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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.swt.SWT;
import org.osate.imv.aadldiagram.adapters.FeatureDirectionType;


public class FeatureGroupFigure extends DirectedFeatureFigure {

	private static final int H_EXTENT = 21;
	private static final int V_EXTENT = 18;

	private static final int CIRCLE_DIAMETER = 8;
	private static final int CIRCLE_RADIUS = (int) (CIRCLE_DIAMETER / 2.0f);

	public FeatureGroupFigure(String label, FeatureDirectionType direction, FeatureLabelStyle labelStyle) {
		super(label, direction, labelStyle);
	}

	@Override
	protected void drawSymbol(Graphics g) {
		super.drawSymbol(g);

		// Configure context.
		g.setBackgroundColor(ColorConstants.black);
		g.setForegroundColor(ColorConstants.black);
		g.setLineCap(SWT.CAP_FLAT);
		g.setLineWidth(4);

		int w = H_EXTENT - 1;
		int h = V_EXTENT - 1;

		int circleX = (int) (0.5f * (H_EXTENT - CIRCLE_DIAMETER));

		// Fill circle.
		g.fillOval(circleX, 0, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
		// Draw arc.
		g.drawArc(0, 0, w, h - CIRCLE_RADIUS, 0, -180);
	}

	@Override
	protected int getSymbolHorizontalExtent() {
		return H_EXTENT;
	}

	@Override
	protected int getSymbolVerticalExtent() {
		return V_EXTENT;
	}

}
