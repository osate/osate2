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
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.osate.imv.aadldiagram.adapters.FeatureAdapterCategory;
import org.osate.imv.aadldiagram.adapters.FeatureDirectionType;


public class AccessFeatureFigure extends DirectedFeatureFigure {

	public static final int V_EXTENT = 15; // Must be odd #
	public static final int H_EXTENT = 15; // Must be odd #

	private FeatureAdapterCategory featureCategory;

	public AccessFeatureFigure(String label, FeatureDirectionType direction,
			FeatureLabelStyle labelStyle, FeatureAdapterCategory accessFeatureCategory) {
		super(label, direction, labelStyle);
		this.featureCategory = accessFeatureCategory;
	}

	protected int getSymbolHorizontalExtent() {
		return H_EXTENT;
	}

	protected int getSymbolVerticalExtent() {
		return V_EXTENT;
	}

	@Override
	protected void drawSymbol(Graphics g) {
		PointList points = null;

		super.drawSymbol(g);

		int centerPointX = (int)Math.ceil((H_EXTENT / 2.0f)); // Center point of odd #.

		switch(this.featureCategory) {
		case BUS_ACCESS:
		case DATA_ACCESS:
			// Configure GC.
			g.setForegroundColor(this.getForegroundColor());
			g.setBackgroundColor(ColorConstants.white);
			g.setLineWidth(2);

			// Create point list that defines the symbol.
			points = new PointList();

			/* Populate point list. */
			points.addPoint(centerPointX, 0);
			points.addPoint(0, V_EXTENT - 8);
			points.addPoint(0, V_EXTENT);
			points.addPoint(centerPointX, V_EXTENT - 2);
			points.addPoint(H_EXTENT, V_EXTENT);
			points.addPoint(H_EXTENT, V_EXTENT - 8);

			// Fill symbol.
			g.fillPolygon(points);
			// Draw symbol.
			g.drawPolygon(points);

			break;
		case SUBPROGRAM_ACCESS:
		case SUBPROGRAM_GROUP_ACCESS:
			// Configure GC
			if(this.featureCategory == FeatureAdapterCategory.SUBPROGRAM_ACCESS) {
				g.setBackgroundColor(ColorConstants.white);
				g.setForegroundColor(ColorConstants.black);
			} else {
				g.setBackgroundColor(ColorConstants.black);
				g.setForegroundColor(ColorConstants.white);
			}

			g.setLineCap(SWT.CAP_ROUND);
			g.setLineWidth(2);

			int ovalWidth = H_EXTENT;
			int ovalHeight = V_EXTENT;
			// Draw oval.
			Rectangle ovalRect = new Rectangle((int)(0.5f * (H_EXTENT - ovalWidth)), (int)(0.5f * (V_EXTENT - ovalHeight)), ovalWidth, ovalHeight);
			g.fillOval(ovalRect);

			if(this.featureCategory == FeatureAdapterCategory.SUBPROGRAM_ACCESS)
				g.drawOval(ovalRect);

			int triangleWidth = 7;
			int triangleHeight = 5;
			int triangleStartX = (int) Math.ceil((0.5f * (H_EXTENT - triangleWidth)));
			int triangleStartY = (int) Math.ceil((0.5f * (V_EXTENT - triangleHeight)));

			// Draw triangle.
			g.drawLine(triangleStartX, triangleStartY, centerPointX, triangleStartY + triangleHeight);
			g.drawLine(triangleStartX + triangleWidth, triangleStartY, centerPointX, triangleStartY + triangleHeight);

			break;
		}
	}


}
